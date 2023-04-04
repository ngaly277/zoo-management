package fa.intern.mock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fa.intern.mock.bean.TicketType;
import fa.intern.mock.service.TicketTypeService;

@Controller
public class AdminTicketTypeController {
    @Autowired
	private TicketTypeService ticketTypeService;

    @RequestMapping(value="/admin/tickets/ticket-type", method = RequestMethod.GET)
	public String pageShowTicketType(
        Model model,
        @RequestParam(required = false) String q
    ) {
        List<TicketType> data = ticketTypeService.getAllTicketType(q);
        model.addAttribute("searchQuery", q);
		model.addAttribute("ticketType", data);
		return "admin/ticketTypeManager";
    }
}
