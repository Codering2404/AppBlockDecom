package ru.noties.markwon.core;

import org.commonmark.node.Node;
import ru.noties.markwon.MarkwonVisitor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class SimpleBlockNodeVisitor implements MarkwonVisitor.NodeVisitor<Node> {
    @Override // ru.noties.markwon.MarkwonVisitor.NodeVisitor
    public void a(MarkwonVisitor markwonVisitor, Node node) {
        markwonVisitor.B();
        markwonVisitor.f(node);
        if (markwonVisitor.i(node)) {
            markwonVisitor.B();
            markwonVisitor.z();
        }
    }
}
