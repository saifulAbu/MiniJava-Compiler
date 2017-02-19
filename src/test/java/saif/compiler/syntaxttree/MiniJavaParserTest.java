package saif.compiler.syntaxttree;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import saif.compiler.parser.MiniJavaParser;
import saif.compiler.parser.ParseException;
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
import saif.compiler.syntaxtree.Exp;
import saif.compiler.syntaxtree.FormalList;
import saif.compiler.syntaxtree.FormalParameter;
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
import saif.compiler.syntaxtree.NotExpression;
import saif.compiler.syntaxtree.PlusExpression;
import saif.compiler.syntaxtree.PrintStatement;
import saif.compiler.syntaxtree.Program;
import saif.compiler.syntaxtree.Statement;
import saif.compiler.syntaxtree.TimesExpression;
import saif.compiler.syntaxtree.Type;
import saif.compiler.syntaxtree.VarDecl;
import saif.compiler.syntaxtree.WhileStatement;

public class MiniJavaParserTest {
	private static MiniJavaParser miniJavaParser;
	private String RESOURCE_PATH = "";
	@BeforeClass
	
	public static void beforeClass(){
		miniJavaParser = new MiniJavaParser(System.in);
	}
	
	@Test
	public void Identifier_test() throws IOException, ParseException{
		String identifierFileName = RESOURCE_PATH + "Identifier";
		List<String> inputFile = readFile(identifierFileName);
		for(String line : inputFile){
			InputStream in = IOUtils.toInputStream(line, "UTF-8");
			miniJavaParser.ReInit(in);
			miniJavaParser.Identifier();
		}
	}
	
	@Test
	public void NewObject_test() throws IOException, ParseException{
		String fileName = "NewObject";
		List<String> inputFile = readFile(fileName);
		for(String line : inputFile){
			InputStream in = IOUtils.toInputStream(line, "UTF-8");
			miniJavaParser.ReInit(in);
			miniJavaParser.NewObject();
		}
	}
	
	@Test
	public void ThisExpression_test() throws IOException, ParseException{
		String fileName = "ThisExpression";
		List<String> inputFile = readFile(fileName);
		for(String line : inputFile){
			InputStream in = IOUtils.toInputStream(line, "UTF-8");
			miniJavaParser.ReInit(in);
			miniJavaParser.ThisExpression();
		}
	}
	
	@Test
	public void IdentifierExpression_test() throws IOException, ParseException{
		String fileName = "IdentifierExpression";
		List<String> inputFile = readFile(fileName);
		for(String line : inputFile){
			InputStream in = IOUtils.toInputStream(line, "UTF-8");
			miniJavaParser.ReInit(in);
			miniJavaParser.IdentifierExpression();
		}
	}
	
	@Test
	public void FalseLiteral_test() throws IOException, ParseException{
		String fileName = "FalseLiteral";
		List<String> inputFile = readFile(fileName);
		for(String line : inputFile){
			InputStream in = IOUtils.toInputStream(line, "UTF-8");
			miniJavaParser.ReInit(in);
			miniJavaParser.FalseLiteral();
		}
	}
	
	@Test
	public void TrueLiteral_test() throws IOException, ParseException{
		String fileName = "TrueLiteral";
		List<String> inputFile = readFile(fileName);
		for(String line : inputFile){
			InputStream in = IOUtils.toInputStream(line, "UTF-8");
			miniJavaParser.ReInit(in);
			miniJavaParser.TrueLiteral();
		}
	}
	
	@Test
	public void IntegerLiteral_test() throws IOException, ParseException{
		String fileName = "IntegerLiteral";
		List<String> inputFile = readFile(fileName);
		for(String line : inputFile){
			InputStream in = IOUtils.toInputStream(line, "UTF-8");
			miniJavaParser.ReInit(in);
			miniJavaParser.IntegerLiteral();
		}
	}
	
	@Test
	public void PlusExpression_test() throws IOException, ParseException{
		String fileName = "PlusExpression";
		List<String> inputFile = readFile(fileName);
		for(String line : inputFile){
			InputStream in = IOUtils.toInputStream(line, "UTF-8");
			miniJavaParser.ReInit(in);
			Exp exp = miniJavaParser.Exp();
			Assert.assertTrue(exp instanceof PlusExpression);			
		}
	}
	
