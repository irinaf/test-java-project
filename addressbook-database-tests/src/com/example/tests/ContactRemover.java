package com.example.tests;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;


public class ContactRemover extends TestBase {

 @Test
public void deleteContact(){
	 
			 
			 // save old
	// SortedListOf<ContactData> oldList=app.getContactHelper().getContacts();
	 
	  SortedListOf<ContactData> oldList= 
	  		 new SortedListOf<ContactData>( app.getHibernateHelper().listContacts());

	  Random rnd =new Random();
		     int index= rnd.nextInt(oldList.size()-1);
		  
		   
	     
		     
		     //app.getContactHelper().getContacts();
		     app.getContactHelper().deleteContact(index,oldList);
		   
		     
		     // save new
	//SortedListOf<ContactData> newList=app.getContactHelper().getContacts();
		    
		     SortedListOf<ContactData> newList= 
		    		 new SortedListOf<ContactData>( app.getHibernateHelper().listContacts());  
		     
		     //compare
			    
		  /*  oldList.remove(index);	           	     
		     Collections.sort(oldList);
		    assertEquals(newList,oldList); */ 
		
		     assertThat(newList,equalTo(oldList.without(index)));
		     
		     
		     if("yes".equals(app.getProperty("check.ui"))){
		    	   	  assertThat(app.getContactHelper().getContacts(),equalTo(app.getHibernateHelper().listContacts()));
		    	 }
		    
		     
			 
		 }



	
}

