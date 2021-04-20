package TripManagementSystem;

import java.util.List;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.tms.entities.Feedback;
import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.exceptions.FeedbackNotFoundException;
import com.cg.tms.service.IFeedbackServiceImpl;

@ExtendWith({SpringExtension.class})
@DataJpaTest
@Import(IFeedbackServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class IFeedbackService {
	public Feedback  addFeedback(Feedback feedback) {
		return null;
	}
	public Feedback   findByFeedbackId(int feedbackId) throws FeedbackNotFoundException {
		return null;
	}
	public Feedback   findByCustomerId(int customerId) throws CustomerNotFoundException {
		return null;
	}
	public List<Feedback> viewAllFeedbacks() {
		return null;
	}

}
