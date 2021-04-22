package TripManagementSystem;

import java.time.LocalDate;

import java.util.List;

import java.util.Optional;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cg.tms.entities.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.tms.entities.Booking;
import com.cg.tms.exceptions.BookingNotFoundException;
import com.cg.tms.repository.IBookingRepository;
import com.cg.tms.repository.IPaymentDetailsRepository;
import com.cg.tms.repository.ITicketDetailsRepository;
import com.cg.tms.service.IBookingServiceImpl;

@ExtendWith(MockitoExtension.class)
public class IBookingServiceImplTest {

	@Mock
	IBookingRepository bRep;

	@Mock
	ITicketDetailsRepository tRep; 
	
	@Mock
	IPaymentDetailsRepository pRep;
	
	@Spy
	@InjectMocks
	IBookingServiceImpl service;
	
	@Test
	public void makeBooking(){
		String ticketId="ticket1";
		Booking book = mock(Booking.class);
		book.setBookingDate(LocalDate.now());
		book.setBookingTitle("abc");
		book.setBookingType("train");
		book.setDescription("yo");
		book.setUserId(23);
		book.setPack(new Package1("package1","def","packing",345.6));
		when(bRep.save(book)).thenReturn(book);
		Booking result = service.makeBooking(book);
		Assertions.assertNotNull(result);
		Assertions.assertSame(result,book);
		verify(bRep).save(book);
	}
	
	@Test
	public void cancelBooking() throws BookingNotFoundException{
		int id = 1;
		Booking book = mock(Booking.class);
		Optional<Booking> optional = Optional.of(book);
		when(bRep.findById(id)).thenReturn(optional);
		doNothing().when(bRep).delete(book);
		Booking result = service.cancelBooking(id);
		Assertions.assertNotNull(optional);
		Assertions.assertEquals(book, result);
		verify(bRep).delete(result);
	}
	
	@Test
	public  void  viewBooking()throws BookingNotFoundException{
		int id = 1;
		Booking book = mock(Booking.class);
		Optional<Booking> optional = Optional.of(book);
		when(bRep.findById(id)).thenReturn(optional);
		Booking result = service.viewBooking(id);
		Assertions.assertEquals(result, book);
		verify(bRep).findById(id);
	}
	
	@Test
	public void viewAllBookings(){
		List<Booking> bookings = mock(List.class);
		when(bRep.findAll()).thenReturn(bookings);
		List<Booking> result = bRep.findAll();
		Assertions.assertSame(bookings, result);
		verify(bRep).findAll();
	}
}
