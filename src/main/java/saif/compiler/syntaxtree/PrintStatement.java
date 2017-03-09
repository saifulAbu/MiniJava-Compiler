package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class PrintStatement extends Statement{
	public Exp e;
	
	public PrintStatement(Exp e){
		this.e = e;
	}
	
	@Override
	public Object accept(Visitor visitor) {
		return visitor.visit(this);		
	}
}
