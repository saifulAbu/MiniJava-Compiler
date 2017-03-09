package saif.compiler.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import saif.compiler.parser.MiniJavaParser;
import saif.compiler.parser.ParseException;
import saif.compiler.symbolTable.SymbolTable;
import saif.compiler.syntaxtree.*;
import saif.compiler.visitor.SymbolTableBuilder;
import saif.compiler.visitor.TypeChecker;



public class Main {
   
   public static void main(String [] args) throws FileNotFoundException {
      try {
         System.setIn(new FileInputStream("SampleProgram.minjava"));
         Program program= new MiniJavaParser(System.in).Program();
         System.out.println("Lexial analysis successfull");
         SymbolTable symbolTable = new SymbolTableBuilder().getSymbolTable(program);
         if(symbolTable == null){
        	 System.exit(0);
         }
         System.out.println("SymbolTable building successful");
         //symbolTable.printSymbolTable();
         boolean typeCheckSuccessful = new TypeChecker(symbolTable).typeCheck(program);
         if(!typeCheckSuccessful){
        	 System.exit(0);
         }
         System.out.println("Typechecking successful");
      }
      catch (ParseException e) {
         System.out.println("Lexer Error : \n"+ e.toString());
      }
   }
}


