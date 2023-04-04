package fa.intern.mock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fa.intern.mock.bean.TicketType;

@Repository
public class TicketTypeDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<TicketType> getAllTicketType() {
		String query = "SELECT * FROM Ticket_Type";
		return jdbcTemplate.query(query, new TicketTypeMapper());
	}
	
	public class TicketTypeMapper implements RowMapper<TicketType> {
		public TicketType mapRow(ResultSet rs, int rowNum) throws SQLException {
			TicketType tt = new TicketType();
			tt.setId_Ticket_Type(rs.getInt("ID_Ticket_Type"));
			tt.setTicket_Type(rs.getNString("Ticket_Type"));
			tt.setTicket_Description(rs.getNString("Ticket_Description"));
			return tt;
		}
	}
}
