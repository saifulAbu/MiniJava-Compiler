package saif.compiler.syntaxtree;

public class MainClass {
	Identifier className;
	Identifier args;
	Statement statement;
	public MainClass(Identifier className, Identifier args, Statement statement){
		this.className = className;
		this.args = args;
		this.statement = statement;
	}
}
