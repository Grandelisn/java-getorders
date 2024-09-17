package com.lambdaschool.getorders.services;

import com.lambdaschool.getorders.models.Customer;
import com.lambdaschool.getorders.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

//Implements the CustomersService Interface
@Transactional
@Service(value = "customersService")
public class CustomersServiceImpl implements CustomersService{

    //Connects this service to the customers table
    @Autowired
    private CustomersRepository custrepos;

    @Override
    public List<Customer> findAllCustomers(){

        List<Customer> list = new ArrayList<>();

        //findAll returns an iterator set
        //iterate over the iterator set and add each element to an array list
        custrepos.findAll()
            .iterator()
            .forEachRemaining(list::add);
        return list;
    }

    @Override
    public List<Customer> findByCustomerName(String custname){

        return custrepos.findByCustnameContainingIgnoreCase(custname);
    }

    @Override
    public Customer findCustomersById(long id) throws EntityNotFoundException {
        return custrepos.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Customer " + id + " Not Found"));
    }
}