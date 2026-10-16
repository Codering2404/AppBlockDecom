package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzdpd implements zzbeq {
    final /* synthetic */ String zza;
    final /* synthetic */ zzdpo zzb;

    zzdpd(zzdpo zzdpoVar, String str) {
        this.zza = str;
        Objects.requireNonNull(zzdpoVar);
        this.zzb = zzdpoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbeq
    public final void zzdj(zzbep zzbepVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcu)).booleanValue()) {
            synchronized (this) {
                try {
                    if (zzbepVar.zzj) {
                        zzdpo zzdpoVar = this.zzb;
                        if (zzdpoVar.zzaa() != null) {
                            zzdpoVar.zzab().put(this.zza, Boolean.TRUE);
                            if (zzdpoVar.zzaa() == null) {
                                return;
                            } else {
                                zzdpoVar.zzu(zzdpoVar.zzaa().zzdF(), zzdpoVar.zzaa().zzi(), zzdpoVar.zzaa().zzj(), true);
                            }
                        }
                    }
                    return;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (zzbepVar.zzj) {
            zzdpo zzdpoVar2 = this.zzb;
            if (zzdpoVar2.zzaa() != null) {
                zzdpoVar2.zzab().put(this.zza, Boolean.TRUE);
                if (zzdpoVar2.zzaa() == null) {
                    return;
                }
                zzdpoVar2.zzu(zzdpoVar2.zzaa().zzdF(), zzdpoVar2.zzaa().zzi(), zzdpoVar2.zzaa().zzj(), true);
            }
        }
    }
}
