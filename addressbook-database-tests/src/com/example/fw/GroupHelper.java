package com.example.fw;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;
import com.example.utils.SortedListOf;


public class GroupHelper extends WebDriverHelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
		
	}

	
/*	private SortedListOf<GroupData> cachedGroups; 
	
	public SortedListOf<GroupData> getGrous() {
		
		if (cachedGroups==null){
			rebuildCache();
		}
		return cachedGroups; 
	}	
	
	
	private void rebuildCache() {
		//ListOf<GroupData> cachedGroups= new ArrayList<GroupData>();	
		cachedGroups=new SortedListOf<GroupData>();	
		manager.navigateTo().groupsPage();
		List<WebElement> checkboxes=driver.findElements(By.name("selected[]"));
	for(WebElement checkbox: checkboxes)
	{
		
		String title= checkbox.getAttribute("title");
		String name=title.substring("Select (".length(),title.length()-")".length());
		cachedGroups.add(new GroupData().withName(name));
		
	}
		
}
  */
	
	public SortedListOf<GroupData>  getUiGroups() {
		//ListOf<GroupData> cachedGroups= new ArrayList<GroupData>();	
		SortedListOf<GroupData> groups=new SortedListOf<GroupData>();	
		manager.navigateTo().groupsPage();
		List<WebElement> checkboxes=driver.findElements(By.name("selected[]"));
	for(WebElement checkbox: checkboxes)
	{
		
		String title= checkbox.getAttribute("title");
		String name=title.substring("Select (".length(),title.length()-")".length());
		groups.add(new GroupData().withName(name));
		
	}
		return groups;
}

	public GroupHelper createGroup(GroupData group) {
		  manager.navigateTo().groupsPage();
		  initGroupCreation();	    
		  fillGroupForm(group);
	      submitGroupCreation();
	      returnToGroupPage();
	     //update model;
	      manager.getModel().addGroup(group);
	     // rebuildCache();
	      return this;
		
	}
	
  public GroupHelper deleteGroup(int index) {
		
		selectGroupByIndex(index);
		submitGroupDeletion();
		returnToGroupPage();
		 manager.getModel().removeGroup(index);
		//rebuildCache();
		return this;
		
	}


	
  public GroupHelper modifyGroup(int index, GroupData group) {
	      
	      initGroupModification(index);
	      fillGroupForm(group);
	      submitGroupModification();
	      returnToGroupPage();
	      manager.getModel().removeGroup(index).addGroup(group);
	      //     rebuildCache();
	
	      return this;
	}
	//----------------------------------------------------------------------
	
	public GroupHelper initGroupCreation() {
		click(By.name("new"));
		return this;
	}

	public  GroupHelper fillGroupForm(GroupData group) {
		type(By.name("group_name"), group.getName());
		type(By.name("group_header"), group.getHeader());
		type(By.name("group_footer"), group.getFooter());
		return this;
	   
	}

	public GroupHelper submitGroupCreation() {
		click(By.name("submit"));
		//cachedGroups=null;
		return this;
		
	}

	private void submitGroupDeletion() {
		click(By.name("delete"));
		//cachedGroups=null;
	}
	public GroupHelper returnToGroupPage() {
		click(By.linkText("group page"));
		return this;
	}

	

	private GroupHelper selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" +(index+1)+ " ]"));
		return this;
	}

	public GroupHelper initGroupModification(int index) {
		
		selectGroupByIndex(index);
		click(By.name("edit"));
		return this;
	}

	public GroupHelper submitGroupModification() {
		
		click(By.name("update"));
		//cachedGroups=null;
		return this;
	}

	

	
	

}
