package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class ClassDeclSimple extends ClassDecl{
	public Identifier className;
	public VarDeclList varDeclList;
	public MethodDeclList methodList;
	public ClassDeclSimple(Identifier className, VarDeclList varDeclList, MethodDeclList methodList){
		this.className = className;
		this.varDeclList = varDeclList;
		this.methodList = methodList;
	}
	
	@Override
	public Object accept(Visitor visitor) {
		return visitor.visit(this);
	}
}
