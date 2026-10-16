package org.commonmark.node;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class Heading extends Block {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f145519g;

    @Override // org.commonmark.node.Node
    public void a(Visitor visitor) {
        visitor.g(this);
    }

    public int p() {
        return this.f145519g;
    }

    public void q(int i3) {
        this.f145519g = i3;
    }
}
