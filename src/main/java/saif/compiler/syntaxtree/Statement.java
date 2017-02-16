package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public abstract class Statement {
	public abstract void accept(Visitor visitor);
}
