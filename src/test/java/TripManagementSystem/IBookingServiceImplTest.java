package TripManagementSystem;

import java.util.List;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.tms.entities.Booking;
import com.cg.tms.exceptions.BookingNotFoundException;
import com.cg.tms.service.IBookingServiceImpl;

@ExtendWith({SpringExtension.class})
@DataJpaTest
@Import(IBookingServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class IBookingServiceImplTest {

	public  Booking  makeBooking(Booking booking){
		return null;
	}
	public  Booking  cancelBooking(int bookingId) throws BookingNotFoundException{
		return null;
	}
	public  Booking  viewBooking(int bookingId)throws BookingNotFoundException{
		return null;
	}
	public List<Booking> viewAllBookings(){
		return null;
	}
}
