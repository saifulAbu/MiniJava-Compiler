package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class ThisExpression extends Exp{
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
