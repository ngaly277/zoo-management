package fa.intern.mock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.intern.mock.bean.Account;
import fa.intern.mock.dao.AccountDAO;

@Service
public class AccountService {
	@Autowired
	private AccountDAO accountDAO;
	
	public Account getAccount(String username) {
		return accountDAO.getAccount(username);
	}
	
	public void createAccountThroughAddNewStaff(String string) {
		accountDAO.createAccountThroughAddNewStaff(string);
	}
}
