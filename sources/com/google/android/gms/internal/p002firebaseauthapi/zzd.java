package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzd<T> implements Iterator<T> {
    private int zza = 2;
    private T zzb;

    protected zzd() {
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i3 = this.zza;
        if (i3 == 4) {
            throw new IllegalStateException();
        }
        int i4 = i3 - 1;
        if (i4 == 0) {
            return true;
        }
        if (i4 != 2) {
            this.zza = 4;
            this.zzb = zza();
            if (this.zza != 3) {
                this.zza = 1;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.zza = 2;
        T t2 = this.zzb;
        this.zzb = null;
        return t2;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    protected abstract T zza();

    protected final T zzb() {
        this.zza = 3;
        return null;
    }
}
