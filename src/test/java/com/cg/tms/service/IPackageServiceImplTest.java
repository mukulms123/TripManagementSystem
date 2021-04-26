package com.cg.tms.service;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.tms.entities.Booking;
import com.cg.tms.entities.Customer;
import com.cg.tms.entities.Hotel;
import com.cg.tms.entities.Package1;
import com.cg.tms.exceptions.PackageNotFoundException;
import com.cg.tms.service.IPackageServiceImpl;

@ExtendWith({ SpringExtension.class })
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@Import(IPackageServiceImpl.class)
public class IPackageServiceImplTest {

	@Autowired
	private IPackageService pService;

	@Autowired
	private EntityManager em;

	@Test
	public void addPackage() {
		Customer cust = new Customer("nandita", "nan123", "delhi", "9810783465", "mail2nanditarao@gmail.com");
		em.persist(cust);
		Booking book = new Booking("business class", "this is first class", "booking1", LocalDate.now(),
				cust.getCustomerId());
		Hotel hotel = new Hotel("hayat", "luxury", "5 star hotel", "delhi", 6000.0, "Booked");
		Package1 pack = new Package1("package1", "luxury package", "luxury", 7080.9);
		pack.setBooking(book);
		pack.setHotel(hotel);
		Package1 packFound = pService.addPackage(pack);
		Assertions.assertEquals(packFound.getPackageName(), pack.getPackageName());
	}

	@Test
	public void deletePackage() throws PackageNotFoundException {
		Package1 pack = new Package1("package1", "luxury package", "luxury", 7080.9);
		em.persist(pack);
		Package1 packFound = pService.deletePackage(pack.getPackageId());
		Assertions.assertEquals(packFound.getPackageName(), pack.getPackageName());
	}

	@Test
	public void searchPackage() throws PackageNotFoundException {
		Package1 pack = new Package1("package1", "luxury package", "luxury", 7080.9);
		em.persist(pack);
		Package1 packFound = pService.searchPackage(pack.getPackageId());
		Assertions.assertEquals(packFound.getPackageName(), pack.getPackageName());
	}

	@Test
	public void viewAllPackages() {
		Package1 pack = new Package1("package1", "luxury package", "luxury", 7080.9);
		em.persist(pack);
		List<Package1> packFound = pService.viewAllPackages();
		Assertions.assertNotNull(packFound);
	}
}
