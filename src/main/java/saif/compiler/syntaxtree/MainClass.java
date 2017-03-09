package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class MainClass {
	public Identifier className;
	public Identifier args;
	public Statement statement;
	
	public MainClass(Identifier className, Identifier args, Statement statement){
		this.className = className;
		this.args = args;
		this.statement = statement;
	}
	public Object accept(Visitor visitor) {
		return visitor.visit(this);
	}
}
