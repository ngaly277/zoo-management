package fa.intern.mock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fa.intern.mock.bean.Account;
import fa.intern.mock.dao.AccountDAO;
import fa.intern.mock.service.AccountService;

@Controller
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AccountDAO accountDAO;
	
	@RequestMapping("login")
	public String showLoginPage(Model model) {
		model.addAttribute("account", new Account());
		return "admin/Login";
	}
	
	@PostMapping("processLogin")
	public String show(Model model, @ModelAttribute("account") Account account) {
		System.out.println(account.getUsername()+"-"+account.getPassword());
		Account a = accountService.getAccount(account.getUsername());
		System.out.println(a+"?");
		if(account.getUsername().equals(a.getUsername()) && account.getPassword().equals(a.getPassword())) {
			return "admin/admin";
		}
		else {
			return"admin/Login";
		}
		
	}
}
