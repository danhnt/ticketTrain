package train.domain.service.khachhang;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import train.domain.model.KhachHang;
import train.domain.repository.khachhang.KhachhangRepository;

@Service
@Transactional
public class KhachHangServiceImp implements KhachHangService {

	@Inject
	KhachhangRepository khachahngRepository;

	public KhachHang findOne(int Id) {
		return khachahngRepository.findOne(Id);
	}

	public List<KhachHang> findAll() {
		return khachahngRepository.listkhachHang();
	}

	public void register(KhachHang khachhang) {
		khachahngRepository.register(khachhang);
	}

	public boolean modify(KhachHang khachhang) {
		return khachahngRepository.modify(khachhang);
	}

	public boolean delete(int khachhangId) {
		return khachahngRepository.delete(khachhangId);
	}

}
