package ec.cjpq.core.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ModuleHomeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		String [] uri = request.getRequestURI().split("/");
	
		/**
		System.out.println("==========================================" + uri.length );
		for(String chain: uri)
			System.out.println("==========================================" + chain);
		*/

		if (uri.length < 4) {
			dispatcher = request.getRequestDispatcher("/xava/homeMenu.jsp");
		} else {
			dispatcher = request.getRequestDispatcher("/xava/home.jsp?application=" + uri[1] + "&module=" + uri[3]);
			//dispatcher = request.getRequestDispatcher("/xava/module.jsp?application=" + uri[1] + "&module=" + uri[3]);
		}
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
