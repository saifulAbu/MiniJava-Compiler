package saif.compiler.visitor;

import saif.compiler.symbol.*;
import saif.compiler.syntaxtree.AndExpression;
import saif.compiler.syntaxtree.ArrayAssignmentStatement;
import saif.compiler.syntaxtree.ArrayLength;
import saif.compiler.syntaxtree.ArrayLookup;
import saif.compiler.syntaxtree.AssignmentStatement;
import saif.compiler.syntaxtree.Block;
import saif.compiler.syntaxtree.BooleanType;
import saif.compiler.syntaxtree.Call;
import saif.compiler.syntaxtree.ClassDecl;
import saif.compiler.syntaxtree.ClassDeclSimple;
import saif.compiler.syntaxtree.ClassExtendsDeclaration;
import saif.compiler.syntaxtree.FalseLiteral;
import saif.compiler.syntaxtree.FormalList;
import saif.compiler.syntaxtree.FormalParameter;
import saif.compiler.syntaxtree.Identifier;
import saif.compiler.syntaxtree.IdentifierExpression;
import saif.compiler.syntaxtree.IdentifierType;
import saif.compiler.syntaxtree.IfStatement;
import saif.compiler.syntaxtree.IntArrayType;
import saif.compiler.syntaxtree.IntegerLiteral;
import saif.compiler.syntaxtree.IntegerType;
import saif.compiler.syntaxtree.LessThanExpression;
import saif.compiler.syntaxtree.MainClass;
import saif.compiler.syntaxtree.MethodDecl;
import saif.compiler.syntaxtree.MethodDeclList;
import saif.compiler.syntaxtree.MinusExpression;
import saif.compiler.syntaxtree.NewArray;
import saif.compiler.syntaxtree.NewObject;
import saif.compiler.syntaxtree.NotExpression;
import saif.compiler.syntaxtree.PlusExpression;
import saif.compiler.syntaxtree.PrintStatement;
import saif.compiler.syntaxtree.Program;
import saif.compiler.syntaxtree.ThisExpression;
import saif.compiler.syntaxtree.TimesExpression;
import saif.compiler.syntaxtree.TrueLiteral;
import saif.compiler.syntaxtree.VarDecl;
import saif.compiler.syntaxtree.VarDeclList;
import saif.compiler.syntaxtree.WhileStatement;

import org.omg.PortableInterceptor.SUCCESSFUL;
public class SymbolTableBuilder implements Visitor <Void>{
	private SymbolTable syntaxTable = null;
	private ClassEntry currentClass = null;
	private MethodEntry currentMethod = null;
	private ErrorMsg error = new ErrorMsg();
	
	/**
	 * @param program
	 * @return SymbolTable if no error
	 */
	public SymbolTable getSymbolTable(Program program){
		syntaxTable = new SymbolTable();
		program.accept(this);
		if(error.anyErrors){
			return null;
		}
		return syntaxTable;
	}
	
	@Override
	public Void visit(Program program) {
		program.mainClass.accept(this);
		for(int i = 0; i < program.classDeclList.size(); i++){
			program.classDeclList.elementAt(i).accept(this);
		}
		return null;
	}

	@Override
	public Void visit(MainClass mainClass) {
		String mainClassName = mainClass.className.name;
		ClassEntry classEntry = new ClassEntry(mainClassName);
		setCurrentClass(classEntry);
		
		//ignoring args parameter for now
		
		//add to syntax table
		syntaxTable.addClassEntry(mainClassName, currentClass);
		syntaxTable.setMainClass(mainClassName);
		//reset
		resetClassAndMethod();
		return null;
	}

