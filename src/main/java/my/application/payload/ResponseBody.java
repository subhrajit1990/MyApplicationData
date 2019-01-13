package my.application.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseBody {

	
	@JsonProperty("response")
	private Object respnse;
	
	
	@JsonIgnore
	private String responseStatus;
	
	
	@JsonIgnore
	private String responseMessage;


	public Object getRespnse() {
		return respnse;
	}


	public void setRespnse(Object respnse) {
		this.respnse = respnse;
	}


	public String getResponseStatus() {
		return responseStatus;
	}


	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}


	public String getResponseMessage() {
		return responseMessage;
	}


	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	
	
}
