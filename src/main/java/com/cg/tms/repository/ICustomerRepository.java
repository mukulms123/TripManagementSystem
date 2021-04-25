package com.cg.tms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.tms.entities.Customer;
import com.cg.tms.entities.Package1;
import com.cg.tms.entities.Route;
import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.exceptions.PackageNotFoundException;
import com.cg.tms.exceptions.RouteNotFoundException;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer>{

//	@Query("")
//	List<Integer> findByPack(@Param("pack") Package1 pack);
	
//	public Customer addCustomer(Customer customer);
//	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException;
//	public Customer deleteCustomer(Customer customer) throws CustomerNotFoundException;
//	public Customer viewCustomer(int custid) throws CustomerNotFoundException;
//	public List<Customer> viewAllCustomers(int packageId)throws PackageNotFoundException;
//	public List<Customer> viewCustomerList(int routeId)throws RouteNotFoundException;

//	@Query("select booking.user_id from Booking booking join booking.ticket tick  where tick.route_id=:route")
//    List<Integer> findByRoute(@Param("route")Route route);
	
	@Query("select booking.userId from Booking booking where booking.pack=:pack")
	public int findByPackage(@Param("pack") Package1 pack);
	
}
