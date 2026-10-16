package org.commonmark.node;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class Block extends Node {
    @Override // org.commonmark.node.Node
    protected void k(Node node) {
        if (!(node instanceof Block)) {
            throw new IllegalArgumentException("Parent of block must also be block (can not be inline)");
        }
        super.k(node);
    }

    @Override // org.commonmark.node.Node
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public Block g() {
        return (Block) super.g();
    }
}
