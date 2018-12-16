package my.application.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationRequestWrapper {

	@JsonProperty("requestBody")
	private CommonRequest commonRequest;

	public CommonRequest getCommonRequest() {
		return commonRequest;
	}

	public void setCommonRequest(CommonRequest commonRequest) {
		this.commonRequest = commonRequest;
	}
	
}
