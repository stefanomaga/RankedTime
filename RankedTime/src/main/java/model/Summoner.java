package model;

import java.util.List;

public class Summoner {
	
	private String username;
	private String password;
	private List<Champion> champions;

	public Summoner() {
		// TODO Auto-generated constructor stub
	}
	
	public Summoner(String username, String password, List<Champion> champions) {
		super();
		this.username = username;
		this.password = password;
		this.champions = champions;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Champion> getChampions() {
		return champions;
	}

	public void setChampions(List<Champion> champions) {
		this.champions = champions;
	}

	@Override
	public String toString() {
		return "Summoner [username=" + username + ", password=" + password + ", champions=" + champions + "]";
	}

	
}