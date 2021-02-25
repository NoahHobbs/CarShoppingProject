package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Details;

/**
 * Servlet implementation class EditCarServlet
 */
@WebServlet("/editCarServlet")
public class EditCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		DetailsHelper dethel = new DetailsHelper();
		String year = request.getParameter("year");
		int intYear = Integer.parseInt(year);
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Details carToUpdate = dethel.searchForCarById(tempId);
		carToUpdate.setYear(intYear);
		carToUpdate.setMake(make);
		carToUpdate.setModel(model);
		dethel.updateItem(carToUpdate);
		getServletContext().getRequestDispatcher("/viewAllCarsServlet").forward(request, response);
		
	}

}
