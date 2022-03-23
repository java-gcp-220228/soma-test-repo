package com.revature.controller;

import com.revature.exception.FailedLoginException;
import io.javalin.Javalin;
import io.javalin.http.ExceptionHandler;

import java.util.logging.Handler;

public class ExceptionController implements Controller{
    private ExceptionHandler failedLogin=(e,ctx)->{
        ctx.status(400);
        ctx.json(e.getMessage());

    };
    @Override
    public void mapEndpoints(Javalin app) {
        app.exception(FailedLoginException.class,failedLogin);
    }
}
