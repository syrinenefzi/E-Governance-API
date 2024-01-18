package Egovernance.Egovernance.controller;

import Egovernance.Egovernance.service.AuthenticationManager;
import Egovernance.Egovernance.dto.UserConnectionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/auth")
@Controller
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authentication;


    @PostMapping("/login")
    public @ResponseBody boolean  logIn(@RequestBody UserConnectionDto var){
        return authentication.LogIn(var.getUserId(), var.getPassword());
    }

    @PostMapping("/logout")
    public @ResponseBody boolean logOut(@RequestBody UserConnectionDto var ){
        return authentication.LogOut(var.getUserId());
    }

}
