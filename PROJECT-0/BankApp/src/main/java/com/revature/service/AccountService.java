package com.revature.service;
import com.revature.dao.AccountDao;
import com.revature.dao.ClientDao;
import com.revature.exception.AcctNotFoundException;
import com.revature.exception.ClientNotFoundException;
import com.revature.model.Account;
import com.revature.model.Client;

import java.sql.SQLException;
import java.util.List;

public class AccountService {
    private ClientDao clientDao;
    private AccountDao accountDao;

    public AccountService() {
        this.clientDao =  new ClientDao();
        this.accountDao = new AccountDao();
    }
    public AccountService(AccountDao mockDao,ClientDao clientmockDao) {

        this.accountDao = mockDao;
        this.clientDao =  clientmockDao;
    }
// Create a new account for a client with id of X

    public Account addAccountByClientid(String client_id,Account account) throws SQLException, ClientNotFoundException {
        try {
            int clientId = Integer.parseInt(client_id);
            Client client = clientDao.getClientById(clientId);
            if (client == null) {
                throw new ClientNotFoundException("Client with id :" + clientId  + "was not found");
            }
                Account newAccount =accountDao.addAccounts(account);
                return newAccount;


        }catch (NumberFormatException e){
            throw  new  IllegalArgumentException("ID provided for client must be a valid int");
        }

    }

    //Get all accounts for client with id of X (if client exists)
    public List<Account> getAllAccounts(String id) throws SQLException, ClientNotFoundException {
        try {
            int clientId = Integer.parseInt(id);
            Client client = clientDao.getClientById(clientId);
            if (client == null) {
                throw new ClientNotFoundException("Client with id :" + clientId + "was not found");
            }
            return this.accountDao.getAllaccounts(clientId);
        }catch (NumberFormatException e){
            throw  new  IllegalArgumentException("ID provided for client must be a valid int");
        }

    }
    public List<Account> getAllAccounts(String id,String amtGreater,String amtLess) throws SQLException, ClientNotFoundException {
        try {
            int clientId = Integer.parseInt(id);
            int amtgt = Integer.parseInt(amtGreater);
            int amtls = Integer.parseInt(amtLess);
            Client client = clientDao.getClientById(clientId);
            if (client == null) {
                throw new ClientNotFoundException("Client with id :" + clientId + "was not found");
            }
            return this.accountDao.getAllaccountsWithCond(clientId,amtgt,amtls);
        }catch (NumberFormatException e){
            throw  new  IllegalArgumentException("ID provided for client must be a valid int");
        }

    }

    //Get account by id if exist in client
    public Account getAccountById(String client_id,String acct_id) throws SQLException, ClientNotFoundException, AcctNotFoundException {
        try {
            int clientId = Integer.parseInt(client_id);
            int acctId = Integer.parseInt(acct_id);
            Client client = clientDao.getClientById(clientId);
            if (client == null) {
                throw new ClientNotFoundException("Client with id :" + clientId + "was not found");
            }
            Account account =accountDao.getAccountById(clientId,acctId);
            if(account==null)
            {
                throw new AcctNotFoundException("Account with id :" + acctId +"and client id : "+clientId+ "was not found");
            }
            return account;

        }catch (NumberFormatException e){
            throw  new  IllegalArgumentException("ID provided for client must be a valid int");
        }

    }
    //Update account by accountid if client exist
    public Account updateAccountById(String client_id,String acct_id,Account account) throws SQLException, AcctNotFoundException {
        try {
            int clientId = Integer.parseInt(client_id);
            int acctId = Integer.parseInt(acct_id);
            Account acct = accountDao.getAccountById(clientId,acctId);
            account.setClient_id(clientId);
            account.setId(acctId);
            if (acct == null) {
                throw new AcctNotFoundException("Account with id :" + acctId +"and client id : "+clientId+ "was not found");
            }

            Account editedAccount =accountDao.updateAccount(clientId,acctId,account);
            return editedAccount;

        }catch (NumberFormatException e){
            throw  new  IllegalArgumentException("ID provided for client must be a valid int");
        }

    }
    //delete account
    public boolean deleteAccountByid(String client_id,String acct_id) throws SQLException, ClientNotFoundException, AcctNotFoundException {
        try {

            int clientId = Integer.parseInt(client_id);
            int acctId = Integer.parseInt(acct_id);
            Account acct = accountDao.getAccountById(clientId,acctId);
            if (acct == null) {
                throw new AcctNotFoundException("Account with id :" + acctId +"and client id: "+clientId+ "was not found");
            }
            Boolean deleteAcct = accountDao.deleteAccounttByid(acctId);
            if (deleteAcct == false) {
                throw new ClientNotFoundException("Account with id :" + acctId +""+" was not found");
            }
            return true;

        }catch (NumberFormatException e){
            throw  new  IllegalArgumentException("ID provided for client must be a valid int");
        }

    }

}
