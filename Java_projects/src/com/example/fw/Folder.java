package com.example.fw;
import java.util.*;

public class Folder {
	
	private List<String> storedFolders=null;
	
	public Folder (List<String>folders) {
		this.storedFolders=new ArrayList<String> (folders);
		
	}

	public Folder withAdded(String folder) {
		
		Folder newList=new Folder (storedFolders);
		newList.storedFolders.add(folder);
		return newList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((storedFolders == null) ? 0 : storedFolders.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Folder other = (Folder) obj;
		if (storedFolders == null) {
			if (other.storedFolders != null)
				return false;
		} else if (!storedFolders.equals(other.storedFolders))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Folder [" + storedFolders + "]";
	}

	
	
}
