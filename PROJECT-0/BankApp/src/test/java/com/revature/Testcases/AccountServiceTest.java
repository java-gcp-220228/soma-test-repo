package com.revature.Testcases;

import com.revature.dao.AccountDao;
import com.revature.dao.ClientDao;
import com.revature.exception.ClientNotFoundException;
import com.revature.model.Account;
import com.revature.model.Client;
import com.revature.service.AccountService;
import com.revature.service.ClientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccountServiceTest {
    AccountDao mockedObject;
    ClientDao clientmockDao;
    ClientService clientService;
    AccountService acctservice;
    @BeforeEach
    public  void setup(){
         mockedObject = mock(AccountDao.class);
        //Arrange
         clientmockDao = mock(ClientDao.class);
         clientService = new ClientService(clientmockDao);
         acctservice = new AccountService(mockedObject,clientmockDao);
    }

    //Get all accounts for client with id of X (if client exists)
    @Test
    public void test_getAllAccountsByClientid() throws SQLException, ClientNotFoundException {




        Client fakeClient = new Client(1, "soma", "jan", 27);
        List<Account> fakeaccts = new ArrayList<>();
        fakeaccts.add(new Account(1, "CHEQUING", 5000, 1));
        fakeaccts.add(new Account(2, "SAVINGS", 1000, 1));
        fakeaccts.add(new Account(3, "TFSA", 5000, 1));
        fakeaccts.add(new Account(4, "RRSP", 2000, 1));
        when(clientmockDao.getClientById(anyInt())).thenReturn(fakeClient);
        when(mockedObject.getAllaccounts(anyInt())).thenReturn(fakeaccts);

        //actual
        List<Account> actual = acctservice.getAllAccounts("18");
        //expected
        List<Account> expected = fakeaccts;
        Assertions.assertEquals(expected, actual);

    }
    @Test
    //NEGATIVE TEST
    public void test_getAllAccountsByClientid_clientNotFound() throws SQLException {

        //Act and ASSERT
        Assertions.assertThrows(ClientNotFoundException.class, () -> {
            acctservice.getAllAccounts("100");
        });

    }

    @Test
    public void test_getAllAccountsByClientid_InvalidId() throws SQLException {

        //ACTAND ASSERT
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            acctservice.getAllAccounts("abc");
        });
    }

    @Test
    //get all accts byclientid and acctid
    public void test_getAllAccountsByClientidAndAcctid() throws SQLException, ClientNotFoundException {
        Client fakeClient = new Client(1, "soma", "jan", 26);
        Account fakeAcct =new Account(1, "CHEQUING", 5000, 1);

        when(clientmockDao.getClientById(anyInt())).thenReturn(fakeClient);
        when(mockedObject.getAccountById(anyInt(),anyInt())).thenReturn(fakeAcct);
        Account actual = acctservice.getAccountById("18","10");
        Account expected =fakeAcct;
        Assertions.assertEquals(expected,actual);

    }

}