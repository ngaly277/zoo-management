package fa.intern.mock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.intern.mock.bean.Customer;
import fa.intern.mock.bean.TicketHistory;
import fa.intern.mock.dao.CustomerDAO;
import fa.intern.mock.dao.TicketHistoryDAO;

@Service
public class TicketHistoryService {
	@Autowired
	private TicketHistoryDAO ticketHistoryDAO;
	
	@Autowired
	private CustomerDAO customerDAO;
	
	public void insertTicketHistory(TicketHistory th) {
		ticketHistoryDAO.insertTicketHistory(th);
	}
	
	public void insertCustomer(Customer c) {
		customerDAO.insertCustomer(c);
	}
	
	public Customer getIDCustomer(String email, String phone) {
		return customerDAO.getIDCustomer(email, phone);
	}
}
