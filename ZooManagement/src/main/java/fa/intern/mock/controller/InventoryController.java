package fa.intern.mock.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fa.intern.mock.bean.Inventory;
import fa.intern.mock.service.InventoryService;

@Controller
public class InventoryController {
	@Autowired
	private InventoryService inventoryService;
	
	@RequestMapping("viewInventory")
	public String showViewInventory(Model model) {
		List<Inventory> list = inventoryService.getAllInventory();
		model.addAttribute("inventory", list);
		return "admin/Inventory";
	}
}
