package model;

import java.util.List;

public class Champion {

	private String name;
	private String role;
	
	private List<Champion> goodAgainst;
	private List<Champion> weakAgainst;
	private List<Champion> goodWith;
	
	private int value;
	
	public Champion(String name, String role) {
		super();
		this.name = name;
		this.role = role;
		this.value = 0;
	}
	
	public Champion(String name, String role, List<Champion> goodAgainst, List<Champion> weakAgainst,
			List<Champion> goodWith) {
		super();
		this.name = name;
		this.role = role;
		this.goodAgainst = goodAgainst;
		this.weakAgainst = weakAgainst;
		this.goodWith = goodWith;
		this.value = 0;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public List<Champion> getGoodAgainst() {
		return goodAgainst;
	}

	public void setGoodAgainst(List<Champion> goodAgainst) {
		this.goodAgainst = goodAgainst;
	}

	public List<Champion> getWeakAgainst() {
		return weakAgainst;
	}

	public void setWeakAgainst(List<Champion> weakAgainst) {
		this.weakAgainst = weakAgainst;
	}

	public List<Champion> getGoodWith() {
		return goodWith;
	}

	public void setGoodWith(List<Champion> goodWith) {
		this.goodWith = goodWith;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
