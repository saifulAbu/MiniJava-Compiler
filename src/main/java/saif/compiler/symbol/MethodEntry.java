package saif.compiler.symbol;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MethodEntry{
	public String methodName;
	public String returnType;
	Map<String, String> paramMap = new HashMap<>();
	Map<String, String> localMap = new HashMap<>();
	List<String> parameterTypeList = new LinkedList<>();
	
	public MethodEntry(String methodName, String returnType){
		this.methodName = methodName;
		this.returnType = returnType;
	}
	
	public boolean addParameter(String paramName, String type){
		if(paramMap.containsKey(paramName)){
			return false;
		}
		paramMap.put(paramName, type);
		return true;
	}
	
	public boolean addLocal(String varName, String type){
		//check in parameter map and local map
		if(paramMap.containsKey(varName) || localMap.containsKey(varName)){
			return false;
		}
		localMap.put(varName, type);
		return true;
	}
	
	public String getVariableType(String variableName){
		String type = null;
		if(paramMap.containsKey(variableName)){
			type = paramMap.get(variableName);
		}else{
			type = localMap.get(variableName);
		}
		return type;
	}
	
	public void addParameterType(String type){
		parameterTypeList.add(type);			
	}
	
	public String getParameterTypeAtPosition(int position){
		return parameterTypeList.get(position);
	}
	
	public int getParamCount(){
		return parameterTypeList.size();
	}

	public void printMethodEntry() {
		String types = "";
		for(String type : parameterTypeList){
			types = types + type + " ";
		}
		System.out.println("\t" + returnType + " " + methodName + "(" + types + ")");
		println("params");
		printlnBrk();
		for(String paramName : paramMap.keySet()){
			println(paramName + " -- " + paramMap.get(paramName));
		}
		println("");
		println("locals");
		printlnBrk();
		for(String local : localMap.keySet()){
			println(local + " -- " + localMap.get(local));
		}
		println("");
	}
	
	private void println(String line){
		String indentation = "\t\t";
		System.out.println(indentation + line);
	}
	
	private void printlnBrk(){
		println("=====================");
	}
}
