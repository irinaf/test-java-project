

package com.example.tests;



import java.util.*;

import  static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;


	public class GroupCreationTests extends TestBase {
	 
			
		
	@Test(dataProvider="randomValidGroupGenerator")
	  public void testGroupCreationWithValidData(GroupData group) throws Exception {
		 app.getNavigationHelper().openMainPage();
	     app.getNavigationHelper().gotoGroupPage();
	    
	     // save old
	     List<GroupData> oldList=app.getGroupHelper().getGrous();
	     
	     //action
	     app.getGroupHelper().initGroupCreation();
	    
		app.getGroupHelper().fillGroupForm(group);
	    app.getGroupHelper().submitGroupCreation();
	    app.getGroupHelper().returnToGroupPage();
	  
	    // save new
	     List<GroupData> newList=app.getGroupHelper().getGrous(); 
	     
	   	   
	    
	     //compare
	     //assertEquals(newList.size(),oldList.size()+1); -�������� �� ������
	     oldList.add(group);
	     
	    	     
	    Collections.sort(oldList);
	  	      
	   assertEquals(newList,oldList);
	  }
	
}