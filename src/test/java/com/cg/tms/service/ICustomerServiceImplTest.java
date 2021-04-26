package com.cg.tms.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.tms.entities.Customer;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(ICustomerServiceImpl.class)
@ExtendWith({ SpringExtension.class })
public class ICustomerServiceImplTest {

	@Autowired
	private ICustomerService cService;

	@Autowired
	private EntityManager em;

	@Test
	public void addCustomer() {
		Customer cust = new Customer("Nandita", "nan123", "delhi", "9810859887", "mail2nanditarao@gmail.com");
		Customer custFound = cService.addCustomer(cust);
		Assertions.assertEquals(custFound.getCustomerName(), cust.getCustomerName());
	}

	@Test
	public void deleteCustomer() {
		Customer cust = new Customer("Nandita", "nan123", "delhi", "9810859887", "mail2nanditarao@gmail.com");
		em.persist(cust);
		Customer custFound = cService.deleteCustomer(cust);
		Assertions.assertEquals(custFound.getCustomerName(), cust.getCustomerName());
	}

	@Test
	public void updateCustomer() {
		Customer cust = new Customer("Nandita", "nan123", "delhi", "9810859887", "mail2nanditarao@gmail.com");
		em.persist(cust);
		Customer newCust = new Customer("Nitanshi", "nan123", "delhi", "9810859887", "mail2nanditarao@gmail.com");
		newCust.setCustomerId(cust.getCustomerId());
		Customer custFound = cService.updateCustomer(newCust);
		Assertions.assertEquals(custFound.getCustomerName(), cust.getCustomerName());
	}

	@Test
	public void viewCustomer() {
		Customer cust = new Customer("Nandita", "nan123", "delhi", "9810859887", "mail2nanditarao@gmail.com");
		em.persist(cust);
		Customer custFound = cService.viewCustomer(cust.getCustomerId());
		Assertions.assertEquals(custFound.getCustomerName(), cust.getCustomerName());
	}

	@Test
	public void ViewAllCustomers() {
		Customer cust = new Customer("nandita", "nan123", "delhi", "9810859887", "mail2nanditarao@gmail.com");
		em.persist(cust);
		List<Customer> custFound = cService.viewAllCustomers();
		Assertions.assertNotNull(custFound);
	}
}
