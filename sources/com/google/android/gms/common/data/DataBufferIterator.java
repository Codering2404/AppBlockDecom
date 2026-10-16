package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class DataBufferIterator<T> implements Iterator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final DataBuffer f71891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f71892b = -1;

    public DataBufferIterator(DataBuffer dataBuffer) {
        this.f71891a = (DataBuffer) Preconditions.m(dataBuffer);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f71892b < this.f71891a.getCount() + (-1);
    }

    @Override // java.util.Iterator
    public Object next() {
        if (hasNext()) {
            DataBuffer dataBuffer = this.f71891a;
            int i3 = this.f71892b + 1;
            this.f71892b = i3;
            return dataBuffer.get(i3);
        }
        throw new NoSuchElementException("Cannot advance the iterator beyond " + this.f71892b);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
