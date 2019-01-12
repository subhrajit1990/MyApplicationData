package my.application.utils;

public class FailureException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String statusCode;
	private String StatusMessage;
	public String getStatusCode() {
		return statusCode;
	}
	
	public FailureException(Throwable cause) {
		super(cause);
	}
	
	public FailureException(Throwable cause, String code, String msg ) {
		super(cause);
		this.statusCode = code;
		this.StatusMessage = msg;
	}
	
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusMessage() {
		return StatusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		StatusMessage = statusMessage;
	}
	
	

}
