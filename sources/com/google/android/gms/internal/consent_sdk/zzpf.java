package com.google.android.gms.internal.consent_sdk;

import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzpf extends zzpg {
    final /* synthetic */ zzpm zza;
    private int zzb;
    private final int zzc;

    zzpf(zzpm zzpmVar) {
        Objects.requireNonNull(zzpmVar);
        this.zza = zzpmVar;
        this.zzb = 0;
        this.zzc = zzpmVar.zzd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpi
    public final byte zza() {
        int i3 = this.zzb;
        if (i3 >= this.zzc) {
            throw new NoSuchElementException();
        }
        this.zzb = i3 + 1;
        return this.zza.zzb(i3);
    }
}
