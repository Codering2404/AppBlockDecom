package com.google.common.graph;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class EdgesConnecting<E> extends AbstractSet<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f84949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f84950b;

    private Object a() {
        return this.f84949a.get(this.f84950b);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public UnmodifiableIterator iterator() {
        Object objA = a();
        return objA == null ? ImmutableSet.z().iterator() : Iterators.K(objA);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        Object objA = a();
        return objA != null && objA.equals(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return a() == null ? 0 : 1;
    }
}
