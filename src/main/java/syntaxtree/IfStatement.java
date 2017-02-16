/* Generated by JTB 1.4.4 */
package syntaxtree;

import visitor.*;

public class IfStatement implements INode {

  public NodeToken f0;

  public NodeToken f1;

  public Exp f2;

  public NodeToken f3;

  public Statement f4;

  public NodeToken f5;

  public Statement f6;

  private static final long serialVersionUID = 144L;

  public IfStatement(final NodeToken n0, final NodeToken n1, final Exp n2, final NodeToken n3, final Statement n4, final NodeToken n5, final Statement n6) {
    f0 = n0;
    f1 = n1;
    f2 = n2;
    f3 = n3;
    f4 = n4;
    f5 = n5;
    f6 = n6;
  }

  public IfStatement(final Exp n0, final Statement n1, final Statement n2) {
    f0 = new NodeToken("if");
    f1 = new NodeToken("(");
    f2 = n0;
    f3 = new NodeToken(")");
    f4 = n1;
    f5 = new NodeToken("else");
    f6 = n2;
  }

  public <R, A> R accept(final IRetArguVisitor<R, A> vis, final A argu) {
    return vis.visit(this, argu);
  }

  public <R> R accept(final IRetVisitor<R> vis) {
    return vis.visit(this);
  }

  public <A> void accept(final IVoidArguVisitor<A> vis, final A argu) {
    vis.visit(this, argu);
  }

  public void accept(final IVoidVisitor vis) {
    vis.visit(this);
  }

}