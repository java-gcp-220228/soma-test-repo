package com.revature.service;

import com.revature.dao.ClientDao;
import com.revature.exception.ClientNotFoundException;
import com.revature.model.Client;
import com.revature.utility.ConnectionUtility;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ClientService {
    private ClientDao clientDao;

    public ClientService() {
        this.clientDao = new ClientDao();
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
                throw new ClientNotFoundException("Client with id :" + clientId + "was not found");
            }
            return client;
        }catch (NumberFormatException e){
            throw  new  IllegalArgumentException("ID provided for client must be a valid int");
        }

    }
    //delete clint
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
            Client updatedClient = clientDao.updateClient(c);
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

        if (c.getAge() < 0) {
            throw new IllegalArgumentException("Adding a client with age < 0 is not valid. Age provided was " + c.getAge());
        }
    }
    }

