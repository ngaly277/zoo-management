package fa.intern.mock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	//  -------------------update-------------------
//	@GetMapping("staffupdate/{idStaff}")
	@GetMapping( value =  "staffupdateform")
	public String showStaffUpdate(@RequestParam("id") int id, Model model) {
		System.out.println("update: "+id);
		List<Staff> staffById = staffService.getStaffById(id);
		List<StaffType> staffTypeList = staffService.getStaffTypeList();
		model.addAttribute("staffList",staffById);
		model.addAttribute("staffTypeList", staffTypeList);
		model.addAttribute("staffupdate", new Staff());
		return "admin/StaffUpdate";
	}
	
	@PostMapping("processupdatestaff")
	public String processUpdateStaff(Model model, @ModelAttribute("staffupdate") Staff staff, @RequestParam("staffTypeClicked") String staffTypeClicked) {
		staff.setIdStaffType(Integer.parseInt(staffTypeClicked));
		staffService.updateStaff(staff);
		return "redirect:/stafflist";
	}
	
//	@GetMapping("staffupdate")
//	public String showStaffUpdate(Model model) {
//		return "admin/StaffUpdate";
//	}
}
