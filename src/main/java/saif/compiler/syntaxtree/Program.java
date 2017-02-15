package saif.compiler.syntaxtree;

public class Program {
	MainClass mainClass;
	ClassDeclList classDeclList;
	public Program(MainClass mainClass, ClassDeclList classDeclList){
		this.mainClass = mainClass;
		this.classDeclList = classDeclList;
	}
}
