package fa.intern.mock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fa.intern.mock.bean.Account;
import fa.intern.mock.service.AccountService;

@Controller
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("login")
	public String showLoginPage(Model model) {
		System.out.println("controller");
		model.addAttribute("account", new Account());
		return "customer/login";
	}
}
