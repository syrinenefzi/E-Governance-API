package Egovernance.Egovernance.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
    private int userId;
    private String userName;
    private String password;
    private String role;
    private Boolean LoggedIn;
}
