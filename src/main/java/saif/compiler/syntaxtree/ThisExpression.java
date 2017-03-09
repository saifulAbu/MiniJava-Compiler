package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class ThisExpression extends Exp{
	@Override
	public Object accept(Visitor visitor) {
		return visitor.visit(this);
	}
}
