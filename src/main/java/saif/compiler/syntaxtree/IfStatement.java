package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class IfStatement extends Statement{
	public Exp exp;
	public Statement s1, s2;
	
	public IfStatement(Exp exp, Statement s1, Statement s2){
		this.exp = exp;
		this.s1 = s1;
		this.s2 = s2;
	}
	
	@Override
	public Object accept(Visitor visitor) {
		return visitor.visit(this);		
	}
	
}
