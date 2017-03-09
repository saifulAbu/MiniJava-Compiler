package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class ArrayAssignmentStatement extends Statement{
	public Identifier id; //the array
	public Exp e1; //the index
	public Exp e2; //the value
	public ArrayAssignmentStatement(Identifier id, Exp e1, Exp e2){
		this.id = id;
		this.e1 = e1;
		this.e2 = e2;
	}
	
	@Override
	public Object accept(Visitor visitor) {
		return visitor.visit(this);		
	}
}
