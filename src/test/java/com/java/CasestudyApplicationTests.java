package com.java;

import com.java.entity.Customer;
import com.java.repo.CustomerRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Collections;

@SpringBootTest
class CasestudyApplicationTests {

	@Autowired
	CustomerRepo customerRepo;
	@Test
	void contextLoads() {
	}
	@Test
	public void testSaveCustomer()
	{
		Customer customer = new Customer();

		customer.setId(0);
		customer.setName("Petunia");
		customer.setSurname("Leboho");
		customer.setProduct("banana");
		customerRepo.save(customer);
		
		Assert.notEmpty(Collections.singleton(customer),"added");

	}
	@Test
	void testListCustomer()
	{
		Customer customer = new Customer();

		customer.setId(0);
		customer.setName("Petunia");
		customer.setSurname("Leboho");
		customer.setProduct("banana");
		customerRepo.save(customer);
		Assert.notEmpty(Collections.singleton(customer),"added");

	}


}
