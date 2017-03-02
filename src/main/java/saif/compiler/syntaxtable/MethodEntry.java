package saif.compiler.syntaxtable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MethodEntry{
	Map<String, String> paramMap = new HashMap<>();
	Map<String, String> localMap = new HashMap<>();
	List<String> parameterTypeList = new LinkedList<>();
	
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
}
