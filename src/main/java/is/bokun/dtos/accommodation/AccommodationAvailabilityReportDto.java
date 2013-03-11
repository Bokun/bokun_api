package is.bokun.dtos.accommodation;

import java.util.Date;
import java.util.List;

import is.bokun.utils.DateUtils;

public class AccommodationAvailabilityReportDto {

	public Date checkInDate, checkOutDate;
	public List<AvailableRoomDto> availableRooms;
	public int nightCount;
	
	public int numberOfNights() {
		return DateUtils.getNightCount(checkInDate, checkOutDate);
	}
	
	public int lowestTotalPrice() {
		int price = -1;
		for (AvailableRoomDto room : availableRooms) {
			if ( price == -1 || room.totalPrice < price ) {
				price = room.totalPrice;
			}
		}
		return price;
	}
	
	public AvailableRoomDto findAvailableRoom(Long roomTypeId) {
		for (AvailableRoomDto room : availableRooms) {
			if ( room.roomType.id.equals(roomTypeId) ) {
				return room;
			}
		}
		return null;
	}
}