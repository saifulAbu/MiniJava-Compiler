package saif.compiler.syntaxtree;

public class AssignmentStatement {
	Identifier id;
	Exp exp;
	
	public AssignmentStatement(Identifier id, Exp exp){
		this.id = id;
		this.exp = exp;
	}
}
