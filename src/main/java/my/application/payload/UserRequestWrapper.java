package my.application.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequestWrapper {

	@JsonProperty("userRequest")
	private UserRequest commonRequest;

	public UserRequest getCommonRequest() {
		return commonRequest;
	}

	public void setCommonRequest(UserRequest commonRequest) {
		this.commonRequest = commonRequest;
	}
	
}
