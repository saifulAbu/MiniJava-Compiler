package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class ArrayLength extends Exp{
	public Exp e1; //e1.length
	
	public ArrayLength(Exp e1){
		this.e1 = e1;
	}
	
	@Override
	public Object accept(Visitor visitor) {
		return visitor.visit(this);
	}
}
