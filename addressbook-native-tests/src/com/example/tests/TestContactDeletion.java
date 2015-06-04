package com.example.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.fw.Contact;

public class TestContactDeletion extends TestBase {
	
	@Test
	public void shouldDeleteContacts() throws InterruptedException  {

		 Contact createdContact= app.getContactHelper().getFirstContact();
		app.getContactHelper().deleteContact();
	    int resultDeletion=app.getContactHelper().checkContactDeletion(createdContact);
		app.getContactHelper().exitFormDeletion(); 
	    Assert.assertNotEquals(resultDeletion, 0);
	   
		
}

}