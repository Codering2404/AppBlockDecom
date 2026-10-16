package com.google.android.gms.internal.ads;

import android.app.AppOpsManager$OnOpActiveChangedListener;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbca implements AppOpsManager$OnOpActiveChangedListener {
    final /* synthetic */ zzbcb zza;

    zzbca(zzbcb zzbcbVar) {
        Objects.requireNonNull(zzbcbVar);
        this.zza = zzbcbVar;
    }

    public final void onOpActiveChanged(String str, int i3, String str2, boolean z2) {
        if (z2) {
            zzbcb zzbcbVar = this.zza;
            zzbcbVar.zze(System.currentTimeMillis());
            zzbcbVar.zzh(true);
            return;
        }
        zzbcb zzbcbVar2 = this.zza;
        long jZzf = zzbcbVar2.zzf();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jZzf > 0 && jCurrentTimeMillis >= zzbcbVar2.zzf()) {
            zzbcbVar2.zzg(jCurrentTimeMillis - zzbcbVar2.zzf());
        }
        zzbcbVar2.zzh(false);
    }
}
