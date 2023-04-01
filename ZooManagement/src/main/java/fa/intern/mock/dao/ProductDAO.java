package fa.intern.mock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fa.intern.mock.bean.Product;
import fa.intern.mock.bean.Supplier;


@Repository
public class ProductDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Supplier getSupplierByID(int id){    
	    return jdbcTemplate.query("SELECT * FROM supplier WHERE ID_Supplier = " + id,new RowMapper<Supplier>(){    
	        public Supplier mapRow(ResultSet rs, int row) throws SQLException {    
	        	Supplier e = new Supplier();    
	            e.setId(rs.getInt(1)); 
	            e.setIdContract(rs.getInt(2));
	            e.setIdSupplierType(rs.getInt(3));
	            e.setName(rs.getString(4));
	            return e;    
	        }    
	    }).get(0);    
		}
	
	public List<Product> getAllProductcs(){    
	    return jdbcTemplate.query("select * from product",new RowMapper<Product>(){    
	        public Product mapRow(ResultSet rs, int row) throws SQLException {    
	        	Product e=new Product();    
	            e.setId(rs.getInt(1)); 
	            e.setName(rs.getString(2));
	            e.setIdBillDetail(rs.getInt(3)); 	             
	            e.setAmount(rs.getInt(4)); 
	            e.setIdSupplier(rs.getInt(5));
	            e.setIdInventory(rs.getInt(6));
	            e.setPrice(rs.getInt(7));
	            e.setSupplier(getSupplierByID(rs.getInt(5)));
	            return e;    
	        }    
	    });    
		} 
	
	public List<Product> getListProductcsByIDInventory(int id){    
	    return jdbcTemplate.query("select * from product where ID_Inventory = " + id,new RowMapper<Product>(){    
	        public Product mapRow(ResultSet rs, int row) throws SQLException {    
	        	Product e=new Product();    
	            e.setId(rs.getInt(1)); 
	            e.setName(rs.getString(2));
	            e.setIdBillDetail(rs.getInt(3)); 	             
	            e.setAmount(rs.getInt(4)); 
	            e.setIdSupplier(rs.getInt(5));
	            e.setIdInventory(rs.getInt(6));
	            e.setPrice(rs.getInt(7));
	            SupplierDAO dao = new SupplierDAO();
	            e.setSupplier(getSupplierByID(rs.getInt(5)));
	            return e;    
	        }    
	    });    
		} 
	
	public int deleteProduct(int id){    
	    String sql="delete from product where ID_Product="+id+"";    
	    return jdbcTemplate.update(sql);    
	}  
}
