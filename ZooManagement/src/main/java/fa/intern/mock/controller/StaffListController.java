package fa.intern.mock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import fa.intern.mock.bean.Staff;
import fa.intern.mock.bean.StaffType;
import fa.intern.mock.service.StaffService;

@Controller
public class StaffListController {
	
//	@GetMapping("stafflist")
//	public String showStaffList() {
//		return "admin/Staff";
//	}
	
	@Autowired
	private StaffService staffService;
	
	@GetMapping("stafflist")
	public String showStaffList(Model model) {
		List<Staff> staffList = staffService.getStaffList();
		List<StaffType> staffTypeList = staffService.getStaffTypeList();
		model.addAttribute("staffList", staffList);
		model.addAttribute("staffTypeList", staffTypeList);
		return "admin/Staff";
	}
}
