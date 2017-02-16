package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class TrueLiteral extends Exp{
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
