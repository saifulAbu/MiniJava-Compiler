package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class NewArray extends Exp{
	public Exp e1;
	
	public NewArray(Exp e1){
		this.e1 = e1;
	}
	
	@Override
	public Object accept(Visitor visitor) {
		return visitor.visit(this);
	}
}
