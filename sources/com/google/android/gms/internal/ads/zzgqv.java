package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgqv extends zzgrx {
    private String zza;
    private String zzb;

    zzgqv() {
    }

    @Override // com.google.android.gms.internal.ads.zzgrx
    public final zzgrx zza(String str) {
        this.zza = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgrx
    public final zzgrx zzb(String str) {
        this.zzb = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgrx
    public final zzgry zzc() {
        return new zzgqw(this.zza, this.zzb, null);
    }
}
