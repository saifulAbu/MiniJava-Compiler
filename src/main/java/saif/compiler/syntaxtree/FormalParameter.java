package saif.compiler.syntaxtree;

public class FormalParameter {
	Type type;
	Identifier varName;
	
	public FormalParameter(Type type, Identifier varName) {
		super();
		this.type = type;
		this.varName = varName;
	}
	
}
