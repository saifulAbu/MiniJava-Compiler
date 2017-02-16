package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class ArrayLookup extends Exp{
	Exp e1, e2;
	
	public ArrayLookup(Exp e1, Exp e2){
		this.e1 = e1;
		this.e2 = e2;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}