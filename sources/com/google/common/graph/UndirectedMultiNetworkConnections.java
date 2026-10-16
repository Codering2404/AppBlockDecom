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
final class UndirectedMultiNetworkConnections<N, E> extends AbstractUndirectedNetworkConnections<N, E> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient Reference f85026b;

    /* JADX INFO: renamed from: com.google.common.graph.UndirectedMultiNetworkConnections$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends MultiEdgesConnecting<Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f85027c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ UndirectedMultiNetworkConnections f85028d;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f85028d.f().Y1(this.f85027c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Multiset f() {
        Multiset multiset = (Multiset) g(this.f85026b);
        if (multiset != null) {
            return multiset;
        }
        HashMultiset hashMultisetN = HashMultiset.n(this.f84918a.values());
        this.f85026b = new SoftReference(hashMultisetN);
        return hashMultisetN;
    }

    private static Object g(Reference reference) {
        if (reference == null) {
            return null;
        }
        return reference.get();
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set c() {
        return Collections.unmodifiableSet(f().i());
    }
}
