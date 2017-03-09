package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class Block extends Statement{
	public StatementList stmtList;
	
	public Block(StatementList stmtList){
		this.stmtList = stmtList;
	}
	
	@Override
	public Object accept(Visitor visitor) {
		return visitor.visit(this);		
	}
}
