package com.revature.controller;
import com.revature.model.Client;

import com.revature.service.ClientService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

import java.util.List;


public class ClientController implements Controller{
     ClientService clientservice =new ClientService();

    public ClientController() {
        this.clientservice = new ClientService();
    }
    private Handler getAllClients=(ctx)->{
        List<Client> clients= clientservice.getAllClients();
        ctx.json(clients);
    };


    @Override

    public void mapEndpoints(Javalin app) {
     app.get("/clients",getAllClients);

    }
}
