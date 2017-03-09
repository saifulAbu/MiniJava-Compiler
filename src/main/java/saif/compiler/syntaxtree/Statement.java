package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public abstract class Statement {
	public abstract Object accept(Visitor visitor);
}
