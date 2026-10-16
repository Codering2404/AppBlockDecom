package org.commonmark.internal.renderer.text;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class ListHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ListHolder f145496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f145497b;

    ListHolder(ListHolder listHolder) {
        this.f145496a = listHolder;
        if (listHolder == null) {
            this.f145497b = "";
            return;
        }
        this.f145497b = listHolder.f145497b + "   ";
    }

    public String a() {
        return this.f145497b;
    }

    public ListHolder b() {
        return this.f145496a;
    }
}
