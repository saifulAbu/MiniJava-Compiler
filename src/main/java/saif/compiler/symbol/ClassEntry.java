package saif.compiler.symbol;

import java.util.HashMap;
import java.util.Map;

public class ClassEntry{
	public String className;
	public String returnType;
	Map<String, String> fieldMap = new HashMap<>();
	Map<String, MethodEntry> methodMap = new HashMap<>();
	
	public ClassEntry(String id) {
		this.className = id;
	}

	public boolean addField(String varName, String type){
		if(fieldMap.containsKey(varName)){
			return false;
		}
		fieldMap.put(varName, type);
		return true;
	}
	
	/**
	 * @param identifierName
	 * @param methodName must be a valid method name or null
	 * @return
	 */
	public String getVariableType(String identifierName, String methodName) {
		String varType = null;
		if(methodName != null){
			MethodEntry methodEntry = methodMap.get(methodName);
			varType = methodEntry.getVariableType(identifierName);
		}
		if(varType != null){
			return varType;
		}
		return fieldMap.get(identifierName);
	}
	
	public boolean addMethodEntry(String methodName, MethodEntry entry){
		if(methodMap.containsKey(methodName)){
			return false;
		}
		methodMap.put(methodName, entry);
		return true;
	}
	
	public MethodEntry getMethodEntry(String methodName){
		return methodMap.get(methodName);
	}

	public void printClassEntry() {
		println("fields");
		printlnBrk();
		for(String varName : fieldMap.keySet()){
			println(varName + " -- " + fieldMap.get(varName));
		}
		println("");
		println("methods");
		printlnBrk();
		for(String methodName : methodMap.keySet()){
			methodMap.get(methodName).printMethodEntry();
		}
		println("");
		
	}
	
	private void println(String line){
		String indentation = "\t";
		System.out.println(indentation + line);
	}
	
	private void printlnBrk(){
		println("=====================");
	}
}