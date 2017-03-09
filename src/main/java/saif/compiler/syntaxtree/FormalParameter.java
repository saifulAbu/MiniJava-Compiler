package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class FormalParameter {
	public Type type;
	public Identifier varName;
	
	public FormalParameter(Type type, Identifier varName) {
		super();
		this.type = type;
		this.varName = varName;
	}

	public Object accept(Visitor visitor) {
		return visitor.visit(this);
	}
	
}
