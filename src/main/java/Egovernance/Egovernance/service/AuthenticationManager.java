package Egovernance.Egovernance.service;

import Egovernance.Egovernance.model.UserDto;
import Egovernance.Egovernance.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AuthenticationManager {
    private static List<UserDto> users = new ArrayList<>();
    @Autowired
    private UserManager userManager;


    public boolean LogIn(int userId, String password) {
        UserDto user = userManager.getUserById(userId);
        if (user != null && user.getPassword().equals(password)) {
            user.setLoggedIn(true);
            return true;
        }
        return false;
    }

    public boolean LogOut(int userId) {
        UserDto user = userManager.getUserById(userId);
        if (user == null) {
            throw new NoSuchElementException(String.format("The id %d is not found", userId));
        } else {
            user.setLoggedIn(false);
            return true;
        }
    }
}
