package com.google.common.graph;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class DirectedMultiNetworkConnections<N, E> extends AbstractDirectedNetworkConnections<N, E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private transient Reference f84945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private transient Reference f84946e;

    /* JADX INFO: renamed from: com.google.common.graph.DirectedMultiNetworkConnections$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends MultiEdgesConnecting<Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f84947c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ DirectedMultiNetworkConnections f84948d;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f84948d.i().Y1(this.f84947c);
        }
    }

    private static Object g(Reference reference) {
        if (reference == null) {
            return null;
        }
        return reference.get();
    }

    private Multiset h() {
        Multiset multiset = (Multiset) g(this.f84945d);
        if (multiset != null) {
            return multiset;
        }
        HashMultiset hashMultisetN = HashMultiset.n(this.f84909a.values());
        this.f84945d = new SoftReference(hashMultisetN);
        return hashMultisetN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Multiset i() {
        Multiset multiset = (Multiset) g(this.f84946e);
        if (multiset != null) {
            return multiset;
        }
        HashMultiset hashMultisetN = HashMultiset.n(this.f84910b.values());
        this.f84946e = new SoftReference(hashMultisetN);
        return hashMultisetN;
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set a() {
        return Collections.unmodifiableSet(i().i());
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set b() {
        return Collections.unmodifiableSet(h().i());
    }
}
