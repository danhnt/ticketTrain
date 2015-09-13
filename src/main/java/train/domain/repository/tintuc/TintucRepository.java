package train.domain.repository.tintuc;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import train.domain.model.Tintuc;

public interface TintucRepository {

	public List<Tintuc> listTintuc();

	public void register(Tintuc tintuc);

	public boolean modify(Tintuc tintuc);

	public boolean delete(@Param("tintucId") int tintucId);

	public Tintuc findOne(@Param("tintucId") int tintucId);

}
