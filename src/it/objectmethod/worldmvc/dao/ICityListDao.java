package it.objectmethod.worldmvc.dao;

import java.util.List;

import it.objectmethod.worldmvc.domain.City;

public interface ICityListDao {

	public List<City> getCityByCountry(String code);

}