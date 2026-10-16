package ru.noties.markwon.html;

import java.util.Collection;
import ru.noties.markwon.MarkwonVisitor;
import ru.noties.markwon.html.MarkwonHtmlRendererImpl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class MarkwonHtmlRenderer {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Builder {
        Builder a(Collection collection, TagHandler tagHandler);

        Builder b(String str, TagHandler tagHandler);

        MarkwonHtmlRenderer build();
    }

    public static Builder a() {
        return new MarkwonHtmlRendererImpl.BuilderImpl();
    }

    public abstract void b(MarkwonVisitor markwonVisitor, MarkwonHtmlParser markwonHtmlParser);

    public abstract TagHandler c(String str);
}
