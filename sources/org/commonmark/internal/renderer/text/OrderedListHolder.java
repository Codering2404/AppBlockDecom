package org.commonmark.internal.renderer.text;

import org.commonmark.node.OrderedList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class OrderedListHolder extends ListHolder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final char f145498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f145499d;

    public OrderedListHolder(ListHolder listHolder, OrderedList orderedList) {
        super(listHolder);
        this.f145498c = orderedList.r();
        this.f145499d = orderedList.s();
    }

    public int c() {
        return this.f145499d;
    }

    public char d() {
        return this.f145498c;
    }

    public void e() {
        this.f145499d++;
    }
}
