package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
class MapIteratorCache<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f84980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile transient Map.Entry f84981b;

    final boolean c(Object obj) {
        return e(obj) != null || this.f84980a.containsKey(obj);
    }

    Object d(Object obj) {
        Preconditions.t(obj);
        Object objE = e(obj);
        return objE == null ? f(obj) : objE;
    }

    Object e(Object obj) {
        Map.Entry entry = this.f84981b;
        if (entry == null || entry.getKey() != obj) {
            return null;
        }
        return entry.getValue();
    }

    final Object f(Object obj) {
        Preconditions.t(obj);
        return this.f84980a.get(obj);
    }

    final Set g() {
        return new AbstractSet<K>() { // from class: com.google.common.graph.MapIteratorCache.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public UnmodifiableIterator iterator() {
                final Iterator<Map.Entry<K, V>> it = MapIteratorCache.this.f84980a.entrySet().iterator();
                return new UnmodifiableIterator<K>(this) { // from class: com.google.common.graph.MapIteratorCache.1.1

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    final /* synthetic */ AnonymousClass1 f84984b;

                    {
                        this.f84984b = this;
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return it.hasNext();
                    }

                    @Override // java.util.Iterator
                    public Object next() {
                        Map.Entry entry = (Map.Entry) it.next();
                        MapIteratorCache.this.f84981b = entry;
                        return entry.getKey();
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return MapIteratorCache.this.c(obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return MapIteratorCache.this.f84980a.size();
            }
        };
    }
}
