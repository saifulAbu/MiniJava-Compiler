package saif.compiler.syntaxtree;

public class IfStatment {
	Exp exp;
	Statement s1, s2;
	
	public IfStatment(Exp exp, Statement s1, Statement s2){
		this.exp = exp;
		this.s1 = s1;
		this.s2 = s2;
	}
}
