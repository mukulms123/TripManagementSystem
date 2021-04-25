package TripManagementSystem;

import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.tms.entities.Travels;
import com.cg.tms.exceptions.TravelsNotFoundException;
import com.cg.tms.service.ITravelsServiceImpl;

@ExtendWith({SpringExtension.class})
@DataJpaTest
@Import(ITravelsServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ITravelsServiceImplTest {

	public Travels  addTravels(Travels travels) {
		return null;
	}
	public Travels  updateTravels(Travels travels) throws TravelsNotFoundException {
		return null;
	}
	public Travels  removeTravels(int travelsId) throws TravelsNotFoundException {
		return null;
	}
	public Travels searchTravels(int travelsId) throws TravelsNotFoundException {
		return null;
	}
	public  List<Travels>  viewTravels() {
		return null;
	}
}
