package it.objectmethod.worldmvc.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.objectmethod.worldmvc.dao.CountryDaoImpl;
import it.objectmethod.worldmvc.dao.ICountryDao;
import it.objectmethod.worldmvc.domain.Country;

@WebServlet("/country")
public class CountryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String nameCountry = req.getParameter("nameCountry");
		String nameContinent = req.getParameter("nameContinent");
		List<Country> countryList = new ArrayList<>();
		ICountryDao countryDao = new CountryDaoImpl();
	
		
	
		countryList = countryDao.getCountryByName(nameCountry, nameContinent);
//		req.setAttribute("nameCountry", nameCountry);
//		req.setAttribute("nameContinent", nameContinent);
		
		session.setAttribute("countryList", countryList);

//		List<Country> countryList = new ArrayList<>();
//		ICountryDao countryDao2 = new CountryDaoImpl();
//		countryList = countryDao2.getCountryByContinent(nameContinent);
//		req.setAttribute("countryList", countryList);

		req.getRequestDispatcher("show-country.jsp").forward(req, resp);

	}

}
