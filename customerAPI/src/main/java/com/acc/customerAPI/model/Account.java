package com.acc.customerAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Account {
    @Id
    private String id;
    private String customer;
    private Integer balance;
    private String currency;

    public Account(String customer, Integer balance, String currency) {
        this.customer = customer;
        this.balance = balance;
        this.currency = currency;
    }

    public String getId() {
        return id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
