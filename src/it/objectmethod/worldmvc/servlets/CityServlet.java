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

import it.objectmethod.worldmvc.dao.ICityDao;
import it.objectmethod.worldmvc.dao.CityDaoImpl;
import it.objectmethod.worldmvc.domain.City;

@WebServlet("/city")
public class CityServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String nameCity = req.getParameter("nameCity");
		String code = req.getParameter("code");
		ICityDao cityDao = new CityDaoImpl();
		City city = null;
		try {
			city = cityDao.getCityByName(nameCity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.setAttribute("city", city);

		List<City> cityList = new ArrayList<>();
		ICityDao cityDaoList = new CityDaoImpl();
		cityList = cityDaoList.getCityByCountry(code);
		session.setAttribute("cityList", cityList);

		req.getRequestDispatcher("show-data-city.jsp").forward(req, resp);
	}
}
