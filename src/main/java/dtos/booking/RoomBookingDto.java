package dtos.booking;

import java.util.*;

import dtos.accommodation.RoomTypeDto;

public class RoomBookingDto {

	public Long id;
	
	public RoomTypeDto roomType;
	
	public String guestFirstName;
	public String guestLastName;

    public Date startDate;
    public Date endDate;
	
	public int adultCount;
	public int childCount;
	public String childAges;

	public String specialRequests;
	
	public List<AccommodationExtraBookingDto> extraBookings = new ArrayList<AccommodationExtraBookingDto>();
	
	public List<AccommodationAvailabilityBookingDto> availabilityBookings = new ArrayList<AccommodationAvailabilityBookingDto>();
	
    public List<AccommodationExtraBookingDto> getExtraBookings(boolean included) {
        List<AccommodationExtraBookingDto> list = new ArrayList<AccommodationExtraBookingDto>();
        for ( AccommodationExtraBookingDto ae : extraBookings ) {
            if ( (ae.extra.mandatory && included) || (!ae.extra.mandatory && !included) ) {
                list.add(ae);
            }
        }
        return list;
    }
}
