package com.google.android.gms.internal.ads;

import android.app.AppOpsManager$OnOpActiveChangedListener;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgqb implements AppOpsManager$OnOpActiveChangedListener {
    final /* synthetic */ zzgqd zza;

    zzgqb(zzgqd zzgqdVar) {
        Objects.requireNonNull(zzgqdVar);
        this.zza = zzgqdVar;
    }

    public final void onOpActiveChanged(String str, int i3, String str2, boolean z2) {
        zzgqd zzgqdVar = this.zza;
        synchronized (zzgqdVar) {
            try {
                if (z2) {
                    zzgqdVar.zzg(System.currentTimeMillis());
                    zzgqdVar.zzj(true);
                } else {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (zzgqdVar.zzh() > 0 && jCurrentTimeMillis >= zzgqdVar.zzh()) {
                        zzgqdVar.zzi(jCurrentTimeMillis - zzgqdVar.zzh());
                    }
                    zzgqdVar.zzj(false);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
