package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase{
	
	
	 @Test(dataProvider="randomValidGroupGenerator")
public void modifySomeGroup(GroupData group)
	 
	 {
		
		 app.getNavigationHelper().openMainPage();
	     app.getNavigationHelper().gotoGroupPage();
	     
	     // save old
	     List<GroupData> oldList=app.getGroupHelper().getGrous();
	     
	     Random rnd =new Random();
	     int index=rnd.nextInt(oldList.size()-1);
	     
	     //actions
	     app.getGroupHelper().initGroupModification(index);
	     /*GroupData group=new GroupData();
	     group.name="new name"; */
	     
	     
		app.getGroupHelper().fillGroupForm(group);
	     app.getGroupHelper().submitGroupModification();
	     app.getGroupHelper().returnToGroupPage();
		 
	     // save new
	     List<GroupData> newList=app.getGroupHelper().getGrous(); 
	    
	     //compare
	    oldList.remove(index);
	    oldList.add(group);
	    Collections.sort(oldList);
	    assertEquals(newList,oldList);
	 
	 }


}
