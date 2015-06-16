

package com.example.tests;



import static com.example.tests.GroupDataGenerator.loadGroupsFromCsvFile;
import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;




import com.example.utils.SortedListOf;


	public class GroupCreationTests extends TestBase {
	 
			
		@DataProvider
		public Iterator<Object[]> groupsFromFile() throws IOException{
			//return wrapGroupsForDataProvider(loadGroupsFromCsvFile (new File("groups.txt"))).iterator();
			return wrapGroupsForDataProvider(loadGroupsFromXmlFile (new File("groups.xml"))).iterator();
		}

	//@Test(dataProvider="randomValidGroupGenerator")
		@Test(dataProvider="groupsFromFile")	
	public void testGroupCreationWithValidData(GroupData group) throws Exception {
		 	       
	     // save old
	    
	   /*  SortedListOf<GroupData> oldList= 
	    		 new SortedListOf<GroupData>( app.getHibernateHelper().listGroups()); */
			
			
			SortedListOf<GroupData> oldList= 
		    		 new SortedListOf<GroupData>( app.getModel().getGroups());			
			
	    
	     
	     //action
	    app.getGroupHelper().createGroup(group);
		
	  
	    // save new
	  /*  SortedListOf<GroupData> newList=
	    		 new SortedListOf<GroupData>( app.getHibernateHelper().listGroups()); */
	    
	    SortedListOf<GroupData> newList=
	    		 new SortedListOf<GroupData>( app.getModel().getGroups());
	    
	   
	    
	     //compare states
	     //assertEquals(newList.size(),oldList.size()+1); -проверка на размер
	    
	
	     
	    
	   // System.out.println ("OLD2  " + oldList); 
	    
	    assertThat(newList,equalTo(oldList.withAdded(group)));
	    

	    
	    //compare model to implementation
	    if (wantToCheck()){
	    if("yes".equals(app.getProperty("check.db")))
	    		  assertThat(app.getModel().getGroups(),equalTo(app.getHibernateHelper().listGroups()));	 
	    
         
	    if("yes".equals(app.getProperty("check.ui")))
	    	      assertThat(app.getModel().getGroups(),equalTo(app.getGroupHelper().getUiGroups()));
	    /* oldList.add(group);	    	  	     
	     Collections.sort(oldList);	   	      
	   assertEquals(newList,oldList); */
	 
	      }
	}
}