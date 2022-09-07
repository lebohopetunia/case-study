package com.java.controller;


import com.java.entity.Customer;
import com.java.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @PostMapping(value="/save",consumes = "application/json")
    public ResponseEntity<String> saveCustomer(@RequestBody Customer customer)
    {

        return customerService.saveCustomer(customer);
    }
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<String> updateCustomer(@RequestBody Customer customer, @PathVariable("id") Integer id)
    {

           return customerService.updateCustomer(customer,id);

    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable(value = "id") Integer id) {

       return customerService.deleteCustomer(id);

    }



    @GetMapping(value = "/list",produces = "application/json")
    public List<Customer> getCustomers()
    {
        return customerService.getAllCustomer();
    }

    @GetMapping(value = "/get/{id}",produces = "application/json")
    public String getCustomer(@PathVariable(value = "id") Integer id)  {


        return customerService.searchCustomer(id);
    }

}
