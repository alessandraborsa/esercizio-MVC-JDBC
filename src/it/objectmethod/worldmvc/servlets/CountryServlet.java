package it.objectmethod.worldmvc.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import it.objectmethod.worldmvc.dao.CountryDaoImpl;
import it.objectmethod.worldmvc.dao.ICountryDao;

import it.objectmethod.worldmvc.domain.Country;

@WebServlet("/country")
public class CountryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nameCountry = req.getParameter("nameCountry");
		String nameContinent = req.getParameter("nameContinent");
		
		List<Country> countryList = new ArrayList<>();
		List<String> continents = new ArrayList<>();
		ICountryDao countryDao = new CountryDaoImpl();
			
		if(nameCountry == null) {
			nameCountry = "";
		}

		countryList = countryDao.getCountryByName(nameCountry, nameContinent);
		continents = countryDao.getContinent();
		
		req.setAttribute("countryList", countryList);
		req.setAttribute("continents", continents);

		req.getRequestDispatcher("show-country.jsp").forward(req, resp);

	}

}
