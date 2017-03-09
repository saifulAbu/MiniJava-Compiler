package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class IdentifierExpression extends Exp{
	public String id;
	
	public IdentifierExpression(String id){
		this.id = id;
	}
	
	@Override
	public Object accept(Visitor visitor) {
		return visitor.visit(this);
	}
}
