package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfpq implements zzdkd, zzddh, zzdkh {
    private final zzfqg zza;
    private final zzfpw zzb;

    zzfpq(Context context, zzfqg zzfqgVar) {
        this.zza = zzfqgVar;
        this.zzb = zzfpw.zzn(context, 13);
    }

    @Override // com.google.android.gms.internal.ads.zzdkh
    public final void zza() {
        if (((Boolean) zzbkj.zzd.zze()).booleanValue()) {
            zzfqg zzfqgVar = this.zza;
            zzfpw zzfpwVar = this.zzb;
            zzfpwVar.zzd(true);
            zzfqgVar.zza(zzfpwVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdkd
    public final void zzh() {
        if (((Boolean) zzbkj.zzd.zze()).booleanValue()) {
            this.zzb.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzddh
    public final void zzj(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (((Boolean) zzbkj.zzd.zze()).booleanValue()) {
            zzfqg zzfqgVar = this.zza;
            zzfpw zzfpwVar = this.zzb;
            zzfpwVar.zzk(zzeVar.M().toString());
            zzfpwVar.zzd(false);
            zzfqgVar.zza(zzfpwVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdkh
    public final void zzb() {
    }

    @Override // com.google.android.gms.internal.ads.zzdkd
    public final void zzg() {
    }
}
