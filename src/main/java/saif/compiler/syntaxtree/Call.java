package saif.compiler.syntaxtree;

public class Call {
	Exp e;
	Identifier id;
	ExpList expList;
	
	public Call(Exp e, Identifier id, ExpList expList){
		this.e = e;
		this.id = id;
		this.expList = expList;
	}
}
