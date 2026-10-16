package ru.noties.markwon.html.tag;

import org.commonmark.node.Heading;
import ru.noties.markwon.MarkwonConfiguration;
import ru.noties.markwon.RenderProps;
import ru.noties.markwon.SpanFactory;
import ru.noties.markwon.core.CoreProps;
import ru.noties.markwon.html.HtmlTag;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class HeadingHandler extends SimpleTagHandler {
    @Override // ru.noties.markwon.html.tag.SimpleTagHandler
    public Object getSpans(MarkwonConfiguration markwonConfiguration, RenderProps renderProps, HtmlTag htmlTag) {
        int i3;
        SpanFactory spanFactoryA = markwonConfiguration.f().a(Heading.class);
        if (spanFactoryA == null) {
            return null;
        }
        try {
            i3 = Integer.parseInt(htmlTag.name().substring(1));
        } catch (NumberFormatException e3) {
            e3.printStackTrace();
            i3 = 0;
        }
        if (i3 < 1 || i3 > 6) {
            return null;
        }
        CoreProps.f147101d.e(renderProps, Integer.valueOf(i3));
        return spanFactoryA.a(markwonConfiguration, renderProps);
    }
}
