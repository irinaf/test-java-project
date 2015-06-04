package com.example.fw;

import java.util.ArrayList;
import java.util.List;





import javax.swing.JDialog;

import org.netbeans.jemmy.operators.JButtonOperator;
import org.netbeans.jemmy.operators.JDialogOperator;
import org.netbeans.jemmy.operators.JTextFieldOperator;
import org.netbeans.jemmy.operators.JTreeOperator;


public class FolderHelper extends HelperBase {

	

	public FolderHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	
	} 

	public Folder getFolders() {
		List<String>list=new ArrayList<String>();
  	JTreeOperator tree = new JTreeOperator(mainFrame);
	//	JTreeOperator tree = new JTreeOperator(manager.getApplication());	
	Object[] children=tree.getChildren(tree.getRoot());
	for(Object child :children){
		list.add(""+child);
	}
		return new Folder (list);
	}


	
	public String createFolder(String folderName) {
		
		manager.getMenuHelper().pushCreateFolder();
		//JDialogOperator dialog=new JDialogOperator(manager.getApplication());
		JDialogOperator dialog=new JDialogOperator(mainFrame);
		new JTextFieldOperator(dialog).setText(folderName);
		new JButtonOperator(dialog,"OK").push();
		return waitMessageDialog("Warning",3000);
	
	}

	
	
	
	
	
		

}
