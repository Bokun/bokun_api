package is.bokun.dtos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author Olafur Gauti Gudmundsson
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerPasswordChangeDto {

    public String oldPassword, newPassword;

    public CustomerPasswordChangeDto() {}

    public CustomerPasswordChangeDto(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
