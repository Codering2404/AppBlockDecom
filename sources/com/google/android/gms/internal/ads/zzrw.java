package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzrw {
    private final zzv zza;
    private zzhaf zzb = null;

    public zzrw(zzv zzvVar) {
        this.zza = zzvVar;
    }

    public final zzrw zza(zzhaf zzhafVar) {
        this.zzb = zzhafVar;
        return this;
    }

    public final zzrx zzb() {
        return new zzrx(this.zza, 0, this.zzb, null);
    }
}
