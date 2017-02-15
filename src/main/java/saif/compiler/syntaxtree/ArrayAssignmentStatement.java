package saif.compiler.syntaxtree;

public class ArrayAssignmentStatement {
	Identifier id;
	Exp e1;
	Exp e2;
	public ArrayAssignmentStatement(Identifier id, Exp e1, Exp e2){
		this.id = id;
		this.e1 = e1;
		this.e2 = e2;
	}
}
