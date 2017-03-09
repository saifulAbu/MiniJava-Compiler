package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class MethodDecl {
	public Type returnType;
	public Identifier methodName; 
	public FormalList parameterList;
	public VarDeclList variableList; 
	public StatementList statementList; 
	public Exp returnExpr;
	
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

	public Object accept(Visitor visitor) {
		return visitor.visit(this);
	}
}
