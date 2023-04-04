package fa.intern.mock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fa.intern.mock.bean.Animal;
import fa.intern.mock.bean.Animal_Type;
import fa.intern.mock.bean.Cage;

@Repository
public class AnimalDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private class AnimalRowMapper implements RowMapper<Animal> {
        public Animal mapRow(ResultSet rs, int rowNum) throws SQLException {
            Animal animal = new Animal();
            animal.setIdAnimal(rs.getInt("ID_Animal"));
            animal.setAnimalName(rs.getString("Animal_Name"));
            animal.setAnimalStatus(rs.getString("Animal_Status"));
            animal.setDetail(rs.getString("Details"));
            animal.setFood(rs.getString("Food"));
            Cage cage = new Cage();
            cage.setIdCage(rs.getInt("ID_Cage"));
            Animal_Type animalType = new Animal_Type();
            animalType.setIdAnimalType(rs.getInt("ID_Animal_Type"));
            animalType.setAnimalType(rs.getString("Animal_Type"));
            animal.setTypes(animalType);
            animal.setCages(cage);
            return animal;
        }
    }
	@SuppressWarnings("deprecation")
	public List<Animal> getAnimalByIDCage(int idCage) {
		Object[] params = new Object[] {idCage};
		 String sql = "SELECT * FROM animal join animal_type on animal.ID_Animal_Type = animal_type.ID_Animal_Type WHERE ID_Cage = ?";
	        return jdbcTemplate.query(sql, params, new AnimalRowMapper());
	}
	public boolean deleteAnimal(int idAnimal) {
		String sql = "delete from Animal where ID_Animal = ?";
		Object[] params = new Object[] {idAnimal};
		if (jdbcTemplate.update(sql, params) !=0) {
			return true;
		}		
		return false;
	}
	public List<Animal> showAnimalInfo(int idAnimal) {
		Object[] params = new Object[] {idAnimal};
		String sql = "SELECT * FROM animal join animal_type on animal.ID_Animal_Type = animal_type.ID_Animal_Type WHERE ID_Animal = ?";
			return jdbcTemplate.query(sql, params, new AnimalRowMapper());
	}

}
