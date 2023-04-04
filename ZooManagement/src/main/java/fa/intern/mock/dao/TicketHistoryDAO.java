package fa.intern.mock.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fa.intern.mock.bean.TicketHistory;

@Repository
public class TicketHistoryDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertTicketHistory(TicketHistory th) {
		String query = "INSERT INTO Ticket_History (Purchase_Date, Amount, ID_Ticket, ID_Customer) VALUES (?,?,?,?)";
		jdbcTemplate.update(query, th.getPurchase_Date(), th.getAmount(), th.getId_Ticket(), th.getId_Customer());
	}
}
