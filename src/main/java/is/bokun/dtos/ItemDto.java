package is.bokun.dtos;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class ItemDto {

	public Long id;
	public String title;
	public String externalId;

    public List<String> flags = new ArrayList<>();
	
	public ItemDto() {}

    public ItemDto(Long id, String title) {
        this(id, title, "");
    }
    
    public ItemDto(Long id, String title, String externalId) {
        this.id = id;
        this.title = title;
        this.externalId = externalId;
        this.flags = null;
    }
    
    public ItemDto(Long id, String title, String externalId, List<String> flags) {
        this.id = id;
        this.title = title;
        this.externalId = externalId;
        this.flags = flags;
    }
	
	public ItemDto(Long id, String title, List<String> flags) {
		this.id = id;
		this.title = title;
        this.flags = flags;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

    public List<String> getFlags() {
        return flags;
    }

    public void setFlags(List<String> flags) {
        this.flags = flags;
    }
	
}
