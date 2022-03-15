package com.revature.model;

import java.util.EnumSet;
import java.util.Objects;

public class Account {
   /*public static  enum AccountNames {
        CHEQUING,
        SAVINGS;

    }*/
  //  public static EnumSet<AccountNames> account_names = EnumSet.allOf(AccountNames.class);
    private int id;
    private String account_name;
    private double account_bal;
    private int client_id;

    public Account() {

    }

    public Account( String account_name, double account_bal, int client_id) {

        this.account_name = account_name;
        this.account_bal = account_bal;
        this.client_id = client_id;
    }

    public Account(int id, String account_name, double account_bal, int client_id) {
        this.id = id;
        this.account_name = account_name;
        this.account_bal = account_bal;
        this.client_id = client_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public double getAccount_bal() {
        return account_bal;
    }

    public void setAccount_bal(long account_bal) {
        this.account_bal = account_bal;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", account_name='" + account_name + '\'' +
                ", account_bal=" + account_bal +
                ", client_id=" + client_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return getId() == account.getId() && getAccount_bal() == account.getAccount_bal() && getClient_id() == account.getClient_id() && Objects.equals(getAccount_name(), account.getAccount_name());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAccount_name(), getAccount_bal(), getClient_id());
    }
}
