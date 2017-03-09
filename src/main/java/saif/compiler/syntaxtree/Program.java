package saif.compiler.syntaxtree;

import saif.compiler.visitor.Visitor;

public class Program {
	public MainClass mainClass;
	public ClassDeclList classDeclList;
	
	public Program(MainClass mainClass, ClassDeclList classDeclList){
		this.mainClass = mainClass;
		this.classDeclList = classDeclList;
	}
	
	public Object accept(Visitor visitor){
		return visitor.visit(this);
	}
}
