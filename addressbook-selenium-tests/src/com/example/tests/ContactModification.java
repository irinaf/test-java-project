package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModification extends TestBase{

	@Test(dataProvider="randomValidContactGenerator")
	public void modifyContact(ContactData contacts){
	
	app.getNavigationHelper().openMainPage();
	
	 // save old
    List<ContactData> oldList=app.getContactHelper().getContacts();
    Random rnd =new Random();
    int index= rnd.nextInt(oldList.size()-1);
	
	app.getContactHelper().initContactModification(index);   
	
	/*ContactData contacts=new ContactData();
    contacts.f_name="Îëÿ";
    contacts.l_name="Ivanova";
    contacts.b_month="January";*/
	
    app.getContactHelper().fillContactForm(contacts);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().gotoHomePage();
	
    // save new
    List<ContactData> newList=app.getContactHelper().getContacts(); 
    
    //compare
	    
      oldList.remove(index);	 
      oldList.add(contacts);
      Collections.sort(oldList);
      assertEquals(newList,oldList);
   }
}	
