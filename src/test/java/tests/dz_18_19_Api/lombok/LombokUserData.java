package tests.dz_18_19_Api.lombok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import tests.dz_18_19_Api.models.User;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LombokUserData {
    @JsonProperty("data")
    private User user;
}
