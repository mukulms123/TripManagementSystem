package TripManagementSystem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.tms.exceptions.RouteNotFoundException;
import com.cg.tms.service.IRouteServiceImpl;

@ExtendWith({SpringExtension.class})
@Import(IRouteServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class IRouteServiceImplTest {

	@Test 
	public void addRoute()
	{
	}
	
	@Test
	public void updateRoute() throws RouteNotFoundException
	{
	}
}
