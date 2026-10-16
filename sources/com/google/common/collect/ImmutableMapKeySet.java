package com.google.common.collect;

import java.io.Serializable;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class ImmutableMapKeySet<K, V> extends IndexedImmutableSet<K> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ImmutableMap f84047c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class KeySetSerializedForm<K> implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ImmutableMap f84048a;

        KeySetSerializedForm(ImmutableMap immutableMap) {
            this.f84048a = immutableMap;
        }

        Object readResolve() {
            return this.f84048a.keySet();
        }
    }

    ImmutableMapKeySet(ImmutableMap immutableMap) {
        this.f84047c = immutableMap;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f84047c.containsKey(obj);
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean g() {
        return true;
    }

    @Override // com.google.common.collect.IndexedImmutableSet
    Object get(int i3) {
        return ((Map.Entry) this.f84047c.entrySet().a().get(i3)).getKey();
    }

    @Override // com.google.common.collect.IndexedImmutableSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    /* JADX INFO: renamed from: h */
    public UnmodifiableIterator iterator() {
        return this.f84047c.l();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f84047c.size();
    }

    @Override // com.google.common.collect.IndexedImmutableSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new KeySetSerializedForm(this.f84047c);
    }
}
