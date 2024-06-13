package ecom.mobile.app.payload.response;

import lombok.Data;

import java.util.List;

@Data
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private int userId;
    private String name;
    private String email;
    private List<String> roles;

    public JwtResponse(String token, int userId, String name, String email, List<String> roles) {
        this.token = token;
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.roles = roles;
    }
}
