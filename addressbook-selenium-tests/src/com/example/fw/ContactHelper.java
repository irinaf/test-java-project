package com.example.fw;


import java.util.List;






import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;




public class ContactHelper extends HelperBase {

	public static boolean CREATION=true;
	public static boolean MODIFICATION =false; 
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);
		
	}
   

	private SortedListOf<ContactData> cachedContacts; 
	
	public SortedListOf<ContactData> getContacts() {
		
		if (cachedContacts==null){
			rebuildCache();
		}
		return cachedContacts; 
	}	
	
	
		private void rebuildCache_old() {

			//List<ContactData> contacts= new ArrayList<ContactData>();
			cachedContacts=new SortedListOf<ContactData>();	
			manager.navigateTo().mainPage();
			List<WebElement> checkboxes=driver.findElements(By.name("selected[]"));
			for(WebElement checkbox: checkboxes)
			{
				//ContactData contact= new ContactData();
				String title= checkbox.getAttribute("title");
				String id = checkbox.getAttribute("value");
				title=title.substring("Select (".length(),title.length()-")".length());
				String f_name=title.substring(0,title.lastIndexOf(" "));
				String l_name=title.substring(title.lastIndexOf(" ")+1);
				//ContactData contact= new ContactData().withFirstName(f_name).withLastName(l_name);
				
				cachedContacts.add(new ContactData().withFirstName(f_name).withLastName(l_name).withId(id));
				
			}
			
	
		
	}
		

	private void rebuildCache() {

		//List<ContactData> contacts= new ArrayList<ContactData>();
		cachedContacts=new SortedListOf<ContactData>();	
		manager.navigateTo().mainPage();
		List<WebElement> checkboxes=driver.findElements(By.name("entry"));
		for(WebElement checkbox: checkboxes)
		{
			
			String id=checkbox.findElement(By.name("selected[]")).getAttribute("value");
			String f_name=checkbox.findElement(By.xpath(".//td[3]")).getText();
			String l_name=checkbox.findElement(By.xpath(".//td[2]")).getText();
			//ContactData contact= new ContactData().withFirstName(f_name).withLastName(l_name);
			cachedContacts.add(new ContactData().withFirstName(f_name).withLastName(l_name).withId(id));
			
		}
		
		
	}
	

	
	public ContactHelper createContacts(ContactData contacts) {
		manager.navigateTo().contactPage();
		//gotoContactPage();
		fillContactForm(contacts,CREATION);
	    submitContact();
	    gotoHomePage(); 
	    rebuildCache();
	    return this;
		
	}
	
	
	
	
public  ContactHelper deleteContact(int index) {
		
	    selectContactById(index, cachedContacts); 
	   //selectContactByIndex(index);
		submitContactDeletion();
		gotoHomePage();
	    rebuildCache();
		return this;
		
	}



public ContactHelper modifySomeContact(int index, ContactData contacts){
	initContactModification(index) ;  
	fillContactForm(contacts,MODIFICATION);
	submitContactModification();
	gotoHomePage();
	 rebuildCache();
	return this;
}

//--------------------------------------------------------------------------------------------	
	
	public ContactHelper initContactCeation() {
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper fillContactForm( ContactData contacts,boolean formType) {
	/* type(By.name("firstname"), contacts.f_name);	    
	   type(By.name("lastname"), contacts.l_name);  
	   type(By.name("address"), contacts.addr);
	   type(By.name("home"), contacts.phone);
	   type(By.name("email"), contacts.e_mail);	    
	   selectByText(By.name("bday"), contacts.b_day);
	   selectByText(By.name("bmonth"), contacts.b_month);
	   type(By.name("byear"), contacts.b_year);  */
		type(By.name("firstname"), contacts.getF_name());
	    type(By.name("lastname"), contacts.getL_name());  
	    type(By.name("address"), contacts.getAddr());
	    type(By.name("home"), contacts.getPhone());
	    type(By.name("email"), contacts.getE_mail());	
	    selectByText(By.name("bday"), contacts.getB_day());
	    selectByText(By.name("bmonth"), contacts.getB_month());
	    type(By.name("byear"), contacts.getB_year());
	  if (formType==CREATION){
		  
	  }
	  else {
		  driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	      boolean result = driver.findElements(By.name("new_group" )).size() > 0;
	      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	      if (result)
		   
		  //if (driver.findElements(By.name("new_group" )).size()!=0)
			  throw new Error ("Group selector exists in contact modification form");
	  }
	  
	  return this;
	} 

	
	public ContactHelper submitContact() {
		click(By.name("submit"));
		//cachedContacts=null;
		return this;
	}

	public ContactHelper gotoHomePage() {
		click(By.linkText("home"));
		return this;
	}

	


	private ContactHelper selectContactById(int index, SortedListOf<ContactData> cachedContacts) {
		
		
		String id =cachedContacts.get(index).getId();
		List<WebElement> checkboxes=driver.findElements(By.name("selected[]"));
	   
		for (int i=0; i<checkboxes.size();i++)
		{
	   
			String idFromList =checkboxes.get(i).getAttribute("value");
			 if ( idFromList.equals(id)) {
	     	 click(By.xpath(".//tr["+(i+2)+"]/td[7]/a/img"));
			 return this;
 	    		
	    	  }
	    	    		 
	    	  
	      }
	    
		 throw new Error( "��� ������ id");	
	   
		}
	

		
		
	
		
		


	private ContactHelper selectContactByIndex(int index) {
		
		index++;
		click(By.xpath("//tr["+(index+1)+"]/td[7]/a/img"));
		return this;
		
		
	}

	public ContactHelper initContactModification(int index) {
		selectContactByIndex(index);
		return this;
		
		
	}

	public ContactHelper submitContactModification()  {
		click(By.xpath("//input[@value='Update']"));
		cachedContacts=null;
		return this;
		
	}


	private void submitContactDeletion() {
		click(By.xpath("//input[@value='Delete']"));
		cachedContacts=null;
	}

	
	

}
