package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class WhileStatement extends Statement{
	public Exp e;
	public Statement s;
	public WhileStatement(Exp e, Statement s){
		this.e = e;
		this.s = s;
	}
	
	@Override
	public Object accept(Visitor visitor) {
		return visitor.visit(this);		
	}
}
