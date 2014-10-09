package is.bokun.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ogg on 2.10.2014.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "LinkedExternalCustomer")
@XmlAccessorType(XmlAccessType.FIELD)
public class LinkedExternalCustomerDto {

    public Long systemConfigId;
    public String systemType;
    public List<String> flags = new ArrayList<>();

    public String externalCustomerId;
    public String externalCustomerTitle;

    public Long getSystemConfigId() {
        return systemConfigId;
    }

    public void setSystemConfigId(Long systemConfigId) {
        this.systemConfigId = systemConfigId;
    }

    public String getSystemType() {
        return systemType;
    }

    public void setSystemType(String systemType) {
        this.systemType = systemType;
    }

    public List<String> getFlags() {
        return flags;
    }

    public void setFlags(List<String> flags) {
        this.flags = flags;
    }

    public String getExternalCustomerId() {
        return externalCustomerId;
    }

    public void setExternalCustomerId(String externalCustomerId) {
        this.externalCustomerId = externalCustomerId;
    }

    public String getExternalCustomerTitle() {
        return externalCustomerTitle;
    }

    public void setExternalCustomerTitle(String externalCustomerTitle) {
        this.externalCustomerTitle = externalCustomerTitle;
    }
}
