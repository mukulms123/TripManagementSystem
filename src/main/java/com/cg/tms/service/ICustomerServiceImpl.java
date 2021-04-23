package com.cg.tms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.entities.Customer;
import com.cg.tms.entities.Package1;
import com.cg.tms.entities.Route;
import com.cg.tms.entities.User;
import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.exceptions.PackageNotFoundException;
import com.cg.tms.exceptions.RouteNotFoundException;
import com.cg.tms.repository.ICustomerRepository;
import com.cg.tms.repository.IPackageRepository;
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
	private IPackageRepository pRep;
	
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
			//add argument while Exception handling
			throw new CustomerNotFoundException();
		}
		Customer cust = cRep.save(customer);
		return cust;

	}

	@Override
	public Customer deleteCustomer(Customer customer) throws CustomerNotFoundException {
		boolean check = cRep.existsById(customer.getCustomerId());
		if(!check)
		{
			//add argument while Exception handling
			throw new CustomerNotFoundException();
		}
		cRep.delete(customer);
		return customer;
	}

	@Override
	public Customer viewCustomer(int custid) throws CustomerNotFoundException {
		Optional<Customer> opt = cRep.findById(custid);
		if(!opt.isPresent()) {
			throw new CustomerNotFoundException();
		}
		Customer cust = opt.get();
		return cust;
	}

	@Override
	public List<Customer> viewAllCustomers(int packId) throws PackageNotFoundException {
		 Optional<Package1> optionalPack = pRep.findById(packId);
	        if (!optionalPack.isPresent()) {
	            throw new PackageNotFoundException();
	        }
	        Package1 pack = optionalPack.get();
	        List<Integer> ids = cRep.findByPack(packId);
	        //List<Customer>customers=cRep.findAllById(ids);
	        return null;
	}

//	@Override
//	public List<Customer> viewCustomerList(String routeId) throws RouteNotFoundException {
//		Optional<Route> opt = rRep.findById(routeId);
//		if(!opt.isPresent())
//		{
//			throw new RouteNotFoundException();
//		}
//		Route route = opt.get();
//		List<Integer> ids = cRep.findByRoute(route);
//		List<Customer> customers = cRep.findAllById(ids);
//		return null;
//	}


	@Override
	public List<Customer> viewCustomerList(String routeId) throws RouteNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	//to validate the 

}
