package com.google.common.graph;

import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.math.IntMath;
import java.util.AbstractSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractDirectedNetworkConnections<N, E> implements NetworkConnections<N, E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Map f84909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Map f84910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f84911c;

    /* JADX INFO: renamed from: com.google.common.graph.AbstractDirectedNetworkConnections$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends AbstractSet<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractDirectedNetworkConnections f84912a;

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public UnmodifiableIterator iterator() {
            return Iterators.O((this.f84912a.f84911c == 0 ? Iterables.d(this.f84912a.f84909a.keySet(), this.f84912a.f84910b.keySet()) : Sets.p(this.f84912a.f84909a.keySet(), this.f84912a.f84910b.keySet())).iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f84912a.f84909a.containsKey(obj) || this.f84912a.f84910b.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return IntMath.i(this.f84912a.f84909a.size(), this.f84912a.f84910b.size() - this.f84912a.f84911c);
        }
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set c() {
        return Sets.p(b(), a());
    }

    @Override // com.google.common.graph.NetworkConnections
    public Object d(Object obj) {
        Object obj2 = this.f84910b.get(obj);
        Objects.requireNonNull(obj2);
        return obj2;
    }
}
