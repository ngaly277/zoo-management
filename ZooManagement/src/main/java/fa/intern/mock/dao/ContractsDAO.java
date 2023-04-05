package fa.intern.mock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fa.intern.mock.bean.Contracts;

@Repository
public class ContractsDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Contracts> getAllContracts(){    
	    return jdbcTemplate.query("select * from contracts",new RowMapper<Contracts>(){    
	        public Contracts mapRow(ResultSet rs, int row) throws SQLException {    
	        	Contracts e=new Contracts();    
	            e.setId(rs.getInt(1)); 
	            e.setDetails(rs.getString(2));
	            return e;    
	        }    
	    });    
	} 
	
	public int deleteContracts(int id){    
	    String sql="delete from contracts where ID_Contract="+id+"";    
	    return jdbcTemplate.update(sql);    
	} 
	
	public int updateContracts(Contracts p){    
	    String sql="update contracts set ID_Contract='"+p.getId()+"', Details="+p.getDetails()+"' where ID_Contract="+p.getId()+"";    
	    return jdbcTemplate.update(sql);    
	}  
	
	public int saveContracts(Contracts p){    
	    String sql="insert into contracts(Details) values('"+p.getDetails()+"')";    
	    return jdbcTemplate.update(sql);    
	}    
}
