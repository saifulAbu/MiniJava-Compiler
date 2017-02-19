package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class PrintStatement extends Statement{
	Exp e;
	public PrintStatement(Exp e){
		this.e = e;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);		
	}
}
