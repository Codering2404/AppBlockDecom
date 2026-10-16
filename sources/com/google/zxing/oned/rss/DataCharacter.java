package com.google.zxing.oned.rss;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class DataCharacter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f91943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f91944b;

    public final boolean equals(Object obj) {
        if (!(obj instanceof DataCharacter)) {
            return false;
        }
        DataCharacter dataCharacter = (DataCharacter) obj;
        return this.f91943a == dataCharacter.f91943a && this.f91944b == dataCharacter.f91944b;
    }

    public final int hashCode() {
        return this.f91943a ^ this.f91944b;
    }

    public final String toString() {
        return this.f91943a + "(" + this.f91944b + ')';
    }
}
