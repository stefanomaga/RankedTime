package persistence;

import java.util.List;

import model.Champion;

public interface ChampionDAO {

	boolean insert(Champion champion);

	boolean delete(Champion champion);

	boolean deleteAll();

	Champion findByName(String name);
	
	List<Champion> findAll();

}
