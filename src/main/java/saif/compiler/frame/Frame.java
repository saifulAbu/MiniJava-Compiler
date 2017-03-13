package saif.compiler.frame;

import saif.compiler.Temp.Label;
import saif.compiler.Util.BoolList;

public abstract class Frame {
	abstract public Frame newFrame(Label name, BoolList formals);
	public Label name;
	public AccessList formals;
	abstract public Access allocLocal(boolean escape);
}
