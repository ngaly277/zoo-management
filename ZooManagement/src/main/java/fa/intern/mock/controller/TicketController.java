package fa.intern.mock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fa.intern.mock.service.TicketService;

@Controller
public class TicketController {
	@Autowired
	private TicketService ticketService;
	
	@RequestMapping("tickets")
	public String showAllTickets(Model model) {
		return "customer/tickets";
	}
	
	@RequestMapping("add-tickets")
	public String showAddTicket(Model model) {
		return "customer/add-ticket-card";
	}
}
