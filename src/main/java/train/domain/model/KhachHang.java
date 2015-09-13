package train.domain.model;

public class KhachHang {
	private int khachHangId;
	private String ten;
	private String email;
	private String phone;
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
