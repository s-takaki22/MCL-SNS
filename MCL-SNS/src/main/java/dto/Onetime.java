package dto;

public class Onetime {
	private String mail;
	private String code;
	private String time;
	
	public Onetime(String mail, String code, String time) {
		super();
		this.mail = mail;
		this.code = code;
		this.time = time;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
