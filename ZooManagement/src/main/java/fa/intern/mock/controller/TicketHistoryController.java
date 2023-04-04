package fa.intern.mock.controller;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fa.intern.mock.bean.Customer;
import fa.intern.mock.bean.TicketHistory;
import fa.intern.mock.service.TicketHistoryService;
import fa.intern.mock.service.TicketService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class TicketHistoryController {
	@Autowired
	private TicketHistoryService ticketHistoryService;
	
	@Autowired
	private TicketService ticketService;
	
	@RequestMapping("checkout")
	public String showCheckoutTickets(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer/checkout";

	}
	
	@RequestMapping(value = "/insertTicketHistory")
	public @ResponseBody String insertTicketHistory(HttpServletRequest request) {
		Customer customer = new Customer();
		customer.setCustomer_Name(request.getParameter("customer_Name"));
		customer.setAddress(request.getParameter("address"));
		customer.setPhone(request.getParameter("phone"));
		customer.setEmail(request.getParameter("email"));
		
		if (customer.getAddress() != "" && customer.getCustomer_Name() != "" & customer.getEmail() != "" & customer.getPhone() != "") { 
//			ticketHistoryService.insertCustomer(customer);
			Customer c = ticketHistoryService.getIDCustomer(customer.getEmail(), customer.getPhone());
			int amountTicket = Integer.parseInt(request.getParameter("ticket-amount"));
			for (int i = 1; i <= amountTicket; i++) {
				String date = request.getParameter("date" + i);
				int idTicket = Integer.parseInt(request.getParameter("idTicket" + date + i));
				int ageAmount = Integer.parseInt(request.getParameter("age-amount" + date + i));
				
				for (int j = 1; j <= ageAmount; j++) {
					int idTicketAge = Integer.parseInt(request.getParameter("idTicketAge" + date + i + j));
					int amount = Integer.parseInt(request.getParameter("amount" + date + i + j));
					
					int id_Ticket = ticketService.getTicket(idTicket, idTicketAge).getId_Ticket();
					TicketHistory th = new TicketHistory();
					th.setPurchase_Date(LocalDate.parse(date));
					th.setAmount(amount);
					th.setId_Ticket(id_Ticket);
					th.setId_Customer(c.getId_Customer());
					ticketHistoryService.insertTicketHistory(th);
				}
			}
			return "tickets"; 
		} else { 
			
		 	return "checkout"; 
		}
	}
}
