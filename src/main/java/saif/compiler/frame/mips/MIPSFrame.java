package saif.compiler.frame.mips;

import saif.compiler.Temp.Label;
import saif.compiler.Temp.Temp;
import saif.compiler.Util.BoolList;
import saif.compiler.frame.Access;
import saif.compiler.frame.Frame;

public class MIPSFrame extends Frame{
	Label label;
	BoolList formals;
	int numLocals = 0;
	@Override
	public Frame newFrame(Label name, BoolList formals) {
		return new MIPSFrame(name, formals);
	}

	/**
	 * escape = true -- alloc in register
	 * escape = false -- alloc in memory 
	 */
	@Override
	public Access allocLocal(boolean escape) {
		Access access;
		if(!escape){
			//store in register
			access = new InReg(new Temp());
		}else{
			access = new InFrame(numLocals);
		}
		numLocals++;
		return access;
	}
	
	private MIPSFrame (Label label, BoolList formals){
		this.label = label;
		this.formals = formals;
	}

}
