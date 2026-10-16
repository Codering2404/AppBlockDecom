package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzedy {
    zzcaa zza;
    zzcaa zzb;
    private final Context zzc;
    private final zzedv zzd;
    private final zzdzl zze;
    private final com.google.android.gms.ads.internal.util.zzg zzf;

    zzedy(zzedv zzedvVar, zzdzl zzdzlVar, Context context, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zzd = zzedvVar;
        this.zze = zzdzlVar;
        this.zzc = context;
        this.zzf = zzgVar;
    }

    public final void zza() {
        try {
            if (this.zzf.zzP()) {
                return;
            }
            zzedv zzedvVar = this.zzd;
            zzedvVar.zza();
            zzedvVar.zzb(new zzedx(this));
        } catch (Exception e3) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzfQ)).booleanValue()) {
                if (this.zzb == null) {
                    this.zzb = zzbzy.zzc(this.zzc);
                }
                this.zzb.zzh(e3, "InstallReferrerUnsampled.initializeAndReport");
            } else {
                if (this.zza == null) {
                    this.zza = zzbzy.zza(this.zzc);
                }
                this.zza.zzh(e3, "InstallReferrer.initializeAndReport");
            }
        }
    }

    final /* synthetic */ Context zzb() {
        return this.zzc;
    }

    final /* synthetic */ zzedv zzc() {
        return this.zzd;
    }

    final /* synthetic */ zzdzl zzd() {
        return this.zze;
    }

    final /* synthetic */ com.google.android.gms.ads.internal.util.zzg zze() {
        return this.zzf;
    }
}
