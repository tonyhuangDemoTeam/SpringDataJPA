package com.tonyhuang.springdata.jpaSample.Demo2.Repository;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
@IdClass(CustomerSubAccountPK.class) //multiple key
@Table(name = "customer_sub_account") //optional, in case the Entity name is not align with DB
public class CustomerSubAccount
{
    @Id //Key indicator
    public String customerNumber;
    @Id
    public String subAccountNumber;

    @Column(name="sub_account_name") //optional, default no need, in case the Column name is not align with DB
    public String subAccountName;

    @Transient //this field is not map to DB column
    public String customerSubAccount;

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

    public String getSubAccountName() {
        return subAccountName;
    }

    public void setSubAccountName(String subAccountName) {
        this.subAccountName = subAccountName;
    }

    public String getCustomerSubAccount()
    {
        return this.customerNumber + "-" + this.subAccountNumber;
    }

    public void setCustomerSubAccount(String customerSubAccount)
    {
        this.customerSubAccount = this.customerNumber + "-" + this.subAccountNumber;
    }
}