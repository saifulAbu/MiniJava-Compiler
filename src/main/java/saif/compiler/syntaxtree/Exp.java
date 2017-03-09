package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public abstract class Exp {
	public abstract Object accept(Visitor visitor);
}
