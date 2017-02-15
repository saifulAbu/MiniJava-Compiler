package saif.compiler.visitor;

import saif.compiler.syntaxtree.AndExpression;
import saif.compiler.syntaxtree.ArrayAssignmentStatement;
import saif.compiler.syntaxtree.ArrayLength;
import saif.compiler.syntaxtree.ArrayLookup;
import saif.compiler.syntaxtree.AssignmentStatement;
import saif.compiler.syntaxtree.Block;
import saif.compiler.syntaxtree.BooleanType;
import saif.compiler.syntaxtree.Call;
import saif.compiler.syntaxtree.ClassDecl;
import saif.compiler.syntaxtree.ClassExtendsDeclaration;
import saif.compiler.syntaxtree.FalseLiteral;
import saif.compiler.syntaxtree.FormalList;
import saif.compiler.syntaxtree.Identifier;
import saif.compiler.syntaxtree.IdentifierExpression;
import saif.compiler.syntaxtree.IdentifierType;
import saif.compiler.syntaxtree.IfStatment;
import saif.compiler.syntaxtree.IntArrayType;
import saif.compiler.syntaxtree.IntegerLiteral;
import saif.compiler.syntaxtree.IntegerType;
import saif.compiler.syntaxtree.LessThanExpression;
import saif.compiler.syntaxtree.MainClass;
import saif.compiler.syntaxtree.MethodDecl;
import saif.compiler.syntaxtree.MinusExpression;
import saif.compiler.syntaxtree.NewArray;
import saif.compiler.syntaxtree.NewObject;
import saif.compiler.syntaxtree.NotExpression;
import saif.compiler.syntaxtree.PlusExpression;
import saif.compiler.syntaxtree.PrintStatement;
import saif.compiler.syntaxtree.Program;
import saif.compiler.syntaxtree.ThisExpression;
import saif.compiler.syntaxtree.TimeExpression;
import saif.compiler.syntaxtree.TrueLiteral;
import saif.compiler.syntaxtree.VarDecl;
import saif.compiler.syntaxtree.WhileStatement;

public interface Visitor {
	public void visit(Program program);
	
	public void visit(MainClass mainClass);
	public void visit(ClassDecl classDecl);
	public void visit(ClassExtendsDeclaration classDeclExtends);
	public void visit(VarDecl varDecl);
	public void visit(MethodDecl methodDecl);
	
	public void visit(FormalList formalParam);
	public void visit(IntArrayType intArrayType);
	public void visit(BooleanType booleanType);
	public void visit(IntegerType integerType);
	public void visit(IdentifierType identifierType);
	
	public void visit(Block block);
	public void visit(IfStatment ifStatement);
	public void visit(WhileStatement whileStatement);
	public void visit(PrintStatement printStatement);
	public void visit(AssignmentStatement assignmentStatement);
	
	public void visit(ArrayAssignmentStatement arrayAssignmentStmt);
	public void visit(AndExpression andExpr);
	public void visit(LessThanExpression lessThanExpr);
	public void visit(PlusExpression plusExpr);
	public void visit(MinusExpression minusExpr);
	
	public void visit(TimeExpression timesExpr);
	public void visit(ArrayLookup arrayLookup);
	public void visit(ArrayLength arrayLength);
	public void visit(Call call);
	public void visit(IntegerLiteral intLit);
	
	public void visit(TrueLiteral trueLit);
	public void visit(FalseLiteral falseLit);
	public void visit(IdentifierExpression identifierExpr);
	public void visit(ThisExpression thisExpr);
	public void visit(NewArray newArr);
	
	public void visit(NewObject newObj);
	public void visit(NotExpression notExpr);
	public void visit(Identifier id);
	
}
