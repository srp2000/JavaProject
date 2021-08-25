package com.amdocs.training.dao;

import java.util.List;

import com.amdocs.training.model.Contact;

public interface ContactDAO {
	boolean saveContact(Contact contact);
	List<Contact> viewContact();
	int deleteContact(int a);
}
