package fa.intern.mock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fa.intern.mock.bean.Inventory;

@Repository
public class InventoryDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Inventory> getAllInventory(){    
	    return jdbcTemplate.query("select * from inventory",new RowMapper<Inventory>(){    
	        public Inventory mapRow(ResultSet rs, int row) throws SQLException {    
	        	Inventory e=new Inventory();    
	            e.setId(rs.getInt(1)); 
	            e.setAddress(rs.getString(2));
	            e.setName(rs.getString(3)); 	             
	            e.setIdType(rs.getInt(4)); 
	            return e;    
	        }    
	    });    
		}    
	
	public List<Inventory> getInventoryByOption(String op, String value){    
	    return jdbcTemplate.query("select * from inventory where " + op + " = '" + value + "'",new RowMapper<Inventory>(){    
	        public Inventory mapRow(ResultSet rs, int row) throws SQLException {    
	        	Inventory e=new Inventory();    
	            e.setId(rs.getInt(1)); 
	            e.setAddress(rs.getString(2));
	            e.setName(rs.getString(3)); 	             
	            e.setIdType(rs.getInt(4)); 
	            return e;    
	        }    
	    });    
		}    
	}   
