package org.mons.demo1.services;

import com.google.common.hash.Hashing;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mons.demo1.dao.user.UserDaoOrmImpl;
import org.mons.demo1.dto.UserDto;
import org.mons.demo1.models.User;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class UserServiceImp {

    UserDaoOrmImpl dao = new UserDaoOrmImpl();

    public UserDto getUser(String username){
        User user = dao.getUser(username);

        if(user == null){
            return null;
        }
       return new UserDto(user);
    }

    public boolean validateUser(UserDto user, String password){
        if(user == null){
            return false;
        }
        String username = user.getUsername();
        String password2 = user.getPassword();

        if(username.equals(username) && password.equals(password2)){
            return true;
        }
        return false;
    }


    public UserDto addUser(String username, String firstName, String lastName, String password){
        String hashedPassword = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();

        return new UserDto(dao.addUser(new User(0L,username, firstName, lastName, hashedPassword)));

    }


}
