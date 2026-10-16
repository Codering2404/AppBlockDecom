package com.google.common.collect;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public enum BoundType {
    OPEN(false),
    CLOSED(true);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f83787a;

    BoundType(boolean z2) {
        this.f83787a = z2;
    }

    static BoundType b(boolean z2) {
        return z2 ? CLOSED : OPEN;
    }
}
