package com.tonyhuang.springdata.jpaSample.Demo2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.concurrent.Future;

public interface CustomerSubAccountRepository extends JpaRepository<CustomerSubAccount, String>
{
    //Tony
    //using the @Query simplely to find all
    @Query("select c from CustomerSubAccount c")
    List<CustomerSubAccount> findAllByCustomerQueryAndStream();

    //Tony
    //by @Param to pass the query parameter, no need to worry about the parameter sequence
    @Query("select c from CustomerSubAccount c where customerNumber = :customerNumber and subAccountNumber = :subAccountNumber")
    CustomerSubAccount findByCustomerAndSubAcc(@Param("subAccountNumber") String subAccountNumber, @Param("customerNumber") String customerNumber);

    //Tony
    //using the #{#entityName} as reference in case change the Entity name (table name), it's SpEL
    @Query("select c from #{#entityName} c where customerNumber = :customerNumber")
    CustomerSubAccount findByCustomer(@Param("customerNumber") String customerNumber);


    //Tony
    //nothing special, just a save
    @Override
    CustomerSubAccount save(CustomerSubAccount subAcc);

    //Tony
    //can use the native SQL
    @Async
    @Query(value = "SELECT * FROM CUSTOMER_SUB_ACCOUNT WHERE SUB_ACCOUNT_NAME LIKE ?1%", nativeQuery = true)
    //nativeQuery not support Sort in the parameter, but support sort keyword in SQL
    Future<CustomerSubAccount> findBySubAccountNameStartingWith1(String subAccName);

    //Tony
    //the return resultset is Name only
    List<CustomerSubAccountNameOnly> findByCustomerNumber(String customerNumber);

    //Tony
    //@Modifying to use for update / delete. Must has @Transactional
    @Transactional
    @Modifying
    @Query("update CustomerSubAccount a set a.subAccountName =?1 where a.customerNumber = ?2")
    int setSubAccountName(String subAccountName, String customerNumber);

    @Procedure(procedureName = "COUNT_CUSTOMER_SUB_ACC")
    Integer countCustomerSubAccountByCustomerNumber(String customerNumber);

}
