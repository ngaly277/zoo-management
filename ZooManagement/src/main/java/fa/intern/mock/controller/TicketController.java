package fa.intern.mock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fa.intern.mock.service.TicketService;
import fa.intern.mock.service.TicketTypeService;

@Controller
public class TicketController {
	@Autowired
	private TicketTypeService ticketTypeService;
	
	@Autowired
	private TicketService ticketService;
	
	@RequestMapping("tickets")
	public String showTickets(Model model) {
		model.addAttribute("ticketTypeList", ticketTypeService.getAllTicketType());
		return "customer/tickets";
	}
	
	@RequestMapping("customer/{id}")
	public String showTicketByType(@PathVariable int id, Model model) {
		model.addAttribute("listTickets", ticketService.getAllTicketByType(id));
		return "add-ticket-card";
	}
}