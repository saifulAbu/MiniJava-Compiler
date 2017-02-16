package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class NotExpression extends Exp{
	Exp exp;
	
	public NotExpression(Exp exp){
		this.exp = exp;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
