package fa.intern.mock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fa.intern.mock.bean.Supplier;


@Repository
public class SupplierDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	 
}
