package fa.intern.mock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fa.intern.mock.bean.Staff;
import fa.intern.mock.bean.StaffType;

@Repository
public class StaffDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Staff> getStaffList(){
		String sql = "SELECT * FROM staff";
		List<Staff> staffList = jdbcTemplate.query(sql, new RowMapper<Staff>() {
			
			public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
				Staff staff = new Staff();
				
				staff.setIdStaff(rs.getInt("ID_Staff"));
				staff.setStaffName(rs.getString("Staff_Name"));
				staff.setSalary(rs.getInt("Salary"));
				staff.setIdContract(rs.getInt("ID_Contract"));
				staff.setIdStaffType(rs.getInt("ID_Staff_Type"));
				staff.setUsername(rs.getString("Username"));
				
				System.out.println(staff.getIdStaff()+"-"+staff.getStaffName()+"-"+staff.getIdContract()+"-"+staff.getIdStaffType()+"-"+staff.getSalary()+"-"+staff.getUsername());
				return staff;
				
			}
		});
		return staffList;
	}
	
	public List<StaffType> getStaffTypeList(){
		String sql = "SELECT * FROM staff_type";
		List<StaffType> staffTypeList = jdbcTemplate.query(sql, new RowMapper<StaffType>() {
			
			public StaffType mapRow(ResultSet rs, int rowNum) throws SQLException {
				StaffType staffType = new StaffType();
				
				staffType.setIdStaffType(rs.getInt("ID_Staff_Type"));
				staffType.setStaffType(rs.getString("Staff_Type"));
				staffType.setDetails(rs.getString("Details"));
				
				System.out.println(staffType.getIdStaffType()+"-"+staffType.getStaffType()+"-"+staffType.getDetails());
				return staffType;
				
			}
		});
		return staffTypeList;
	}
}
