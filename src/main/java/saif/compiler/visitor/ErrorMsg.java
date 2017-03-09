package saif.compiler.visitor;

class ErrorMsg{
	boolean anyErrors = false;
	void complain(String msg){
		anyErrors = true;
		System.out.println(msg);
	}
}