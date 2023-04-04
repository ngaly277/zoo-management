package fa.intern.mock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.intern.mock.bean.TicketAge;
import fa.intern.mock.dao.TicketAgeDAO;

@Service
public class TicketAgeService {
    @Autowired
	private TicketAgeDAO ticketAgeDao;

    public List<TicketAge> getAllTicketAge(String searchQuery) {
        return ticketAgeDao.getAllTicketAge(searchQuery);
    }
}
