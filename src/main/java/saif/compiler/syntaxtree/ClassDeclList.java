package saif.compiler.syntaxtree;

import java.util.Vector;

public class ClassDeclList {
	private Vector list;
	
	public ClassDeclList(){
		list = new Vector();
	}
	
	public void addElement(ClassDecl classDecl){
		list.addElement(classDecl);		
	}
	
	public ClassDecl elementAt(int index){
		return (ClassDecl) list.elementAt(index);
	}
	
	public int size(){
		return list.size();
	}
}
