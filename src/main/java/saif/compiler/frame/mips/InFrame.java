package saif.compiler.frame.mips;

import saif.compiler.frame.Access;

public class InFrame extends Access{
	int offset;
	InFrame(int offset){
		this.offset = offset;
	}
}
