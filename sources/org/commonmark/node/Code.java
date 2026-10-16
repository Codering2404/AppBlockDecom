package org.commonmark.node;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class Code extends Node {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f145512g;

    @Override // org.commonmark.node.Node
    public void a(Visitor visitor) {
        visitor.e(this);
    }

    public String o() {
        return this.f145512g;
    }

    public void p(String str) {
        this.f145512g = str;
    }
}
