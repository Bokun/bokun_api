package is.bokun.dtos.booking;

import is.bokun.dtos.VendorDto;

import java.util.Date;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class ProductBookingDto {

	public Long id;
    public String productConfirmationCode;
	
	public Date creationDate;
	public Date lastModifiedDate;
    
    public String customerUuid;
    
    public String bookingStatus;

    public int totalPrice;

    @JsonIgnore
    public abstract VendorDto getVendor();
    
    @JsonIgnore
    public abstract Date getSortDate(); 
    
    @JsonIgnore
    public abstract String getProductCategory();
}
