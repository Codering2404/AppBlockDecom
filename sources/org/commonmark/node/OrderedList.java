package org.commonmark.node;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class OrderedList extends ListBlock {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f145541h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private char f145542i;

    @Override // org.commonmark.node.Node
    public void a(Visitor visitor) {
        visitor.p(this);
    }

    public char r() {
        return this.f145542i;
    }

    public int s() {
        return this.f145541h;
    }

    public void t(char c3) {
        this.f145542i = c3;
    }

    public void u(int i3) {
        this.f145541h = i3;
    }
}
