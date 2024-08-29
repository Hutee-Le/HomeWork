package vn.likelion.springsecurity.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestApiResponse<T> {
    private int statusCode;
    private String error;

    // message có thể là string, hoặc arrayList
    private Object message;
    private T data;
}
