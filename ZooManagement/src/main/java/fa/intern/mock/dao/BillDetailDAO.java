package fa.intern.mock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fa.intern.mock.bean.Bill;
import fa.intern.mock.bean.BillDetail;
import fa.intern.mock.bean.Supplier;


@Repository
public class BillDetailDAO {
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
	
	public Bill getBillByID(int id){    
	    return jdbcTemplate.query("select * from bill WHERE ID_Bill = " + id,new RowMapper<Bill>(){    
	        public Bill mapRow(ResultSet rs, int row) throws SQLException {    
	        	Bill e=new Bill();    
	            e.setId(rs.getInt(1)); 
	            e.setBillType(rs.getInt(2)); 
	            e.setName(rs.getString(3)); 
	            e.setIdSupplier(rs.getInt(4)); 
	            e.setSupplier(getSupplierByID(rs.getInt(4)));
	            return e;    
	        }    
	    }).get(0);    
	}
	
	public List<BillDetail> getAllBillDetail(){    
	    return jdbcTemplate.query("select * from bill_detail",new RowMapper<BillDetail>(){    
	        public BillDetail mapRow(ResultSet rs, int row) throws SQLException {    
	        	BillDetail e=new BillDetail();    
	            e.setId(rs.getInt(1)); 
	            e.setIdBill(rs.getInt(2)); 
	            e.setAmountTransfer(rs.getInt(3)); 
	            e.setTransferDate(rs.getDate(4)); 
	            e.setBill(getBillByID(rs.getInt(2)));
	            return e;    
	        }    
	    });    
	} 
	
	public List<BillDetail> getBillDetailByOption(String op, String value){   
		String query = "";
		if(op.equals("Bill_Name") || op.equals("Bill_Type"))
			query =  "select * from bill_detail WHERE ID_Bill IN ( SELECT ID_Bill FROM bill WHERE " + op + " = '" + value + "')";
		else if(op.equals("Supplier_Name"))
			query =  "select * from bill_detail WHERE ID_Bill IN ( SELECT ID_Bill FROM bill WHERE ID_Supplier IN ( SELECT ID_Supplier FROM supplier WHERE " + op + " = '" + value + "'))";
		else 
			query =  "select * from bill_detail where " + op + " = '" + value + "'";
		
	    return jdbcTemplate.query(query, new RowMapper<BillDetail>(){    
	        public BillDetail mapRow(ResultSet rs, int row) throws SQLException {    
	        	BillDetail e=new BillDetail();    
	            e.setId(rs.getInt(1)); 
	            e.setIdBill(rs.getInt(2)); 
	            e.setAmountTransfer(rs.getInt(3)); 
	            e.setTransferDate(rs.getDate(4)); 
	            e.setBill(getBillByID(rs.getInt(2)));
	            return e;    
	        }    
	    });    
	} 
	
	public int deleteBillDetail(int id){    
	    String sql="delete from bill_detail where ID_Bill_Detail="+id+"";    
	    return jdbcTemplate.update(sql);    
	} 
	
	public int updateBillDetail(BillDetail p){    
	    String sql="update bill_detail set ID_Bill_Detail='"+p.getId()+"', ID_Bill="+p.getIdBill()+"', Amount_Transfer="+p.getAmountTransfer()+"', Transfer_Date="+p.getAmountTransfer()+"' where ID_Bill_Detail="+p.getId()+"";    
	    return jdbcTemplate.update(sql);    
	}  
}
