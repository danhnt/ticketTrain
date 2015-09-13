package train.domain.service.tintuc;

import java.util.List;

import train.domain.model.Tintuc;

public interface TintucService {
	Tintuc findOne(int Id);

	List<Tintuc> findAll();

	void register(Tintuc tintuc);

	boolean modify(Tintuc tintuc);

	boolean delete(int tintucId);

}
