package com.itrapp.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorldServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Init Called");
		super.init();
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = ""; // = request.getParameter("name");
		String name1 = request.getParameter("name1");
		String name2 = request.getParameter("name2");
		String[] names = request.getParameterValues("name");
		for(int i=0;i<names.length;i++){
			name = name + names[i];
		}
		System.out.println("Got name 1 " + name1);
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String resHtml = "<!DOCTYPE html> <html><head><title>Hello World</title></head>"+
				"<body bgcolor=\"#fdf5e6\">\n`" +
				"<h1>Test</h1>\n" +
				"<p>Hello " + name + "</p>\n" +
				"</body></html>";
		
		writer.println(resHtml);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		System.out.println("Got in do Post");
		response.getWriter().println("Welcome " + firstName + " " + lastName);
	}

}
