package org.commonmark.node;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class FencedCodeBlock extends Block {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private char f145514g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f145515h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f145516i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f145517j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f145518k;

    @Override // org.commonmark.node.Node
    public void a(Visitor visitor) {
        visitor.h(this);
    }

    public char p() {
        return this.f145514g;
    }

    public int q() {
        return this.f145516i;
    }

    public int r() {
        return this.f145515h;
    }

    public String s() {
        return this.f145517j;
    }

    public String t() {
        return this.f145518k;
    }

    public void u(char c3) {
        this.f145514g = c3;
    }

    public void v(int i3) {
        this.f145516i = i3;
    }

    public void w(int i3) {
        this.f145515h = i3;
    }

    public void x(String str) {
        this.f145517j = str;
    }

    public void y(String str) {
        this.f145518k = str;
    }
}
