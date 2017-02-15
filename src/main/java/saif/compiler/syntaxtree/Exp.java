package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public abstract class Exp {
	public abstract void accept(Visitor visitor);
}
