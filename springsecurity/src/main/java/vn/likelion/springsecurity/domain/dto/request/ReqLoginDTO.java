package vn.likelion.springsecurity.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqLoginDTO {
    private String username;
    private String password;
}
