package saif.compiler.syntaxtree;


public class ClassDeclSimple extends ClassDecl{
	Identifier className;
	VarDeclList varDeclList;
	MethodDeclList methodList;
	public ClassDeclSimple(Identifier className, VarDeclList varDeclList, MethodDeclList methodList){
		this.className = className;
		this.varDeclList = varDeclList;
		this.methodList = methodList;
	}
}
