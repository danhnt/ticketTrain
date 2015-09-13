package train.domain.service.account;

import java.util.List;

import train.domain.model.Account;

public interface AccountService {
	Account findOne(int Id);

	List<Account> findAll();

	void register(Account acount);

	boolean modify(Account acount);

	boolean delete(int accountId);

	boolean checklogin(Account account);
}
