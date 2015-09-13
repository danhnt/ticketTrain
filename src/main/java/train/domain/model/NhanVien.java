package train.domain.model;

import java.util.List;

public class NhanVien {
	private int id;
	private String ten;
	private String gioiTinh;
	private String diaChi;
	private String phone;
	private List<Tintuc> listTin;

	public List<Tintuc> getListTin() {
		return listTin;
	}

	public void setListTin(List<Tintuc> listTin) {
		this.listTin = listTin;
	}

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

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
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
