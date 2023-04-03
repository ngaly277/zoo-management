package fa.intern.mock.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminTicketController {
	@RequestMapping(value="/admin/tickets/add", method = RequestMethod.GET)
	public String addTicket() {
		return "admin/ticketManagerEdit";
	}

	@RequestMapping(value="/admin/tickets/edit", method = RequestMethod.GET)
	public String editTicket(@RequestParam(required = true) Integer id, Model model) {
		// TODO: Check if ticket is exist before return to edit page.
		// If not exist, will return to main page.
		model.addAttribute("ticketId", id);
		return "admin/ticketManagerEdit";
	}

	@RequestMapping(value="/admin/tickets/delete", method = RequestMethod.POST)
	public String deleteTicket(@RequestParam(required = true) Integer id, Model model) {
		// TODO: Delete here.
		// Any result will return to main page.
		return String.format("redirect:/admin/tickets?q=%d", id);
	}

	@RequestMapping(value="/admin/tickets", method = RequestMethod.GET)
	public String showAllTickets(@RequestParam(required = false) String q, Model model) {
		// model.addAttribute("ticketTypeList", ticketTypeService.getAllTicketType());
		List<Integer> data = Arrays.asList(1, 2, 3, 4, 5, 6);
		model.addAttribute("searchQuery", q);
		model.addAttribute("data", data);
		return "admin/ticketManager";
	}
}
