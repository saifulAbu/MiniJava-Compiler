package saif.compiler.syntaxtree;

public class AndExpression {
	Exp e1, e2;
	
	public AndExpression(Exp e1, Exp e2){
		this.e1 = e1;
		this.e2 = e2;
	}
}
