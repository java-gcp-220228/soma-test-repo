package com.revature.controller;

import com.revature.dto.LoginDTO;
import com.revature.model.User;
import com.revature.service.UserService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class AuthenticationController implements  Controller{
    private UserService userservice;
    private  LoginDTO loginInfo;

    public AuthenticationController() {
        this.userservice = new UserService();
        this.loginInfo =new LoginDTO();
    }

    private Handler login =(ctx)->{

        System.out.println("Login function invoked");
        System.out.println(ctx.body());
        loginInfo = ctx.bodyAsClass(LoginDTO.class);
       // String user1 =loginInfo.getUserName();
        User user = userservice.login(loginInfo.getUsername(),loginInfo.getPassword());
        ctx.json(user);

    };


    @Override
    public void mapEndpoints(Javalin app) {
         app.post("/login", login);
    }
}
