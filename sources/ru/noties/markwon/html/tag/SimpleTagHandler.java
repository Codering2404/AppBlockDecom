package ru.noties.markwon.html.tag;

import ru.noties.markwon.MarkwonConfiguration;
import ru.noties.markwon.MarkwonVisitor;
import ru.noties.markwon.RenderProps;
import ru.noties.markwon.SpannableBuilder;
import ru.noties.markwon.html.HtmlTag;
import ru.noties.markwon.html.MarkwonHtmlRenderer;
import ru.noties.markwon.html.TagHandler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class SimpleTagHandler extends TagHandler {
    public abstract Object getSpans(MarkwonConfiguration markwonConfiguration, RenderProps renderProps, HtmlTag htmlTag);

    @Override // ru.noties.markwon.html.TagHandler
    public void handle(MarkwonVisitor markwonVisitor, MarkwonHtmlRenderer markwonHtmlRenderer, HtmlTag htmlTag) {
        Object spans = getSpans(markwonVisitor.x(), markwonVisitor.q(), htmlTag);
        if (spans != null) {
            SpannableBuilder.j(markwonVisitor.builder(), spans, htmlTag.start(), htmlTag.end());
        }
    }
}
