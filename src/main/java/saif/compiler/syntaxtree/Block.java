package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class Block extends Statement{
	StatementList stmtList;
	
	public Block(StatementList stmtList){
		this.stmtList = stmtList;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);		
	}
}
