package TripManagementSystem;

import java.util.List;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.tms.entities.Customer;
import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.exceptions.PackageNotFoundException;
import com.cg.tms.exceptions.RouteNotFoundException;
import com.cg.tms.service.ICustomerServiceImpl;

@ExtendWith({SpringExtension.class})
@DataJpaTest
@Import(ICustomerServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ICustomerServiceImplTest {

	public Customer addCustomer(Customer customer) {
		return null;
	}
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
		return null;
	}
	public Customer deleteCustomer(Customer customer) throws CustomerNotFoundException {
		return null;
	}
	public Customer viewCustomer(int custid) throws CustomerNotFoundException {
		return null;
	}
	public List<Customer> viewAllCustomers(int packageId)throws PackageNotFoundException {
		return null;
	}
	public List<Customer> viewCustomerList(int routeId)throws RouteNotFoundException {
		return null;
	}
}
