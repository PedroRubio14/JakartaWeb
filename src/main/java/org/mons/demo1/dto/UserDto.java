package org.mons.demo1.dto;

import lombok.Getter;
import lombok.Setter;
import org.mons.demo1.models.User;

import java.util.Date;


@Getter
@Setter
public class UserDto {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String password;

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.password = user.getPassword();
    }

}
