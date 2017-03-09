package saif.compiler.syntaxtree;

public class BooleanType extends Type{
	public BooleanType(){
		
	}
	@Override
	public String toString(){
		return "boolean";
	}
	
	public static String getTypeString(){
		return "boolean";
	}
}
