package ru.noties.markwon.html;

import ru.noties.markwon.MarkwonVisitor;
import ru.noties.markwon.html.HtmlTag;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class TagHandler {
    protected static void visitChildren(MarkwonVisitor markwonVisitor, MarkwonHtmlRenderer markwonHtmlRenderer, HtmlTag.Block block) {
        for (HtmlTag.Block block2 : block.e()) {
            if (block2.isClosed()) {
                TagHandler tagHandlerC = markwonHtmlRenderer.c(block2.name());
                if (tagHandlerC != null) {
                    tagHandlerC.handle(markwonVisitor, markwonHtmlRenderer, block2);
                } else {
                    visitChildren(markwonVisitor, markwonHtmlRenderer, block2);
                }
            }
        }
    }

    public abstract void handle(MarkwonVisitor markwonVisitor, MarkwonHtmlRenderer markwonHtmlRenderer, HtmlTag htmlTag);
}
