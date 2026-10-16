package com.google.common.cache;

import com.google.common.cache.LocalCache;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
interface ReferenceEntry<K, V> {
    LocalCache.ValueReference a();

    ReferenceEntry b();

    int c();

    ReferenceEntry d();

    ReferenceEntry e();

    ReferenceEntry f();

    void g(ReferenceEntry referenceEntry);

    Object getKey();

    ReferenceEntry h();

    void i(LocalCache.ValueReference valueReference);

    long j();

    void k(long j3);

    long l();

    void m(long j3);

    void n(ReferenceEntry referenceEntry);

    void o(ReferenceEntry referenceEntry);

    void p(ReferenceEntry referenceEntry);
}
