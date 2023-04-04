package fa.intern.mock.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fa.intern.mock.bean.Ticket;
import fa.intern.mock.bean.TicketType;
import fa.intern.mock.service.TicketService;
import fa.intern.mock.service.TicketTypeService;

@Controller
public class AdminTicketController {
	@Autowired
	private TicketTypeService ticketTypeService;
	
	@Autowired
	private TicketService ticketService;
	
	@RequestMapping(value="/admin/tickets/add", method = RequestMethod.GET)
	public String addTicket(Model model) {
		List<TicketType> data = ticketTypeService.getAllTicketType();
		model.addAttribute("ticketTypeList", data);
		return "admin/ticketManagerEdit";
	}

	@RequestMapping(value="/admin/tickets/edit", method = RequestMethod.GET)
	public String editTicket(@RequestParam(required = true) Integer id, Model model) {
		// TODO: Check if ticket is exist before return to edit page.
		// If id was not defined, will return to main page.
		if (id == null)
			return "redirect:/admin/tickets";
		
		// TODO: If not exist ticket with this id, will return to main page, too.
		Ticket data = ticketService.getTicketById(id.toString());
		if (data == null)
			return "redirect:/admin/tickets";

		// Return to edit page.
		model.addAttribute("ticketId", id);
		model.addAttribute("ticketData", data);
		List<TicketType> ticketTypeList = ticketTypeService.getAllTicketType();
		model.addAttribute("ticketTypeList", ticketTypeList);
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
		List<Ticket> data = ticketService.getAllTickets(q);
		model.addAttribute("searchQuery", q);
		model.addAttribute("tickets", data);
		return "admin/ticketManager";
	}
}
