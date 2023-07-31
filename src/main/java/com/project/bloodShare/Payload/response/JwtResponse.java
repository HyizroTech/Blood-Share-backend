package com.project.bloodShare.Payload.response;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> acc7ed584275b2b5011af5e33c78dff94200b225
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String name;
<<<<<<< HEAD

    private String role;



=======
    private String role;

>>>>>>> acc7ed584275b2b5011af5e33c78dff94200b225
    public JwtResponse(String accessToken, String name, String role) {
        this.token = accessToken;
        this.name = name;
        this.role = role;
<<<<<<< HEAD

=======
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
>>>>>>> acc7ed584275b2b5011af5e33c78dff94200b225
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
<<<<<<< HEAD


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


=======
>>>>>>> acc7ed584275b2b5011af5e33c78dff94200b225
}
