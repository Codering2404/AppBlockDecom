package ru.noties.markwon.html.tag;

import android.text.style.UnderlineSpan;
import ru.noties.markwon.MarkwonVisitor;
import ru.noties.markwon.SpannableBuilder;
import ru.noties.markwon.html.HtmlTag;
import ru.noties.markwon.html.MarkwonHtmlRenderer;
import ru.noties.markwon.html.TagHandler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class UnderlineHandler extends TagHandler {
    @Override // ru.noties.markwon.html.TagHandler
    public void handle(MarkwonVisitor markwonVisitor, MarkwonHtmlRenderer markwonHtmlRenderer, HtmlTag htmlTag) {
        if (htmlTag.b()) {
            TagHandler.visitChildren(markwonVisitor, markwonHtmlRenderer, htmlTag.a());
        }
        SpannableBuilder.j(markwonVisitor.builder(), new UnderlineSpan(), htmlTag.start(), htmlTag.end());
    }
}
