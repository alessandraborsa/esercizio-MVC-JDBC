package it.objectmethod.worldmvc.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import it.objectmethod.worldmvc.dao.ICityDao;
import it.objectmethod.worldmvc.dao.impl.CityDaoImpl;
import it.objectmethod.worldmvc.domain.City;

@WebServlet("/city")
public class CityServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String nameCity = req.getParameter("nameCity");
	
		ICityDao cityDao = new CityDaoImpl();
		City city = null;
		try {
			city = cityDao.getCityByName(nameCity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("city", city);

		

		req.getRequestDispatcher("show-data-city.jsp").forward(req, resp);
	}
}
