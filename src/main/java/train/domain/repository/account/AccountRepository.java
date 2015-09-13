package train.domain.repository.account;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import train.domain.model.Account;

public interface AccountRepository {

	public boolean checklogin(String username, String password);

	public List<Account> listAccount();

	public void register(Account account);

	public boolean modify(Account account);

	public boolean delete(@Param("accountId") int accountId);

	public Account findOne(@Param("accountId") int accountId);

}
