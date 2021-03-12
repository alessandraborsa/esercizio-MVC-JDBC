package it.objectmethod.worldmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.objectmethod.worldmvc.config.ConnectionFactory;

import it.objectmethod.worldmvc.domain.Country;

public class CountryDaoImpl implements ICountryDao {

	@Override
	public Country getCountryByName(String nameCountry) {
		Connection conn = ConnectionFactory.getConnection();
		Country country = null;

		String sql = "SELECT * FROM country WHERE name = ? ";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, nameCountry);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				country = new Country();
				country.setCode(rs.getString("code"));
				country.setName(rs.getString("name"));
				country.setContinent(rs.getString("continent"));
				country.setPopulation(rs.getInt("population"));
				country.setSurfaceArea(rs.getInt("surfaceArea"));
			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return country;
	}
}