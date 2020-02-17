package com.yash.country.dao;

import java.util.List;

import com.yash.country.model.Country;

public interface CountryDAO {
	public int save(Country country);
	
	public int update(Country country);
	
	public Country get(Integer id);
	
	public int delete(Integer id);
	
	public List<Country> list();
}
