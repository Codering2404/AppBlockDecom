package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Collection;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class EvictingQueue<E> extends ForwardingQueue<E> implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Queue f83925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f83926b;

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
    public boolean add(Object obj) {
        Preconditions.t(obj);
        if (this.f83926b == 0) {
            return true;
        }
        if (size() == this.f83926b) {
            this.f83925a.remove();
        }
        this.f83925a.add(obj);
        return true;
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public boolean addAll(Collection collection) {
        int size = collection.size();
        if (size < this.f83926b) {
            return S1(collection);
        }
        clear();
        return Iterables.a(this, Iterables.s(collection, size - this.f83926b));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection
    public Queue k2() {
        return this.f83925a;
    }

    @Override // com.google.common.collect.ForwardingQueue, java.util.Queue
    public boolean offer(Object obj) {
        return add(obj);
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return super.toArray();
    }
}
