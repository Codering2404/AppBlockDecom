package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgqp extends zzgqx {
    private String zza;
    private String zzb;

    zzgqp() {
    }

    @Override // com.google.android.gms.internal.ads.zzgqx
    public final zzgqx zza(String str) {
        this.zza = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgqx
    public final zzgqx zzb(String str) {
        this.zzb = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgqx
    public final zzgqy zzc() {
        return new zzgqq(this.zza, this.zzb, null);
    }
}
