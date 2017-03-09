package saif.compiler.visitor;

import javax.print.attribute.standard.RequestingUserName;

import saif.compiler.symbolTable.ClassEntry;
import saif.compiler.symbolTable.MethodEntry;
import saif.compiler.symbolTable.SymbolTable;
import saif.compiler.syntaxtree.AndExpression;
import saif.compiler.syntaxtree.ArrayAssignmentStatement;
import saif.compiler.syntaxtree.ArrayLength;
import saif.compiler.syntaxtree.ArrayLookup;
import saif.compiler.syntaxtree.AssignmentStatement;
import saif.compiler.syntaxtree.Block;
import saif.compiler.syntaxtree.BooleanType;
import saif.compiler.syntaxtree.Call;
import saif.compiler.syntaxtree.ClassDeclList;
import saif.compiler.syntaxtree.ClassDeclSimple;
import saif.compiler.syntaxtree.ClassExtendsDeclaration;
import saif.compiler.syntaxtree.FalseLiteral;
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
import saif.compiler.syntaxtree.Statement;
import saif.compiler.syntaxtree.StatementList;
import saif.compiler.syntaxtree.ThisExpression;
import saif.compiler.syntaxtree.TimesExpression;
import saif.compiler.syntaxtree.TrueLiteral;
import saif.compiler.syntaxtree.VarDecl;
import saif.compiler.syntaxtree.WhileStatement;

/**
 * an undeclared variable will be set to int type,
 * an undeclared method will return to int type and continue type checking for the rest of the code.
 * error will contain error flag if there is any error.
 * @author sid
 *
 */
public class TypeChecker implements Visitor<String>{
	ErrorMsg error;
	SymbolTable symbolTable;
	String currentClassName;
	ClassEntry currentClass;
	MethodEntry currentMethod;
	private String currentMethodName;
	
	public TypeChecker(SymbolTable symbolTable) {
		error = new ErrorMsg();
		this.symbolTable = symbolTable;
	}
	
	public boolean typeCheck(Program program){
		program.accept(this);
		return !error.anyErrors;
	}

	@Override
	public String visit(Program program) {
		//visit main class
		program.mainClass.accept(this);
		//visit all other classes
		ClassDeclList classList = program.classDeclList;
		for(int i = 0; i < classList.size(); i++){
			classList.elementAt(i).accept(this);
		}
		return null;
	}

	@Override
	public String visit(MainClass mainClass) {
		//check the statement in main class
		mainClass.statement.accept(this);
		return null;
	}

	@Override
	public String visit(ClassDeclSimple classDecl) {
		//set current class
		currentClass = symbolTable.getClassEntry(classDecl.className.name);
		setCurrentClass(currentClass);
		//visit methodlist
		MethodDeclList methodList = classDecl.methodList;
		for(int i = 0; i < methodList.size(); i++){
			methodList.elementAt(i).accept(this);
		}
		resetClassAndMethod();
		return null;
	}

	@Override
	public String visit(ClassExtendsDeclaration classDeclExtends) {
		return null;
	}

	@Override
	public String visit(VarDecl varDecl) {
		return null;
	}

	@Override
	public String visit(MethodDecl methodDecl) {
		setCurrentMethod(currentClass.getMethodEntry(methodDecl.methodName.name));
		//return type is proper
		String returnExpType = (String)methodDecl.returnExpr.accept(this);
		if(!returnExpType.equals(methodDecl.returnType.toString())){
			error.complain(getContext() + "Error in Method Decl: return expression not same as return type");
		}
		//statements are proper
		for(int i = 0; i < methodDecl.statementList.size(); i++){
			methodDecl.statementList.elementAt(i).accept(this);
		}
		resetCurrentMethod();
		return null;
	}

	@Override
	public String visit(FormalParameter formalParam) {
		// this node has already been visited while building symbol tree
		return null;
	}

	@Override
	public String visit(IntArrayType intArrayType) {
		return null;
	}

	@Override
	public String visit(BooleanType booleanType) {
		return null;
	}

	@Override
	public String visit(IntegerType integerType) {
		return null;
	}

	@Override
	public String visit(IdentifierType identifierType) {
		return null;
	}

	@Override
	public String visit(Block block) {
		//all the statements should be visited
		StatementList stmtList = block.stmtList;
		for(int i = 0; i < stmtList.size(); i++){
			Statement stmt = stmtList.elementAt(i);
			stmt.accept(this);
		}
		return null;
	}

	@Override
	public String visit(IfStatement ifStatement) {
		//expression in if statement should be boolean
		String exprType = (String)ifStatement.exp.accept(this);
		if(!exprType.equals(BooleanType.getTypeString())){
			error.complain(getContext() + "Error in If statement: expression should have boolean expression");
		}
		ifStatement.s1.accept(this);
		ifStatement.s2.accept(this);
		return null;
	}

