package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzad implements Iterator {
    final /* synthetic */ zzae zza;
    private int zzb;

    zzad(zzae zzaeVar) {
        Objects.requireNonNull(zzaeVar);
        this.zza = zzaeVar;
        this.zzb = 0;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zza.zzh();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        zzae zzaeVar = this.zza;
        if (this.zzb < zzaeVar.zzh()) {
            int i3 = this.zzb;
            this.zzb = i3 + 1;
            return zzaeVar.zzl(i3);
        }
        int i4 = this.zzb;
        StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 21);
        sb.append("Out of bounds index: ");
        sb.append(i4);
        throw new NoSuchElementException(sb.toString());
    }
}
