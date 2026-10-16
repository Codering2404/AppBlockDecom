package ru.noties.markwon.html.tag;

import org.commonmark.node.StrongEmphasis;
import ru.noties.markwon.MarkwonConfiguration;
import ru.noties.markwon.RenderProps;
import ru.noties.markwon.SpanFactory;
import ru.noties.markwon.html.HtmlTag;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class StrongEmphasisHandler extends SimpleTagHandler {
    @Override // ru.noties.markwon.html.tag.SimpleTagHandler
    public Object getSpans(MarkwonConfiguration markwonConfiguration, RenderProps renderProps, HtmlTag htmlTag) {
        SpanFactory spanFactoryA = markwonConfiguration.f().a(StrongEmphasis.class);
        if (spanFactoryA == null) {
            return null;
        }
        return spanFactoryA.a(markwonConfiguration, renderProps);
    }
}
