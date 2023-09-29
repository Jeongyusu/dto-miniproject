package com.example.kakao.user;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class UserRequest {
    @Getter
    @Setter
    @ToString
    public static class JoinDTO {

        @NotEmpty(message = "email은 비어있을수 없습니다.")
        private String email;

        @NotEmpty(message = "password는 비어있을수 없습니다.")
        private String password;

        @NotEmpty(message = "username은 비어있을수 없습니다.")
        private String username;

        public User toEntity() {
            return User.builder()
                    .email(email)
                    .password(password)
                    .username(username)
                    .build();
        }
    }

    @Getter
    @Setter
    @ToString
    public static class LoginDTO {

        @NotEmpty(message = "email을 입력해주세요.")
        private String email;

        @NotEmpty(message = "password를 입력해주세요.")
        private String password;
    }
}
