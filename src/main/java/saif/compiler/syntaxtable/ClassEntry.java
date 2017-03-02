package saif.compiler.syntaxtable;

import java.util.HashMap;
import java.util.Map;

public class ClassEntry{
	Map<String, String> fieldMap = new HashMap<>();
	Map<String, MethodEntry> methodMap = new HashMap<>();
	
	boolean addField(String varName, String type){
		if(fieldMap.containsKey(varName)){
			return false;
		}
		fieldMap.put(varName, type);
		return true;
	}
	
	boolean addMethodEntry(String methodName, MethodEntry entry){
		if(methodMap.containsKey(methodName)){
			return false;
		}
		methodMap.put(methodName, entry);
		return true;
	}
}