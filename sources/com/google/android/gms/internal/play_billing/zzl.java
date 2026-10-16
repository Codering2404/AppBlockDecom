package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzl extends zzd {
    zzl() {
        super(null);
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    final void zza(zzm zzmVar, zzm zzmVar2) {
        zzmVar.zzc = zzmVar2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    final void zzb(zzm zzmVar, Thread thread) {
        zzmVar.zzb = thread;
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    final boolean zzc(zzo zzoVar, zzh zzhVar, zzh zzhVar2) {
        synchronized (zzoVar) {
            try {
                if (zzoVar.zzd != zzhVar) {
                    return false;
                }
                zzoVar.zzd = zzhVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    final boolean zzd(zzo zzoVar, Object obj, Object obj2) {
        synchronized (zzoVar) {
            try {
                if (zzoVar.zzc != obj) {
                    return false;
                }
                zzoVar.zzc = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    final boolean zze(zzo zzoVar, zzm zzmVar, zzm zzmVar2) {
        synchronized (zzoVar) {
            try {
                if (zzoVar.zze != zzmVar) {
                    return false;
                }
                zzoVar.zze = zzmVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
