package vn.edu.likelion.SpringSecurityJWT.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import vn.edu.likelion.SpringSecurityJWT.domain.UserEntity;
import vn.edu.likelion.SpringSecurityJWT.domain.dto.request.ChangePasswordDTO;
import vn.edu.likelion.SpringSecurityJWT.domain.dto.request.ReqLoginDTO;
import vn.edu.likelion.SpringSecurityJWT.domain.dto.response.ResLoginDTO;
import vn.edu.likelion.SpringSecurityJWT.service.EmailService;
import vn.edu.likelion.SpringSecurityJWT.service.UserService;
import vn.edu.likelion.SpringSecurityJWT.utils.PasswordUtil;
import vn.edu.likelion.SpringSecurityJWT.utils.SecurityUtil;
import vn.edu.likelion.SpringSecurityJWT.utils.error.WeakPasswordException;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private AuthenticationManagerBuilder authenticationManagerBuilder;

    @Autowired
    private SecurityUtil securityUtil;

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/login")
    public ResponseEntity<ResLoginDTO> login(@Valid @RequestBody ReqLoginDTO loginDto) {
        // Nạp input gồm username/password vào Security
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(), loginDto.getPassword());

        // xác thực người dùng => cần viết hàm loadUserByUsername
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // create a token
        String access_token = this.securityUtil.createToken(authentication);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        ResLoginDTO res = new ResLoginDTO();
        res.setAccessToken(access_token);
        return ResponseEntity.ok().body(res);
    }

    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@Valid @RequestBody ChangePasswordDTO changePasswordDTO) throws WeakPasswordException {
        String username = securityUtil.getCurrentUserLogin().orElseThrow(() ->
                new IllegalArgumentException("User not logged in"));

        // Check if the new password is strong enough
        if (!PasswordUtil.isValid(changePasswordDTO.getNewPassword())) {
            throw new WeakPasswordException("The new password is too weak!");
        }

        boolean success = userService.changePassword(username, changePasswordDTO.getOldPassword(),
                changePasswordDTO.getNewPassword());

        if (!success) {
            return ResponseEntity.badRequest().body("Invalid password or old password does not match!");
        }

        return ResponseEntity.ok("Password changed successfully!");
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestParam String email) {
        UserEntity user = userService.handleGetUserByUsername(email);

        if (user != null) {
            String token = securityUtil.createTokenForPasswordReset(user);
            String resetLink = "http://localhost:8080/api/v1/auth/reset-password?token=" + token;

            emailService.sendEmail(email, "Password Reset Request", "To reset your password, click the link below:\n" + resetLink);
        }

        return ResponseEntity.ok("If the email exists, a password reset link has been sent.");
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestParam String token, @RequestParam String newPassword) {
        // Validate the token and reset the password
        String email = securityUtil.getUsernameFromToken(token);
        UserEntity user = userService.handleGetUserByUsername(email);

        if (user != null) {
            userService.updatePassword(user, newPassword);
            return ResponseEntity.ok("Password has been reset successfully.");
        }

        return ResponseEntity.badRequest().body("Invalid token or user not found.");
    }
}