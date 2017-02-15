package saif.compiler.syntaxtree;

public class WhileStatement {
	Exp e;
	Statement s;
	public WhileStatement(Exp e, Statement s){
		this.e = e;
		this.s = s;
	}
}
