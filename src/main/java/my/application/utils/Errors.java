package my.application.utils;

public enum Errors {
PERSISTANCEERROR("100","Error in processing request"),
NODATA("100","No Data or record found"),
SERVICETIMEEDOUT("560","TImed out..please try again after some time");
	
	private final String errorCode;
	private final String errorMessage;
	
	Errors(String id, String msg){
		this.errorCode =id;
		this.errorMessage = msg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	
}
