package TripManagementSystem;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doReturn;

import java.util.List;
import java.util.Optional;
import com.cg.tms.entities.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.tms.exceptions.PackageNotFoundException;
import com.cg.tms.repository.IHotelRepository;
import com.cg.tms.repository.IPackageRepository;
import com.cg.tms.service.IPackageServiceImpl;


@ExtendWith({MockitoExtension.class})
public class IPackageServiceImplTest {
	
	@Mock
	IPackageRepository packageRepository;

	@Mock
	IHotelRepository hotelRepository;

	@Spy
	@InjectMocks
	IPackageServiceImpl packageService;
	
	@Test
	public  void addPackage() {
		Package1 pack = mock(Package1.class);
		Hotel hotel = pack.getHotel();
		Package1 saved = mock(Package1.class);
		when(hotelRepository.save(hotel)).thenReturn(hotel);
		when(packageRepository.save(pack)).thenReturn(saved);
		Package1 result = packageService.addPackage(pack);
		Assertions.assertSame(saved, result);
		verify(packageRepository).save(pack);
		verify(hotelRepository).save(hotel);
	}
	
	@Test
	public void deletePackage() throws PackageNotFoundException {
		int packageId = 3;
		Package1 pack = mock(Package1.class);
		doReturn(pack).when(packageService).searchPackage(packageId);
		Package1 result = packageService.deletePackage(packageId);
		Assertions.assertEquals(pack, result);
		verify(packageRepository).deleteById(packageId);
	}
	
	@Test
	public void searchPackage() throws PackageNotFoundException {
		int packageId = 2;
		Package1 pack = mock(Package1.class);
		Optional<Package1> optional = Optional.of(pack);
		when(packageRepository.findById(packageId)).thenReturn(optional);
		Package1 result = packageService.searchPackage(packageId);
		Assertions.assertEquals(pack, result);
		verify(packageRepository).findById(packageId);
	}
	
	@Test
	public void viewAllPackages() {
		List<Package1> packages = mock(List.class);
		when(packageRepository.findAll()).thenReturn(packages);
		List<Package1> result = packageService.viewAllPackages();
		Assertions.assertSame(packages, result);
		verify(packageRepository).findAll();
	}

}
