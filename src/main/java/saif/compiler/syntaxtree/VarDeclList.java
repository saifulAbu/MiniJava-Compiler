package saif.compiler.syntaxtree;

import java.util.Vector;

public class VarDeclList {
	private Vector list;
	
	public VarDeclList(){
		list = new Vector();
	}
	
	public void addElement(VarDecl varDecl){
		list.addElement(varDecl);		
	}
	
	public VarDecl elementAt(int index){
		return (VarDecl) list.elementAt(index);
	}
	
	public int size(){
		return list.size();
	}
}
