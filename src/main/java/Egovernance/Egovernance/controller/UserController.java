package Egovernance.Egovernance.controller;

import Egovernance.Egovernance.model.UserDto;
import Egovernance.Egovernance.model.UserDto;
import Egovernance.Egovernance.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@Controller
public class UserController {
    @Autowired
    private UserManager userManager;
    private UserDto user ;

    @GetMapping("/")
    public @ResponseBody List<UserDto> getUser() {
        return userManager.getAll();
    }

    @PostMapping("/list")
    public @ResponseBody List<UserDto> addUsers(@RequestBody List<UserDto> newUser){
        return userManager.addUsers(newUser);
    }

    @PostMapping("/")
    public @ResponseBody UserDto addUser(@RequestBody UserDto newUser){
        return userManager.addUser(newUser);
    }

    @DeleteMapping("/")
    public @ResponseBody boolean deleteUser(Integer idUserToBeDeleted){
        return userManager.removeUser(idUserToBeDeleted);
    }

    @GetMapping("/{userId}")
    public @ResponseBody UserDto getUsernameById(@PathVariable int userId) {
        return userManager.getUserById(userId);
    }
}