	@Test
	public void MinusExpression_test() throws IOException, ParseException{
		String fileName = "MinusExpression";
		List<String> inputFile = readFile(fileName);
		for(String line : inputFile){
			InputStream in = IOUtils.toInputStream(line, "UTF-8");
			miniJavaParser.ReInit(in);
			Exp exp = miniJavaParser.Exp();
			Assert.assertTrue(exp instanceof MinusExpression);			
		}
	}
	
	@Test
	public void TimesExpression_test() throws IOException, ParseException{
		String fileName = "TimesExpression";
		List<String> inputFile = readFile(fileName);
		for(String line : inputFile){
			InputStream in = IOUtils.toInputStream(line, "UTF-8");
			miniJavaParser.ReInit(in);
			Exp exp = miniJavaParser.Exp();
			Assert.assertTrue(exp instanceof TimesExpression);			
		}
	}
	
	@Test
	public void LessThanExpression_test() throws IOException, ParseException{
		String fileName = "LessThanExpression";
		List<String> inputFile = readFile(fileName);
		for(String line : inputFile){
			InputStream in = IOUtils.toInputStream(line, "UTF-8");
			miniJavaParser.ReInit(in);
			Exp exp = miniJavaParser.Exp();
			Assert.assertTrue(exp instanceof LessThanExpression);			
		}
	}
	
	@Test
	public void AndExpression_test() throws IOException, ParseException{
		String fileName = "AndExpression";
		List<String> inputFile = readFile(fileName);
		for(String line : inputFile){
			InputStream in = IOUtils.toInputStream(line, "UTF-8");
			miniJavaParser.ReInit(in);
			Exp exp = miniJavaParser.Exp();
			Assert.assertTrue(exp instanceof AndExpression);			
		}
	}
	
	@Test
	public void Call_test() throws IOException, ParseException{
		String fileName = "Call";
		List<String> inputFile = readFile(fileName);
		for(String line : inputFile){
			InputStream in = IOUtils.toInputStream(line, "UTF-8");
			miniJavaParser.ReInit(in);
			Exp exp = miniJavaParser.Exp();
			Assert.assertTrue(exp instanceof Call);			
		}
	}
	
	@Test
	public void NewArray_test() throws IOException, ParseException{
		String fileName = "NewArray";
		List<String> inputFile = readFile(fileName);
		for(String line : inputFile){
			InputStream in = IOUtils.toInputStream(line, "UTF-8");
			miniJavaParser.ReInit(in);
			Exp exp = miniJavaParser.Exp();
			Assert.assertTrue(exp instanceof NewArray);			
		}
	}
	
	@Test
	public void NotExpression_test() throws IOException, ParseException{
		String fileName = "NotExpression";
		List<String> inputFile = readFile(fileName);
		for(String line : inputFile){
			InputStream in = IOUtils.toInputStream(line, "UTF-8");
			miniJavaParser.ReInit(in);
			Exp exp = miniJavaParser.Exp();
			Assert.assertTrue(exp instanceof NotExpression);			
		}
	}
	
	@Test
	public void ArrayLength_test() throws IOException, ParseException{
		String fileName = "ArrayLength";
		List<String> inputFile = readFile(fileName);
		for(String line : inputFile){
			InputStream in = IOUtils.toInputStream(line, "UTF-8");
			miniJavaParser.ReInit(in);
			Exp exp = miniJavaParser.Exp();
			Assert.assertTrue(exp instanceof ArrayLength);			
		}
	}
	
	@Test
	public void ArrayLookup_test() throws IOException, ParseException{
		String fileName = "ArrayLookup";
		List<String> inputFile = readFile(fileName);
		for(String line : inputFile){
			InputStream in = IOUtils.toInputStream(line, "UTF-8");
			miniJavaParser.ReInit(in);
			Exp exp = miniJavaParser.Exp();
			Assert.assertTrue(exp instanceof ArrayLookup);			
		}
	}
	
