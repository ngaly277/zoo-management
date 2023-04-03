package fa.intern.mock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fa.intern.mock.bean.Customer;
import fa.intern.mock.bean.TicketType;

@Repository
public class CustomerDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void insertCustomer(Customer c) {
		String query = "INSERT INTO Customer (Customer_Name, Address, Email, Phone) VALUES (?,?,?,?)";
		jdbcTemplate.update(query, c.getCustomer_Name(), c.getAddress(), c.getEmail(), c.getPhone());
	}
	
	public Customer getIDCustomer(String email, String phone) {
		String query = "SELECT * FROM Customer WHERE Email = '" + email + "' and Phone = '" + phone + "'";
		return jdbcTemplate.query(query, new CustomerMapper()).get(0);
	}
	
	public class CustomerMapper implements RowMapper<Customer> {

		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customer c = new Customer();
			c.setId_Customer(rs.getInt("ID_Customer"));
			c.setCustomer_Name(rs.getNString("Customer_Name"));
			c.setAddress(rs.getNString("Address"));
			c.setPhone(rs.getString("Phone"));
			c.setEmail(rs.getString("Email"));
			return c;
		}
		
	}
}
