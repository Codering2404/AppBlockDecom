package ru.noties.markwon.html.tag;

import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import org.commonmark.node.Link;
import ru.noties.markwon.MarkwonConfiguration;
import ru.noties.markwon.RenderProps;
import ru.noties.markwon.SpanFactory;
import ru.noties.markwon.core.CoreProps;
import ru.noties.markwon.html.HtmlTag;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class LinkHandler extends SimpleTagHandler {
    @Override // ru.noties.markwon.html.tag.SimpleTagHandler
    public Object getSpans(MarkwonConfiguration markwonConfiguration, RenderProps renderProps, HtmlTag htmlTag) {
        SpanFactory spanFactoryA;
        String str = (String) htmlTag.c().get(ShareConstants.WEB_DIALOG_PARAM_HREF);
        if (TextUtils.isEmpty(str) || (spanFactoryA = markwonConfiguration.f().a(Link.class)) == null) {
            return null;
        }
        CoreProps.f147102e.e(renderProps, markwonConfiguration.i().a(str));
        return spanFactoryA.a(markwonConfiguration, renderProps);
    }
}
