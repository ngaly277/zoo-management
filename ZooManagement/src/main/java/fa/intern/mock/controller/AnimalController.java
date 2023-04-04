package fa.intern.mock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fa.intern.mock.bean.Animal;
import fa.intern.mock.bean.Animal_Type;
import fa.intern.mock.service.AnimalService;
import fa.intern.mock.service.AnimalTypeService;

@Controller
public class AnimalController {

	@Autowired
	private AnimalService animalService;
	@Autowired
	private AnimalTypeService animalTypeService;
	
	@RequestMapping(value = "/getAnimalbyIDCage")
	public String getAnimalByIDCage(@RequestParam("idCage") int idCage, ModelMap model) {
		List<Animal> animals =  animalService.getAnimalByIDCage(idCage);
		model.addAttribute("animal", animals);
		return "admin/AnimalbyCage";
	}
	
	@RequestMapping(value = "deleteAnimal", method = RequestMethod.GET)
	public String deleteCage(@RequestParam("idAnimal") int idAnimal, @RequestParam("idCage") int idCage) {
		if (animalService.deleteAnimal(idAnimal))
		{
		return "redirect:getAnimalbyIDCage?idCage=" + idCage;
		}
		else return "redirect:admin/AnimalbyCage";
	}	

	@RequestMapping(value = "showAnimalInfo", method = RequestMethod.GET)
	public String showAnimalInfo(@RequestParam("idAnimal") int idAnimal, ModelMap model) {
		 List<Animal> animals = animalService.showAnimalInfo(idAnimal);
		 List<Animal_Type> types = animalTypeService.showTypes();
	     model.addAttribute("animalTypeList", types);
		 if (!animals.isEmpty()) {
		        model.addAttribute("animal", animals.get(0));
		    }
	        return "admin/editAnimal";
	}	
}
