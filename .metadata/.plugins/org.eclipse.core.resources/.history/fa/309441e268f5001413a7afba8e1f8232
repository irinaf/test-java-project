package com.example.tests;

import org.testng.annotations.Test;

public class ContactModification extends TestBase{

	@Test
	public void modifyContact(){
	
	app.getNavigationHelper().openMainPage();
	app.getContactHelper().initContactModification(2);   
	
	ContactData contacts=new ContactData();
    contacts.f_name="Îëÿ";
    contacts.l_name="Ivanova";
    contacts.b_month="January";
	
    app.getContactHelper().fillContactForm(contacts);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().gotoHomePage();
	
   }
}	
