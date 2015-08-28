package model.facade;

import java.util.List;

import model.Summoner;
import persistence.clusterPoint.SummonerDAOClusterPoint;

public class FacadeSummoner {
	private SummonerDAOClusterPoint dao;
	
	public FacadeSummoner() {
		super();
		this.dao = new SummonerDAOClusterPoint();
	}

	public boolean addSummoner(Summoner summoner) {
		return this.dao.insert(summoner);
	}

	public boolean deleteSummoner(Summoner summoner){
		return this.dao.delete(summoner);
	}
	
	public boolean deleteAll() {
		return this.dao.deleteAll();
	}
	
	public List<Summoner> findAll() {
		return this.dao.findAll();
	}
	
	public Summoner findSummoner(String username){
		return this.dao.findByUsername(username);
	}

}
