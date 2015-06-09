

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
	    
	     SortedListOf<GroupData> oldList= 
	    		 new SortedListOf<GroupData>( app.getHibernateHelper().listGroups());
	     
	     //action
	    app.getGroupHelper().createGroup(group);
		
	  
	    // save new
	    SortedListOf<GroupData> newList=
	    		 new SortedListOf<GroupData>( app.getHibernateHelper().listGroups());
	     
	   	   
	    
	     //compare
	     //assertEquals(newList.size(),oldList.size()+1); -проверка на размер
	    
	  	    
	    assertThat(newList,equalTo(oldList.withAdded(group)));
	   /* oldList.add(group);	    	  	     
	     Collections.sort(oldList);	   	      
	   assertEquals(newList,oldList); */
	  }
	
}