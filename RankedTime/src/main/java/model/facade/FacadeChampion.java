package model.facade;

import model.Champion;
import persistence.clusterPoint.ChampionDAOClusterPoint;

public class FacadeChampion {
	private ChampionDAOClusterPoint dao;
	
	public FacadeChampion() {
		super();
		this.dao = new ChampionDAOClusterPoint();
	}

	public boolean addChampion(Champion champion) {
		return this.dao.insert(champion);
	}

	public boolean deleteChampion(Champion champion){
		return this.dao.delete(champion);
	}
	
	public boolean deleteAll() {
		return this.dao.deleteAll();
	}
	
	public Champion findChampion(String name){
		return this.dao.findByName(name);
	}

}
