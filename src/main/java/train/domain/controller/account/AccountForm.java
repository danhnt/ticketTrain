package train.domain.controller.account;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class AccountForm {

	@NotEmpty(message = "username require")
	@Size(max = 200, message = "username;200")
	private String username;

	private String password;

	/*
	 * // @NotEmpty(message = "confirmPassword") // @Size(min = 6, max = 200,
	 * message = "confirmPassword;6;200") // private String confirmPassword;
	 */
	private int permission;

	private int accountId;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
}
