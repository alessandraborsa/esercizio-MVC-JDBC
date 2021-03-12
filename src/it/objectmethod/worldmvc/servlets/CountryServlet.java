package it.objectmethod.worldmvc.servlets;

import java.io.IOException;

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
		ICountryDao countryDao = new CountryDaoImpl();
		Country country = null;
		try {
			country = countryDao.getCountryByName(nameCountry);
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("country", country);
		req.getRequestDispatcher("show-country.jsp").forward(req, resp);
	}
}
