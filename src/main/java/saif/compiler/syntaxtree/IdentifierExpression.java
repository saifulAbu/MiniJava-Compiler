package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class IdentifierExpression extends Exp{
	String id;
	
	public IdentifierExpression(String id){
		this.id = id;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
