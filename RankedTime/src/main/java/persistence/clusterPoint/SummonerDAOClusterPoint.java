package persistence.clusterPoint;

import java.util.List;

import model.Summoner;
import persistence.SummonerDAO;

public class SummonerDAOClusterPoint implements SummonerDAO {
	private DataSource data;

	public SummonerDAOClusterPoint() {
		this.data = new DataSource();
	}
	
	public boolean insert(Summoner summoner) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Summoner summoner) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteAll() {
		// TODO Auto-generated method stub
		return false;
	}

	public Summoner findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Summoner> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
