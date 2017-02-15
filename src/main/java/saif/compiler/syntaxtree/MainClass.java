package saif.compiler.syntaxtree;

import java.beans.Statement;

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
