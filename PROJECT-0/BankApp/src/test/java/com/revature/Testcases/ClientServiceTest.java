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

import static org.mockito.ArgumentMatchers.any;
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
    @Test
    public void test_getClientInvalidId()throws SQLException{
        ClientDao mockDao = mock(ClientDao.class);
        ClientService clientService =new ClientService(mockDao);
        //ACTAND ASSERT
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            clientService.getClientById("abc");
        });
    }
    //add positive test
    @Test
    public void test_addClient()throws SQLException{
        ClientDao mockDao = mock(ClientDao.class);
        ClientService clientService =new ClientService(mockDao);
    //Arrange
        when(mockDao.addClient(eq(new Client(2,"lixy","mat",25))))
                .thenReturn(new Client(2,"lixy","mat",25));
        Client actual = clientService.addClient(new Client(2,"lixy","mat",25));
        Client expected =new Client(2,"lixy","mat",25);
        Assertions.assertEquals(expected,actual);

    }
    //add negative test
    @Test
    public void test_validateClient_WithLeadingAndTrailingFirstAndLastName() throws SQLException {
        ClientDao mockDao = mock(ClientDao.class);
        ClientService clientService =new ClientService(mockDao);
        //Arrange
        when(mockDao.addClient(eq(new Client(2,"lixy","mat",25))))
                .thenReturn(new Client(2,"lixy","mat",25));
        Client actual = clientService.addClient(new Client(2,"    lixy     ","    mat     ",25));
        Client expected =new Client(2,"lixy","mat",25);
        Assertions.assertEquals(expected,actual);

    }
    @Test
    public void test_validateClient_FirstnameWithInvalidcharacters() throws SQLException {

        // Arrange
        ClientDao mockDao = mock(ClientDao.class);
        ClientService clientService = new ClientService(mockDao);

        // Act + Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            clientService.addClient(new Client(0, "lixy123", "mat", 24));
        });
    }
    @Test
    public void test_validateClient_LastnameWithInvalidcharacters() throws SQLException {

        // Arrange
        ClientDao mockDao = mock(ClientDao.class);
        ClientService clientService =new ClientService(mockDao);

        // Act + Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            clientService.addClient(new Client(0, "lixy", "mat%123", 24));
        });
    }
    @Test
    public void test_validateClient_NeagativeAge() throws SQLException {

        // Arrange
        ClientDao mockDao = mock(ClientDao.class);
        ClientService clientService =new ClientService(mockDao);

        // Act + Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            clientService.addClient(new Client(0, "lixy", "mat", -26));
        });
    }

    //update positivetest
    @Test
    public void test_UpdateClient() throws SQLException, ClientNotFoundException {
        // Arrange
        ClientDao mockDao = mock(ClientDao.class);
        ClientService clientService =new ClientService(mockDao);
        Client client =new Client(8,"soma","jan",25);
        //act
        when(mockDao.updateClient(eq("8"),eq(client)))
                .thenReturn(client);
        Client actual = clientService.updateClient("8",new Client(8,"soma","jans",25));
        Client expected =new Client(8,"soma","jans",25);
        Assertions.assertEquals(expected,actual);


    }
}





