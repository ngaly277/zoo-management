package fa.intern.mock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fa.intern.mock.bean.Ticket;
import fa.intern.mock.bean.TicketAge;
import fa.intern.mock.bean.TicketType;

@Repository
public class TicketDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Ticket> getAllTicketByType(int idTicketType){
		String query = "SELECT ticket.ID_Ticket, ticket_type.ID_Ticket_Type, ticket_type.Ticket_Type, ticket_type.Ticket_Description, ticket_age.ID_Ticket_Age, ticket_age.Age_Description, ticket.Amount, ticket.Price FROM ticket INNER JOIN ticket_type ON ticket.ID_Ticket_Type = ticket_type.ID_Ticket_Type INNER JOIN ticket_age ON ticket_age.ID_Ticket_Age = ticket.ID_Ticket_Age where ticket.ID_Ticket_Type = " + idTicketType;
		return jdbcTemplate.query(query, new TicketMapper());
	}
	
	public class TicketMapper implements RowMapper<Ticket> {

		public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
			Ticket t = new Ticket();
			t.setId_Ticket(rs.getInt("ID_Ticket"));
			
			TicketType tt = new TicketType();
			tt.setId_Ticket_Type(rs.getInt("ID_Ticket_Type"));
			tt.setTicket_Type(rs.getNString("Ticket_Type"));
			tt.setTicket_Description(rs.getNString("Ticket_Description"));
			
			TicketAge ta = new TicketAge();
			ta.setId_Ticket_Age(rs.getInt("ID_Ticket_Age"));
			ta.setAge_Description(rs.getNString("Age_Description"));
			
			t.setTicket_Type(tt);
			t.setTicket_Age(ta);
			t.setAmount(rs.getInt("Amount"));
			t.setPrice(rs.getInt("Price"));
			
			return t;
		}
		
	}
}

