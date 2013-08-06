package is.bokun.dtos.booking;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import is.bokun.dtos.accommodation.AccommodationAvailabilityDto;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccommodationAvailabilityBookingDto {

	public Long id;
	
	public AccommodationAvailabilityDto availability;
	
	public int bookedPrice;
}
