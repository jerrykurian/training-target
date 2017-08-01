package com.itrapp.web;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itrapp.enduser.PersonDetailsManager;
import com.itrapp.entities.Person;

/**
 * Servlet implementation class PersonServlet
 */
@Controller
public class PersonServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PersonDetailsManager personDetailsManager;
   
	// GET <ip:port>/person?id=1
	@RequestMapping("/person")
	public ModelAndView findPerson(@RequestParam("id") long id) {
		// TODO Auto-generated method stub
		System.out.println("Got the ID " + id);
		Person person = personDetailsManager.findPersonById(id);
		System.out.println("Got Person Details Manager " + personDetailsManager);
		return new ModelAndView("viewpersondetails","person",person);
	}
	
	// POST <ip:port>/person
	@RequestMapping(method=RequestMethod.POST, value="/person")
	public ModelAndView createPerson(@ModelAttribute("person")
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

}
