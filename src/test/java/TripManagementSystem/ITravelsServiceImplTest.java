package TripManagementSystem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.tms.service.ITravelsServiceImpl;

@ExtendWith({SpringExtension.class})
@DataJpaTest
@Import(ITravelsServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ITravelsServiceImplTest {

	@Test
	public void testAddTravels() {
	}
	
	@Test
	public void testUpdateTravels() {
	}
	
	@Test
	public void testRemoveTravels() {
	}
	
	@Test
	public void testSearchTravels() {
	}
	
	@Test
	public void testViewTravels() {
	}
}
