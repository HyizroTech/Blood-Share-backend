package com.project.bloodShare.Payload.response;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String name;
    private String role;

    public JwtResponse(String accessToken, String name, String role) {
        this.token = accessToken;
        this.name = name;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
