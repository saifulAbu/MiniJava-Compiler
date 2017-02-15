package saif.compiler.syntaxtree;

public class VarDecl {
	Type varType;
	Identifier varName;
	public VarDecl(Type varType, Identifier varName){
		this.varType = varType;
		this.varName = varName;
	}
}
