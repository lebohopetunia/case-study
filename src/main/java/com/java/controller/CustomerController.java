package com.java.controller;

import com.java.exception.CustomerNotFound;
import com.java.repo.CustomerRepo;
import com.java.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerRepo customerRepo;

    @PostMapping(value="/save",consumes = "application/json")
    public String saveCustomer(@RequestBody Customer customer)
    {

        try {
            customerRepo.save(customer);
            return customer.getName() +" has been Saved";
        } catch (Exception e) {

            return customer.getName() +" already exists";
        }


    }
    @PutMapping(value = "/update/{id}")
    public String updateCustomer(@RequestBody Customer customer, @PathVariable("id") Integer id)
    {
        boolean checkCustomer=customerRepo.existsById(id);
        if (checkCustomer){
         Customer customerUpdate= customerRepo.findById(id).get();
         customerUpdate.setName(customer.getName());
         customerUpdate.setProduct(customer.getProduct());
         customerUpdate.setSurname(customer.getSurname());
         customerRepo.save(customerUpdate);

            return "updated "+customer.getName()+"'s profile" ;
        }
        else {
            return customer.getName()+ " does not exist";
        }


    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteCustomer(@PathVariable(value = "id") Integer id) throws CustomerNotFound {

        Customer customer=customerRepo.findById(id).orElseThrow(() ->
                        new CustomerNotFound("No customer with id : " +id.toString()));
        String name=customer.getName();
        customerRepo.deleteById(id);
        return name +" deleted ";
    }



    @GetMapping(value = "/list",produces = "application/json")
    public List<Customer> getCustomer()
    {
        return customerRepo.findAll();
    }

    @GetMapping(value = "/get/{id}",produces = "application/json")
    public Customer getCustomer(@PathVariable(value = "id") Integer id) throws CustomerNotFound {

        Customer customer=customerRepo.findById(id).orElseThrow(() -> new CustomerNotFound("No customer with id : " +id.toString()));
        return customer;
    }

}
