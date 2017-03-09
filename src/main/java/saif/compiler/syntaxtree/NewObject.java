package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class NewObject extends Exp{
	public Identifier id;
	
	public NewObject(Identifier id){
		this.id = id;
	}
	
	@Override
	public Object accept(Visitor visitor) {
		return visitor.visit(this);
	}
}
