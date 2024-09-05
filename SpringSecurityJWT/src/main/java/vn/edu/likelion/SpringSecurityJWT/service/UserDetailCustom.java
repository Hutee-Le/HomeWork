package vn.edu.likelion.SpringSecurityJWT.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import vn.edu.likelion.SpringSecurityJWT.domain.UserEntity;

import java.util.Collections;

@Component("userDetailsService")
public class UserDetailCustom implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = this.userService.handleGetUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username/password không hợp lệ");
        }

        // Return authorities including role (from the entity)
        return new User(
                user.getEmail(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
        );
    }
}
