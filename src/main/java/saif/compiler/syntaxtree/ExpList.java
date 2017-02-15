package saif.compiler.syntaxtree;

import java.util.Vector;

public class ExpList {
	private Vector list;
	
	public ExpList(){
		list = new Vector();
	}
	
	public void addElement(Exp expression){
		list.addElement(expression);		
	}
	
	public Exp elementAt(int index){
		return (Exp) list.elementAt(index);
	}
	
	public int size(){
		return list.size();
	}
}
