package com.base.c.document;

import java.util.Date;

public class Transaction {
  private Date date;
  private Double value;

    public Transaction() {
    }

    public Transaction(Date date, Double value) {
        this.date = date;
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
