package my.application.entities;



public class AccountResponse {

	
	private String username ;
	private Integer point ;
	
	public AccountResponse(String username, Integer point ) {
		this.username = username ;
		this.point = point;
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}
	
	
	
}

