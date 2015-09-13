package train.domain.controller.employee;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class EmployeeForm {

	private int id;
	@NotEmpty(message = "Employee Name require")
	@Size(max = 200, message = "Name;200")
	private String ten;
	private String gioiTinh;
	private boolean bgioiTinh;
	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public boolean isBgioiTinh() {
		return bgioiTinh;
	}

	public void setBgioiTinh(boolean bgioiTinh) {
		this.bgioiTinh = bgioiTinh;
	}

	private String diaChi;
	@NotEmpty(message = "Phone require")
	@Size(min=10,max = 12, message = "phone;10,12")
	private String phone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
