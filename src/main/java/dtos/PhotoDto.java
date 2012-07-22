package dtos;

import com.codiform.moo.annotation.Optionality;
import com.codiform.moo.annotation.Property;

public class PhotoDto {

	public Long id;
	
	@Property(optionality=Optionality.OPTIONAL)
	public String path;
	
	public PhotoDto() {}
}
