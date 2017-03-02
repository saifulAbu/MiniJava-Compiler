package saif.compiler.syntaxtable;

import java.util.HashMap;
import java.util.Map;

public class SyntaxTable {
	String mainClassName = null;
	Map<String, ClassEntry> classMap = new HashMap<>();
	
	public boolean addClassEntry(String className, ClassEntry classEntry){
		if(classMap.containsKey(className)){
			return false;
		}
		classMap.put(className, classEntry);
		return true;
	}
	
	public boolean setMainClass(String mainClassName){
		if(this.mainClassName != null){
			return false;
		}
		this.mainClassName = mainClassName;
		return true;
	}
	
	public String getMainClassName(){
		return mainClassName;
	}
}
