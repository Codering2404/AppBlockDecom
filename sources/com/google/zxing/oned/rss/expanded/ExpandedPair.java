package com.google.zxing.oned.rss.expanded;

import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class ExpandedPair {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DataCharacter f91953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DataCharacter f91954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FinderPattern f91955c;

    private static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    private static int b(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ExpandedPair)) {
            return false;
        }
        ExpandedPair expandedPair = (ExpandedPair) obj;
        return a(this.f91953a, expandedPair.f91953a) && a(this.f91954b, expandedPair.f91954b) && a(this.f91955c, expandedPair.f91955c);
    }

    public int hashCode() {
        return (b(this.f91953a) ^ b(this.f91954b)) ^ b(this.f91955c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        sb.append(this.f91953a);
        sb.append(" , ");
        sb.append(this.f91954b);
        sb.append(" : ");
        FinderPattern finderPattern = this.f91955c;
        sb.append(finderPattern == null ? "null" : Integer.valueOf(finderPattern.a()));
        sb.append(" ]");
        return sb.toString();
    }
}
