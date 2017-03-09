package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class Call extends Exp{
	public Exp e;  //the object
	public Identifier id; //the method name
	public ExpList expList; //list of arguments
	
	public Call(Exp e, Identifier id, ExpList expList){
		this.e = e;
		this.id = id;
		this.expList = expList;
	}

	@Override
	public Object accept(Visitor visitor) {
		return visitor.visit(this);
	}
}
