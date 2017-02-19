# MiniJavaCompiler
A compiler to compile a subset of Java instructions. I have implemented what I learnt from the [Modern Compiler Implementation in Java](https://www.amazon.com/Modern-Compiler-Implementation-Andrew-Appel/dp/052182060X).

## Description of the project
The compiler is a maven project. A sample java class that the compiler would compile is given in SampleProgram.minjava can be found in the root directory. The grammar can be found in saif.compiler.parser package. The name of the grammar file is MiniJavaLexer.jj. The grammar is created using [JavaCC](https://java.net/projects/javacc/). Looking at the [grammar](http://www.cambridge.org/resources/052182060X/MCIIJ2e/grammar.htm), you will have an understanding of what the compiler is capable of. 

## Running The project
0. Go to the package saif.compiler.main. 
1. Run the file Main.java in this pakcage. By default, this will compile the SampleProgram.minijava file.

Upto now, the compiler is able to create a abstract syntax tree. You can set a debug pointer to see the tree structure.

## Updating the grammar
If you extend the provided grammar, you will have to recomiple parser classes.
0. install javacc in your machine
    [for ubuntu : sudo apt-get update
    sudo apt-get install javacc]
1. update the grammar located in /compiler/src/main/java/saif/compiler/parser/MiniJavaLexer.jj as required.
1. Execute the following command. 
``` sh	
cd /compiler/src/main/java/saif/compiler/parser/
javacc MiniJavaLexer.jj
```
## Useful Links
0. [JavaCC Tutorial] (https://www.cs.purdue.edu/homes/hosking/javacc/doc/docindex.html)
1. [Moder Compiler Implementation in Java](https://www.amazon.com/Modern-Compiler-Implementation-Andrew-Appel/dp/052182060X)
