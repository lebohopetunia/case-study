package com.java.controller;

import com.java.repo.CustomerRepo;
import com.java.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerRepo customerRepo;

    @PostMapping(value="/save",consumes = "application/json")
    @ResponseBody
    public void saveEmployee(@RequestBody Customer customer)
    {
        customerRepo.save(customer);
    }

    @GetMapping(value = "/list",produces = "application/json")
    public List<Customer> getEmployee()
    {
        return customerRepo.findAll();
    }

}
