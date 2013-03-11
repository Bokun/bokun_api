package is.bokun.dtos.booking;

import is.bokun.dtos.PhotoDto;

public class ProductInfoDto extends BookingItemInfoDto {

	public String slug;
	public PhotoDto keyPhoto;
	
	public ProductInfoDto() {
		super();
	}
	
	public ProductInfoDto(Long id, String title, String slug) {
		super(id, title);
		this.slug = slug;
	}
	
}