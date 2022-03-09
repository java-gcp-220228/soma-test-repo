package com.revature.service;

import com.revature.dao.ClientDao;
import com.revature.model.Client;
import java.sql.SQLException;
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
}
