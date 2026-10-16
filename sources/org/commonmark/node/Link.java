package org.commonmark.node;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class Link extends Node {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f145525g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f145526h;

    public Link(String str, String str2) {
        this.f145525g = str;
        this.f145526h = str2;
    }

    @Override // org.commonmark.node.Node
    public void a(Visitor visitor) {
        visitor.C(this);
    }

    @Override // org.commonmark.node.Node
    protected String m() {
        return "destination=" + this.f145525g + ", title=" + this.f145526h;
    }

    public String o() {
        return this.f145525g;
    }

    public String p() {
        return this.f145526h;
    }
}
