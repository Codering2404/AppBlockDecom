package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzics extends zzict {
    final /* synthetic */ zzida zza;
    private int zzb;
    private final int zzc;

    zzics(zzida zzidaVar) {
        Objects.requireNonNull(zzidaVar);
        this.zza = zzidaVar;
        this.zzb = 0;
        this.zzc = zzidaVar.zzb();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzicv
    public final byte zza() {
        int i3 = this.zzb;
        if (i3 >= this.zzc) {
            throw new NoSuchElementException();
        }
        this.zzb = i3 + 1;
        return this.zza.zza(i3);
    }
}
