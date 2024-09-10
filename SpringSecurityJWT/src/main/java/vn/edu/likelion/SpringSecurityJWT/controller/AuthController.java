package vn.edu.likelion.SpringSecurityJWT.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import vn.edu.likelion.SpringSecurityJWT.domain.dto.request.ChangePasswordDTO;
import vn.edu.likelion.SpringSecurityJWT.domain.dto.request.ReqLoginDTO;
import vn.edu.likelion.SpringSecurityJWT.domain.dto.response.ResLoginDTO;
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
        String username = SecurityUtil.getCurrentUserLogin().orElseThrow(() ->
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

}