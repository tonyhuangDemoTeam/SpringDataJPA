package com.tonyhuang.springdata.jpaSample.Demo1.Repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Customer
{
    @Id
    public String customerNumber;
    @Column
    public String customerName;
    @Column
    public String gender;

    public Integer age;
    @Column
    public String rmCode;
    @Column
    public Date accountOpenDate;
    @Column
    public Date accountClosedDate;
    @Column
    public String firstName;
    @Column
    public String lastName;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRmCode() {
        return rmCode;
    }

    public void setRmCode(String rmCode) {
        this.rmCode = rmCode;
    }

    public Date getAccountOpenDate() {
        return accountOpenDate;
    }

    public void setAccountOpenDate(Date accountOpenDate) {
        this.accountOpenDate = accountOpenDate;
    }

    public Date getAccountClosedDate() {
        return accountClosedDate;
    }

    public void setAccountClosedDate(Date accountClosedDate) {
        this.accountClosedDate = accountClosedDate;
    }
}
