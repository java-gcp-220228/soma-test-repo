package com.revature.Testcases;

import com.revature.controller.ExceptionController;
import com.revature.dao.ClientDao;
import com.revature.exception.ClientNotFoundException;
import com.revature.model.Client;
import com.revature.service.ClientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClientServiceTest {
    //private Logger logger = LoggerFactory.getLogger(ClientServiceTest.class);



    @Test
    public void testgetAllClients() throws SQLException{
        ClientDao mockedObject = mock(ClientDao.class);
        ClientService clientservice =new ClientService(mockedObject);
        List<Client> fakeclients =new ArrayList<>();
        fakeclients.add(new Client(1,"soma","jan",25));
        fakeclients.add(new Client(2,"nikhil","sas",26));
        fakeclients.add(new Client(3,"neithan","nikhil",27));
        fakeclients.add(new Client(4,"lixy","eldho",28));
        when(mockedObject.getAllClients()).thenReturn(fakeclients);

        //actual
        List<Client> actual = clientservice.getAllClients();
        //expected
        List<Client> expected = new ArrayList<>(fakeclients);
        Assertions.assertEquals(expected,actual);




    }
    @Test
    public void testgetClientByIdPositive() throws SQLException, ClientNotFoundException {
        //Arranage
        ClientDao mockedDao = mock(ClientDao.class);
        ClientService clientservice =new ClientService(mockedDao);
        Client fakeclient =new Client(1,"soma","jan",25);
        //act
        when(mockedDao.getClientById(eq(1))).thenReturn(fakeclient);
        //Assert
        Client actual = clientservice.getClientById("1");
        Client expected = fakeclient;
        Assertions.assertEquals(expected,actual);




    }
    @Test
    //NEGATIVE TEST
    public void test_getClientById_clientNotFound()throws SQLException{
        //Arrange
        ClientDao mockDao = mock(ClientDao.class);
        ClientService clientservice =new ClientService(mockDao);
        //Act and ASSERT
        Assertions.assertThrows(ClientNotFoundException.class,()->{
            clientservice.getClientById("10");
        });

    }
    //NEGATIVE TEST
    //@Test
    /*public void test_getClientInvalidId()throws SQLException{
        ClientDao mockDao = mock(ClientDao.class);
        ClientService clientService =new ClientService(mockDao);
        //ACTAND ASSERT
        Assertions.assertThrows(ClientNotFoundException.class,()->{
            clientService.getClientById("abc");
        });*/
    }





