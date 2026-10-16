package org.commonmark.node;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class Image extends Node {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f145522g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f145523h;

    public Image(String str, String str2) {
        this.f145522g = str;
        this.f145523h = str2;
    }

    @Override // org.commonmark.node.Node
    public void a(Visitor visitor) {
        visitor.m(this);
    }

    @Override // org.commonmark.node.Node
    protected String m() {
        return "destination=" + this.f145522g + ", title=" + this.f145523h;
    }

    public String o() {
        return this.f145522g;
    }

    public String p() {
        return this.f145523h;
    }
}
