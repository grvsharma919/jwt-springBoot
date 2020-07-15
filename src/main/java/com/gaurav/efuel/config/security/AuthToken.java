package com.gaurav.efuel.config.security;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthToken {
    private String token;

    public AuthToken() {
        super();
    }
}