	@Override
	public String visit(WhileStatement whileStatement) {
		String exprType = (String)whileStatement.e.accept(this);
		if(!exprType.equals(BooleanType.getTypeString())){
			error.complain(getContext() + "Error in While statement: expression should have boolean expression");
		}
		whileStatement.s.accept(this);
		return null;
	}

	@Override
	public String visit(PrintStatement printStatement) {
		//print statment will only print integer types
		String exprType = (String)printStatement.e.accept(this);
		if(!exprType.equals(IntegerType.getTypeString())){
			error.complain(getContext() + "Error in Print statement: expression should have int expression");
		}
		return null;
	}

	@Override
	public String visit(AssignmentStatement assignmentStatement) {
		//both side shoudl have declared before
		String identifierName = assignmentStatement.id.name;
		//look at the class entry and find the variable type
		String identifierType = currentClass.getVariableType(identifierName, currentMethodName);
		if(identifierType == null){
			error.complain(getContext() + "Error in Assignment statement: variable " + identifierName + " was not declared");
		}
		//expression should have same type as the identifier
		String expressionType = (String)assignmentStatement.exp.accept(this);
		if((identifierType != null) && !identifierType.equals(expressionType)){
			error.complain(getContext() + "Error in Assignment statement: left and right hand side does not have same type");
		}
		return null;
	}

	@Override
	public String visit(ArrayAssignmentStatement arrayAssignmentStmt) {
		//identifier should be a int[] type
		String varType = currentClass.getVariableType(arrayAssignmentStmt.id.name, currentMethodName);
		if(!varType.equals(IntArrayType.getTypeString())){
			error.complain(getContext() + "Error in Array assignment statement: left hand side variable should be a int[]");
		}
		//exp1 should be int type
		String indexType = (String)arrayAssignmentStmt.e1.accept(this);
		if(!indexType.equals(IntegerType.getTypeString())){
			error.complain(getContext() + "Error in array assignment statement: index should be of int type");
		}
		//exp2 should be int type
		String valType = (String)arrayAssignmentStmt.e2.accept(this);
		if(!valType.equals(IntegerType.getTypeString())){
			error.complain(getContext() + "Error in array assignment statement: value on right side should be int");
		}
		return null;
	}

	@Override
	public String visit(AndExpression andExpr) {
		//both expression should be boolean type
		String type = (String)andExpr.e1.accept(this);
		if(!type.equals(BooleanType.getTypeString())){
			error.complain(getContext() + "Error in and expression: exp1 should be of boolean type");
		}
		
		type = (String)andExpr.e2.accept(this);
		if(!type.equals(BooleanType.getTypeString())){
			error.complain(getContext() + "Error in and expression: exp2 should be of boolean type");
		}
		return BooleanType.getTypeString();
	}

	@Override
	public String visit(LessThanExpression lessThanExpr) {
		// both expression should have int type
		String type = (String)lessThanExpr.e1.accept(this);
		if(!type.equals(IntegerType.getTypeString())){
			error.complain(getContext() + "Error in less than expression: exp1 should be of int type");
		}
		
		type = (String)lessThanExpr.e2.accept(this);
		if(!type.equals(IntegerType.getTypeString())){
			error.complain(getContext() + "Error in less than expression: exp2 should be of int type");
		}
		return BooleanType.getTypeString();
	}

	@Override
	public String visit(PlusExpression plusExpr) {
		// both expression should have int type
		String type = (String) plusExpr.e1.accept(this);
		if (!type.equals(IntegerType.getTypeString())) {
			error.complain(getContext() + "Error in plus expression: exp1 should be of int type");
		}

		type = (String) plusExpr.e2.accept(this);
		if (!type.equals(IntegerType.getTypeString())) {
			error.complain(getContext() + "Error in plus expression error: exp2 should be of int type");
		}
		return IntegerType.getTypeString();
	}

	@Override
	public String visit(MinusExpression minusExpr) {
		// both expression should have int type
		String type = (String) minusExpr.e1.accept(this);
		if (!type.equals(IntegerType.getTypeString())) {
			error.complain(getContext() + "Error in minus expression: exp1 should be of int type");
		}

		type = (String) minusExpr.e2.accept(this);
		if (!type.equals(IntegerType.getTypeString())) {
			error.complain(getContext() + "Error in minus expression: exp2 should be of int type");
		}
		return IntegerType.getTypeString();
	}

	@Override
	public String visit(TimesExpression timesExpr) {
		// both expression should have int type
		String type = (String) timesExpr.e1.accept(this);
		if (!type.equals(IntegerType.getTypeString())) {
			error.complain(getContext() + "Error in times expression: exp1 should be of int type");
		}

		type = (String) timesExpr.e2.accept(this);
		if (!type.equals(IntegerType.getTypeString())) {
			error.complain(getContext() + "Error in times expression: exp2 should be of int type");
		}
		return IntegerType.getTypeString();
	}

