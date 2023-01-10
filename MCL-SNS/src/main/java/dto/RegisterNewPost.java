package dto;

public class RegisterNewPost {
	private String nickName;
	private String note;

	public RegisterNewPost(String nickName, String note) {
		super();
		this.nickName = nickName;
		this.note = note;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
}