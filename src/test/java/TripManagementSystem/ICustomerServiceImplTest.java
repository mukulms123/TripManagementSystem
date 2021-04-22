package TripManagementSystem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import com.cg.tms.entities.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.exceptions.PackageNotFoundException;
import com.cg.tms.exceptions.RouteNotFoundException;
import com.cg.tms.repository.ICustomerRepository;
import com.cg.tms.repository.IPackageRepository;
import com.cg.tms.repository.IRouteRepository;
import com.cg.tms.service.ICustomerServiceImpl;

@ExtendWith({MockitoExtension.class})
public class ICustomerServiceImplTest {

	@Mock
	ICustomerRepository customerRepository;
	
	@Mock
	IRouteRepository routeRepository;
	
	@Mock
	IPackageRepository packageRepository;
	
	@Spy
	@InjectMocks
	ICustomerServiceImpl customerService;
	
	@Test
	public void addCustomer() {
		Customer customer = new Customer();
		int customerId = 1;
		String customerName = "msp";
		String customerAddress = "chennai";
		customer.setAddress(customerAddress);
		customer.setCustomerName(customerName);
		customer.setCustomerId(customerId);
		when(customerRepository.save(customer)).thenReturn(customer);
		Customer result = customerService.addCustomer(customer);
		Assertions.assertNotNull(result);
		Assertions.assertEquals(customerName, result.getCustomerName());
		Assertions.assertEquals(customerAddress, result.getAddress());
		Assertions.assertEquals(customerId, result.getCustomerId());

	}
	
	@Test
	public void updateCustomer() throws CustomerNotFoundException{
		int customerId = 1;
		String customername = "Mohan";
		String customeraddress = "chennai";
		String customerpassword = "Msp23";
		Customer customer = mock(Customer.class);
		Optional<Customer> optional = Optional.of(customer);
		when(customerRepository.existsById(customer.getCustomerId())).thenReturn(true);
		when(customerRepository.save(customer)).thenReturn(customer);
		Customer result = customerService.updateCustomer(customer);
		Assertions.assertNotNull(result);
		Assertions.assertSame(result, customer);
	}

	@Test
	public void viewAllCustomers()throws PackageNotFoundException {
		int packageId=1;
		List<Integer>customers=mock(List.class);
		List<Customer>fetchedCustomer=mock(List.class);
		Customer customer=mock(Customer.class);
		Package1 pack =mock(Package1.class);
		Optional<Customer>optional=Optional.of(customer);
		Optional<Package1>optional1=Optional.of(pack);
		when(packageRepository.findById(packageId)).thenReturn(optional1);
		when(customerRepository.findByPack(pack)).thenReturn(customers);
		when(customerRepository.findAllById(customers)).thenReturn(fetchedCustomer);
		List<Customer>result=customerService.viewAllCustomers(packageId);
		Assertions.assertNotNull(result);
		Assertions.assertSame(result, fetchedCustomer);
	}
	
	@Test
	public void viewCustomerList() throws RouteNotFoundException {
		String routeId="R1";
		String routeFrom = "Delhi";
		String routeTo = "Kanpur";
		LocalDateTime departureTime = LocalDateTime.now();
		LocalDateTime arrivalTime = LocalDateTime.now();
		LocalDate doj = LocalDate.now();
		String PickupPoint = "Delhi";
		Double fare = 56.78;
		List<Integer>customers=mock(List.class);
		List<Customer>fetchedCustomer=mock(List.class);
		Customer customer=mock(Customer.class);
		Route route =mock(Route.class);
		Optional<Customer>optional=Optional.of(customer);
		Optional<Route>optional1=Optional.of(route);
		when(routeRepository.findById(routeId)).thenReturn(optional1);
		when(customerRepository.findByRoute(route)).thenReturn(customers);
	    when(customerRepository.findAllById(customers)).thenReturn(fetchedCustomer);
		List<Customer>result=customerService.viewCustomerList(routeId);
		Assertions.assertNotNull(result);
		Assertions.assertSame(result, fetchedCustomer);
	}
	
	public void deleteCustomer() throws CustomerNotFoundException {
		
	}
	public void viewCustomer() throws CustomerNotFoundException {
		
	}
}
