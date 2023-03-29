package fa.intern.mock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.intern.mock.dao.TicketDAO;

@Service
public class TicketService {
	@Autowired
	private TicketDAO ticketDAO;
}
