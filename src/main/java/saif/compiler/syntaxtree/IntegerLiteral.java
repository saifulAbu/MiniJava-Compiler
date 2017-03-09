package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class IntegerLiteral extends Exp{
	int literal;
	
	public IntegerLiteral(int literal){
		this.literal = literal;
	}
	
	@Override
	public Object accept(Visitor visitor) {
		return visitor.visit(this);
	}
}
