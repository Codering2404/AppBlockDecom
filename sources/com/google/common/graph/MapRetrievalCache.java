package com.google.common.graph;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class MapRetrievalCache<K, V> extends MapIteratorCache<K, V> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile transient CacheEntry f84985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile transient CacheEntry f84986d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CacheEntry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f84987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object f84988b;

        CacheEntry(Object obj, Object obj2) {
            this.f84987a = obj;
            this.f84988b = obj2;
        }
    }

    private void h(CacheEntry cacheEntry) {
        this.f84986d = this.f84985c;
        this.f84985c = cacheEntry;
    }

    private void i(Object obj, Object obj2) {
        h(new CacheEntry(obj, obj2));
    }

    @Override // com.google.common.graph.MapIteratorCache
    Object d(Object obj) {
        Preconditions.t(obj);
        Object objE = e(obj);
        if (objE != null) {
            return objE;
        }
        Object objF = f(obj);
        if (objF != null) {
            i(obj, objF);
        }
        return objF;
    }

    @Override // com.google.common.graph.MapIteratorCache
    Object e(Object obj) {
        Object objE = super.e(obj);
        if (objE != null) {
            return objE;
        }
        CacheEntry cacheEntry = this.f84985c;
        if (cacheEntry != null && cacheEntry.f84987a == obj) {
            return cacheEntry.f84988b;
        }
        CacheEntry cacheEntry2 = this.f84986d;
        if (cacheEntry2 == null || cacheEntry2.f84987a != obj) {
            return null;
        }
        h(cacheEntry2);
        return cacheEntry2.f84988b;
    }
}
