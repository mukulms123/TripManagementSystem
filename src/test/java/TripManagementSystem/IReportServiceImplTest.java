package TripManagementSystem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.tms.service.IReportServiceImpl;

@ExtendWith({SpringExtension.class})
@DataJpaTest
@Import(IReportServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class IReportServiceImplTest {

	@Test
	public void testAddReport() {}
	
	@Test
	public void testDeleteReport() {}
	
	@Test
	public void testViewReport() {}
	
	@Test
	public void testViewAllReports() {}
}
