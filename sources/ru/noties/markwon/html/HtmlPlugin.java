package ru.noties.markwon.html;

import com.facebook.AuthenticationTokenClaims;
import com.facebook.appevents.UserDataStore;
import io.reactivex.internal.operators.mixed.yrog.FptyjHFU;
import java.util.Arrays;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Node;
import ru.noties.markwon.AbstractMarkwonPlugin;
import ru.noties.markwon.MarkwonConfiguration;
import ru.noties.markwon.MarkwonVisitor;
import ru.noties.markwon.html.MarkwonHtmlRenderer;
import ru.noties.markwon.html.tag.BlockquoteHandler;
import ru.noties.markwon.html.tag.EmphasisHandler;
import ru.noties.markwon.html.tag.HeadingHandler;
import ru.noties.markwon.html.tag.ImageHandler;
import ru.noties.markwon.html.tag.LinkHandler;
import ru.noties.markwon.html.tag.ListHandler;
import ru.noties.markwon.html.tag.StrikeHandler;
import ru.noties.markwon.html.tag.StrongEmphasisHandler;
import ru.noties.markwon.html.tag.SubScriptHandler;
import ru.noties.markwon.html.tag.SuperScriptHandler;
import ru.noties.markwon.html.tag.UnderlineHandler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class HtmlPlugin extends AbstractMarkwonPlugin {
    public static HtmlPlugin b() {
        return new HtmlPlugin();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(MarkwonVisitor markwonVisitor, String str) {
        if (str != null) {
            markwonVisitor.x().b().d(markwonVisitor.builder(), str);
        }
    }

    @Override // ru.noties.markwon.AbstractMarkwonPlugin, ru.noties.markwon.MarkwonPlugin
    public void afterRender(Node node, MarkwonVisitor markwonVisitor) {
        MarkwonConfiguration markwonConfigurationX = markwonVisitor.x();
        markwonConfigurationX.c().b(markwonVisitor, markwonConfigurationX.b());
    }

    @Override // ru.noties.markwon.AbstractMarkwonPlugin, ru.noties.markwon.MarkwonPlugin
    public void configureConfiguration(MarkwonConfiguration.Builder builder) {
        builder.k(MarkwonHtmlParserImpl.h());
    }

    @Override // ru.noties.markwon.AbstractMarkwonPlugin, ru.noties.markwon.MarkwonPlugin
    public void configureVisitor(MarkwonVisitor.Builder builder) {
        builder.b(HtmlBlock.class, new MarkwonVisitor.NodeVisitor<HtmlBlock>() { // from class: ru.noties.markwon.html.HtmlPlugin.2
            @Override // ru.noties.markwon.MarkwonVisitor.NodeVisitor
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(MarkwonVisitor markwonVisitor, HtmlBlock htmlBlock) {
                HtmlPlugin.this.c(markwonVisitor, htmlBlock.p());
            }
        }).b(HtmlInline.class, new MarkwonVisitor.NodeVisitor<HtmlInline>() { // from class: ru.noties.markwon.html.HtmlPlugin.1
            @Override // ru.noties.markwon.MarkwonVisitor.NodeVisitor
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(MarkwonVisitor markwonVisitor, HtmlInline htmlInline) {
                HtmlPlugin.this.c(markwonVisitor, htmlInline.o());
            }
        });
    }

    @Override // ru.noties.markwon.AbstractMarkwonPlugin, ru.noties.markwon.MarkwonPlugin
    public void configureHtmlRenderer(MarkwonHtmlRenderer.Builder builder) {
        builder.b("img", ImageHandler.a()).b("a", new LinkHandler()).b("blockquote", new BlockquoteHandler()).b(AuthenticationTokenClaims.JSON_KEY_SUB, new SubScriptHandler()).b("sup", new SuperScriptHandler()).a(Arrays.asList("b", "strong"), new StrongEmphasisHandler()).a(Arrays.asList("s", "del"), new StrikeHandler()).a(Arrays.asList(FptyjHFU.WSCFpqzICC, "ins"), new UnderlineHandler()).a(Arrays.asList("ul", "ol"), new ListHandler()).a(Arrays.asList("i", UserDataStore.EMAIL, "cite", "dfn"), new EmphasisHandler()).a(Arrays.asList("h1", "h2", "h3", "h4", "h5", "h6"), new HeadingHandler());
    }
}
