package TripManagementSystem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.tms.service.IBookingServiceImpl;

@ExtendWith({SpringExtension.class})
@DataJpaTest
@Import(IBookingServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class IBookingServiceImplTest {

	@Test
	public  void  testMakeBooking(){}
	
	@Test
	public  void  testCancelBooking()
	{}
	
	@Test
	public  void  testViewBooking()
	{}
	
	@Test
	public void testViewAllBookings(){}
}