	@Test
	public void ArrayAssignmentStatement_test() throws IOException, ParseException{
		String fileName = "ArrayAssignmentStatement";
		List<String> inputFile = readFile(fileName);
		for(String line : inputFile){
			InputStream in = IOUtils.toInputStream(line, "UTF-8");
			miniJavaParser.ReInit(in);
			Statement stmt = miniJavaParser.Statement();
			Assert.assertTrue(stmt instanceof ArrayAssignmentStatement);			
		}
	}
	
	@Test
	public void AssignmentStatement_test() throws IOException, ParseException{
		String fileName = "AssignmentStatement";
		List<String> inputFile = readFile(fileName);
		for(String line : inputFile){
			InputStream in = IOUtils.toInputStream(line, "UTF-8");
			miniJavaParser.ReInit(in);
			Statement stmt = miniJavaParser.Statement();
			Assert.assertTrue(stmt instanceof AssignmentStatement);			
		}
	}
	
	@Test
	public void PrintStatement_test() throws IOException, ParseException{
		String fileName = "PrintStatement";
		List<String> inputFile = readFile(fileName);
		for(String line : inputFile){
			InputStream in = IOUtils.toInputStream(line, "UTF-8");
			miniJavaParser.ReInit(in);
			Statement stmt = miniJavaParser.Statement();
			Assert.assertTrue(stmt instanceof PrintStatement);			
		}
	}
	
	@Test
	public void WhileStatement_test() throws IOException, ParseException{
		String fileName = "WhileStatement";
		List<String> inputFile = readFile(fileName);
		for(String line : inputFile){
			InputStream in = IOUtils.toInputStream(line, "UTF-8");
			miniJavaParser.ReInit(in);
			Statement stmt = miniJavaParser.Statement();
			Assert.assertTrue(stmt instanceof WhileStatement);			
		}
	}
	
	@Test
	public void Block_test() throws IOException, ParseException{
		String fileName = "Block";
		List<String> inputFile = readFile(fileName);
		for(String line : inputFile){
			InputStream in = IOUtils.toInputStream(line, "UTF-8");
			miniJavaParser.ReInit(in);
			Statement stmt = miniJavaParser.Statement();
			Assert.assertTrue(stmt instanceof Block);			
		}
	}
	
	@Test
	public void IfStatement_test() throws IOException, ParseException{
		String fileName = "IfStatement";
		List<String> inputFile = readFile(fileName);
		for(String line : inputFile){
			InputStream in = IOUtils.toInputStream(line, "UTF-8");
			miniJavaParser.ReInit(in);
			Statement stmt = miniJavaParser.Statement();
			Assert.assertTrue(stmt instanceof IfStatement);			
		}
	}
	
	@Test
	public void IntArrayType_test() throws IOException, ParseException{
		String fileName = "IntArrayType";
		List<String> inputFile = readFile(fileName);
		for(String line : inputFile){
			InputStream in = IOUtils.toInputStream(line, "UTF-8");
			miniJavaParser.ReInit(in);
			Type type = miniJavaParser.Type();
			Assert.assertTrue(type instanceof IntArrayType);			
		}
	}
	
	@Test
	public void IntegerType_test() throws IOException, ParseException{
		String fileName = "IntegerType";
		List<String> inputFile = readFile(fileName);
		for(String line : inputFile){
			InputStream in = IOUtils.toInputStream(line, "UTF-8");
			miniJavaParser.ReInit(in);
			Type type = miniJavaParser.Type();
			Assert.assertTrue(type instanceof IntegerType);			
		}
	}
	
	@Test
	public void BooleanType_test() throws IOException, ParseException{
		String fileName = "BooleanType";
		List<String> inputFile = readFile(fileName);
		for(String line : inputFile){
			InputStream in = IOUtils.toInputStream(line, "UTF-8");
			miniJavaParser.ReInit(in);
			Type type = miniJavaParser.Type();
			Assert.assertTrue(type instanceof BooleanType);			
		}
	}
	
	@Test
	public void IdentifierType_test() throws IOException, ParseException{
		String fileName = "IdentifierType";
		List<String> inputFile = readFile(fileName);
		for(String line : inputFile){
			InputStream in = IOUtils.toInputStream(line, "UTF-8");
			miniJavaParser.ReInit(in);
			Type type = miniJavaParser.Type();
			Assert.assertTrue(type instanceof IdentifierType);			
		}
	}
	
