package fa.intern.mock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fa.intern.mock.bean.Account;

@Repository
public class AccountDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Account getAccount(String username) {
		String query = "SELECT * FROM Account WHERE Username = " + username;
		return jdbcTemplate.query(query, new AccountMapper()).get(0);
	}
	
	public class AccountMapper implements RowMapper<Account> {
		  public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
			  Account a = new Account();
			  a.setUsername(rs.getString("Username"));
			  a.setPassword(rs.getString("Pass"));
			  a.setID_Account_Type(rs.getInt("ID_Account_Type"));
			  return a;
		  }
		}
}