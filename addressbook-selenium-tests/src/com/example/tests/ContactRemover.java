package com.example.tests;
import org.testng.annotations.Test;

public class ContactRemover extends TestBase {

 @Test
public void deleteContact(){
	 

			 app.getNavigationHelper().openMainPage();
		     app.getContactHelper().deleteContact(1);
		     app.getContactHelper().gotoHomePage();
			 
		 }



	
}

