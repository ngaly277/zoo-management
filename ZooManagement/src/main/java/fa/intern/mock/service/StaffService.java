package fa.intern.mock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.intern.mock.bean.Staff;
import fa.intern.mock.bean.StaffType;
import fa.intern.mock.dao.StaffDAO;

@Service
public class StaffService {
	
	@Autowired
	private StaffDAO staffDAO;
	
	public List<Staff> getStaffList(){
		return staffDAO.getStaffList();
	}
	
	public List<StaffType> getStaffTypeList(){
		return staffDAO.getStaffTypeList();
	}
	
	public List<Staff> getStaffById(int id) {
		return staffDAO.getStaffById(id);
	}
	
	public List<Staff> getStaffSearch(String searchString){
		return staffDAO.getStaffSearch(searchString);
	}
	
}
