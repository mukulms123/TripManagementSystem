package com.cg.tms.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.tms.dto.CustomerDetails;
import com.cg.tms.entities.Customer;

@Component
public class CustomerUtil {

	public CustomerDetails toDetailsCustomer(Customer customer)
	{
		CustomerDetails cust = new CustomerDetails( customer.getCustomerId(), 
													customer.getCustomerName(), 
													customer.getCustomerPassword(), 
													customer.getAddress(), 
													customer.getMobileNo(), 
													customer.getEmail());
		return cust;
		
	}
	
	public List<CustomerDetails> toDetailsCustomer(Collection<Customer> customers)
	{
		List<CustomerDetails> customerList = new ArrayList<>();
		for (Customer cust : customers) {
			CustomerDetails customerDetail = toDetailsCustomer(cust);
			customerList.add(customerDetail);
		}
		return customerList;
	}
}
