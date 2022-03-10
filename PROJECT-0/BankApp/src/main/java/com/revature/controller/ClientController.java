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
    private Handler getClientByid =(ctx)->{
        String id =ctx.pathParam("client_id");
        Client client  = clientservice.getClientById(id);
        ctx.json(client);
    };
    private Handler deleteClientByid =(ctx)->{
        String id =ctx.pathParam("client_id");
        Boolean deleteClient  = clientservice.deleteClientByid(id);
        ctx.json("client");
    };
    private Handler updateClientByid =(ctx)->{
        String id =ctx.pathParam("client_id");
        Client clientToedit =ctx.bodyAsClass(Client.class);
        Client updatedclient   = clientservice.updateClient(id,clientToedit);
        ctx.json(200);
        ctx.json(updatedclient);
    };
    private Handler addClient =(ctx)->{

        Client clientToadd =ctx.bodyAsClass(Client.class);
        Client newClient   = clientservice.addClient(clientToadd);
        ctx.json(200);
        ctx.json(newClient);
    };

    @Override

    public void mapEndpoints(Javalin app) {
     app.get("/clients",getAllClients);
     app.get("/clients/{client_id}",getClientByid);
     app.delete("/clients/{client_id}",deleteClientByid);
     app.put("/clients/{client_id}",updateClientByid);
     app.post("/clients",addClient);

    }
}
