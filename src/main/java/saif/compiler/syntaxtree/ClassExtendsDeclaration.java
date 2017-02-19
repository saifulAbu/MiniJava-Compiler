package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class ClassExtendsDeclaration extends ClassDecl{
	Identifier className;
	Identifier baseClass;
	VarDeclList varDeclList;
	MethodDeclList methodList;
	public ClassExtendsDeclaration(Identifier className, Identifier baseClass, VarDeclList varDeclList, MethodDeclList methodList){
		this.className = className;
		this.baseClass = baseClass;
		this.varDeclList = varDeclList;
		this.methodList = methodList;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
