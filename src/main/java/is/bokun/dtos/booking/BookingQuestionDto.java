package is.bokun.dtos.booking;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

public class BookingQuestionDto {

	public String type;
	
	public String question;
	public boolean selectFromOptions;
	public String defaultAnswer;
	
	public List<String> options = new ArrayList<String>();
	
	@JsonIgnore
	public boolean isOfType(String t) {
		return t.equals(type);
	}
	
	@JsonIgnore
	public String getQuestionType() {
		return type;
	}
	
	public Long getId() {
		return null;
	}
}