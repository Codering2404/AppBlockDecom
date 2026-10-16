package org.commonmark.renderer.text;

import org.commonmark.internal.renderer.text.BulletListHolder;
import org.commonmark.internal.renderer.text.ListHolder;
import org.commonmark.internal.renderer.text.OrderedListHolder;
import org.commonmark.node.AbstractVisitor;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.BulletList;
import org.commonmark.node.Code;
import org.commonmark.node.Document;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Heading;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Image;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.Link;
import org.commonmark.node.ListItem;
import org.commonmark.node.Node;
import org.commonmark.node.OrderedList;
import org.commonmark.node.Paragraph;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.Text;
import org.commonmark.node.ThematicBreak;
import org.commonmark.renderer.NodeRenderer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class CoreTextContentNodeRenderer extends AbstractVisitor implements NodeRenderer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final TextContentNodeRendererContext f145583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextContentWriter f145584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ListHolder f145585c;

    private void G() {
        if (this.f145583a.b()) {
            this.f145584b.e();
        } else {
            this.f145584b.d();
        }
    }

    private void H(Node node, Character ch) {
        if (!this.f145583a.b()) {
            if (node.f() != null) {
                this.f145584b.d();
            }
        } else {
            if (ch != null) {
                this.f145584b.f(ch.charValue());
            }
            if (node.f() != null) {
                this.f145584b.e();
            }
        }
    }

    private void I(Node node, String str, String str2) {
        boolean z2 = false;
        boolean z3 = node.d() != null;
        boolean z4 = (str == null || str.equals(str2)) ? false : true;
        if (str2 != null && !str2.equals("")) {
            z2 = true;
        }
        if (z3) {
            this.f145584b.f('\"');
            f(node);
            this.f145584b.f('\"');
            if (z4 || z2) {
                this.f145584b.e();
                this.f145584b.f('(');
            }
        }
        if (z4) {
            this.f145584b.g(str);
            if (z2) {
                this.f145584b.c();
                this.f145584b.e();
            }
        }
        if (z2) {
            this.f145584b.g(str2);
        }
        if (z3) {
            if (z4 || z2) {
                this.f145584b.f(')');
            }
        }
    }

    private void J(String str) {
        if (this.f145583a.b()) {
            this.f145584b.h(str);
        } else {
            this.f145584b.g(str);
        }
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void A(BulletList bulletList) {
        if (this.f145585c != null) {
            G();
        }
        this.f145585c = new BulletListHolder(this.f145585c, bulletList);
        f(bulletList);
        H(bulletList, null);
        if (this.f145585c.b() != null) {
            this.f145585c = this.f145585c.b();
        } else {
            this.f145585c = null;
        }
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void C(Link link) {
        I(link, link.p(), link.o());
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void D(IndentedCodeBlock indentedCodeBlock) {
        if (!this.f145583a.b()) {
            this.f145584b.g(indentedCodeBlock.p());
        } else {
            this.f145584b.h(indentedCodeBlock.p());
            H(indentedCodeBlock, null);
        }
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void F(SoftLineBreak softLineBreak) {
        H(softLineBreak, null);
    }

    @Override // org.commonmark.renderer.NodeRenderer
    public void a(Node node) {
        node.a(this);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void b(Document document) {
        f(document);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void c(BlockQuote blockQuote) {
        this.f145584b.f((char) 171);
        f(blockQuote);
        this.f145584b.f((char) 187);
        H(blockQuote, null);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void e(Code code) {
        this.f145584b.f('\"');
        this.f145584b.g(code.o());
        this.f145584b.f('\"');
    }

    @Override // org.commonmark.node.AbstractVisitor
    protected void f(Node node) {
        Node nodeD = node.d();
        while (nodeD != null) {
            Node nodeF = nodeD.f();
            this.f145583a.a(nodeD);
            nodeD = nodeF;
        }
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void g(Heading heading) {
        f(heading);
        H(heading, ':');
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void h(FencedCodeBlock fencedCodeBlock) {
        if (!this.f145583a.b()) {
            this.f145584b.g(fencedCodeBlock.t());
        } else {
            this.f145584b.h(fencedCodeBlock.t());
            H(fencedCodeBlock, null);
        }
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void j(HtmlBlock htmlBlock) {
        J(htmlBlock.p());
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void k(Text text) {
        J(text.o());
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void l(HtmlInline htmlInline) {
        J(htmlInline.o());
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void m(Image image) {
        I(image, image.p(), image.o());
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void o(ThematicBreak thematicBreak) {
        if (!this.f145583a.b()) {
            this.f145584b.g("***");
        }
        H(thematicBreak, null);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void p(OrderedList orderedList) {
        if (this.f145585c != null) {
            G();
        }
        this.f145585c = new OrderedListHolder(this.f145585c, orderedList);
        f(orderedList);
        H(orderedList, null);
        if (this.f145585c.b() != null) {
            this.f145585c = this.f145585c.b();
        } else {
            this.f145585c = null;
        }
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void s(Paragraph paragraph) {
        f(paragraph);
        if (paragraph.g() == null || (paragraph.g() instanceof Document)) {
            H(paragraph, null);
        }
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void t(HardLineBreak hardLineBreak) {
        H(hardLineBreak, null);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void v(ListItem listItem) {
        ListHolder listHolder = this.f145585c;
        if (listHolder != null && (listHolder instanceof OrderedListHolder)) {
            OrderedListHolder orderedListHolder = (OrderedListHolder) listHolder;
            String strA = this.f145583a.b() ? "" : orderedListHolder.a();
            this.f145584b.g(strA + orderedListHolder.c() + orderedListHolder.d() + " ");
            f(listItem);
            H(listItem, null);
            orderedListHolder.e();
            return;
        }
        if (listHolder == null || !(listHolder instanceof BulletListHolder)) {
            return;
        }
        BulletListHolder bulletListHolder = (BulletListHolder) listHolder;
        if (!this.f145583a.b()) {
            this.f145584b.g(bulletListHolder.a() + bulletListHolder.c() + " ");
        }
        f(listItem);
        H(listItem, null);
    }
}
