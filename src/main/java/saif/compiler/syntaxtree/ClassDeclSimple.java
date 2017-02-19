package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class ClassDeclSimple extends ClassDecl{
	Identifier className;
	VarDeclList varDeclList;
	MethodDeclList methodList;
	public ClassDeclSimple(Identifier className, VarDeclList varDeclList, MethodDeclList methodList){
		this.className = className;
		this.varDeclList = varDeclList;
		this.methodList = methodList;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
