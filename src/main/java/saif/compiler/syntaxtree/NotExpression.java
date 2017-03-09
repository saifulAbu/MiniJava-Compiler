package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class NotExpression extends Exp{
	public Exp exp;
	
	public NotExpression(Exp exp){
		this.exp = exp;
	}

	@Override
	public Object accept(Visitor visitor) {
		return visitor.visit(this);
	}
}
