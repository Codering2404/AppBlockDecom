package org.commonmark.renderer.html;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.commonmark.Extension;
import org.commonmark.internal.renderer.NodeRendererMap;
import org.commonmark.internal.util.Escaping;
import org.commonmark.node.Node;
import org.commonmark.renderer.Renderer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class HtmlRenderer implements Renderer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f145572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f145573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f145574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final UrlSanitizer f145575d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f145576e;

    /* JADX INFO: renamed from: org.commonmark.renderer.html.HtmlRenderer$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements HtmlNodeRendererFactory {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface HtmlRendererExtension extends Extension {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class RendererContext implements HtmlNodeRendererContext, AttributeProviderContext {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f145577a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final NodeRendererMap f145578b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ HtmlRenderer f145579c;

        private void h(Node node, String str, Map map) {
            Iterator it = this.f145577a.iterator();
            while (it.hasNext()) {
                ((AttributeProvider) it.next()).a(node, str, map);
            }
        }

        @Override // org.commonmark.renderer.html.HtmlNodeRendererContext
        public void a(Node node) {
            this.f145578b.a(node);
        }

        @Override // org.commonmark.renderer.html.HtmlNodeRendererContext
        public UrlSanitizer b() {
            return this.f145579c.f145575d;
        }

        @Override // org.commonmark.renderer.html.HtmlNodeRendererContext
        public Map c(Node node, String str, Map map) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(map);
            h(node, str, linkedHashMap);
            return linkedHashMap;
        }

        @Override // org.commonmark.renderer.html.HtmlNodeRendererContext
        public boolean d() {
            return this.f145579c.f145573b;
        }

        @Override // org.commonmark.renderer.html.HtmlNodeRendererContext
        public String e() {
            return this.f145579c.f145572a;
        }

        @Override // org.commonmark.renderer.html.HtmlNodeRendererContext
        public String f(String str) {
            return this.f145579c.f145576e ? Escaping.d(str) : str;
        }

        @Override // org.commonmark.renderer.html.HtmlNodeRendererContext
        public boolean g() {
            return this.f145579c.f145574c;
        }
    }
}
