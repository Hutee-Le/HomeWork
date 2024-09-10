package vn.edu.likelion.SpringSecurityJWT.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResetPasswordTokenDTO {
    private String token;
    private String newPassword;
}
