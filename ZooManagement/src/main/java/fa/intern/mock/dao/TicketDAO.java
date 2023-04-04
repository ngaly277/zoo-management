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

	public List<Ticket> getAllTicketByType(int idTicketType) {
		String query = "SELECT ticket.ID_Ticket, ticket_type.ID_Ticket_Type, ticket_type.Ticket_Type, ticket_type.Ticket_Description, ticket_age.ID_Ticket_Age, ticket_age.Age_Description, ticket.Amount, ticket.Price FROM ticket INNER JOIN ticket_type ON ticket.ID_Ticket_Type = ticket_type.ID_Ticket_Type INNER JOIN ticket_age ON ticket_age.ID_Ticket_Age = ticket.ID_Ticket_Age where ticket.ID_Ticket_Type = "
				+ idTicketType;
		return jdbcTemplate.query(query, new TicketMapper());
	}

	public List<Ticket> getAllTickets(String searchQuery) {
		try {
			// TODO: Need change this query because this database script hasn't contain
			// "Ticket_Age" table!!!!!
			String[] queryArray = {
					"SELECT",
					"Ticket.ID_Ticket, Ticket_Type.ID_Ticket_Type, Ticket_Type.Ticket_Type, Ticket_Type.Ticket_Description,",
					"Ticket.Amount, Ticket.Price,",
					"Ticket_Age.ID_Ticket_Age, Ticket_Age.Age_Description",
					"FROM Ticket INNER JOIN Ticket_Type ON Ticket.ID_Ticket_Type = Ticket_Type.ID_Ticket_Type",
					"INNER JOIN Ticket_Age ON Ticket_Age.ID_Ticket_Age = Ticket.ID_Ticket_Age",
					"WHERE Ticket_Type LIKE N'%%%s%%' OR Ticket.Amount LIKE N'%%%s%%' OR Ticket.Price LIKE N'%%%s%%'",
					";"
			};
			String query = String.join(" ", queryArray);
			query = String.format(
					query,
					searchQuery == null ? "" : searchQuery,
					searchQuery == null ? "" : searchQuery,
					searchQuery == null ? "" : searchQuery);
			return jdbcTemplate.query(query, new TicketMapper());
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Ticket getTicketById(String ticketId) {
		try {
			// TODO: Need change this query because this database script hasn't contain
			// "Ticket_Age" table!!!!!
			String[] queryArray = {
					"SELECT",
					"Ticket.ID_Ticket, Ticket_Type.ID_Ticket_Type, Ticket_Type.Ticket_Type, Ticket_Type.Ticket_Description,",
					"Ticket.Amount, Ticket.Price,",
					"Ticket_Age.ID_Ticket_Age, Ticket_Age.Age_Description",
					"FROM Ticket INNER JOIN Ticket_Type ON Ticket.ID_Ticket_Type = Ticket_Type.ID_Ticket_Type",
					"INNER JOIN Ticket_Age ON Ticket_Age.ID_Ticket_Age = Ticket.ID_Ticket_Age",
					"WHERE Ticket.ID_Ticket = %s LIMIT 1",
					";"
			};
			String query = String.join(" ", queryArray);
			query = String.format(query, ticketId);

			List<Ticket> data = jdbcTemplate.query(query, new TicketMapper());
			if (data.size() > 0) {
				return data.get(0);
			} else {
				return null;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public boolean addTicket(Ticket ticket) {
		if (ticket == null)
			return false;

		try {
			// TODO: Need change this query because this database script hasn't contain
			// "Ticket_Age" table!!!!!
			String[] queryArray = {
					"INSERT INTO Ticket(ID_Ticket_Type, Amount, Price)",
					"VALUES (%d, %d, %d)",
					";"
			};

			String query = String.join(" ", queryArray);
			query = String.format(query, ticket.getTicket_Type().getId_Ticket_Type(), ticket.getAmount(),
					ticket.getPrice());
			return jdbcTemplate.update(query) == 1;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean editTicket(Ticket ticket) {
		if (ticket == null)
			return false;

		try {
			// TODO: Need change this query because this database script hasn't contain
			// "Ticket_Age" table!!!!!
			String[] queryArray = {
					"UPDATE Ticket",
					"SET ID_Ticket_Type = %d, Amount = %d, Price = %d",
					"WHERE ID_Ticket = %d",
					";"
			};

			String query = String.join(" ", queryArray);
			query = String.format(query, ticket.getTicket_Type().getId_Ticket_Type(), ticket.getAmount(),
					ticket.getPrice(), ticket.getId_Ticket());
			return jdbcTemplate.update(query) == 1;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean deleteTicketById(String ticketId) {
		if (ticketId == null)
			return false;

		try {
			String[] queryArray = {
					"DELETE FROM Ticket",
					"WHERE ID_Ticket = %s",
					";"
			};

			String query = String.join(" ", queryArray);
			query = String.format(query, ticketId);
			return jdbcTemplate.update(query) == 1;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
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