	@Override
	public Void visit(ClassDeclSimple classDecl) {
		String className = classDecl.className.name;
		ClassEntry classEntry = new ClassEntry(className);
		setCurrentClass(classEntry);
		VarDeclList varList = classDecl.varDeclList;
		MethodDeclList methodList = classDecl.methodList;
		boolean success = false;
		//add this class to symbol table
		success = syntaxTable.addClassEntry(className, classEntry);
		if(!success){
			error.complain(className + " already declared");
		}
		
		//visit variables
		for(int i = 0; i < varList.size(); i++){
			VarDecl varDecl = varList.elementAt(i);
			varDecl.accept(this);
		}
		//visit methods
		for(int i = 0; i < methodList.size(); i++){
			MethodDecl methodDecl = methodList.elementAt(i);
			methodDecl.accept(this);
		}
		resetClassAndMethod();
		return null;
	}

	@Override
	public Void visit(ClassExtendsDeclaration classDeclExtends) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(VarDecl varDecl) {
		boolean success = false;
		//get type and name of this variable
		String varName = varDecl.varName.name;
		String type = varDecl.varType.toString();
		
		//this variable is declared in a class
		if(currentMethod==null){	
			//add it to current class entry
			success = currentClass.addField(varName, type);
			if(!success){
				error.complain(varName + " already declared in class " + currentClass.className);
			}
		}else{
			//the variable is declared in a method
			success = currentMethod.addLocal(varName, type);
			if(!success){
				error.complain(varName + " already declared in method " + currentMethod.methodName + " in class " + currentClass.className);
			}
		}
		return null;
	}

	@Override
	public Void visit(MethodDecl methodDecl) {
		boolean success = false;
		//get method name and type
		String methodName = methodDecl.methodName.name;
		String returnType = methodDecl.returnType.toString();
		
		//create current method entry
		currentMethod = new MethodEntry(methodName, returnType);
		//add to symbol table
		success = currentClass.addMethodEntry(methodName, currentMethod);
		if(!success){
			error.complain(methodName + " already exists in class " + currentClass.className);
		}
		//visit params
		FormalList paramList = methodDecl.parameterList;
		for(int i = 0; i < paramList.size(); i++){
			FormalParameter parameter = paramList.elementAt(i);
			currentMethod.addParameterType(parameter.type.toString());
			parameter.accept(this);
		}
		
		//visit locals
		VarDeclList varList = methodDecl.variableList;
		for(int i = 0; i < varList.size(); i++){
			VarDecl varDecl = varList.elementAt(i);
			varDecl.accept(this);
		}
		return null;
	}

	@Override
	public Void visit(FormalParameter formalParam) {
		boolean success = false;
		String varName = formalParam.varName.name;
		String type = formalParam.type.toString();
		success = currentMethod.addParameter(varName, type);
		if(!success){
			error.complain(varName + " already declared in method " + currentMethod.methodName 
					+ " in class " + currentClass.className); 
		}
		return null;
	}

	@Override
	public Void visit(IntArrayType intArrayType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(BooleanType booleanType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(IntegerType integerType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(IdentifierType identifierType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(Block block) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(IfStatement ifStatement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(WhileStatement whileStatement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(PrintStatement printStatement) {
		printStatement.accept(this);
		return null;
	}

	@Override
	public Void visit(AssignmentStatement assignmentStatement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(ArrayAssignmentStatement arrayAssignmentStmt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(AndExpression andExpr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(LessThanExpression lessThanExpr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(PlusExpression plusExpr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(MinusExpression minusExpr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(TimesExpression timesExpr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(ArrayLookup arrayLookup) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(ArrayLength arrayLength) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(Call call) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(IntegerLiteral intLit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(TrueLiteral trueLit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(FalseLiteral falseLit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(IdentifierExpression identifierExpr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(ThisExpression thisExpr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(NewArray newArr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(NewObject newObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(NotExpression notExpr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(Identifier id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Void setCurrentClass(ClassEntry classEntry){
		currentMethod = null;
		currentClass = classEntry;
		return null;
	}
	
	private Void setCurrentMethod(MethodEntry methodEntry){
		currentMethod = methodEntry;
		return null;
	}
	
	private Void resetClassAndMethod(){
		currentMethod = null;
		currentClass = null;
		return null;
	}

}
