package com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class Count implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f83871a;

    public boolean equals(Object obj) {
        return (obj instanceof Count) && ((Count) obj).f83871a == this.f83871a;
    }

    public int hashCode() {
        return this.f83871a;
    }

    public String toString() {
        return Integer.toString(this.f83871a);
    }
}
