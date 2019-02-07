package repository.entity;

public class LoginUserDto {

	private String LoginId="";
	private String LoginPSD="";

	public String getLoginId() {
		return LoginId;
	}

	public void setLoginId(String loginId) {
		LoginId = loginId;
	}

	public String getLoginPSD() {
		return LoginPSD;
	}

	public void setLoginPSD(String loginPSD) {
		LoginPSD = loginPSD;
	}
	
public String kumiawase() {
	
	StringBuffer buffer=new StringBuffer();
	buffer.append(LoginId);
	buffer.append(";");
	buffer.append(LoginPSD);
	buffer.append(";");
	return buffer.toString();
	
}	

}
