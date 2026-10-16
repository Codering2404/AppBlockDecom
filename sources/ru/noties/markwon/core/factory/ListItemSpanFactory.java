package ru.noties.markwon.core.factory;

import ru.noties.markwon.MarkwonConfiguration;
import ru.noties.markwon.RenderProps;
import ru.noties.markwon.SpanFactory;
import ru.noties.markwon.core.CoreProps;
import ru.noties.markwon.core.spans.BulletListItemSpan;
import ru.noties.markwon.core.spans.OrderedListItemSpan;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class ListItemSpanFactory implements SpanFactory {
    @Override // ru.noties.markwon.SpanFactory
    public Object a(MarkwonConfiguration markwonConfiguration, RenderProps renderProps) {
        if (CoreProps.ListItemType.BULLET == CoreProps.f147098a.d(renderProps)) {
            return new BulletListItemSpan(markwonConfiguration.h(), ((Integer) CoreProps.f147099b.d(renderProps)).intValue());
        }
        return new OrderedListItemSpan(markwonConfiguration.h(), String.valueOf(CoreProps.f147100c.d(renderProps)) + ". ");
    }
}
