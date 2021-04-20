package TripManagementSystem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.tms.service.IPackageServiceImpl;

@ExtendWith({SpringExtension.class})
@DataJpaTest
@Import(IPackageServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class IPackageServiceImplTest {
	
	@Test
	public void testAddPackage() {}
	
	@Test
	public void testDeletePackage() {}
	
	@Test
	public void testSearchPackage() {}
	
	@Test
	public void testViewAllPackages() {}

}
