package com.amdocs.training.client;

import java.util.ArrayList;
import java.util.List;

import com.amdocs.training.dao.ContactDAO;
import com.amdocs.training.dao.impl.ContactDAOImpl;
import com.amdocs.training.model.Contact;
public class ContactClient {
public static void main(String[] args) {
	
		List<Contact> contacts=new ArrayList<>();
		ContactDAO dao = new ContactDAOImpl();
//		Contact contact = new Contact(101, "Ankit", "ankit@gmail.com", 1234, "Message",2);
//		if(dao.saveContact(contact)) {
//		System.out.println("Contact Added Successfully");
//		}
//		else {
//		System.out.println("Error Cannot Insert");
//		}
		contacts=dao.viewContact();
		System.out.println("hello");
		contacts.forEach((n)-> System.out.println(n));
	}
}