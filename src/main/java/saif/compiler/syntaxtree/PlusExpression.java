package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class PlusExpression extends Exp{
	public Exp e1, e2;
	
	public PlusExpression(Exp e1, Exp e2){
		this.e1 = e1;
		this.e2 = e2;
	}
	
	@Override
	public Object accept(Visitor visitor) {
		return visitor.visit(this);
	}
}
