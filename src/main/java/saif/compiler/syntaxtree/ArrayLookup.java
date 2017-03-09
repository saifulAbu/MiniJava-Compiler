package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class ArrayLookup extends Exp{
	public Exp e1, e2; //e1 is int[], e2 is int index
	
	public ArrayLookup(Exp e1, Exp e2){
		this.e1 = e1;
		this.e2 = e2;
	}
	
	@Override
	public Object accept(Visitor visitor) {
		return visitor.visit(this);
	}
}
