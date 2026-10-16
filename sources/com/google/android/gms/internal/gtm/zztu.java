package com.google.android.gms.internal.gtm;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zztu extends zztw {
    final /* synthetic */ zzud zza;
    private int zzb = 0;
    private final int zzc;

    zztu(zzud zzudVar) {
        this.zza = zzudVar;
        this.zzc = zzudVar.zzd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override // com.google.android.gms.internal.gtm.zzty
    public final byte zza() {
        int i3 = this.zzb;
        if (i3 >= this.zzc) {
            throw new NoSuchElementException();
        }
        this.zzb = i3 + 1;
        return this.zza.zzb(i3);
    }
}
