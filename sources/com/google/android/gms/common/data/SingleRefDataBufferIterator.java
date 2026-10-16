package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.Preconditions;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class SingleRefDataBufferIterator<T> extends DataBufferIterator<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f71914c;

    @Override // com.google.android.gms.common.data.DataBufferIterator, java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Cannot advance the iterator beyond " + this.f71892b);
        }
        int i3 = this.f71892b + 1;
        this.f71892b = i3;
        if (i3 == 0) {
            Object objM = Preconditions.m(this.f71891a.get(0));
            this.f71914c = objM;
            if (!(objM instanceof DataBufferRef)) {
                throw new IllegalStateException("DataBuffer reference of type " + String.valueOf(objM.getClass()) + " is not movable");
            }
        } else {
            ((DataBufferRef) Preconditions.m(this.f71914c)).a(this.f71892b);
        }
        return this.f71914c;
    }
}
