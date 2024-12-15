package dto;

import jakarta.servlet.http.Part;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UsersDto {
    String name;
    String birthday;
    Part image;
    String email;
    String password;
    String gender;
    String role;

}
