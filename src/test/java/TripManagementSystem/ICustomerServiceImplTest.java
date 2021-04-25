package TripManagementSystem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.service.ICustomerServiceImpl;

@ExtendWith({SpringExtension.class})
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(ICustomerServiceImpl.class)
public class ICustomerServiceImplTest {
	
	@Test
	public void addCustomer() {
	}
	
	@Test
	public void updateCustomer() throws CustomerNotFoundException{
	}

	public void deleteCustomer() throws CustomerNotFoundException {
		
	}
	public void viewCustomer() throws CustomerNotFoundException {
		
	}
}
