package TripManagementSystem;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.tms.service.IFeedbackServiceImpl;

@ExtendWith({SpringExtension.class})
@DataJpaTest
@Import(IFeedbackServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class IFeedbackService {
	
	@Test
	public void testAddFeedback() {}
	
	@Test
	public void testFindByFeedbackId() {}
	
	@Test
	public void testFindByCustomerId() {}
	
	@Test
	public void testViewAllFeedbacks() {}

}
