package is.bokun.dtos.carrental;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CarTypeInfoDto {

	public Long id;
	public String title;
	public String exampleCarModel;
	
	public CarTypeInfoDto() {}
	
	public CarTypeInfoDto(Long id, String title) {
		this.id = id;
		this.title = title;
	}
}