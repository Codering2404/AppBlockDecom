package org.commonmark.ext.gfm.strikethrough.internal;

import org.commonmark.node.Node;
import org.commonmark.renderer.text.TextContentNodeRendererContext;
import org.commonmark.renderer.text.TextContentWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class StrikethroughTextContentNodeRenderer extends StrikethroughNodeRenderer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextContentNodeRendererContext f145361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextContentWriter f145362b;

    private void b(Node node) {
        Node nodeD = node.d();
        while (nodeD != null) {
            Node nodeF = nodeD.f();
            this.f145361a.a(nodeD);
            nodeD = nodeF;
        }
    }

    @Override // org.commonmark.renderer.NodeRenderer
    public void a(Node node) {
        this.f145362b.f('/');
        b(node);
        this.f145362b.f('/');
    }
}