	@Test
	public void FormalRest_test() throws IOException, ParseException{
		String fileName = "FormalRest";
		List<String> inputFile = readFile(fileName);
		for(String line : inputFile){
			InputStream in = IOUtils.toInputStream(line, "UTF-8");
			miniJavaParser.ReInit(in);
			FormalParameter param = miniJavaParser.FormalRest();
			Assert.assertTrue(param instanceof FormalParameter);			
		}
	}
	
	@Test
	public void FormalParameter_test() throws IOException, ParseException{
		String fileName = "FormalParameter";
		List<String> inputFile = readFile(fileName);
		for(String line : inputFile){
			InputStream in = IOUtils.toInputStream(line, "UTF-8");
			miniJavaParser.ReInit(in);
			FormalParameter param = miniJavaParser.FormalParameter();
			Assert.assertTrue(param instanceof FormalParameter);			
		}
	}
	
	@Test
	public void VarDecl_test() throws IOException, ParseException{
		String fileName = "VarDecl";
		List<String> inputFile = readFile(fileName);
		for(String line : inputFile){
			InputStream in = IOUtils.toInputStream(line, "UTF-8");
			miniJavaParser.ReInit(in);
			VarDecl varDecl = miniJavaParser.VarDecl();
			Assert.assertTrue(varDecl instanceof VarDecl);			
		}
	}
	
	@Test
	public void MethodDecl_test() throws IOException, ParseException{
		String fileName = "MethodDecl";
		List<String> inputFile = readFile(fileName);
		for(String line : inputFile){
			InputStream in = IOUtils.toInputStream(line, "UTF-8");
			miniJavaParser.ReInit(in);
			MethodDecl mDecl = miniJavaParser.MethodDecl();
			Assert.assertTrue(mDecl instanceof MethodDecl);			
		}
	}
	
	@Test
	public void ClassDecl_test() throws IOException, ParseException{
		String fileName = "ClassDeclSimple";
		List<String> inputFile = readFile(fileName);
		for(String line : inputFile){
			InputStream in = IOUtils.toInputStream(line, "UTF-8");
			miniJavaParser.ReInit(in);
			ClassDecl classDecl = miniJavaParser.ClassDecl();
			Assert.assertTrue(classDecl instanceof ClassDeclSimple);			
		}
	}
	
	@Test
	public void ClassExtendsDeclaration_test() throws IOException, ParseException{
		String fileName = "ClassExtendsDeclaration";
		List<String> inputFile = readFile(fileName);
		for(String line : inputFile){
			InputStream in = IOUtils.toInputStream(line, "UTF-8");
			miniJavaParser.ReInit(in);
			ClassDecl classDecl = miniJavaParser.ClassDecl();
			Assert.assertTrue(classDecl instanceof ClassExtendsDeclaration);			
		}
	}
	
	@Test
	public void MainClass_test() throws IOException, ParseException{
		String fileName = "MainClass";
		List<String> inputFile = readFile(fileName);
		for(String line : inputFile){
			InputStream in = IOUtils.toInputStream(line, "UTF-8");
			miniJavaParser.ReInit(in);
			MainClass mainClass = miniJavaParser.MainClass();
			Assert.assertTrue(mainClass instanceof MainClass);			
		}
	}
	
	@Test
	public void Program_test() throws IOException, ParseException{
		String fileName = "Program";
		List<String> inputFile = readFile(fileName);
		for(String line : inputFile){
			InputStream in = IOUtils.toInputStream(line, "UTF-8");
			miniJavaParser.ReInit(in);
			Program program = miniJavaParser.Program();
			Assert.assertTrue(program instanceof Program);			
		}
	}
	
	/**
	 * returns a list of lines from the given file location. skips lines starting with #
	 * @param fileLocation
	 * @return
	 * @throws IOException
	 */
	public List<String> readFile(String fileName) throws IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		String fileLocation = classLoader.getResource(fileName).getPath();
		List<String> list = new ArrayList<>();
		Stream<String> stream = Files.lines(Paths.get(fileLocation));
		list = stream
				.filter(line -> !line.startsWith("#"))
				.collect(Collectors.toList());
		return list;
	}
}
