package com.example.tests;
import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemover extends TestBase {

 @Test
public void deleteContact(){
	 

			 app.getNavigationHelper().openMainPage();
			 
			 // save old
		     List<ContactData> oldList=app.getContactHelper().getContacts();
		     Random rnd =new Random();
		     int index= rnd.nextInt(oldList.size()-1);
		     
		     app.getContactHelper().deleteContact(index);
		     app.getContactHelper().gotoHomePage();
		     
		     // save new
		     List<ContactData> newList=app.getContactHelper().getContacts(); 
		     
		     //compare
			    
		       oldList.remove(index);	           	     
		     
		    Collections.sort(oldList);
		    assertEquals(newList,oldList);
		
		    
			 
		 }



	
}

