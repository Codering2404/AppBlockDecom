package com.google.common.collect;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractSequentialIterator<T> extends UnmodifiableIterator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f83750a;

    protected AbstractSequentialIterator(Object obj) {
        this.f83750a = obj;
    }

    protected abstract Object a(Object obj);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f83750a != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object obj = this.f83750a;
        if (obj == null) {
            throw new NoSuchElementException();
        }
        this.f83750a = a(obj);
        return obj;
    }
}
