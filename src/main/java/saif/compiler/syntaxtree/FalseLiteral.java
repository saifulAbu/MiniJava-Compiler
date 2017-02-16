package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class FalseLiteral extends Exp{
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
