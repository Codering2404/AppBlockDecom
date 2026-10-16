package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzimk implements Iterator {
    int zza = 0;
    final /* synthetic */ zziml zzb;

    zzimk(zziml zzimlVar) {
        this.zzb = zzimlVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i3 = this.zza;
        zziml zzimlVar = this.zzb;
        return i3 < zzimlVar.zza.size() || zzimlVar.zzb.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i3 = this.zza;
        zziml zzimlVar = this.zzb;
        List list = zzimlVar.zza;
        if (i3 >= list.size()) {
            list.add(zzimlVar.zzb.next());
            return next();
        }
        int i4 = this.zza;
        this.zza = i4 + 1;
        return list.get(i4);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
