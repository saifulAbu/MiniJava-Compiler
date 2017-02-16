package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class NewObject extends Exp{
	Identifier id;
	
	public NewObject(Identifier id){
		this.id = id;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
