package TripManagementSystem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.tms.exceptions.PackageNotFoundException;
import com.cg.tms.service.IPackageServiceImpl;

@ExtendWith({SpringExtension.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@Import(IPackageServiceImpl.class)
public class IPackageServiceImplTest {
		
	@Test
	public  void addPackage() {
		
	}
	
	@Test
	public void deletePackage() throws PackageNotFoundException {
		
	}
	
	@Test
	public void searchPackage() throws PackageNotFoundException {
		
	}
	
	@Test
	public void viewAllPackages() {
	}
}
