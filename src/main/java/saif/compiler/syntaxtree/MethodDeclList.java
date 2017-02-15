package saif.compiler.syntaxtree;

import java.util.Vector;

public class MethodDeclList {
	private Vector list;
	
	public MethodDeclList(){
		list = new Vector();
	}
	
	public void addElement(MethodDecl expression){
		list.addElement(expression);		
	}
	
	public MethodDecl elementAt(int index){
		return (MethodDecl) list.elementAt(index);
	}
	
	public int size(){
		return list.size();
	}
}
