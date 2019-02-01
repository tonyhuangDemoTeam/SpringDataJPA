package com.tonyhuang.springdata.jpaSample.Demo2.Repository;

import org.springframework.beans.factory.annotation.Value;

//Tony
//can use the interface or DTO to projection every column combination to result and return
public interface CustomerSubAccountNameOnly
{
    String getSubAccountName();

    @Value("#{target.customerNumber + '-' + target.subAccountNumber}")
    String getFullCustomerNumber();
}
