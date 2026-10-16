package com.google.android.gms.internal.fido;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfe implements Iterator {
    final /* synthetic */ zzff zza;
    private int zzb = 0;

    zzfe(zzff zzffVar) {
        this.zza = zzffVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i3 = this.zzb;
        zzff zzffVar = this.zza;
        return i3 < zzffVar.zza() - zzffVar.zzb();
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i3 = this.zzb;
        zzff zzffVar = this.zza;
        if (i3 >= zzffVar.zza() - zzffVar.zzb()) {
            throw new NoSuchElementException();
        }
        zzff zzffVar2 = this.zza;
        Object obj = zzffVar2.zzb.zzb[zzffVar2.zzb() + i3];
        this.zzb = i3 + 1;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
