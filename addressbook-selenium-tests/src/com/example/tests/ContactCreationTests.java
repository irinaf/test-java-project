
	package com.example.tests;

	import org.testng.annotations.Test;
	


	public class ContactCreationTests extends TestBase {
	  @Test
	  public void testNonEmptyContact() throws Exception {
	   // driver.get(baseUrl + "/addressbookv4.1.4/");
		openMainPage();  
	    gotoContactPage();
	    //ContactData contacts = new ContactData("Ольга", "Попова", "Москва, ул. Новикова, 2", "8(495)222-33-44", "olga@mail.ru", "15", "February", "1980");
		
	    ContactData contacts = new ContactData();
	    contacts.f_name="IRINA";
	    contacts.l_name= "KOTOVA";
	    contacts.addr= "Москва, ул. Новикова, 2";
	    contacts.e_mail= "olga@mail.ru";
	    contacts.phone="8(495)222-33-44";
	    contacts.b_day="15";
	    contacts.b_month="February";
	    contacts.b_year="1980";
	    
	    fillContactForm(contacts);
	    submitContact();
	    gotoHomePage();
	  }

	  
	 
	}



