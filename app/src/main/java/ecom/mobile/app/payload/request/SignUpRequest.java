package ecom.mobile.app.payload.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

@Data
public class SignUpRequest {
    private String name;
    private String gender;
    private String email;
    private String password;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date create = new Date();

    private Set<String> roles;
}
