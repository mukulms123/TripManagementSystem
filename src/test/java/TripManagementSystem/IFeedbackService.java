package TripManagementSystem;

import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

import com.cg.tms.entities.Feedback;
import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.exceptions.FeedbackNotFoundException;
import com.cg.tms.repository.IFeedbackRepository;
import com.cg.tms.service.ICustomerService;
import com.cg.tms.service.IFeedbackServiceImpl;

@ExtendWith(MockitoExtension.class)
public class IFeedbackService {
	
	@Mock
	IFeedbackRepository feedbackRepository;

	@Mock
	ICustomerService customerService;

	@Spy
	@InjectMocks
	IFeedbackServiceImpl feedbackService;
	
	@Test
	public void addFeedback() {
		Feedback feedback = mock(Feedback.class);
		Feedback saved = mock(Feedback.class);
		when(feedbackRepository.save(feedback)).thenReturn(saved);
		Feedback result = feedbackService.addFeedback(feedback);
		Assertions.assertNotNull(result);
		Assertions.assertSame(saved, result);
		feedbackRepository.save(feedback);
	}
	
	@Test
	public void findByFeedbackId() throws FeedbackNotFoundException {
		int feedbackId = 23;
		Optional<Feedback> optional = Optional.empty();
		when(feedbackRepository.findById(feedbackId)).thenReturn(optional);
		Executable executable = () -> feedbackService.findByFeedbackId(feedbackId);
		Assertions.assertThrows(FeedbackNotFoundException.class, executable);
	}
	
	@Test
	public void findByCustomerId() throws CustomerNotFoundException {
		int customerId=1;
		Customer customer=mock(Customer.class);
		Feedback feedback=mock(Feedback.class);
		when(customerService.viewCustomer(customerId)).thenReturn(customer);
		when(feedbackRepository.findFeedbackByCustomer(customer)).thenReturn(feedback);
		Feedback result = feedbackService.findByCustomerId(customerId);
		Assertions.assertNotNull(result);
		Assertions.assertEquals(result, feedback);
	}
	
	@Test
	public void viewAllFeedbacks() {
		List<Feedback> allfeedbacks = mock(List.class);
		when(feedbackRepository.findAll()).thenReturn(allfeedbacks);
		List<Feedback> result = feedbackService.viewAllFeedbacks();
		Assertions.assertSame(allfeedbacks, result);
		verify(feedbackRepository).findAll();
	}

}
