package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataBuffer;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class DataBufferResponse<T, R extends AbstractDataBuffer<T> & Result> extends Response<R> implements DataBuffer<T> {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ((AbstractDataBuffer) a()).close();
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public final Object get(int i3) {
        return ((AbstractDataBuffer) a()).get(i3);
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public final int getCount() {
        return ((AbstractDataBuffer) a()).getCount();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return ((AbstractDataBuffer) a()).iterator();
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final void release() {
        ((AbstractDataBuffer) a()).release();
    }
}
