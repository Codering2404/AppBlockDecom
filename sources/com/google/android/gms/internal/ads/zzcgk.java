package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcgk implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzcgr zzc;

    zzcgk(zzcgr zzcgrVar, String str, String str2) {
        this.zza = str;
        this.zzb = str2;
        Objects.requireNonNull(zzcgrVar);
        this.zzc = zzcgrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcgr zzcgrVar = this.zzc;
        if (zzcgrVar.zzt() != null) {
            zzcgrVar.zzt().zzf(this.zza, this.zzb);
        }
    }
}
