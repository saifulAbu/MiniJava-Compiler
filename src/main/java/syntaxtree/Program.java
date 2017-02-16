/* Generated by JTB 1.4.4 */
package syntaxtree;

import visitor.*;

public class Program implements INode {

  public MainClass f0;

  public NodeListOptional f1;

  public NodeToken f2;

  private static final long serialVersionUID = 144L;

  public Program(final MainClass n0, final NodeListOptional n1, final NodeToken n2) {
    f0 = n0;
    f1 = n1;
    f2 = n2;
  }

  public Program(final MainClass n0, final NodeListOptional n1) {
    f0 = n0;
    f1 = n1;
    f2 = new NodeToken("");
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