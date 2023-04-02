package fa.intern.mock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping(value = "staffupdate/{idStaff}")
	public String showStaffUpdate(@PathVariable int idStaff, Model model) {
		System.out.println("update: "+idStaff);
		List<Staff> staffById = staffService.getStaffById(idStaff);
		model.addAttribute("staff",staffById);
		return "admin/StaffUpdate";
	}
	
	@PostMapping("staffsearch")
	public String showStaffSearch(Model model, @RequestParam("searchString") String searchString) {
		List<Staff> staffSeach = staffService.getStaffSearch(searchString);
		List<StaffType> staffTypeList = staffService.getStaffTypeList();
		model.addAttribute("staffList", staffSeach);
		model.addAttribute("staffTypeList", staffTypeList);
		return "admin/Staff";
	}
	
//	@GetMapping("staffupdate")
//	public String showStaffUpdate(Model model) {
//		return "admin/StaffUpdate";
//	}
}
