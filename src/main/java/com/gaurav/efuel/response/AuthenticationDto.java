package com.gaurav.efuel.response;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
public class AuthenticationDto {

    @NotBlank(message = "*Please enter email!")
    private String email;

    @NotBlank(message = "*Please enter password!")
    private String password;

    public AuthenticationDto() {
        super();
    }

    public AuthenticationDto(@NotBlank(message = "*Please enter email!") String email, @NotBlank(message = "*Please enter password!") String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
