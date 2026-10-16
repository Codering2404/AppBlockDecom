package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdhx implements zzdfx {
    private int zza = ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzbS)).intValue();
    private int zzb = ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzor)).intValue();

    public final synchronized int zzc() {
        return this.zza;
    }

    public final synchronized int zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzdfx
    public final synchronized void zzdQ(zzfkq zzfkqVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzbT)).booleanValue()) {
            try {
                zzfki zzfkiVar = zzfkqVar.zzb.zzb;
                this.zza = zzfkiVar.zzc;
                this.zzb = zzfkiVar.zzd;
            } catch (NullPointerException unused) {
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdfx
    public final void zzdP(zzcbd zzcbdVar) {
    }
}
