package com.tonyhuang.springdata.jpaSample.Demo1.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Id;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, String>
{
    List<Customer> findByCustomerName(String name);

    Customer save(Customer customer);

    List<Customer> findByCustomerNumber(String customerNumber);

    List<Customer> findByAge(Integer age);

    List<Customer> findByAgeBetween(Integer age1, Integer age2);

    List<Customer> findByCustomerNameAndAge(String name, Integer age);

    List<Customer> findByFirstNameOrLastName(String firstName, String lastName);

    List<Customer> findByAgeLessThan(Integer age);

    List<Customer> findByAccountOpenDateAfter(Date openDate);

    List<Customer> findByFirstNameIgnoreCase(String firstName);

    List<Customer> findByFirstNameContaining(String firstName);

    List<Customer> countByAgeGreaterThan(Integer age);

    long count();

    @Override
    List<Customer> findAll();

    @Override
    void delete(Customer customer);

    void deleteAll();

    Page<Customer> findByLastName(String lastName, Pageable pageable);
}
