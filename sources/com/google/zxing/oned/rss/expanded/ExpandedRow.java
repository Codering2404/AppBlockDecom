package com.google.zxing.oned.rss.expanded;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class ExpandedRow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f91956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f91957b;

    List a() {
        return this.f91956a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ExpandedRow)) {
            return false;
        }
        ExpandedRow expandedRow = (ExpandedRow) obj;
        return this.f91956a.equals(expandedRow.a()) && this.f91957b == expandedRow.f91957b;
    }

    public int hashCode() {
        return this.f91956a.hashCode() ^ Boolean.valueOf(this.f91957b).hashCode();
    }

    public String toString() {
        return "{ " + this.f91956a + " }";
    }
}
