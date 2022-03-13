package com.revature.controller;

import com.revature.model.Account;
import com.revature.model.Client;
import com.revature.service.AccountService;
import com.revature.service.ClientService;
import io.javalin.Javalin;
import io.javalin.core.validation.BodyValidator;
import io.javalin.core.validation.BodyValidatorKt;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.List;

public class AccountController implements Controller {
    ClientService clientservice ;
    AccountService accountservice;

    public AccountController() {
        this.clientservice = new ClientService();
        this.accountservice =new AccountService();
    }
    private Handler addAccountByClientid =(ctx)->{
        String id =ctx.pathParam("client_id");
        Account accountToadd =bodyValidate(ctx);
         accountToadd =ctx.bodyAsClass(Account.class);
        Account newAccount   = accountservice.addAccountByClientid(id,accountToadd);
        ctx.json(200);
        ctx.json(newAccount);
    };
    private Handler getAllAccounts=(ctx)-> {
        String id =ctx.pathParam("client_id");
        String amtGreater =ctx.queryParam("amountGreaterThan");
        String amtLess =ctx.queryParam("amountLessThan");

        if(amtGreater!=null && amtLess!=null){
            List<Account> accounts = accountservice.getAllAccounts(id,amtGreater,amtLess);
            ctx.json(accounts);
        }else{
            List<Account> accounts = accountservice.getAllAccounts(id);
            ctx.json(accounts);
        }


    };
    private Handler getAllAccountById=(ctx)-> {
            String client_id =ctx.pathParam("client_id");
            String acct_id =ctx.pathParam("account_id");
            Account accounts = accountservice.getAccountById(client_id,acct_id);
            ctx.json(accounts);

    };
    private Handler updateAccountByid=(ctx)-> {
        String client_id = ctx.pathParam("client_id");

        Account accountToedit = ctx.bodyAsClass(Account.class);
        Account editedaccount = accountservice.updateAccountById(client_id, accountToedit);
        ctx.json(editedaccount);
    };

    private Handler deleteAccountByid =(ctx)-> {
        String client_id = ctx.pathParam("client_id");
        String acct_id = ctx.pathParam("account_id");
        Boolean deleteClient = accountservice.deleteAccountByid(client_id, acct_id);
        ctx.json("client has been deleted");
    };
    public Account bodyValidate(Context ctx)
    {
        String id =ctx.pathParam("client_id");
        BodyValidator<Account> body = ctx.bodyValidator(Account.class);
        return body.check(account -> Account.account_names.contains(Account.AccountNames.valueOf(account.getAccount_name())),
                        "Invalid account Name")
                .check(account -> account.getClient_id() > 0, "Invalid Client Id")
                .get();
    }
    @Override
    public void mapEndpoints(Javalin app) {
        app.post("/clients/{client_id}/accounts",addAccountByClientid);
        app.get("/clients/{client_id}/accounts",getAllAccounts);
     //   app.get("/clients/{client_id}/accounts?amountLessThan=2000&amountGreaterThan=400",getAllAccounts);
        app.get("/clients/{client_id}/accounts/{account_id}",getAllAccountById);
        app.put("/clients/{client_id}/accounts/{account_id}",updateAccountByid);
        app.delete("/clients/{client_id}/accounts/{account_id}",deleteAccountByid);
    }
}
