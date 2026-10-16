package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcgo implements Runnable {
    final /* synthetic */ zzcgr zza;

    zzcgo(zzcgr zzcgrVar) {
        Objects.requireNonNull(zzcgrVar);
        this.zza = zzcgrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcgr zzcgrVar = this.zza;
        if (zzcgrVar.zzt() != null) {
            if (!zzcgrVar.zzu()) {
                zzcgrVar.zzt().zzk();
                zzcgrVar.zzv(true);
            }
            zzcgrVar.zzt().zzc();
        }
    }
}
