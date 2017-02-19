package saif.compiler.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import saif.compiler.syntaxtree.*;
import saif.parser.MiniJavaParser;
import saif.parser.ParseException;



public class Main {
   
   public static void main(String [] args) throws FileNotFoundException {
      try {
         System.setIn(new FileInputStream("SampleProgram.java"));
         Program program= new MiniJavaParser(System.in).Program();
         System.out.println("Lexical analysis successfull");
      }
      catch (ParseException e) {
         System.out.println("Lexer Error : \n"+ e.toString());
      }
   }
}


