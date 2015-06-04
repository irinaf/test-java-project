package com.example.fw;




import java.io.IOException;
import java.util.Properties;




import java.util.Properties;
public class ApplicationManager {



	
	
	private Process exec;
	private Properties properties;
	private ContactHelper contactHelper;
	private AutoItHelper autoItHelper;
	
	
	public ApplicationManager(Properties properties) throws IOException {
		
		this.properties = properties;
		String command=properties.getProperty("app.path");
		exec=Runtime.getRuntime().exec(command);
	}
	
	
	public void stop() {
		
		//exec.destroy();
		
	}


	public ContactHelper getContactHelper() {

		if (contactHelper ==null){
			contactHelper=new ContactHelper(this);
		}
		return contactHelper;
	}


/*	public FolderHelper getFolderHelper() {
		
		if (folderHelper ==null){
			folderHelper=new FolderHelper(this);
		}
		return folderHelper;
	} */



	public AutoItHelper getAutoItHelper() {

		if (autoItHelper ==null){
			autoItHelper=new AutoItHelper(this);
		}
		return autoItHelper;
	}

	

	

	

}

