import java.io.FileInputStream;
import java.io.FileNotFoundException;

import syntaxtree.Program;



public class Main {
   
   public static void main(String [] args) throws FileNotFoundException {
      try {
         System.setIn(new FileInputStream("Test.java"));
         new MiniJavaParser(System.in).Program();
         System.out.println("Lexical analysis successfull");
      }
      catch (ParseException e) {
         System.out.println("Lexer Error : \n"+ e.toString());
      }
   }
}


