package fa.intern.mock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fa.intern.mock.bean.BillDetail;
import fa.intern.mock.service.BillDetailService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BillDetailController {
	@Autowired
	private BillDetailService billDetailService;
	
	@RequestMapping("/viewBillDetail")
	public String showViewInventory(Model model) {
		List<BillDetail> list = billDetailService.getAllBillDetail();
		model.addAttribute("billDetail", list);
		return "admin/Bill";
	}
	
	@RequestMapping("/SearchBillDetail")
	public String showSearchInventory(HttpServletRequest request, Model model) {
		String op = request.getParameter("op");
		String search = request.getParameter("search");
		System.out.print(op + "---" + search);
		
		List<BillDetail> list = billDetailService.getBillDetailByOption(op, search);
		model.addAttribute("billDetail", list);
		return "admin/Bill";
	}
	
	@RequestMapping("/deleteBillDetail")
	public String deleteInventory(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		billDetailService.deleteBillDetail(Integer.parseInt(id));
		return "admin/Bill";
	}
}
