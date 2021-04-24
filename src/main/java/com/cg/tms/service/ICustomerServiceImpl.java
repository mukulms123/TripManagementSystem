package com.cg.tms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.entities.Customer;
import com.cg.tms.entities.Package1;
import com.cg.tms.entities.User;
import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.exceptions.PackageNotFoundException;
import com.cg.tms.repository.ICustomerRepository;
import com.cg.tms.repository.IRouteRepository;
import com.cg.tms.repository.IUserRepository;

@Service
@Transactional
public class ICustomerServiceImpl implements ICustomerService{

	@Autowired
	private ICustomerRepository cRep;
	
	@Autowired 
	private IRouteRepository rRep;
	
	@Autowired
	private IPackageService pService;
	
	@Autowired
	private IUserRepository uRep;
	
	
	@Override
	public Customer addCustomer(Customer customer) {
		Customer cust = cRep.save(customer);
		User user = new User();
		user.addCustomer(cust);
		User newUser = uRep.save(user);
        return cust;
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
		boolean check = cRep.existsById(customer.getCustomerId());
		if(!check)
		{
			throw new CustomerNotFoundException("Customer Not Found at Id: "+customer.getCustomerId());
		}
		Customer cust = cRep.save(customer);
		return cust;

	}

	@Override
	public Customer deleteCustomer(Customer customer) throws CustomerNotFoundException {
		boolean check = cRep.existsById(customer.getCustomerId());
		if(!check)
		{
			throw new CustomerNotFoundException("Customer Not found at Id: " + customer.getCustomerId());
		}
		cRep.delete(customer);
		return customer;
	}

	@Override
	public Customer viewCustomer(int custId) throws CustomerNotFoundException {
		Optional<Customer> opt = cRep.findById(custId);
		if(!opt.isPresent()) {
			throw new CustomerNotFoundException("Customer Not Found at Id: "+custId);
		}
		Customer cust = opt.get();
		return cust;
	}

	@Override
	public Customer viewCustomerList(int id) throws PackageNotFoundException,CustomerNotFoundException {
		 	Package1 pack = pService.searchPackage(id);
		 	int packId = cRep.findByPackage(pack);
	        //List<Booking> booking = bRep.findByPackId(id);
	        //List<Integer> ids = new ArrayList<>();
	        //for (Booking booking2 : booking) {
	        //	System.out.println(booking2.getUserId());
			//}
	        
	        //List<Integer> custIds = cRep.findByPack(id);
	        Optional<Customer> opt=cRep.findById(packId);
	        if(!opt.isPresent())
	        {
	        	throw new CustomerNotFoundException("Customer Not Found at Package Id: "+id);
	        }
	        Customer cust = opt.get();
	        return cust;
	}

	@Override
	public List<Customer> viewAllCustomers() {
		List<Customer> customers = cRep.findAll();
		return customers;
	}



}
