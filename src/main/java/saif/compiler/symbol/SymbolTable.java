package saif.compiler.symbol;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
	String mainClassName = null;
	Map<String, ClassEntry> classMap = new HashMap<>();
	
	public boolean addClassEntry(String className, ClassEntry classEntry){
		if(classMap.containsKey(className)){
			return false;
		}
		classMap.put(className, classEntry);
		return true;
	}
	
	public ClassEntry getClassEntry(String className){
		return classMap.get(className);
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
	
	public void printSymbolTable(){
		System.out.println("mainclass :: "+ mainClassName);
		for(String className : classMap.keySet()){
			if(className.equals(mainClassName)){
				continue;
			}
			System.out.println("className :: " + className);
			classMap.get(className).printClassEntry();
			System.out.println();
		}
	}
}
