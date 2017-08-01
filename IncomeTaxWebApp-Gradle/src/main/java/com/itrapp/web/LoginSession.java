package com.itrapp.web;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.itrapp.entities.Person;

@Component
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS, value="session")
public class LoginSession implements Serializable{
	private Person person;

	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
}
