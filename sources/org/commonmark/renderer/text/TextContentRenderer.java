package org.commonmark.renderer.text;

import org.commonmark.Extension;
import org.commonmark.internal.renderer.NodeRendererMap;
import org.commonmark.node.Node;
import org.commonmark.renderer.Renderer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class TextContentRenderer implements Renderer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f145586a;

    /* JADX INFO: renamed from: org.commonmark.renderer.text.TextContentRenderer$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements TextContentNodeRendererFactory {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class RendererContext implements TextContentNodeRendererContext {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final NodeRendererMap f145587a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextContentRenderer f145588b;

        @Override // org.commonmark.renderer.text.TextContentNodeRendererContext
        public void a(Node node) {
            this.f145587a.a(node);
        }

        @Override // org.commonmark.renderer.text.TextContentNodeRendererContext
        public boolean b() {
            return this.f145588b.f145586a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface TextContentRendererExtension extends Extension {
    }
}
