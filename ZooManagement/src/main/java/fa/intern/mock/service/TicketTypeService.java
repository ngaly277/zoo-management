package fa.intern.mock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.intern.mock.bean.TicketType;
import fa.intern.mock.dao.TicketTypeDAO;

@Service
public class TicketTypeService {
	@Autowired
	private TicketTypeDAO ticketDAO;
	
	public List<TicketType> getAllTicketType(String searchQuery){
		return ticketDAO.getAllTicketType(searchQuery);
	}
}
