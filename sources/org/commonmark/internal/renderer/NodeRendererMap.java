package org.commonmark.internal.renderer;

import java.util.Map;
import org.commonmark.node.Node;
import org.commonmark.renderer.NodeRenderer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class NodeRendererMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f145494a;

    public void a(Node node) {
        NodeRenderer nodeRenderer = (NodeRenderer) this.f145494a.get(node.getClass());
        if (nodeRenderer != null) {
            nodeRenderer.a(node);
        }
    }
}
