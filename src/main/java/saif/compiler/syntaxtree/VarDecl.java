package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class VarDecl {
	public Type varType;
	public Identifier varName;
	public VarDecl(Type varType, Identifier varName){
		this.varType = varType;
		this.varName = varName;
	}
	public Object accept(Visitor visitor) {
		return visitor.visit(this);
	}
}
