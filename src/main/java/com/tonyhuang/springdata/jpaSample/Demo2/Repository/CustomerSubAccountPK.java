package com.tonyhuang.springdata.jpaSample.Demo2.Repository;

import java.io.Serializable;
//Tony
//IdClass must implement Serializable
public class CustomerSubAccountPK implements Serializable
{
    public String customerNumber;
    public String subAccountNumber;

    public CustomerSubAccountPK(String customerNumber, String subAccountNumber) {
        this.customerNumber = customerNumber;
        this.subAccountNumber = subAccountNumber;
    }

    //must have this constructor
    public CustomerSubAccountPK() {
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getSubAccountNumber() {
        return subAccountNumber;
    }

    public void setSubAccountNumber(String subAccountNumber) {
        this.subAccountNumber = subAccountNumber;
    }
}
