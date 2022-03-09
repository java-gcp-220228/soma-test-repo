package com.revature.main;

import com.revature.controller.ClientController;
import com.revature.controller.Controller;
import io.javalin.Javalin;

public class Driver {

    public static void main(String[] args) {
        Javalin app = Javalin.create();

        mapControllers(app, new ClientController());

        app.start(); // port 8080 by default
    }

    public static void mapControllers(Javalin app, Controller... controller) {
        for (Controller c : controller) {
            c.mapEndpoints(app);
        }
    }


}
