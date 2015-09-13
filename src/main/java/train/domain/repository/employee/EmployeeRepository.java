package train.domain.repository.employee;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import train.domain.model.NhanVien;

public interface EmployeeRepository {

	public List<NhanVien> listEmployee();

	public void register(NhanVien nhanvien);

	public boolean modify(NhanVien nhanvien);

	public boolean delete(@Param("nhanvienId") int nhanvienId);

	public NhanVien findOne(@Param("nhanvienId") int nhanvienId);

}
