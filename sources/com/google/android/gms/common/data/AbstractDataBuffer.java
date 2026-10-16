package com.google.android.gms.common.data;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractDataBuffer<T> implements DataBuffer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final DataHolder f71884a;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        release();
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public abstract Object get(int i3);

    @Override // com.google.android.gms.common.data.DataBuffer
    public int getCount() {
        DataHolder dataHolder = this.f71884a;
        if (dataHolder == null) {
            return 0;
        }
        return dataHolder.getCount();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new DataBufferIterator(this);
    }

    @Override // com.google.android.gms.common.api.Releasable
    public void release() {
        DataHolder dataHolder = this.f71884a;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }
}
