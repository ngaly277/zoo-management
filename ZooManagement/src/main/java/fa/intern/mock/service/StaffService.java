package fa.intern.mock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.intern.mock.bean.Staff;
import fa.intern.mock.dao.StaffDAO;

@Service
public class StaffService {
	@Autowired
	private StaffDAO staffDAO;

	public List<Staff> showStaff() {
		return staffDAO.showStaff();
	}
	
	
}
