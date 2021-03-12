package it.objectmethod.worldmvc.dao;


import java.util.List;

import it.objectmethod.worldmvc.domain.Country;

public interface ICountryDao {

	public Country getCountryByName(String nameCountry);
	
	public List<Country> getCountryByContinent(String continent);
}
