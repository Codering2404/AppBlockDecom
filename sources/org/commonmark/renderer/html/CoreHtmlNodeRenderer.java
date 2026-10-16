package org.commonmark.renderer.html;

import com.facebook.appevents.UserDataStore;
import com.facebook.share.internal.ShareConstants;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.commonmark.node.AbstractVisitor;
import org.commonmark.node.Block;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.BulletList;
import org.commonmark.node.Code;
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
import org.commonmark.node.ListBlock;
import org.commonmark.node.ListItem;
import org.commonmark.node.Node;
import org.commonmark.node.OrderedList;
import org.commonmark.node.Paragraph;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.node.ThematicBreak;
import org.commonmark.renderer.NodeRenderer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class CoreHtmlNodeRenderer extends AbstractVisitor implements NodeRenderer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final HtmlNodeRendererContext f145568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HtmlWriter f145569b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class AltTextVisitor extends AbstractVisitor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final StringBuilder f145570a;

        private AltTextVisitor() {
            this.f145570a = new StringBuilder();
        }

        @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
        public void F(SoftLineBreak softLineBreak) {
            this.f145570a.append('\n');
        }

        String G() {
            return this.f145570a.toString();
        }

        @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
        public void k(Text text) {
            this.f145570a.append(text.o());
        }

        @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
        public void t(HardLineBreak hardLineBreak) {
            this.f145570a.append('\n');
        }
    }

    private Map G(Node node, String str) {
        return H(node, str, Collections.EMPTY_MAP);
    }

    private Map H(Node node, String str, Map map) {
        return this.f145568a.c(node, str, map);
    }

    private boolean I(Paragraph paragraph) {
        Block blockG = paragraph.g();
        if (blockG == null) {
            return false;
        }
        Node nodeG = blockG.g();
        if (nodeG instanceof ListBlock) {
            return ((ListBlock) nodeG).p();
        }
        return false;
    }

    private void J(String str, Node node, Map map) {
        this.f145569b.b();
        this.f145569b.e("pre", G(node, "pre"));
        this.f145569b.e("code", H(node, "code", map));
        this.f145569b.g(str);
        this.f145569b.d("/code");
        this.f145569b.d("/pre");
        this.f145569b.b();
    }

    private void K(ListBlock listBlock, String str, Map map) {
        this.f145569b.b();
        this.f145569b.e(str, map);
        this.f145569b.b();
        f(listBlock);
        this.f145569b.b();
        this.f145569b.d('/' + str);
        this.f145569b.b();
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void A(BulletList bulletList) {
        K(bulletList, "ul", G(bulletList, "ul"));
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void C(Link link) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String strO = link.o();
        if (this.f145568a.g()) {
            strO = this.f145568a.b().a(strO);
            linkedHashMap.put("rel", "nofollow");
        }
        linkedHashMap.put(ShareConstants.WEB_DIALOG_PARAM_HREF, this.f145568a.f(strO));
        if (link.p() != null) {
            linkedHashMap.put("title", link.p());
        }
        this.f145569b.e("a", H(link, "a", linkedHashMap));
        f(link);
        this.f145569b.d("/a");
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void D(IndentedCodeBlock indentedCodeBlock) {
        J(indentedCodeBlock.p(), indentedCodeBlock, Collections.EMPTY_MAP);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void F(SoftLineBreak softLineBreak) {
        this.f145569b.c(this.f145568a.e());
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
        this.f145569b.b();
        this.f145569b.e("blockquote", G(blockQuote, "blockquote"));
        this.f145569b.b();
        f(blockQuote);
        this.f145569b.b();
        this.f145569b.d("/blockquote");
        this.f145569b.b();
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void e(Code code) {
        this.f145569b.e("code", G(code, "code"));
        this.f145569b.g(code.o());
        this.f145569b.d("/code");
    }

    @Override // org.commonmark.node.AbstractVisitor
    protected void f(Node node) {
        Node nodeD = node.d();
        while (nodeD != null) {
            Node nodeF = nodeD.f();
            this.f145568a.a(nodeD);
            nodeD = nodeF;
        }
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void g(Heading heading) {
        String str = "h" + heading.p();
        this.f145569b.b();
        this.f145569b.e(str, G(heading, str));
        f(heading);
        this.f145569b.d('/' + str);
        this.f145569b.b();
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void h(FencedCodeBlock fencedCodeBlock) {
        String strT = fencedCodeBlock.t();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String strS = fencedCodeBlock.s();
        if (strS != null && !strS.isEmpty()) {
            int iIndexOf = strS.indexOf(" ");
            if (iIndexOf != -1) {
                strS = strS.substring(0, iIndexOf);
            }
            linkedHashMap.put("class", "language-" + strS);
        }
        J(strT, fencedCodeBlock, linkedHashMap);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void j(HtmlBlock htmlBlock) {
        this.f145569b.b();
        if (this.f145568a.d()) {
            this.f145569b.e("p", G(htmlBlock, "p"));
            this.f145569b.g(htmlBlock.p());
            this.f145569b.d("/p");
        } else {
            this.f145569b.c(htmlBlock.p());
        }
        this.f145569b.b();
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void k(Text text) {
        this.f145569b.g(text.o());
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void l(HtmlInline htmlInline) {
        if (this.f145568a.d()) {
            this.f145569b.g(htmlInline.o());
        } else {
            this.f145569b.c(htmlInline.o());
        }
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void m(Image image) {
        String strO = image.o();
        AltTextVisitor altTextVisitor = new AltTextVisitor();
        image.a(altTextVisitor);
        String strG = altTextVisitor.G();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.f145568a.g()) {
            strO = this.f145568a.b().b(strO);
        }
        linkedHashMap.put("src", this.f145568a.f(strO));
        linkedHashMap.put("alt", strG);
        if (image.p() != null) {
            linkedHashMap.put("title", image.p());
        }
        this.f145569b.f("img", H(image, "img", linkedHashMap), true);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void o(ThematicBreak thematicBreak) {
        this.f145569b.b();
        this.f145569b.f("hr", G(thematicBreak, "hr"), true);
        this.f145569b.b();
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void p(OrderedList orderedList) {
        int iS = orderedList.s();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (iS != 1) {
            linkedHashMap.put("start", String.valueOf(iS));
        }
        K(orderedList, "ol", H(orderedList, "ol", linkedHashMap));
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void s(Paragraph paragraph) {
        boolean zI = I(paragraph);
        if (!zI) {
            this.f145569b.b();
            this.f145569b.e("p", G(paragraph, "p"));
        }
        f(paragraph);
        if (zI) {
            return;
        }
        this.f145569b.d("/p");
        this.f145569b.b();
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void t(HardLineBreak hardLineBreak) {
        this.f145569b.f("br", G(hardLineBreak, "br"), true);
        this.f145569b.b();
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void u(StrongEmphasis strongEmphasis) {
        this.f145569b.e("strong", G(strongEmphasis, "strong"));
        f(strongEmphasis);
        this.f145569b.d("/strong");
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void v(ListItem listItem) {
        this.f145569b.e("li", G(listItem, "li"));
        f(listItem);
        this.f145569b.d("/li");
        this.f145569b.b();
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void y(Emphasis emphasis) {
        this.f145569b.e(UserDataStore.EMAIL, G(emphasis, UserDataStore.EMAIL));
        f(emphasis);
        this.f145569b.d("/em");
    }
}
