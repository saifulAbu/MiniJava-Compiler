package saif.compiler.frame;

public abstract class AccessList {
	Access head;
	AccessList tail;
	public AccessList(Access h, AccessList t) {head=h; tail=t;}
}
