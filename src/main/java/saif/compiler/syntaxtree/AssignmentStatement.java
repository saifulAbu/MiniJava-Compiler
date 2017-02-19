package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class AssignmentStatement extends Statement{
	Identifier id;
	Exp exp;
	
	public AssignmentStatement(Identifier id, Exp exp){
		this.id = id;
		this.exp = exp;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);		
	}
}
