package com.base.c.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Hotels")
public class Person {
    @Id
    private String id;
    private String cpf;
    private String last_query;
    private List<LastPurchase> lastPurchases;
    private List<Transaction> transactions;

    protected Person() {
        this.transactions = new ArrayList<>();
    }

    public Person(String cpf, String last_query, List<LastPurchase> lastPurchases, List<Transaction> transactions) {
        this.cpf = cpf;
        this.last_query = last_query;
        this.lastPurchases = lastPurchases;
        this.transactions = transactions;
    }

    public String getLast_query() {
        return last_query;
    }

    public void setLast_query(String last_query) {
        this.last_query = last_query;
    }

    public List<LastPurchase> getLastPurchases() {
        return lastPurchases;
    }

    public void setLastPurchases(List<LastPurchase> lastPurchases) {
        this.lastPurchases = lastPurchases;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
