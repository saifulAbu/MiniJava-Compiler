package saif.compiler.syntaxtree;

public class IntegerType  extends Type{
	public IntegerType(){
		
	}
	
	@Override
	public String toString(){
		return "int";
	}

	public static String getTypeString() {
		return "int";
	}
}
