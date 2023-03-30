package fa.intern.mock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fa.intern.mock.service.TicketTypeService;

@Controller
public class TicketController {
	@Autowired
	private TicketTypeService ticketTypeService;
	
	@RequestMapping("tickets")
	public String showAllTickets(Model model) {
		model.addAttribute("ticketTypeList", ticketTypeService.getAllTicketType());
		return "customer/tickets";
	}
	
	@RequestMapping("add-tickets")
	public String showAddTicket(Model model) {
		return "customer/add-ticket-card";
	}
}
