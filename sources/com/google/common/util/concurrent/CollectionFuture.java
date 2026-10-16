package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AggregateFuture;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class CollectionFuture<V, C> extends AggregateFuture<V, C> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private List f85787o;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ListFuture<V> extends CollectionFuture<V, List<V>> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Present<V> {
    }

    @Override // com.google.common.util.concurrent.AggregateFuture
    void F(AggregateFuture.ReleaseResourcesReason releaseResourcesReason) {
        super.F(releaseResourcesReason);
        this.f85787o = null;
    }
}
