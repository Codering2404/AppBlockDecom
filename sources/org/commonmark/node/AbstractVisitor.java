package org.commonmark.node;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AbstractVisitor implements Visitor {
    @Override // org.commonmark.node.Visitor
    public void A(BulletList bulletList) {
        f(bulletList);
    }

    @Override // org.commonmark.node.Visitor
    public void C(Link link) {
        f(link);
    }

    @Override // org.commonmark.node.Visitor
    public void D(IndentedCodeBlock indentedCodeBlock) {
        f(indentedCodeBlock);
    }

    @Override // org.commonmark.node.Visitor
    public void E(CustomBlock customBlock) {
        f(customBlock);
    }

    @Override // org.commonmark.node.Visitor
    public void F(SoftLineBreak softLineBreak) {
        f(softLineBreak);
    }

    @Override // org.commonmark.node.Visitor
    public void b(Document document) {
        f(document);
    }

    @Override // org.commonmark.node.Visitor
    public void c(BlockQuote blockQuote) {
        f(blockQuote);
    }

    @Override // org.commonmark.node.Visitor
    public void e(Code code) {
        f(code);
    }

    protected void f(Node node) {
        Node nodeD = node.d();
        while (nodeD != null) {
            Node nodeF = nodeD.f();
            nodeD.a(this);
            nodeD = nodeF;
        }
    }

    @Override // org.commonmark.node.Visitor
    public void g(Heading heading) {
        f(heading);
    }

    @Override // org.commonmark.node.Visitor
    public void h(FencedCodeBlock fencedCodeBlock) {
        f(fencedCodeBlock);
    }

    @Override // org.commonmark.node.Visitor
    public void j(HtmlBlock htmlBlock) {
        f(htmlBlock);
    }

    @Override // org.commonmark.node.Visitor
    public void k(Text text) {
        f(text);
    }

    @Override // org.commonmark.node.Visitor
    public void l(HtmlInline htmlInline) {
        f(htmlInline);
    }

    @Override // org.commonmark.node.Visitor
    public void m(Image image) {
        f(image);
    }

    @Override // org.commonmark.node.Visitor
    public void n(LinkReferenceDefinition linkReferenceDefinition) {
        f(linkReferenceDefinition);
    }

    @Override // org.commonmark.node.Visitor
    public void o(ThematicBreak thematicBreak) {
        f(thematicBreak);
    }

    @Override // org.commonmark.node.Visitor
    public void p(OrderedList orderedList) {
        f(orderedList);
    }

    @Override // org.commonmark.node.Visitor
    public void s(Paragraph paragraph) {
        f(paragraph);
    }

    @Override // org.commonmark.node.Visitor
    public void t(HardLineBreak hardLineBreak) {
        f(hardLineBreak);
    }

    @Override // org.commonmark.node.Visitor
    public void u(StrongEmphasis strongEmphasis) {
        f(strongEmphasis);
    }

    @Override // org.commonmark.node.Visitor
    public void v(ListItem listItem) {
        f(listItem);
    }

    @Override // org.commonmark.node.Visitor
    public void w(CustomNode customNode) {
        f(customNode);
    }

    @Override // org.commonmark.node.Visitor
    public void y(Emphasis emphasis) {
        f(emphasis);
    }
}
