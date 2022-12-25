package dto;

public class Register {
	private String mail;
	private String pass;
	private String nickName;
	private String lastName;
	private String firstName;
	private String birthday;
	private String schoolNamel;
	private String salt;
	private String hashedPassWord;

	public Register(String mail, String pass, String nickName, String lastName, String firstName, String birthday,
			String schoolNamel, String salt, String hashedPassWord) {
		super();
		this.mail = mail;
		this.pass = pass;
		this.nickName = nickName;
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthday = birthday;
		this.schoolNamel = schoolNamel;
		this.salt = salt;
		this.hashedPassWord = hashedPassWord;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSchoolNamel() {
		return schoolNamel;
	}

	public void setSchoolNamel(String schoolNamel) {
		this.schoolNamel = schoolNamel;
	}
	
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getHashedPassWord() {
		return hashedPassWord;
	}

	public void setHashedPassWord(String hashedPassWord) {
		this.hashedPassWord = hashedPassWord;
	}
}