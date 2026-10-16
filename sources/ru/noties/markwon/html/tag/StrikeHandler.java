package ru.noties.markwon.html.tag;

import android.text.style.StrikethroughSpan;
import org.commonmark.ext.gfm.strikethrough.Strikethrough;
import ru.noties.markwon.MarkwonConfiguration;
import ru.noties.markwon.MarkwonVisitor;
import ru.noties.markwon.SpanFactory;
import ru.noties.markwon.SpannableBuilder;
import ru.noties.markwon.html.HtmlTag;
import ru.noties.markwon.html.MarkwonHtmlRenderer;
import ru.noties.markwon.html.TagHandler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class StrikeHandler extends TagHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f147330a = true;

    private static Object a(MarkwonVisitor markwonVisitor) {
        MarkwonConfiguration markwonConfigurationX = markwonVisitor.x();
        SpanFactory spanFactoryA = markwonConfigurationX.f().a(Strikethrough.class);
        if (spanFactoryA == null) {
            return null;
        }
        return spanFactoryA.a(markwonConfigurationX, markwonVisitor.q());
    }

    @Override // ru.noties.markwon.html.TagHandler
    public void handle(MarkwonVisitor markwonVisitor, MarkwonHtmlRenderer markwonHtmlRenderer, HtmlTag htmlTag) {
        if (htmlTag.b()) {
            TagHandler.visitChildren(markwonVisitor, markwonHtmlRenderer, htmlTag.a());
        }
        SpannableBuilder.j(markwonVisitor.builder(), f147330a ? a(markwonVisitor) : new StrikethroughSpan(), htmlTag.start(), htmlTag.end());
    }
}
