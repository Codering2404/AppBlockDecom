package org.commonmark.node;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class Text extends Node {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f145548g;

    public Text(String str) {
        this.f145548g = str;
    }

    @Override // org.commonmark.node.Node
    public void a(Visitor visitor) {
        visitor.k(this);
    }

    @Override // org.commonmark.node.Node
    protected String m() {
        return "literal=" + this.f145548g;
    }

    public String o() {
        return this.f145548g;
    }

    public void p(String str) {
        this.f145548g = str;
    }
}
