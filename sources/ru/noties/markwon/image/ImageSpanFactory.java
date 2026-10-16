package ru.noties.markwon.image;

import ru.noties.markwon.MarkwonConfiguration;
import ru.noties.markwon.RenderProps;
import ru.noties.markwon.SpanFactory;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class ImageSpanFactory implements SpanFactory {
    @Override // ru.noties.markwon.SpanFactory
    public Object a(MarkwonConfiguration markwonConfiguration, RenderProps renderProps) {
        return new AsyncDrawableSpan(markwonConfiguration.h(), new AsyncDrawable((String) ImageProps.f147371a.d(renderProps), markwonConfiguration.a(), markwonConfiguration.d(), (ImageSize) ImageProps.f147373c.a(renderProps)), 0, ((Boolean) ImageProps.f147372b.b(renderProps, Boolean.FALSE)).booleanValue());
    }
}
