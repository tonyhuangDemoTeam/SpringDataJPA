package com.tonyhuang.springdata.jpaSample.Demo2.Controller;

import com.tonyhuang.springdata.jpaSample.Demo2.Repository.CustomerSubAccount;
import com.tonyhuang.springdata.jpaSample.Demo2.Repository.CustomerSubAccountNameOnly;
import com.tonyhuang.springdata.jpaSample.Demo2.Repository.CustomerSubAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/subAcc")
public class CustomerSubAccountController
{
    @Autowired
    CustomerSubAccountRepository subAccRepo;

    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    public List<CustomerSubAccount> findAll()
    {
        return subAccRepo.findAllByCustomerQueryAndStream();
    }

    @RequestMapping(value = "/get/bySubAccNameStart", method = RequestMethod.GET)
    public Future<CustomerSubAccount> findBySubAccNameStartWith(@PathParam("subAccName") String subAccName)
    {
        System.out.println("subAcc" + subAccName);
        return subAccRepo.findBySubAccountNameStartingWith1(subAccName);
    }

    @RequestMapping(value = "/get/byCustomerNumberNameOnly", method = RequestMethod.GET)
    public List<CustomerSubAccountNameOnly> findByCustomerNumberNameOnly(@PathParam("custNo") String custNo)
    {
        return subAccRepo.findByCustomerNumber(custNo);
    }

    @RequestMapping(value = "/get/byCustAndSubAcc", method = RequestMethod.GET)
    public CustomerSubAccount findByCustomerNumberNameOnly(@PathParam("custNo") String custNo, @PathParam("subAcc") String subAcc)
    {
        return subAccRepo.findByCustomerAndSubAcc(subAcc, custNo);
    }

    @RequestMapping(value = "/get/byCust", method = RequestMethod.GET)
    public CustomerSubAccount findByCustomer(@PathParam("custNo") String custNo)
    {
        return subAccRepo.findByCustomer(custNo);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public CustomerSubAccount save(@RequestBody CustomerSubAccount subAcc)
    {
        return subAccRepo.save(subAcc);
    }

    //Tony
    //Update
    @RequestMapping(value = "/set/subAccNameByCust", method = RequestMethod.POST)
    public List<CustomerSubAccountNameOnly> setSubAccNameByCust(@RequestBody CustomerSubAccount subAcc)
    {
        System.out.println(subAcc.getSubAccountName() + "---" + subAcc.getCustomerNumber());

        int  i = subAccRepo.setSubAccountName(subAcc.getSubAccountName(), subAcc.getCustomerNumber());

        //total updated record
        System.out.println("i: " + i);

        return subAccRepo.findByCustomerNumber(subAcc.getCustomerNumber());
    }

    //Tony call SP
    @RequestMapping(value = "/get/countByCustNo", method = RequestMethod.GET)
    public int getByCustomerNumber(@PathParam("custNo") String custNo)
    {
        int  i = subAccRepo.countCustomerSubAccountByCustomerNumber(custNo);

        //total updated record
        System.out.println("i: " + i);

        return i;
    }
}
