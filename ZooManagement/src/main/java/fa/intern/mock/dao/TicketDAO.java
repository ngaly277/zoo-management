package fa.intern.mock.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
}
