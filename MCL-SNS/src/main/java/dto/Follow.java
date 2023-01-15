package dto;

public class Follow {
	private String accountName;
	private String name;
	
	public Follow(String accountName, String name) {
		super();
		this.accountName = accountName;
		this.name = name;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
