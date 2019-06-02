package cn.swu.edu.javaweb.user;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class LoginController {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping("/")
    public String root(){
        return "index";
    }

    public User getUser(){//为了从session中获取用户信息
        User user = new User();
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        if (authentication.getPrincipal() instanceof UserDetails){
            user = (User) authentication.getPrincipal();
        }
        return user;
    }

    public HttpServletRequest getRequest() {
        return ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest();
    }
}
