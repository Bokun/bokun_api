package is.bokun.dtos.booking;

import java.util.*;

import org.codehaus.jackson.annotate.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RoomBookingDto {

	public Long id;
	
	public BookingItemInfoDto roomType;

    public Date startDate;
    public Date endDate;
	
    public int unitCount;
	
	public boolean unavailable;
	public int availabilityCount;
	public int roomPrice;
	public int extrasPrice;
	
	public List<ExtraBookingDto> extraBookings = new ArrayList<>();
	
	public List<AccommodationAvailabilityBookingDto> availabilityBookings = new ArrayList<>();
	
	@JsonIgnore
    public List<ExtraBookingDto> getExtraBookings(boolean included) {
        List<ExtraBookingDto> list = new ArrayList<>();
        for ( ExtraBookingDto ae : extraBookings ) {
            if ( (ae.included && included) || (!ae.included && !included) ) {
                list.add(ae);
            }
        }
        return list;
    }

}
