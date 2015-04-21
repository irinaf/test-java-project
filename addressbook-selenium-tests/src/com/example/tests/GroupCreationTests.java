
package com.example.tests;



//import org.junit.*;



import org.testng.annotations.Test;


	public class GroupCreationTests extends TestBase {
	  @Test
	  public void testNonEmptygroupCreation() throws Exception {
		 openMainPage();
	     gotoGroupPage();
	    initGroupCreation();
	    GroupData group = new GroupData();
	    group.name="group name 1";
	    group.header="header 1";
	    group.footer="footer 1";
		fillGroupForm(group);
	    submitGroupCreation();
	    returnToGroupPage();
	  }
	  
	  
	  @Test
	  public void testEmptygroupCreation() throws Exception {
		 openMainPage();
	     gotoGroupPage();
	    initGroupCreation();
	    fillGroupForm(new GroupData("", "", ""));
	    submitGroupCreation();
	    returnToGroupPage();
	  }
	}
