package com.google.common.collect;

import java.io.Serializable;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class ImmutableMapValues<K, V> extends ImmutableCollection<V> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ImmutableMap f84049b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class SerializedForm<V> implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ImmutableMap f84054a;

        SerializedForm(ImmutableMap immutableMap) {
            this.f84054a = immutableMap;
        }

        Object readResolve() {
            return this.f84054a.values();
        }
    }

    ImmutableMapValues(ImmutableMap immutableMap) {
        this.f84049b = immutableMap;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList a() {
        final ImmutableList immutableListA = this.f84049b.entrySet().a();
        return new ImmutableList<V>(this) { // from class: com.google.common.collect.ImmutableMapValues.2

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ ImmutableMapValues f84053d;

            {
                this.f84053d = this;
            }

            @Override // com.google.common.collect.ImmutableCollection
            boolean g() {
                return true;
            }

            @Override // java.util.List
            public Object get(int i3) {
                return ((Map.Entry) immutableListA.get(i3)).getValue();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return immutableListA.size();
            }

            @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
            Object writeReplace() {
                return super.writeReplace();
            }
        };
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return obj != null && Iterators.j(iterator(), obj);
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean g() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    /* JADX INFO: renamed from: h */
    public UnmodifiableIterator iterator() {
        return new UnmodifiableIterator<V>() { // from class: com.google.common.collect.ImmutableMapValues.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final UnmodifiableIterator f84050a;

            {
                this.f84050a = ImmutableMapValues.this.f84049b.entrySet().iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f84050a.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                return ((Map.Entry) this.f84050a.next()).getValue();
            }
        };
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.f84049b.size();
    }

    @Override // com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(this.f84049b);
    }
}
