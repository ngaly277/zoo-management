package fa.intern.mock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.intern.mock.bean.Account;
import fa.intern.mock.dao.AccountDAO;

@Service
public class AccountService {
	@Autowired
	private AccountDAO accountDAO;
	
	
	public void createAccountThroughAddNewStaff(String string) {
		accountDAO.createAccountThroughAddNewStaff(string);
	}
}
