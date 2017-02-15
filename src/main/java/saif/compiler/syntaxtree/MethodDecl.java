package saif.compiler.syntaxtree;

public class MethodDecl {
	Type returnType;
	Identifier methodName; 
	FormalList parameterList;
	VarDeclList variableList; 
	StatementList statementList; 
	Exp returnExpr;
	
	public MethodDecl(Type returnType, Identifier methodName, FormalList parameterList, VarDeclList variableList,
			StatementList statementList, Exp returnExpr) {
		super();
		this.returnType = returnType;
		this.methodName = methodName;
		this.parameterList = parameterList;
		this.variableList = variableList;
		this.statementList = statementList;
		this.returnExpr = returnExpr;
	}
}
