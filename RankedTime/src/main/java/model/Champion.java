package model;

import java.util.List;

public class Champion {

	private String name;
	private String role;

	private List<String> goodAgainst;
	private List<String> weakAgainst;
	private List<String> goodWith;

	private int value;

	public Champion() {
		// TODO Auto-generated constructor stub
	}

	public Champion(String name, String role) {
		super();
		this.name = name;
		this.role = role;
		this.value = 0;
	}

	public Champion(String name, List<String> goodAgainst, List<String> weakAgainst, List<String> goodWith) {
		super();
		this.name = name;
		this.goodAgainst = goodAgainst;
		this.weakAgainst = weakAgainst;
		this.goodWith = goodWith;
		this.value = 0;
	}

	public Champion(String name, String role, List<String> goodAgainst, List<String> weakAgainst,
			List<String> goodWith) {
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

	public List<String> getGoodAgainst() {
		return goodAgainst;
	}

	public void setGoodAgainst(List<String> goodAgainst) {
		this.goodAgainst = goodAgainst;
	}

	public List<String> getWeakAgainst() {
		return weakAgainst;
	}

	public void setWeakAgainst(List<String> weakAgainst) {
		this.weakAgainst = weakAgainst;
	}

	public List<String> getGoodWith() {
		return goodWith;
	}

	public void setGoodWith(List<String> goodWith) {
		this.goodWith = goodWith;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Champion [name=" + name + ", role=" + role + ", goodAgainst=" + goodAgainst + ", weakAgainst="
				+ weakAgainst + ", goodWith=" + goodWith + ", value=" + value + "]";
	}

}
