package com.revature.service;

import com.revature.dao.ClientDao;
import com.revature.exception.ClientNotFoundException;
import com.revature.model.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

public class ClientService {
    private ClientDao clientDao;

    private static Logger logger = LoggerFactory.getLogger(ClientService.class);

    public ClientService() {
        this.clientDao = new ClientDao();
    }
    public ClientService(ClientDao mockDao) {
        this.clientDao = mockDao;
    }
    //Get all clients
    public List<Client> getAllClients() throws SQLException {
        return this.clientDao.getAllClients();
    }
    //Get client by id
    public Client getClientById(String id) throws SQLException, ClientNotFoundException {
        try {
            int clientId = Integer.parseInt(id);
            Client client = clientDao.getClientById(clientId);
            if (client == null) {
                throw new ClientNotFoundException("Client with id :" + clientId + " "+" was not found");
            }
            return client;
        }catch (NumberFormatException e){
            throw  new  IllegalArgumentException("ID provided for client must be a valid integer");
        }

    }
    //delete client
    public boolean deleteClientByid(String id) throws SQLException, ClientNotFoundException {
        try {

            int clientId = Integer.parseInt(id);
            Boolean deleteClient = clientDao.deleteClientByid(clientId);
            if (deleteClient == false) {
                throw new ClientNotFoundException("Client with id :" + clientId + "was not found");
            }
            return true;
        }catch (NumberFormatException e){
            throw  new  IllegalArgumentException("ID provided for client must be a valid int");
        }

        }
        //update client
    public Client updateClient(String id,Client c) throws SQLException, ClientNotFoundException {
    try{
            int clientId = Integer.parseInt(id);
            Client client = clientDao.getClientById(clientId);
            if (client == null) {
                throw new ClientNotFoundException("User is trying to update a client that does not exist");
            }
            validateClientInfomation(c);
            c.setId(clientId);
            Client updatedClient = clientDao.updateClient("1", c);
            return updatedClient;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("Id provided for client is not valid");
        }
    }
    //addClient
    public Client addClient(Client c) throws SQLException {


            validateClientInfomation(c);
            Client newClient =clientDao.addClient(c);
            return newClient;

    }
    public void validateClientInfomation(Client c) {
        c.setFirst_name(c.getFirst_name().trim());
        c.setLast_name(c.getLast_name().trim());

        if (!c.getFirst_name().matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("First name must only have alphabetical characters. First name input was " + c.getFirst_name());
        }

        if (!c.getLast_name().matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Last name must only have alphabetical characters. Last name input was " + c.getLast_name());
        }

        if (c.getAge() <=0) {
            throw new IllegalArgumentException("Adding a client with age < 0 is not valid. Age provided was " + c.getAge());
        }

    }
    }

