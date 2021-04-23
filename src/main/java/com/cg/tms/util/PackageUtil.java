package com.cg.tms.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;
import com.cg.tms.dto.PackageDetails;
import com.cg.tms.entities.Booking;
import com.cg.tms.entities.Hotel;
import com.cg.tms.entities.Package1;

@Component
public class PackageUtil {

	public PackageDetails toDetailsPackage(Package1 pack)
	{
		PackageDetails packageDetails = new PackageDetails(pack.getPackageId(), pack.getPackageName(), pack.getPackageDescription(), pack.getPackageType(), pack.getPackageCost());
		Booking book = pack.getBooking();
		Hotel hot = pack.getHotel();
//		if(book!=null){
//			packageDetails.setBook(book);
//		}
		if(hot!=null) {
			packageDetails.setHotelId(hot.getHotelId());
//			packageDetails.setHotelName(hot.getHotelName());
//			packageDetails.setHotelType(hot.getHotelType());
//			packageDetails.setHotelDescription(hot.getHotelDescription());
//			packageDetails.setAddress(hot.getAddress());
//			packageDetails.setRent(hot.getRent());
//			packageDetails.setStatus(hot.getStatus());
			
		}
		if(book!=null) {
			packageDetails.setBookingId(book.getBookingId());
		}
		return packageDetails;
	}
	
	
	public List<PackageDetails> toDetailsPackages(Collection<Package1> packages) {

        List<PackageDetails> packs = new ArrayList<>();
        for (Package1 pack : packages) {

            PackageDetails packageDetails = toDetailsPackage(pack);
            packs.add(packageDetails);
        }

        return packs;

    }
}
