package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class ArrayLength extends Exp{
	Exp e1;
	
	public ArrayLength(Exp e1){
		this.e1 = e1;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
