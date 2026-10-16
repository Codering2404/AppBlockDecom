package org.commonmark.ext.gfm.strikethrough;

import org.commonmark.Extension;
import org.commonmark.ext.gfm.strikethrough.internal.StrikethroughDelimiterProcessor;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlNodeRendererFactory;
import org.commonmark.renderer.html.HtmlRenderer;
import org.commonmark.renderer.text.TextContentNodeRendererFactory;
import org.commonmark.renderer.text.TextContentRenderer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class StrikethroughExtension implements Parser.ParserExtension, HtmlRenderer.HtmlRendererExtension, TextContentRenderer.TextContentRendererExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f145356a;

    /* JADX INFO: renamed from: org.commonmark.ext.gfm.strikethrough.StrikethroughExtension$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements HtmlNodeRendererFactory {
    }

    /* JADX INFO: renamed from: org.commonmark.ext.gfm.strikethrough.StrikethroughExtension$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 implements TextContentNodeRendererFactory {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f145357a = false;

        public Extension b() {
            return new StrikethroughExtension(this, null);
        }
    }

    /* synthetic */ StrikethroughExtension(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public static Builder b() {
        return new Builder();
    }

    public static Extension c() {
        return b().b();
    }

    @Override // org.commonmark.parser.Parser.ParserExtension
    public void a(Parser.Builder builder) {
        builder.h(new StrikethroughDelimiterProcessor(this.f145356a));
    }

    private StrikethroughExtension(Builder builder) {
        this.f145356a = builder.f145357a;
    }
}
