package ru.noties.markwon.core.factory;

import ru.noties.markwon.MarkwonConfiguration;
import ru.noties.markwon.RenderProps;
import ru.noties.markwon.SpanFactory;
import ru.noties.markwon.core.CoreProps;
import ru.noties.markwon.core.spans.HeadingSpan;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class HeadingSpanFactory implements SpanFactory {
    @Override // ru.noties.markwon.SpanFactory
    public Object a(MarkwonConfiguration markwonConfiguration, RenderProps renderProps) {
        return new HeadingSpan(markwonConfiguration.h(), ((Integer) CoreProps.f147101d.d(renderProps)).intValue());
    }
}
