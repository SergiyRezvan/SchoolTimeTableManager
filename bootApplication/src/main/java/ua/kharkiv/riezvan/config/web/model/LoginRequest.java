package ua.kharkiv.riezvan.config.web.model;


import javax.validation.constraints.NotEmpty;

public class LoginRequest {

    @NotEmpty(message = "Username is empty or not correct")
    private String userName;
    @NotEmpty(message = "Please provide your password")
    private String password;

    public LoginRequest() {
    }

    public LoginRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
