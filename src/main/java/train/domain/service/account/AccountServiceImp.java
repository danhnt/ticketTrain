package train.domain.service.account;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import train.domain.model.Account;
import train.domain.repository.account.AccountRepository;

@Service
@Transactional
public class AccountServiceImp implements AccountService {

	@Inject
	AccountRepository accountRepository;

	public List<Account> findAll() {
		return accountRepository.listAccount();
	}

	public void register(Account acount) {
		accountRepository.register(acount);
	}

	public boolean modify(Account acount) {
		return accountRepository.modify(acount);
	}

	public boolean delete(int accountId) {
		return accountRepository.delete(accountId);

	}

	public boolean checklogin(Account account) {
		return accountRepository.checklogin(account.getUsername(),
				account.getPassword());
	}

	public Account findOne(int Id) {
		return accountRepository.findOne(Id);
	}

}
