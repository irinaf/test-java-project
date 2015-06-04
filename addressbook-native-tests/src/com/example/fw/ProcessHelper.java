package com.example.fw;

public class ProcessHelper extends HelperBase {

	private Process exec;
	public ProcessHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	}
		
	/*  public void startAppUnderTest(){
			 String command=manager.getProperty("app.path");
			exec=Runtime.getRuntime().exec(command);
			
		}
	
      public void stopAppUnderTest(){
			exec.destroy();
		}
 */
}
