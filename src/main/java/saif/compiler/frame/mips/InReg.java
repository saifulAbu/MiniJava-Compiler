package saif.compiler.frame.mips;

import saif.compiler.Temp.Temp;
import saif.compiler.frame.Access;

public class InReg extends Access{
	Temp temp;
	InReg(Temp temp){
		this.temp = temp;
	}
}
