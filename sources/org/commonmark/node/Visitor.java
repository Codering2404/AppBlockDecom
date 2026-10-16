package org.commonmark.node;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public interface Visitor {
    void A(BulletList bulletList);

    void C(Link link);

    void D(IndentedCodeBlock indentedCodeBlock);

    void E(CustomBlock customBlock);

    void F(SoftLineBreak softLineBreak);

    void b(Document document);

    void c(BlockQuote blockQuote);

    void e(Code code);

    void g(Heading heading);

    void h(FencedCodeBlock fencedCodeBlock);

    void j(HtmlBlock htmlBlock);

    void k(Text text);

    void l(HtmlInline htmlInline);

    void m(Image image);

    void n(LinkReferenceDefinition linkReferenceDefinition);

    void o(ThematicBreak thematicBreak);

    void p(OrderedList orderedList);

    void s(Paragraph paragraph);

    void t(HardLineBreak hardLineBreak);

    void u(StrongEmphasis strongEmphasis);

    void v(ListItem listItem);

    void w(CustomNode customNode);

    void y(Emphasis emphasis);
}