	@Override
	public String visit(ArrayLookup arrayLookup) {
		//e1 should be int[]
		String type = (String) arrayLookup.e1.accept(this);
		if(!type.equals(IntArrayType.getTypeString())){
			error.complain(getContext() + "Error in array lookup: array should be a int[] type");
		}
		//e2 should be int
		type = (String) arrayLookup.e2.accept(this);
		if(!type.equals(IntegerType.getTypeString())){
			error.complain(getContext() + "Error in array lookup: index should be a int type");
		}
		return IntegerType.getTypeString();
	}

	@Override
	public String visit(ArrayLength arrayLength) {
		//e1 should be int[] type
		String type = (String) arrayLength.e1.accept(this);
		if(!type.equals(IntArrayType.getTypeString())){
			error.complain(getContext() + "Error in array length: array should be a int[] type");
		}
		return new IntegerType().toString();
	}

	@Override
	public String visit(Call call) {
		//exp should be an object type
		String variableType = (String) call.e.accept(this);
		if(variableType == null){
			error.complain(getContext() + "Error in call expr: undeclared variable");
			return IntegerType.getTypeString();
		}
		ClassEntry varClassEntry = symbolTable.getClassEntry(variableType);
		if(varClassEntry == null){
			error.complain(getContext() + "Error in call expr: undeclared class " + variableType);
			return IntegerType.getTypeString();
		}
		//method should be present in the symbol table
		MethodEntry calledMethodEntry = varClassEntry.getMethodEntry(call.id.name);
		if(calledMethodEntry == null){
			error.complain(getContext() + "Error in call expr: undeclared method call");
			return IntegerType.getTypeString();
		}
		
		//explist should match with params
		if(calledMethodEntry.getParamCount() != call.expList.size()){
			error.complain(getContext() + "Error in call expr: parameter count mismatch");
			return IntegerType.getTypeString();
		}
		
		for(int i = 0; i < calledMethodEntry.getParamCount(); i++){
			String paramType = (String) call.expList.elementAt(i).accept(this);
			if(!paramType.equals(calledMethodEntry.getParameterTypeAtPosition(i))){
				error.complain(getContext() + "Error in call expr: parameter type mismatch at position " + i);
				return IntegerType.getTypeString();
			}
		}
		
		//return method's return type
		return calledMethodEntry.returnType;
	}

	@Override
	public String visit(IntegerLiteral intLit) {
		return new IntegerType().toString();
	}

	@Override
	public String visit(TrueLiteral trueLit) {
		return new BooleanType().toString();
	}

	@Override
	public String visit(FalseLiteral falseLit) {
		return new BooleanType().toString();
	}

	@Override
	public String visit(IdentifierExpression identifierExpr) {
		String vartype = currentClass.getVariableType(identifierExpr.id, currentMethodName);
		if(vartype == null){
			error.complain(getContext() + "Error in identifier expr: undeclared identifier reference " + identifierExpr.id);
			return IntegerType.getTypeString();
		}
		return vartype;
	}

	@Override
	public String visit(ThisExpression thisExpr) {
		// use the syntax table to retrieve this
		return currentClassName;
	}

	@Override
	public String visit(NewArray newArr) {
		// array size expression should be an integer
		String arrSizeType = (String)newArr.e1.accept(this);
		if(!arrSizeType.equals(IntegerType.getTypeString())){
			error.complain(getContext() + "Error in new array expr: array size expression should be an integer");
		}
		return new IntArrayType().toString();
	}

	@Override
	public String visit(NewObject newObj) {
		//identifer should be present in the symbol table
		if(symbolTable.getClassEntry(newObj.id.name) == null){
			error.complain(getContext() + "Error in new object expr: undeclared class " + newObj.id.name);
			return IntegerType.getTypeString();
		}
		//newObj.id has the class name 
		return newObj.id.name;
	}

	@Override
	public String visit(NotExpression notExpr) {
		String exprType = (String) notExpr.exp.accept(this);
		if(!exprType.equals(BooleanType.getTypeString())){
			error.complain(getContext() + "Error in not expr: expression inside not should be a boolean expression");
		}
		return new BooleanType().toString();
	}

	@Override
	public String visit(Identifier id) {
		String idType = currentClass.getVariableType(id.name, currentMethodName);
		if(idType == null){
			error.complain(getContext() + "Error in id expr: undeclared type for variable " + id);
			return IntegerType.getTypeString();
		}
		return idType;
	}
	
	private void setCurrentClass(ClassEntry classEntry){
		currentMethod = null;
		currentClass = classEntry;
		currentClassName = currentClass.className;
	}
	
	private void setCurrentMethod(MethodEntry methodEntry){
		currentMethod = methodEntry;
		currentMethodName = methodEntry.methodName;
	}
	
	private void resetCurrentMethod(){
		currentMethod = null;
		currentMethodName = null;
	}
	
	private void resetClassAndMethod(){
		currentMethod = null;
		currentClass = null;
		currentMethodName = null;
		currentClassName = null;
	}
	
	private String getContext(){
		String str = "";
		if(currentClassName != null){
			str += "class " + currentClassName + " ";
		}
		
		if(currentMethodName != null){
			str += "method " + currentMethodName + " ";
		}
		
		return str;
	}

}
