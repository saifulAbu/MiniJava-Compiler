package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class WhileStatement extends Statement{
	Exp e;
	Statement s;
	public WhileStatement(Exp e, Statement s){
		this.e = e;
		this.s = s;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);		
	}
}
