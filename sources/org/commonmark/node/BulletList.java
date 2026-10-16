package org.commonmark.node;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class BulletList extends ListBlock {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private char f145511h;

    @Override // org.commonmark.node.Node
    public void a(Visitor visitor) {
        visitor.A(this);
    }

    public char r() {
        return this.f145511h;
    }

    public void s(char c3) {
        this.f145511h = c3;
    }
}
