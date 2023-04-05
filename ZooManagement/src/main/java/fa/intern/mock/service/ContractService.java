package fa.intern.mock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.intern.mock.bean.Contracts;
import fa.intern.mock.dao.ContractDAO;

@Service
public class ContractService {
	
	@Autowired
	private ContractDAO contractDAO;
	
	public void createContract() {
		contractDAO.createContract();
	}
	
	public List<Contracts> getTheLastContract() {
		return contractDAO.getTheLastContract();
	}
	
}
