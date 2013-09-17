package is.bokun.dtos.booking;

import is.bokun.dtos.ItemDto;

import java.util.*;

import javax.xml.bind.annotation.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "roomBooking")
@XmlAccessorType(XmlAccessType.FIELD)
public class RoomBookingDetailsDto {

	@XmlElement(name="id")
	public Long bookingId;
	@XmlTransient
	public String title;
	public ItemDto roomType;
	
	public int unitCount;
	public int unitPrice;
	
	@XmlElementWrapper
	@XmlElement(name="answer")
	public List<BookingAnswerDto> answers = new ArrayList<BookingAnswerDto>();
	
	@XmlElementWrapper(name = "extraBookings")
	@XmlElement(name="extraBooking")
	public List<ExtraBookingDetailsDto> extras = new ArrayList<ExtraBookingDetailsDto>();
}
