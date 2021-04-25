package TripManagementSystem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.exceptions.FeedbackNotFoundException;
import com.cg.tms.service.IFeedbackServiceImpl;

@ExtendWith({SpringExtension.class})
@DataJpaTest
@Import(IFeedbackServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class IFeedbackService {
		
	@Test
	public void addFeedback() {
	}
	
	@Test
	public void findByFeedbackId() throws FeedbackNotFoundException {
	}
	
	@Test
	public void findByCustomerId() throws CustomerNotFoundException {
	}
	
	@Test
	public void viewAllFeedbacks() {
	}

}
