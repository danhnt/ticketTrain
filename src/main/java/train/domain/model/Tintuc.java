package train.domain.model;

public class Tintuc {
	private int maTin;
	private NhanVien maNv;
	private int nvId;

	 public NhanVien getMaNv() {
	 return maNv;
	 }
	
	 public void setMaNv(NhanVien maNv) {
	 this.maNv = maNv;
	 }

	private String ngayDang;
	private String tieuDe;
	private String noiDung;
	private String anh;

	public int getMaTin() {
		return maTin;
	}

	public void setMaTin(int maTin) {
		this.maTin = maTin;
	}

	public String getNgayDang() {
		return ngayDang;
	}

	public void setNgayDang(String ngayDang) {
		this.ngayDang = ngayDang;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public int getNvId() {
		return nvId;
	}

	public void setNvId(int nvId) {
		this.nvId = nvId;
	}

}
