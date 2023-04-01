package fa.intern.mock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fa.intern.mock.bean.Contracts;
import fa.intern.mock.bean.Supplier;
import fa.intern.mock.bean.SupplierType;


@Repository
public class SupplierDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Contracts getContractsByID(int id){    
	    return jdbcTemplate.query("select * from contracts WHERE ID_Product_Type = " + id,new RowMapper<Contracts>(){    
	        public Contracts mapRow(ResultSet rs, int row) throws SQLException {    
	        	Contracts e=new Contracts();    
	            e.setId(rs.getInt(1)); 
	            e.setDetails(rs.getString(2));
	            return e;    
	        }    
	    }).get(0);    
	} 
	
	public SupplierType getSupplierTypeByID(int id){    
	    return jdbcTemplate.query("select * from supplier_type WHERE ID_Supplier_Type = " + id,new RowMapper<SupplierType>(){    
	        public SupplierType mapRow(ResultSet rs, int row) throws SQLException {    
	        	SupplierType e=new SupplierType();    
	            e.setId(rs.getInt(1)); 
	            e.setSupplierType(rs.getString(2));
	            return e;    
	        }    
	    }).get(0);    
	} 
	
	public List<Supplier> getAllSupplier(){    
	    return jdbcTemplate.query("select * from supplier",new RowMapper<Supplier>(){    
	        public Supplier mapRow(ResultSet rs, int row) throws SQLException {    
	        	Supplier e=new Supplier();    
	            e.setId(rs.getInt(1)); 
	            e.setIdContract(rs.getInt(2));
	            e.setIdSupplierType(rs.getInt(3));
	            e.setName(rs.getString(4));
	            e.setContracts(getContractsByID(rs.getInt(2)));
	            e.setSupplierType(getSupplierTypeByID(rs.getInt(3)));
	            return e;    
	        }    
	    });    
	} 
	
	public List<Supplier> getSupplierByOption(String op, String value) {    
	    return jdbcTemplate.query("select * from supplier where " + op + " = '" + value + "'",new RowMapper<Supplier>(){    
	        public Supplier mapRow(ResultSet rs, int row) throws SQLException {    
	        	Supplier e=new Supplier();    
	            e.setId(rs.getInt(1)); 
	            e.setIdContract(rs.getInt(2));
	            e.setIdSupplierType(rs.getInt(3));
	            e.setName(rs.getString(4));
	            e.setContracts(getContractsByID(rs.getInt(2)));
	            e.setSupplierType(getSupplierTypeByID(rs.getInt(3)));
	            return e;    
	        }    
	    });    
	} 
	
	public int deleteContracts(int id){    
	    String sql="delete from supplier where ID_Supplier="+id+"";    
	    return jdbcTemplate.update(sql);    
	} 
	
	public int updateContracts(Supplier p){    
	    String sql="update supplier set ID_Supplier='"+p.getId()+"', ID_Contract="+p.getIdContract()+"', ID_Supplier_Type="+p.getIdSupplierType()+"', Supplier_Name="+p.getIdSupplierType()+"' where ID_Supplier="+p.getId()+"";    
	    return jdbcTemplate.update(sql);    
	} 
}
