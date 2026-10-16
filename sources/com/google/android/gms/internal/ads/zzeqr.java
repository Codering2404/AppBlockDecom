package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzeqr implements zzdea {
    boolean zza;
    final /* synthetic */ zzelv zzb;
    final /* synthetic */ zzcfw zzc;

    zzeqr(zzequ zzequVar, zzelv zzelvVar, zzcfw zzcfwVar) {
        this.zzb = zzelvVar;
        this.zzc = zzcfwVar;
        Objects.requireNonNull(zzequVar);
        this.zza = false;
    }

    private final synchronized void zze(com.google.android.gms.ads.internal.client.zze zzeVar) {
        int i3 = 1;
        if (true == ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzgz)).booleanValue()) {
            i3 = 3;
        }
        this.zzc.zzd(new zzelw(i3, zzeVar));
    }

    @Override // com.google.android.gms.internal.ads.zzdea
    public final synchronized void zza() {
        this.zzc.zzc(null);
    }

    @Override // com.google.android.gms.internal.ads.zzdea
    public final synchronized void zzb(int i3) {
        if (this.zza) {
            return;
        }
        this.zza = true;
        zze(new com.google.android.gms.ads.internal.client.zze(i3, zzequ.zze(this.zzb.zza, i3), "undefined", null, null));
    }

    @Override // com.google.android.gms.internal.ads.zzdea
    public final synchronized void zzc(int i3, String str) {
        try {
            if (this.zza) {
                return;
            }
            this.zza = true;
            if (str == null) {
                str = zzequ.zze(this.zzb.zza, i3);
            }
            zze(new com.google.android.gms.ads.internal.client.zze(i3, str, "undefined", null, null));
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdea
    public final synchronized void zzd(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (this.zza) {
            return;
        }
        this.zza = true;
        zze(zzeVar);
    }
}
