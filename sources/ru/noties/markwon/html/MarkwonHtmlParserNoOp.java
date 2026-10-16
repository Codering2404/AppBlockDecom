package ru.noties.markwon.html;

import java.util.Collections;
import ru.noties.markwon.html.MarkwonHtmlParser;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
class MarkwonHtmlParserNoOp extends MarkwonHtmlParser {
    MarkwonHtmlParserNoOp() {
    }

    @Override // ru.noties.markwon.html.MarkwonHtmlParser
    public void a(int i3, MarkwonHtmlParser.FlushAction flushAction) {
        flushAction.a(Collections.EMPTY_LIST);
    }

    @Override // ru.noties.markwon.html.MarkwonHtmlParser
    public void b(int i3, MarkwonHtmlParser.FlushAction flushAction) {
        flushAction.a(Collections.EMPTY_LIST);
    }

    @Override // ru.noties.markwon.html.MarkwonHtmlParser
    public void e() {
    }

    @Override // ru.noties.markwon.html.MarkwonHtmlParser
    public void d(Appendable appendable, String str) {
    }
}
