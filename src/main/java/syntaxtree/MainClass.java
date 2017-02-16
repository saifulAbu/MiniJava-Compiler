/* Generated by JTB 1.4.4 */
package syntaxtree;

import visitor.*;

public class MainClass implements INode {

  public NodeToken f0;

  public NodeToken f1;

  public NodeToken f2;

  public NodeToken f3;

  public NodeToken f4;

  public NodeToken f5;

  public NodeToken f6;

  public NodeToken f7;

  public NodeToken f8;

  public NodeToken f9;

  public NodeToken f10;

  public NodeToken f11;

  public NodeToken f12;

  public NodeToken f13;

  public NodeListOptional f14;

  public NodeListOptional f15;

  public NodeToken f16;

  public NodeToken f17;

  private static final long serialVersionUID = 144L;

  public MainClass(final NodeToken n0, final NodeToken n1, final NodeToken n2, final NodeToken n3, final NodeToken n4, final NodeToken n5, final NodeToken n6, final NodeToken n7, final NodeToken n8, final NodeToken n9, final NodeToken n10, final NodeToken n11, final NodeToken n12, final NodeToken n13, final NodeListOptional n14, final NodeListOptional n15, final NodeToken n16, final NodeToken n17) {
    f0 = n0;
    f1 = n1;
    f2 = n2;
    f3 = n3;
    f4 = n4;
    f5 = n5;
    f6 = n6;
    f7 = n7;
    f8 = n8;
    f9 = n9;
    f10 = n10;
    f11 = n11;
    f12 = n12;
    f13 = n13;
    f14 = n14;
    f15 = n15;
    f16 = n16;
    f17 = n17;
  }

  public MainClass(final NodeToken n0, final NodeToken n1, final NodeListOptional n2, final NodeListOptional n3) {
    f0 = new NodeToken("class");
    f1 = n0;
    f2 = new NodeToken("{");
    f3 = new NodeToken("public");
    f4 = new NodeToken("static");
    f5 = new NodeToken("void");
    f6 = new NodeToken("main");
    f7 = new NodeToken("(");
    f8 = new NodeToken("String");
    f9 = new NodeToken("[");
    f10 = new NodeToken("]");
    f11 = n1;
    f12 = new NodeToken(")");
    f13 = new NodeToken("{");
    f14 = n2;
    f15 = n3;
    f16 = new NodeToken("}");
    f17 = new NodeToken("}");
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