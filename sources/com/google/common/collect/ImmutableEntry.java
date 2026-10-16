package com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
class ImmutableEntry<K, V> extends AbstractMapEntry<K, V> implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Object f84008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object f84009b;

    ImmutableEntry(Object obj, Object obj2) {
        this.f84008a = obj;
        this.f84009b = obj2;
    }

    @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
    public final Object getKey() {
        return this.f84008a;
    }

    @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
    public final Object getValue() {
        return this.f84009b;
    }

    @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }
}
