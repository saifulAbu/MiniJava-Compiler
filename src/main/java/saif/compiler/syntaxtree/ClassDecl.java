package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public abstract class ClassDecl {
	public abstract void accept(Visitor visitor);
}
