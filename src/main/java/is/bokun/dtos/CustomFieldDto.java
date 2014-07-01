package is.bokun.dtos;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CustomFieldIntValueDto.class, name = "int"),
        @JsonSubTypes.Type(value = CustomFieldDoubleValueDto.class, name = "double"),
        @JsonSubTypes.Type(value = CustomFieldBooleanValueDto.class, name = "boolean"),
        @JsonSubTypes.Type(value = CustomFieldTextValueDto.class, name = "string"),
        @JsonSubTypes.Type(value = CustomFieldDateValueDto.class, name = "date")
})
@XmlType(name = "customField")
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class CustomFieldDto {
	
	public List<String> flags = new ArrayList<>();

    @JsonIgnore
    public abstract Object getObject();

}
