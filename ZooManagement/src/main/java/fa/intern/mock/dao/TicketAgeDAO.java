package fa.intern.mock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fa.intern.mock.bean.TicketAge;

@Repository
public class TicketAgeDAO {
    @Autowired
	private JdbcTemplate jdbcTemplate;

    public List<TicketAge> getAllTicketAge(String searchQuery) {
        try {
            String[] queryArray = {
                "SELECT * FROM Ticket_Age",
                "WHERE ID_Ticket_Age LIKE N'%%%s%%' OR Age_Description LIKE N'%%%s%%'",
                ";"
            };
            String query = String.join(" ", queryArray); 
            query = String.format(
                query,
                searchQuery == null ? "" : searchQuery,
                searchQuery == null ? "" : searchQuery
            );
            return jdbcTemplate.query(query, new TicketAgeMapper());
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public class TicketAgeMapper implements RowMapper<TicketAge> {
        public TicketAge mapRow(ResultSet rs, int rowNum) throws SQLException {
            TicketAge t = new TicketAge();

            t.setId_Ticket_Age(rs.getInt("ID_Ticket_Age"));
            t.setAge_Description(rs.getString("Age_Description"));

            return t;
        }
    }
}
