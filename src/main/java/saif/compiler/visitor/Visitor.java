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
import saif.compiler.syntaxtree.WhileStatement;

public interface Visitor <E>{
	public E visit(Program program);	
	public E visit(MainClass mainClass);
	public E visit(ClassDeclSimple classDecl);
	public E visit(ClassExtendsDeclaration classDeclExtends);
	public E visit(VarDecl varDecl);
	public E visit(MethodDecl methodDecl);
	
	public E visit(FormalParameter formalParam);
	public E visit(IntArrayType intArrayType);
	public E visit(BooleanType booleanType);
	public E visit(IntegerType integerType);
	public E visit(IdentifierType identifierType);
	
	public E visit(Block block);
	public E visit(IfStatement ifStatement);
	public E visit(WhileStatement whileStatement);
	public E visit(PrintStatement printStatement);
	public E visit(AssignmentStatement assignmentStatement);
	
	public E visit(ArrayAssignmentStatement arrayAssignmentStmt);
	public E visit(AndExpression andExpr);
	public E visit(LessThanExpression lessThanExpr);
	public E visit(PlusExpression plusExpr);
	public E visit(MinusExpression minusExpr);
	
	public E visit(TimesExpression timesExpr);
	public E visit(ArrayLookup arrayLookup);
	public E visit(ArrayLength arrayLength);
	public E visit(Call call);
	public E visit(IntegerLiteral intLit);
	
	public E visit(TrueLiteral trueLit);
	public E visit(FalseLiteral falseLit);
	public E visit(IdentifierExpression identifierExpr);
	public E visit(ThisExpression thisExpr);
	public E visit(NewArray newArr);
	
	public E visit(NewObject newObj);
	public E visit(NotExpression notExpr);
	public E visit(Identifier id);
	
}
