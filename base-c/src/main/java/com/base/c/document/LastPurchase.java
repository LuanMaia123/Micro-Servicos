package com.base.c.document;

import java.util.Date;

public class LastPurchase {
  private String companyName;
  private Date date;
  private Double value;

    public LastPurchase() {
    }

    public LastPurchase(String companyName, Date date, Double value) {
        this.companyName = companyName;
        this.date = date;
        this.value = value;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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
