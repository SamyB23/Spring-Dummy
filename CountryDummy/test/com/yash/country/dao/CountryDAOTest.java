package com.yash.country.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.yash.country.model.Country;

class CountryDAOTest {
	private DriverManagerDataSource dataSource;
	private CountryDAO dao;
	
	@BeforeEach
	void setupBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/countrydb");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		dao = new CountryDAOImpl(dataSource);
	}
	@Test
	void testSave() {		
		Country country = new Country("UAE");
		
		int result = dao.save(country);
		
		assertTrue(result > 0);
	}

	@Test
	void testUpdate() {
		Country country = new Country(2, "Italy");
		
		int result = dao.update(country);
		
		assertTrue(result > 0);
	}

	@Test
	void testGet() {
		Integer id = 1;
		Country country = dao.get(id);
		
		if(country!=null) {
			System.out.println(country);
		}
		
		assertNotNull(country);
	}

	@Test
	void testDelete() {
		Integer id = 2;
		int result = dao.delete(id);
		
		assertTrue(result > 0);
	}

	@Test
	void testList() {
		List<Country> countryList = dao.list();
		
		for(Country countries : countryList) {
			System.out.println(countries);
		}
		
		assertTrue(!countryList.isEmpty());
	}

}
