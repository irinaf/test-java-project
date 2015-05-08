

	package com.example.tests;

	import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;
	


	public class ContactCreationTests extends TestBase
	
	{
	  @Test(dataProvider="randomValidContactGenerator")
	  public void testValidContactCreation(ContactData contacts) throws Exception {
	  
		app.getNavigationHelper().openMainPage();  
	   
	    
	    // save old
	     List<ContactData> oldList=app.getContactHelper().getContacts();
		
	  /*  ContactData contacts = new ContactData();
	    contacts.f_name="IRINA";
	    contacts.l_name= "KOTOVA";
	    contacts.addr= "������, ��. ��������, 2";
	    contacts.e_mail= "olga@mail.ru";
	    contacts.phone="8(495)222-33-44";
	    contacts.b_day="15";
	    contacts.b_month="February";
	    contacts.b_year="1980";    */
	    
	    app.getContactHelper().gotoContactPage();
	    app.getContactHelper().fillContactForm(contacts);
	    app.getContactHelper().submitContact();
	    app.getContactHelper().gotoHomePage();
	    

	    // save new
	     List<ContactData> newList=app.getContactHelper().getContacts(); 
	    
	     //compare
	    
	     
	     
	     
	     //assertEquals(newList.size(),oldList.size()+1); 
	     oldList.add(contacts);
	     
	        	     
	     
	    Collections.sort(oldList);
	    assertEquals(newList,oldList);
	
	    
	    
	  }

	  
	 
	}



