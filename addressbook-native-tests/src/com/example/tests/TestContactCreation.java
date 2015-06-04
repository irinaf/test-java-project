package com.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.fw.Contact;

public class TestContactCreation extends TestBase {
	
	@Test
	public void shouldCreateContactsWithValidData()  {

		Contact contact=new Contact().setFirstName("tester").setLastName("tester");
		app.getContactHelper().createContact(contact);
	     Contact createdContact= app.getContactHelper().getFirstContact();
	     app.getContactHelper().exitForm();
	     Assert.assertEquals(contact, createdContact);
	  
		
}

}