package com.tonyhuang.springdata.jpaSample.Demo1.Controller;

import com.tonyhuang.springdata.jpaSample.Demo1.Repository.Customer;
import com.tonyhuang.springdata.jpaSample.Demo1.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import javax.websocket.server.PathParam;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController
{

    @Autowired
    CustomerRepository custRepo;

    //Tony
    //1. Enquiry
    //1.1 GET method, findByName
    @RequestMapping(value="/get/byName", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> findByName(@PathParam("name") String name)
    {
        return custRepo.findByCustomerName(name);
    }

    //Tony
    //1.2 find by customerNumber
    @RequestMapping(value="/get/byCustNo", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> saveCustomer(@PathParam("custNo") String customerNumber)
    {
        return custRepo.findByCustomerNumber(customerNumber);
    }

    //Tony
    //1.3 GET method, find by Age
    @RequestMapping(value="/get/byAge", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> findByAge(@PathParam("age") Integer age)
    {

        System.out.println("age:" + age);
        return custRepo.findByAge(age);
    }

    //TonyHuang
    //1.4 can using the keyword: Between
    @RequestMapping(value="/get/byAgeBtw", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> findByAgeBetween(@PathParam("age1") Integer age1, @PathParam("age2") Integer age2)
    {

        System.out.println("age1:" + age1 + " age2:" +age2);
        return custRepo.findByAgeBetween(age1, age2);
    }

    //Tony
    //1.5 keyword AND
    @RequestMapping(value="/get/byNameAndAge", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> findByNameAndAge(@PathParam("name") String name, @PathParam("age") Integer age)
    {
        return custRepo.findByCustomerNameAndAge(name, age);
    }

    //Tony
    //1.6 keyword OR
    @RequestMapping(value="/get/byFirstNameOrLastName", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> findByFirstNameOrLastName(@PathParam("firstName") String firstName, @PathParam("lastName") String lastName)
    {
        return custRepo.findByFirstNameOrLastName(firstName, lastName);
    }

    //Tony
    //1.6 keyword LessThan
    @RequestMapping(value="/get/byAgeLessThan", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> findByAgeLessThan(@PathParam("age") Integer age)
    {
        return custRepo.findByAgeLessThan(age);
    }

    //Tony
    //1.7 keyword After
    @RequestMapping(value="/get/byAccOpenDateAfter", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> findByAccountOpenDateAfter(@PathParam("openDate") Date openDate)
    {
        return custRepo.findByAccountOpenDateAfter(openDate);
    }

    //Tony
    //1.8 keyword IgnoreCase
    @RequestMapping(value="/get/byFirstName", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> findByFirstNameIgnoreCase(@PathParam("firstName") String firstName)
    {
        return custRepo.findByFirstNameIgnoreCase(firstName);
    }

    //Tony
    //1.9 keyword Contain
    @RequestMapping(value="/get/byFirstNameContain", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> findByFirstNameContains(@PathParam("firstName") String firstName)
    {
        return custRepo.findByFirstNameContaining(firstName);
    }

    //Tony
    //1.10 keyword count
    @RequestMapping(value="/get/countByAge", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> countByAgeGreaterThan(@PathParam("age") Integer age)
    {
        return custRepo.countByAgeGreaterThan(age);
    }

    //Tony
    //Key word: LessThanEqual, GreaterThan, Is, Equal, IsNull, IsNotNull, Like, NotLike, StartingWith, EndingWith,
    //OrderBy, Not, In, NotIn, True, False

    //Tony
    //2. POST method, save the bean into db
    //2.1 actually it's a insert or update function. no need to enquiry before insert the JPA already did it for u
    @RequestMapping(value="/save", method = RequestMethod.POST)
    @ResponseBody
    public Customer saveCustomer(@RequestBody  Customer customer)
    {
        return custRepo.save(customer);
    }


    //Tony
    //3. POST method, delete the bean into db
    //3.1 it's a select and delete function, if not exist JPA will throw exception.
    @RequestMapping(value="/delete" , method = RequestMethod.POST)
    public String delete(@RequestBody Customer customer)
    {
        String result = "Success";
        try
        {
            custRepo.delete(customer);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            result = "False";
        }
        finally
        {
        }

        return result;
    }


    //Tony
    //4. Pageable, Sort
    //4.1 Pageable
    @RequestMapping(value="/get/byLastName", method = RequestMethod.GET)
    public Page<Customer> findByLastName(@PathParam("lastName") String lastName, @PathParam("pageNo") int pageNo, @PathParam("size") int size)
    {
        return custRepo.findByLastName(lastName, new PageRequest(pageNo, size, Sort.Direction.DESC, "age"));
    }
}
