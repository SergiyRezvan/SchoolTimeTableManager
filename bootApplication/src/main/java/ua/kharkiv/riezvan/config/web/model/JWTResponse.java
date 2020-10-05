package ua.kharkiv.riezvan.config.web.model;

public class JWTResponse {

    private String accessToken;

    public JWTResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
