package train.domain.controller.khachhang;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class KhachHangForm {
	private int khachHangId;

	@NotEmpty(message = "Employee Name require")
	@Size(max = 200, message = "Name;200")
	private String ten;
	@NotEmpty(message = "email require")
	private String email;
	@NotEmpty(message = "Phone require")
	@Size(min = 10, max = 12, message = "phone;10,12")
	private String phone;
	@NotEmpty(message = "cmt require")
	private String cmt;

	public int getKhachHangId() {
		return khachHangId;
	}

	public void setKhachHangId(int khachHangId) {
		this.khachHangId = khachHangId;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCmt() {
		return cmt;
	}

	public void setCmt(String cmt) {
		this.cmt = cmt;
	}
}
