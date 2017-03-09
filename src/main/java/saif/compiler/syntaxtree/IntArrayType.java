package saif.compiler.syntaxtree;

public class IntArrayType extends Type {
	public IntArrayType(){
		
	}
	
	@Override
	public String toString(){
		return "int[]";
	}
	
	public static String getTypeString(){
		return "int[]";
	}
}
