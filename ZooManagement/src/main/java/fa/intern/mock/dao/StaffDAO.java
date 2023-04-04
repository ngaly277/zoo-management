package fa.intern.mock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fa.intern.mock.bean.Cage;
import fa.intern.mock.bean.Staff;

@Repository
public class StaffDAO {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
    private class StaffRowMapper implements RowMapper<Staff> {
        public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
            Staff staff = new Staff();
            staff.setIdStaff(rs.getInt("ID_Staff"));
            staff.setStaffName(rs.getString("Staff_Name"));
            return staff;
        }
    }

    public Staff getStaffById(int id) {
    	 	Object[] params = new Object[]{id};
    	    String sql = "SELECT * FROM staff WHERE ID_Staff = ?";
    	    return jdbcTemplate.queryForObject(sql, params, new StaffRowMapper());
    	}

	public List<Staff> showStaff() {
		String sql = "SELECT * FROM staff";
	    return jdbcTemplate.query(sql, new StaffRowMapper());
	}
}
