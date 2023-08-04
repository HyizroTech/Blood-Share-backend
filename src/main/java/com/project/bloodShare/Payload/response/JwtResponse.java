package com.project.bloodShare.Payload.response;

import java.util.List;

public class JwtResponse {
    private String token;

    private Long id;
    private String type = "Bearer";
    private String name;

    private String role;



    public JwtResponse(String accessToken,Long id ,String name, String role) {
        this.token = accessToken;
        this.id = id;
        this.name = name;
        this.role = role;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
