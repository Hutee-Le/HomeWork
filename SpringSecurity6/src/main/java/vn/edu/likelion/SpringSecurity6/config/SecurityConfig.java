package vn.edu.likelion.SpringSecurity6.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Vô hiệu hóa CSRF
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/login", "/resources/**", "/api/users/register").permitAll()  // Cho phép truy cập vào trang đăng nhập và tài nguyên tĩnh
                        .anyRequest().authenticated()  // Yêu cầu xác thực với mọi request khác
                )
                .formLogin(form -> form
                        .loginPage("/login")  // Chỉ định trang đăng nhập tùy chỉnh
                        .defaultSuccessUrl("/api/users/info", true)  // Chuyển hướng sau khi đăng nhập thành công
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
