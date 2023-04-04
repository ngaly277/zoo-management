package fa.intern.mock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.intern.mock.bean.Animal;
import fa.intern.mock.bean.Animal_Type;
import fa.intern.mock.bean.Cage;
import fa.intern.mock.bean.Staff;
import fa.intern.mock.dao.AnimalDAO;
import fa.intern.mock.dao.AnimalTypeDAO;

@Service
public class AnimalService {
	@Autowired
	private AnimalDAO animalDAO;

	
	public List<Animal> getAnimalByIDCage(int idCage) {
	        return animalDAO.getAnimalByIDCage(idCage);
	}


	public boolean deleteAnimal(int idAnimal) {
		return animalDAO.deleteAnimal(idAnimal);
	}



	public List<Animal> showAnimalInfo(int idAnimal) {
        return animalDAO.showAnimalInfo(idAnimal);
	}
	
}
