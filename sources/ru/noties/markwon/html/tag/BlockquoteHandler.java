package ru.noties.markwon.html.tag;

import org.commonmark.node.BlockQuote;
import ru.noties.markwon.MarkwonConfiguration;
import ru.noties.markwon.MarkwonVisitor;
import ru.noties.markwon.SpanFactory;
import ru.noties.markwon.SpannableBuilder;
import ru.noties.markwon.html.HtmlTag;
import ru.noties.markwon.html.MarkwonHtmlRenderer;
import ru.noties.markwon.html.TagHandler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class BlockquoteHandler extends TagHandler {
    @Override // ru.noties.markwon.html.TagHandler
    public void handle(MarkwonVisitor markwonVisitor, MarkwonHtmlRenderer markwonHtmlRenderer, HtmlTag htmlTag) {
        if (htmlTag.b()) {
            TagHandler.visitChildren(markwonVisitor, markwonHtmlRenderer, htmlTag.a());
        }
        MarkwonConfiguration markwonConfigurationX = markwonVisitor.x();
        SpanFactory spanFactoryA = markwonConfigurationX.f().a(BlockQuote.class);
        if (spanFactoryA != null) {
            SpannableBuilder.j(markwonVisitor.builder(), spanFactoryA.a(markwonConfigurationX, markwonVisitor.q()), htmlTag.start(), htmlTag.end());
        }
    }
}
