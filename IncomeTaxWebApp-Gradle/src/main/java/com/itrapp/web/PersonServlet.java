package com.itrapp.web;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itrapp.enduser.PersonDetailsManager;
import com.itrapp.enduser.UserNotFoundException;
import com.itrapp.entities.Person;

/**
 * Servlet implementation class PersonServlet
 */
@Controller
public class PersonServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private LoginSession loginSession;
	@Autowired
	private PersonDetailsManager personDetailsManager;
   
	@RequestMapping("/loginform")  
    public ModelAndView showLoginForm(){  
         //command is a reserved request attribute name, now use <form> tag to show object data
		System.out.println("Got request");
		Person person = new Person();
        return new ModelAndView("loginform","command",person);  
    }  
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView login(@ModelAttribute Person person){
		// Go to the database to check if the user with username and password exists
		try {
			person = personDetailsManager.findByUserNameAndPassword(person.getUserName(), 
					person.getPassword());
			person.setFirstName("Loggin");
			person.setLastName("User");
			// Once successfully logged in, store person to the session
			this.loginSession.setPerson(person);
			
			return new ModelAndView("viewpersondetails","person",person);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			ModelAndView mandv = new ModelAndView("loginform","command",person);
			mandv.addObject("error", "Invalid username or password");
			return mandv;
		}
	}	
	
	// GET <ip:port>/person?id=1
	@RequestMapping("/person")
	public ModelAndView findPerson(@RequestParam("id") long id) {
		// TODO Auto-generated method stub
		System.out.println("Got the ID " + id);
		Person person = personDetailsManager.findPersonById(id);
		System.out.println("Got Person Details Manager " + personDetailsManager);
		return new ModelAndView("viewpersondetails","person",person);
	}
	
	// GET <ip:port>/person/1
	@RequestMapping("/person/{id}")
	public ModelAndView findPersonById(
			@PathVariable("id") long id) {
		// TODO Auto-generated method stub
		System.out.println("Got the ID from path " + id);
		Person person = personDetailsManager.
				findPersonById(id);
		System.out.println("Got Person Details Manager " 
				+ personDetailsManager);
		return new ModelAndView("viewpersondetails",
				"person",person);
	}
	
	// POST <ip:port>/person
	@RequestMapping(method=RequestMethod.POST, value="/person")
	public ModelAndView createPerson(@ModelAttribute
		Person person){
		// TODO Auto-generated method stub
		System.out.println("Checking for firstName " + person.getFirstName());
		if(person.getFirstName() != null && person.getFirstName().length()>0){
			person = this.personDetailsManager.
				createPerson(person.getFirstName(), person.getLastName(), 
						person.getAge(), person.getGender(), null);
			return new ModelAndView("viewpersondetails","person",person);
		}else{
			return new ModelAndView("error");
		}
	}
	@RequestMapping("/personform")  
    public ModelAndView showform(){  
         //command is a reserved request attribute name, now use <form> tag to show object data
		System.out.println("Got request");
		Person person = new Person();
		person.setFirstName("Danny");
        return new ModelAndView("persondetails","command",person);  
    }  

}
