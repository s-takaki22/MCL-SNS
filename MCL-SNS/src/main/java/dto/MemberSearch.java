package dto;

public class MemberSearch {
	private String accountName;
	
	public MemberSearch(String accountName) {
		super();
		this.accountName = accountName;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
}
