package it.objectmethod.worldmvc.dao;

import java.util.List;

import it.objectmethod.worldmvc.domain.City;

public interface ICityDao {

	public City getCityByName(String nameCity);
	
	public List<City> getCityByCountry(String code);

}