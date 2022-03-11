package com.revature.main;

import com.revature.controller.AccountController;
import com.revature.controller.ClientController;
import com.revature.controller.Controller;
import com.revature.controller.ExceptionController;
import io.javalin.Javalin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Driver {
  //  public static Logger logger = LoggerFactory.getLogger(Driver.class);
    public static void main(String[] args) {
        Javalin app = Javalin.create();
        //logs before all request
        app.before((ctx) -> {
            //logger.info(ctx.method() + " request received for " + ctx.path());
        });
        mapControllers(app, new ClientController(),new ExceptionController(),new AccountController());

        app.start(); // port 8080 by default
    }

    public static void mapControllers(Javalin app, Controller... controller) {
        for (Controller c : controller) {
            c.mapEndpoints(app);
        }
    }


}
