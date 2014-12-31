package com.tkbaru.dao;

import com.tkbaru.model.Person;

public interface PersonDAO {
	public Person getPersonEntityById(int personId);
	
	public void addPerson(Person person);
	public void editPerson(Person person);
}
