package com.cg.tms.util;

import org.springframework.stereotype.Component;

import com.cg.tms.dto.UserDetails;
import com.cg.tms.entities.User;

@Component
public class UserUtil {
	
	public UserDetails toDetailsUser(User user)
	{
		UserDetails userDetails = new UserDetails(user.getUserId(),user.getUserType(),user.getPassword());
		if(user.getUserType().equalsIgnoreCase("customer"))
		{userDetails.setCustomer(user.getCustomer());
		}
		else {
			userDetails.setAdmin(user.getAdmin());
		}
		return userDetails;
	}

}
