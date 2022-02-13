package jfsd.assessments.phase2.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jfsd.assessments.phase2.database.ProductsDB;
import jfsd.assessments.phase2.entities.Product;

/**
 * Servlet implementation class ProductFinder
 */
@WebServlet(name = "FindProductServlet", urlPatterns = "/findProduct")
public class FindProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor. 
	 */
	public FindProductServlet() {
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param = request.getParameter("pid");
		if(param != null && param != "") {
			int pid = Integer.parseInt(param);

			Product prod = ProductsDB.getProduct(pid);
			if(prod != null) {
				RequestDispatcher rd = request.getRequestDispatcher("viewProduct.jsp");
				request.setAttribute("product", prod);
				rd.forward(request, response);
				return;
			}
		}

		PrintWriter out = response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("index.html");
		rd.include(request,  response);
		out.println("<br/><center><span style='color:red'>Product not found.</span></center>");
	}

}
