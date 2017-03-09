package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class AssignmentStatement extends Statement{
	public Identifier id;
	public Exp exp;
	
	public AssignmentStatement(Identifier id, Exp exp){
		this.id = id;
		this.exp = exp;
	}

	@Override
	public Object accept(Visitor visitor) {
		return visitor.visit(this);		
	}
}
