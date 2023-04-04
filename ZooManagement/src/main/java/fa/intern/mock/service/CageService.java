package fa.intern.mock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.intern.mock.bean.Cage;
import fa.intern.mock.bean.Staff;
import fa.intern.mock.dao.CageDAO;
import fa.intern.mock.dao.StaffDAO;

@Service
public class CageService {
	@Autowired
	private CageDAO cageDAO;
	@Autowired
	private StaffDAO staffDAO;
	

	public boolean deleteCage(int idCage) {
		return cageDAO.deleteCage(idCage);
	}

	public List<Cage> searchCage(String option, String search) {
		List<Cage> cages = cageDAO.searchCage(option, search);
		for (Cage cage : cages) {
            Staff staff = staffDAO.getStaffById(cage.getStaffs().getIdStaff());
            cage.setStaffs(staff);
        }
        return cages;
	}

	public List<Cage> showAllCage() {
		 List<Cage> cages = cageDAO.showAllCage();
	        for (Cage cage : cages) {
	            Staff staff = staffDAO.getStaffById(cage.getStaffs().getIdStaff());
	            cage.setStaffs(staff);
	        }
	        return cages;
	}

	public List<Cage> showCageInfo(int idCage) {
		 List<Cage> cages = cageDAO.showCageInfo(idCage);
		for (Cage cage : cages) {
            Staff staff = staffDAO.getStaffById(cage.getStaffs().getIdStaff());
            cage.setStaffs(staff);
        }
        return cages;
	}

	public void editCage(int idCage, String nameCage, int limit, int staffName) throws Exception {
		cageDAO.editCage(idCage, nameCage, limit, staffName);
	}


}
