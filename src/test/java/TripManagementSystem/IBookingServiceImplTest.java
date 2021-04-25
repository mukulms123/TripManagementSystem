package TripManagementSystem;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.tms.entities.Booking;
import com.cg.tms.exceptions.BookingNotFoundException;
import com.cg.tms.service.IBookingService;
import com.cg.tms.service.IBookingServiceImpl;

@ExtendWith({SpringExtension.class})
@Import(IBookingServiceImpl.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class IBookingServiceImplTest {
	
	@Autowired
	private IBookingService bService;
	
	@Test
	public void makeBooking(){
	}
	
	@Test
	public void cancelBooking() throws BookingNotFoundException{
		
	}
	
	@Test
	public  void  viewBooking()throws BookingNotFoundException{
	Booking book = null;
	}
	
	@Test
	public void viewAllBookings(){
	
	}
}
