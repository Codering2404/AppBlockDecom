package ru.noties.markwon;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.BulletList;
import org.commonmark.node.Code;
import org.commonmark.node.CustomBlock;
import org.commonmark.node.CustomNode;
import org.commonmark.node.Document;
import org.commonmark.node.Emphasis;
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
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.node.ThematicBreak;
import ru.noties.markwon.MarkwonVisitor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
class MarkwonVisitorImpl implements MarkwonVisitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MarkwonConfiguration f147085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RenderProps f147086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SpannableBuilder f147087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f147088d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class BuilderImpl implements MarkwonVisitor.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map f147089a = new HashMap();

        BuilderImpl() {
        }

        @Override // ru.noties.markwon.MarkwonVisitor.Builder
        public MarkwonVisitor a(MarkwonConfiguration markwonConfiguration, RenderProps renderProps) {
            return new MarkwonVisitorImpl(markwonConfiguration, renderProps, new SpannableBuilder(), Collections.unmodifiableMap(this.f147089a));
        }

        @Override // ru.noties.markwon.MarkwonVisitor.Builder
        public MarkwonVisitor.Builder b(Class cls, MarkwonVisitor.NodeVisitor nodeVisitor) {
            if (nodeVisitor == null) {
                this.f147089a.remove(cls);
                return this;
            }
            this.f147089a.put(cls, nodeVisitor);
            return this;
        }
    }

    MarkwonVisitorImpl(MarkwonConfiguration markwonConfiguration, RenderProps renderProps, SpannableBuilder spannableBuilder, Map map) {
        this.f147085a = markwonConfiguration;
        this.f147086b = renderProps;
        this.f147087c = spannableBuilder;
        this.f147088d = map;
    }

    private void G(Node node) {
        MarkwonVisitor.NodeVisitor nodeVisitor = (MarkwonVisitor.NodeVisitor) this.f147088d.get(node.getClass());
        if (nodeVisitor != null) {
            nodeVisitor.a(this, node);
        } else {
            f(node);
        }
    }

    @Override // org.commonmark.node.Visitor
    public void A(BulletList bulletList) {
        G(bulletList);
    }

    @Override // ru.noties.markwon.MarkwonVisitor
    public void B() {
        if (this.f147087c.length() <= 0 || '\n' == this.f147087c.h()) {
            return;
        }
        this.f147087c.append('\n');
    }

    @Override // org.commonmark.node.Visitor
    public void C(Link link) {
        G(link);
    }

    @Override // org.commonmark.node.Visitor
    public void D(IndentedCodeBlock indentedCodeBlock) {
        G(indentedCodeBlock);
    }

    @Override // org.commonmark.node.Visitor
    public void E(CustomBlock customBlock) {
        G(customBlock);
    }

    @Override // org.commonmark.node.Visitor
    public void F(SoftLineBreak softLineBreak) {
        G(softLineBreak);
    }

    public void a(Class cls, int i3) {
        SpanFactory spanFactoryA = this.f147085a.f().a(cls);
        if (spanFactoryA != null) {
            d(i3, spanFactoryA.a(this.f147085a, this.f147086b));
        }
    }

    @Override // org.commonmark.node.Visitor
    public void b(Document document) {
        G(document);
    }

    @Override // ru.noties.markwon.MarkwonVisitor
    public SpannableBuilder builder() {
        return this.f147087c;
    }

    @Override // org.commonmark.node.Visitor
    public void c(BlockQuote blockQuote) {
        G(blockQuote);
    }

    @Override // ru.noties.markwon.MarkwonVisitor
    public void clear() {
        this.f147086b.b();
        this.f147087c.clear();
    }

    @Override // ru.noties.markwon.MarkwonVisitor
    public void d(int i3, Object obj) {
        SpannableBuilder spannableBuilder = this.f147087c;
        SpannableBuilder.j(spannableBuilder, obj, i3, spannableBuilder.length());
    }

    @Override // org.commonmark.node.Visitor
    public void e(Code code) {
        G(code);
    }

    @Override // ru.noties.markwon.MarkwonVisitor
    public void f(Node node) {
        Node nodeD = node.d();
        while (nodeD != null) {
            Node nodeF = nodeD.f();
            nodeD.a(this);
            nodeD = nodeF;
        }
    }

    @Override // org.commonmark.node.Visitor
    public void g(Heading heading) {
        G(heading);
    }

    @Override // org.commonmark.node.Visitor
    public void h(FencedCodeBlock fencedCodeBlock) {
        G(fencedCodeBlock);
    }

    @Override // ru.noties.markwon.MarkwonVisitor
    public boolean i(Node node) {
        return node.f() != null;
    }

    @Override // org.commonmark.node.Visitor
    public void j(HtmlBlock htmlBlock) {
        G(htmlBlock);
    }

    @Override // org.commonmark.node.Visitor
    public void k(Text text) {
        G(text);
    }

    @Override // org.commonmark.node.Visitor
    public void l(HtmlInline htmlInline) {
        G(htmlInline);
    }

    @Override // ru.noties.markwon.MarkwonVisitor
    public int length() {
        return this.f147087c.length();
    }

    @Override // org.commonmark.node.Visitor
    public void m(Image image) {
        G(image);
    }

    @Override // org.commonmark.node.Visitor
    public void o(ThematicBreak thematicBreak) {
        G(thematicBreak);
    }

    @Override // org.commonmark.node.Visitor
    public void p(OrderedList orderedList) {
        G(orderedList);
    }

    @Override // ru.noties.markwon.MarkwonVisitor
    public RenderProps q() {
        return this.f147086b;
    }

    @Override // ru.noties.markwon.MarkwonVisitor
    public void r(Node node, int i3) {
        a(node.getClass(), i3);
    }

    @Override // org.commonmark.node.Visitor
    public void s(Paragraph paragraph) {
        G(paragraph);
    }

    @Override // org.commonmark.node.Visitor
    public void t(HardLineBreak hardLineBreak) {
        G(hardLineBreak);
    }

    @Override // org.commonmark.node.Visitor
    public void u(StrongEmphasis strongEmphasis) {
        G(strongEmphasis);
    }

    @Override // org.commonmark.node.Visitor
    public void v(ListItem listItem) {
        G(listItem);
    }

    @Override // org.commonmark.node.Visitor
    public void w(CustomNode customNode) {
        G(customNode);
    }

    @Override // ru.noties.markwon.MarkwonVisitor
    public MarkwonConfiguration x() {
        return this.f147085a;
    }

    @Override // org.commonmark.node.Visitor
    public void y(Emphasis emphasis) {
        G(emphasis);
    }

    @Override // ru.noties.markwon.MarkwonVisitor
    public void z() {
        this.f147087c.append('\n');
    }
}
