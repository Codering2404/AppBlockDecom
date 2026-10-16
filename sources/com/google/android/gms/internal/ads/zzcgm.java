package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcgm implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzcgr zzc;

    zzcgm(zzcgr zzcgrVar, int i3, int i4) {
        this.zza = i3;
        this.zzb = i4;
        Objects.requireNonNull(zzcgrVar);
        this.zzc = zzcgrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcgr zzcgrVar = this.zzc;
        if (zzcgrVar.zzt() != null) {
            zzcgrVar.zzt().zzj(this.zza, this.zzb);
        }
    }
}
