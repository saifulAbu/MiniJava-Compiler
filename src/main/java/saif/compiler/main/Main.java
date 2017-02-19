package saif.compiler.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import saif.compiler.parser.MiniJavaParser;
import saif.compiler.parser.ParseException;
import saif.compiler.syntaxtree.*;



public class Main {
   
   public static void main(String [] args) throws FileNotFoundException {
      try {
         System.setIn(new FileInputStream("SampleProgram.minjava"));
         Program program= new MiniJavaParser(System.in).Program();
         System.out.println("Lexical analysis successfull");
      }
      catch (ParseException e) {
         System.out.println("Lexer Error : \n"+ e.toString());
      }
   }
}


