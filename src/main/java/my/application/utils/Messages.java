package my.application.utils;

public enum Messages {
PERSISTANCEERROR("100","Error in processing request"),
NODATA("100","No Data or record found"),
SERVICETIMEEDOUT("560","TImed out..please try again after some time"),
SUCCESS("0","SUCCESS");

	
	private final String Code;
	private final String Message;
	
	Messages(String id, String msg){
		this.Code =id;
		this.Message = msg;
	}

	public String getCode() {
		return Code;
	}

	public String getMessage() {
		return Message;
	}
	
}
