package cn.swu.edu.javaweb.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class SecurityUser extends User implements UserDetails {

    public SecurityUser(User user) {
        if (user != null) {
            this.setUserUuid(user.getUserUuid());
            this.setUsername(user.getUsername());
            this.setPassword(user.getPassword());
            this.setEmail(user.getEmail());
            this.setTelephone(user.getTelephone());
            this.setRole(user.getRole());
            this.setImage(user.getImage());
            this.setLastIp(user.getLastIp());
            this.setLastTime(user.getLastTime());
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        String username = this.getUsername();
        if (username != null){
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(username);
            authorities.add(authority);//user 具有的权限
        }
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
