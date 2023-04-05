package fa.intern.mock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fa.intern.mock.bean.Contracts;
import fa.intern.mock.bean.Staff;

@Repository
public class ContractDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void createContract() {
		String nothing = "nothing";
		String sql = "insert into Contracts (Details) VALUE ('"+nothing+"')";
		jdbcTemplate.update(sql);
	}
	
	public List<Contracts> getTheLastContract(){
		String sql = "SELECT * FROM Contracts ORDER BY ID_Contract DESC LIMIT 1";
		List<Contracts> contractList = jdbcTemplate.query(sql, new RowMapper<Contracts>() {
			
			public Contracts mapRow(ResultSet rs, int rowNum) throws SQLException {
				Contracts contracts = new Contracts();
				
				contracts.setIdContract(rs.getInt("ID_Contract"));
				contracts.setDetails(rs.getString("Details"));
				
				System.out.println("contractID: "+contracts.getIdContract()+"-"+contracts.getDetails());
				return contracts;
				
			}
		});
		return contractList;
	}
}
