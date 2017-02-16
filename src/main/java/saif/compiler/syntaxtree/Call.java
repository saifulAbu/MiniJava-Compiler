package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class Call extends Exp{
	Exp e;
	Identifier id;
	ExpList expList;
	
	public Call(Exp e, Identifier id, ExpList expList){
		this.e = e;
		this.id = id;
		this.expList = expList;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
