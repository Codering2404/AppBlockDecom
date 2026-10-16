package ru.noties.markwon.html;

import ru.noties.markwon.MarkwonVisitor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
class MarkwonHtmlRendererNoOp extends MarkwonHtmlRenderer {
    MarkwonHtmlRendererNoOp() {
    }

    @Override // ru.noties.markwon.html.MarkwonHtmlRenderer
    public void b(MarkwonVisitor markwonVisitor, MarkwonHtmlParser markwonHtmlParser) {
        markwonHtmlParser.e();
    }

    @Override // ru.noties.markwon.html.MarkwonHtmlRenderer
    public TagHandler c(String str) {
        return null;
    }
}
