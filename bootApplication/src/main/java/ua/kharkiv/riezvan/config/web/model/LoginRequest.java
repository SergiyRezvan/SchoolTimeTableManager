package ua.kharkiv.riezvan.config.web.model;


import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginRequest {

    @NotEmpty(message = "Username is empty or not correct")
    private String userName;
    @NotEmpty(message = "Please provide your password")
    private String password;

}
