package cn.swu.edu.javaweb.config;

import cn.swu.edu.javaweb.user.SecurityUser;
import cn.swu.edu.javaweb.user.User;
import cn.swu.edu.javaweb.user.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class WebSecurityConfig extends WebSecurityEnablerConfiguration {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(WebSecurityConfig.class);

    protected void configure(HttpSecurity http) throws Exception{//配置策略
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/static/**").
                permitAll().anyRequest().authenticated().and().formLogin().
                loginPage("/login").permitAll().successHandler(loginSuccessHandler()).
                and().logout().permitAll().invalidateHttpSession(true).
                deleteCookies("JSESSIONID").logoutSuccessHandler(logoutSuccessHandler()).
                and().sessionManagement().maximumSessions(10).expiredUrl("/login");
    }

    private SavedRequestAwareAuthenticationSuccessHandler loginSuccessHandler() {//登入处理
        return new SavedRequestAwareAuthenticationSuccessHandler(){
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException,ServletException{
                User userDetails = (User) authentication.getPrincipal();//登入成功后就可以获取用户具体的权限信息
                logger.info("USER : " + userDetails.getUsername() + " LOGIN SUCCESS! ");
                super.onAuthenticationSuccess(request,response,authentication);
            }
        };
    }


    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
      auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
      auth.eraseCredentials(false);
    }

    @Bean
    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4);
    }

    @Bean
    private UserDetailsService userDetailsService() {
        return new UserDetailsService() {

            @Autowired
            private UserRepository userRepository;

            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                User user = userRepository.findByUsername(username);
                if (user == null) throw new UsernameNotFoundException("Username " + username + "not found");
                return new SecurityUser(user);
            }
        };
    }

    @Bean
    private LogoutSuccessHandler logoutSuccessHandler() {
        return new LogoutSuccessHandler() {
            @Override
            public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                try {
                    SecurityUser user = (SecurityUser) authentication.getPrincipal();
                    LOGGER.info("USER:" + user.getUsername() + "LOGOUT SUCCESS! ");
                }catch (Exception e){
                    LOGGER.info("LOGOUT EXCEPTION,e : " + e.getMessage());
                }
                response.sendRedirect("/login");
            }
        };
    }

}
