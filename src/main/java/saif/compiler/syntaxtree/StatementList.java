package saif.compiler.syntaxtree;

import java.util.Vector;

public class StatementList {
	private Vector list;
	
	public StatementList(){
		list = new Vector();
	}
	
	public void addElement(Statement stmt){
		list.addElement(stmt);		
	}
	
	public Statement elementAt(int index){
		return (Statement) list.elementAt(index);
	}
	
	public int size(){
		return list.size();
	}
}
