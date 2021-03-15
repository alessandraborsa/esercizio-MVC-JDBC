package it.objectmethod.worldmvc.dao;


import java.util.List;

import it.objectmethod.worldmvc.domain.City;
import it.objectmethod.worldmvc.domain.Country;

public interface ICountryDao {

	public List<Country> getCountryByName(String nameCountry, String nameContinent);
	
//	public  getCountryByContinent(String continent);
	

}
