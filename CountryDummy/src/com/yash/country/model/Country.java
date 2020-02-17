package com.yash.country.model;

public class Country {
	private Integer id;
	private String name;

	public Country(Integer id, String name) {
		this(name);
		this.id = id;
	}
	
	public Country(String name) {
		this.name = name;
	}

	public Country() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + "]";
	}

}
