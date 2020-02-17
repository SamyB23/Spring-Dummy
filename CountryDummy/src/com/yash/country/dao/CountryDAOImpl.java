package com.yash.country.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.yash.country.model.Country;

public class CountryDAOImpl implements CountryDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public CountryDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int save(Country country) {
		String sql = "INSERT INTO Country (name) VALUES (?)";
		return jdbcTemplate.update(sql, country.getName());
	}

	@Override
	public int update(Country country) {
		String sql = "UPDATE Country SET name=? WHERE country_id=?";
		return jdbcTemplate.update(sql, country.getName(), country.getId());
	}

	@Override
	public Country get(Integer id) {
		String sql = "SELECT * FROM Country WHERE country_id=" +id;
		
		ResultSetExtractor<Country> extractor = new ResultSetExtractor<Country>() {

			@Override
			public Country extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					String name = rs.getString("name");
					
					return new Country(id, name);
				}
				return null;
			}	
		};
		
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM country WHERE country_id=" +id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Country> list() {
		String sql = "SELECT * FROM country";
		
		RowMapper<Country> rowMapper = new RowMapper<Country>() {

			@Override
			public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("country_id");
				String name = rs.getString("name");
				
				return new Country(id, name);
			}
		};
		return jdbcTemplate.query(sql, rowMapper);
	}

}
