package fa.intern.mock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fa.intern.mock.bean.Account;
import fa.intern.mock.dao.AccountDAO;
import fa.intern.mock.service.AccountService;

@Controller
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AccountDAO accountDAO;
	
	
		
	
}
