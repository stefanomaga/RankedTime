package persistence;

import java.util.List;

import model.Summoner;

public interface SummonerDAO {
	
	boolean insert(Summoner summoner);

	boolean delete(Summoner summoner);

	boolean deleteAll();

	Summoner findByUsername(String username);
	
	List<Summoner> findAll();
}
