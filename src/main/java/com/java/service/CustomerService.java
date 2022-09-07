package com.java.service;

import com.java.entity.Customer;
import com.java.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;


    public ResponseEntity<String> saveCustomer(Customer customer)
    {
        try {

            customerRepo.save(customer);
            return ResponseEntity.ok(customer.getName() +" has been Saved") ;
        } catch (Exception e) {

            return ResponseEntity.ok(customer.getName() +" Already exist") ;
        }
    }

    public List<Customer> getAllCustomer()
    {
        return customerRepo.findAll();
    }

    public ResponseEntity<String> updateCustomer(Customer customer, Integer id)
    {
        boolean checkCustomer=customerRepo.existsById(id);
        if (!checkCustomer) {
            return ResponseEntity.ok(customer.getName() +" does not exist") ;
        }

        Customer customerUpdate= customerRepo.findById(id).get();
        customerUpdate.setName(customer.getName());
        customerUpdate.setProduct(customer.getProduct());
        customerUpdate.setSurname(customer.getSurname());
        customerRepo.save(customerUpdate);


        return ResponseEntity.ok("updated "+customer.getName()+"'s profile");


    }

    public ResponseEntity<String> deleteCustomer(Integer id)  {

        boolean checkCustomer=customerRepo.existsById(id);

        if (!checkCustomer) {
            return ResponseEntity.ok( "Customer with id-"+id +" does not exist") ;
        }
        Customer customer=customerRepo.findById(id).get();

        String name=customer.getName();
        customerRepo.deleteById(id);
        return ResponseEntity.ok(name +" deleted ");
    }

    public String searchCustomer(Integer id) {
        boolean checkCustomer=customerRepo.existsById(id);

        if (!checkCustomer) {
            return  "Customer with id-"+id +" does not exist" ;
        }

        Customer customer=customerRepo.findById(id).get();
        return customer.toString();
    }





}
