package train.domain.service.employee;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import train.domain.model.Account;
import train.domain.model.NhanVien;
import train.domain.repository.account.AccountRepository;
import train.domain.repository.employee.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImp implements EmployeeService {

	@Inject
	EmployeeRepository employeeRepository;

	public NhanVien findOne(int Id) {
		return employeeRepository.findOne(Id);
	}

	public List<NhanVien> findAll() {
		return employeeRepository.listEmployee();
	}

	public void register(NhanVien nhanvien) {
		employeeRepository.register(nhanvien);
	}

	public boolean modify(NhanVien nhanvien) {
		return employeeRepository.modify(nhanvien);
	}

	public boolean delete(int nhanvienId) {
		return employeeRepository.delete(nhanvienId);
	}

}
