package train.domain.repository.khachhang;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import train.domain.model.KhachHang;

public interface KhachhangRepository {

	public List<KhachHang> listkhachHang();

	public void register(KhachHang khachhang);

	public boolean modify(KhachHang khachhang);

	public boolean delete(@Param("khachhangId") int khachhangId);

	public KhachHang findOne(@Param("khachhangId") int khachhangId);

}
