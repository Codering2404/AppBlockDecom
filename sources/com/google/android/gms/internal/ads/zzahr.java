package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzahr implements zzahb {
    final /* synthetic */ zzaht zza;
    private final long zzb;

    public zzahr(zzaht zzahtVar, long j3) {
        Objects.requireNonNull(zzahtVar);
        this.zza = zzahtVar;
        this.zzb = j3;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final long zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final boolean zzb() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final zzagz zzc(long j3) {
        zzaht zzahtVar = this.zza;
        zzagz zzagzVarZzg = zzahtVar.zzh()[0].zzg(j3);
        for (int i3 = 1; i3 < zzahtVar.zzh().length; i3++) {
            zzagz zzagzVarZzg2 = zzahtVar.zzh()[i3].zzg(j3);
            if (zzagzVarZzg2.zza.zzc < zzagzVarZzg.zza.zzc) {
                zzagzVarZzg = zzagzVarZzg2;
            }
        }
        return zzagzVarZzg;
    }
}
