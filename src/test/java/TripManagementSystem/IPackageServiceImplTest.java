package TripManagementSystem;

import java.util.List;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.tms.exceptions.PackageNotFoundException;
import com.cg.tms.service.IPackageServiceImpl;

@ExtendWith({SpringExtension.class})
@DataJpaTest
@Import(IPackageServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class IPackageServiceImplTest {
	public  Package  addPackage(Package pack) {
		return null;
	}
	public  Package  deletePackage(int packageId) throws PackageNotFoundException {
		return null;
	}
	public  Package  searchPackage(int packageId) throws PackageNotFoundException {
		return null;
	}
	public  List<Package> viewAllPackages() {
		return null;
	}

}
