package com.acc.customerAPI.dto;

public class AccountDTO {
    private String id;
    private String customer;
    private Integer balance;
    private String currency;

    public AccountDTO(String id, String customer, Integer balance, String currency) {
        this.id = id;
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
