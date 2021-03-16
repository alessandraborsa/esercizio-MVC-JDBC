package it.objectmethod.worldmvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.worldmvc.config.ConnectionFactory;
import it.objectmethod.worldmvc.dao.ICityListDao;
import it.objectmethod.worldmvc.domain.City;

public class CityListDaoImpl implements ICityListDao {

	@Override
	public List<City> getCityByCountry(String code) {
		Connection conn = ConnectionFactory.getConnection();
		List<City> cities = new ArrayList<City>();

		String sql = "SELECT * FROM city, country WHERE country.Code = city.CountryCode AND country.Code = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, code);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				City city = new City();
				city.setId(rs.getInt("ID"));
				city.setCountryCode(rs.getString("CountryCode"));
				city.setName(rs.getString("Name"));
				city.setDistrict(rs.getString("District"));
				city.setPopulation(rs.getInt("Population"));
				cities.add(city);
			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cities;
	}
}
