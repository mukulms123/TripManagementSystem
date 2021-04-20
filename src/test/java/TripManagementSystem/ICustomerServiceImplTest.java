package TripManagementSystem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.tms.service.ICustomerServiceImpl;

@ExtendWith({SpringExtension.class})
@DataJpaTest
@Import(ICustomerServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ICustomerServiceImplTest {

	@Test
	public void testAddCustomer() {}
	
	@Test
	public void testUpdateCustomer() {}
	
	@Test
	public void testDeleteCustomer() {}
	
	@Test
	public void testViewCustomer() {}
	
	@Test
	public void testViewAllCustomers() {}
	
	@Test
	public void testViewCustomerList(){}
}
