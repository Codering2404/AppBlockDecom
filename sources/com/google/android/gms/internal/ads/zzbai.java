package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbai implements Runnable {
    final /* synthetic */ zzbaj zza;

    zzbai(zzbaj zzbajVar) {
        Objects.requireNonNull(zzbajVar);
        this.zza = zzbajVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zBooleanValue;
        zzbaj zzbajVar = this.zza;
        if (zzbajVar.zzb != null) {
            return;
        }
        synchronized (zzbaj.zzd) {
            if (zzbajVar.zzb != null) {
                return;
            }
            boolean z2 = false;
            try {
                zBooleanValue = ((Boolean) zzbiq.zzdu.zze()).booleanValue();
            } catch (IllegalStateException unused) {
                zBooleanValue = false;
            }
            if (zBooleanValue) {
                try {
                    zzbaj.zza = zzfzc.zzb(this.zza.zzb().zza, "ADSHIELD", null);
                    z2 = zBooleanValue;
                } catch (Throwable unused2) {
                }
            } else {
                z2 = zBooleanValue;
            }
            this.zza.zzb = Boolean.valueOf(z2);
            zzbaj.zzd.open();
        }
    }
}
