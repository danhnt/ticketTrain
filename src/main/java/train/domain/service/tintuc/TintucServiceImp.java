package train.domain.service.tintuc;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import train.domain.model.Tintuc;
import train.domain.repository.tintuc.TintucRepository;

@Service
@Transactional
public class TintucServiceImp implements TintucService {

	@Inject
	TintucRepository tintucRepository;

	public Tintuc findOne(int Id) {
		return tintucRepository.findOne(Id);
	}

	public List<Tintuc> findAll() {
		return tintucRepository.listTintuc();
	}

	public void register(Tintuc tintuc) {
		tintucRepository.register(tintuc);
	}

	public boolean modify(Tintuc tintuc) {
		return tintucRepository.modify(tintuc);
	}

	public boolean delete(int nhanvienId) {
		return tintucRepository.delete(nhanvienId);
	}

}
