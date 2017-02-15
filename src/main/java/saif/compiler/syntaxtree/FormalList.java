package saif.compiler.syntaxtree;

import java.util.Vector;

public class FormalList {
	private Vector list;
	
	public FormalList(){
		list = new Vector();
	}
	
	public void addElement(FormalParameter formalParameter){
		list.addElement(formalParameter);		
	}
	
	public FormalParameter elementAt(int index){
		return (FormalParameter) list.elementAt(index);
	}
	
	public int size(){
		return list.size();
	}
}
