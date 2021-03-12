package it.objectmethod.worldmvc.dao;


import it.objectmethod.worldmvc.domain.Country;

public interface ICountryDao {

	public Country getCountryByName(String nameCountry);
}
