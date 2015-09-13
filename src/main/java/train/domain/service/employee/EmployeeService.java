package train.domain.service.employee;

import java.util.List;

import train.domain.model.NhanVien;

public interface EmployeeService {
	NhanVien findOne(int Id);

	List<NhanVien> findAll();

	void register(NhanVien nhanvien);

	boolean modify(NhanVien nhanvien);

	boolean delete(int nhanvienId);

}
