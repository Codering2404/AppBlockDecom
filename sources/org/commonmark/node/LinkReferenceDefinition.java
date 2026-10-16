package org.commonmark.node;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class LinkReferenceDefinition extends Node {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f145527g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f145528h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f145529i;

    public LinkReferenceDefinition(String str, String str2, String str3) {
        this.f145527g = str;
        this.f145528h = str2;
        this.f145529i = str3;
    }

    @Override // org.commonmark.node.Node
    public void a(Visitor visitor) {
        visitor.n(this);
    }

    public String o() {
        return this.f145528h;
    }

    public String p() {
        return this.f145527g;
    }

    public String q() {
        return this.f145529i;
    }
}
