package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class zzcgd {
    private final zzcfw zza;
    private final AtomicInteger zzb;

    public zzcgd() {
        zzcfw zzcfwVar = new zzcfw();
        this.zza = zzcfwVar;
        this.zzb = new AtomicInteger(0);
        zzhbw.zzr(zzcfwVar, new zzcgb(this), zzcfr.zzh);
    }

    @Deprecated
    public final void zze(zzcga zzcgaVar, zzcfy zzcfyVar) {
        zzhbw.zzr(this.zza, new zzcgc(this, zzcgaVar, zzcfyVar), zzcfr.zzh);
    }

    @Deprecated
    public final void zzf(Object obj) {
        this.zza.zzc(obj);
    }

    @Deprecated
    public final void zzg() {
        this.zza.zzd(new Exception());
    }

    @Deprecated
    public final void zzh(Throwable th, String str) {
        this.zza.zzd(th);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zziF)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.l().zzh(th, str);
        }
    }

    @Deprecated
    public final int zzi() {
        return this.zzb.get();
    }

    final /* synthetic */ AtomicInteger zzj() {
        return this.zzb;
    }
}
