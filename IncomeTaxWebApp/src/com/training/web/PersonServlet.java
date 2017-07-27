package com.training.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itrapp.enduser.PersonDetailsManager;
import com.itrapp.enduser.impl.PersonDetailsManagerImpl;
import com.itrapp.entities.Gender;
import com.itrapp.entities.Person;

/**
 * Servlet implementation class PersonServlet
 */
@WebServlet("/person")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PersonDetailsManager personDetailsManager;
       
    @Override
    public void init(){
    	this.personDetailsManager = new PersonDetailsManagerImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession httpSession = request.getSession();
		Person person = (Person) httpSession.getAttribute("person");
		if(person==null){
			System.out.println("Person not found. Redirecting");
			response.sendRedirect("persondetails.jsp");
		}else{
		
			System.out.println("Setting person " + person);
			request.setAttribute("person", person);
			httpSession.invalidate();
			System.out.println("Sendng using layout");
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("layout/header.jsp");
			dispatcher.include(request, response);
			dispatcher = request.
				getRequestDispatcher("viewpersondetails.jsp");
			dispatcher.include(request, response);
			dispatcher = request.getRequestDispatcher("layout/footer.jsp");
			dispatcher.include(request, response);
			// response.sendRedirect("viewpersondetails.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String age = request.getParameter("age");
		Gender gender = Gender.MALE;
		if(request.getParameter("gender").equals("F")){
			gender = Gender.FEMALE;
		}	
		System.out.println("Checking for firstName " + firstName);
		if(firstName != null && firstName.length()>0){
/*			HttpSession session = request.getSession();
			session.setAttribute("person_name", firstName);
			System.out.println("Stored the person");
*/			Person person = this.personDetailsManager.
				createPerson(firstName, lastName, 
						new Integer(age).intValue(), gender, null);
			request.getSession().setAttribute("person", person);
			response.sendRedirect("person");
		}else{
			request.setAttribute("error", "Missing Required Data");
			RequestDispatcher dispatcher = request.getRequestDispatcher("persondetails.jsp");
			dispatcher.forward(request, response);
		}
	}

}
