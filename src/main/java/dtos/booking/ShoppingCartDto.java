package dtos.booking;

import java.util.*;

public class ShoppingCartDto {

	public String sessionId;
	public String userUUID;
	public Date lastAccessDate;
	
	public List<AccommodationBookingDto> accommodationBookings = new ArrayList<AccommodationBookingDto>();

	
	public ShoppingCartDto() {}
}
