package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class ArrayAssignmentStatement extends Statement{
	Identifier id;
	Exp e1;
	Exp e2;
	public ArrayAssignmentStatement(Identifier id, Exp e1, Exp e2){
		this.id = id;
		this.e1 = e1;
		this.e2 = e2;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);		
	}
}
