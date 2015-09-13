package train.domain.service.khachhang;

import java.util.List;

import train.domain.model.KhachHang;

public interface KhachHangService {
	KhachHang findOne(int Id);

	List<KhachHang> findAll();

	void register(KhachHang khachhang);

	boolean modify(KhachHang khachhang);

	boolean delete(int khachhangId);

}
