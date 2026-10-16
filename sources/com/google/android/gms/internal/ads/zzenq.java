package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzenq implements zzdno {
    private final zzfkf zza;
    private final zzbxb zzb;
    private final AdFormat zzc;
    private zzddj zzd = null;

    zzenq(zzfkf zzfkfVar, zzbxb zzbxbVar, AdFormat adFormat) {
        this.zza = zzfkfVar;
        this.zzb = zzbxbVar;
        this.zzc = adFormat;
    }

    @Override // com.google.android.gms.internal.ads.zzdno
    public final void zza(boolean z2, Context context, zzdde zzddeVar) throws zzdnn {
        boolean zZzk;
        try {
            AdFormat adFormat = AdFormat.BANNER;
            int iOrdinal = this.zzc.ordinal();
            if (iOrdinal == 1) {
                zZzk = this.zzb.zzk(ObjectWrapper.i5(context));
            } else {
                if (iOrdinal != 2) {
                    if (iOrdinal == 5) {
                        zZzk = this.zzb.zzt(ObjectWrapper.i5(context));
                    }
                    throw new zzdnn("Adapter failed to show.");
                }
                zZzk = this.zzb.zzm(ObjectWrapper.i5(context));
            }
            if (zZzk) {
                zzddj zzddjVar = this.zzd;
                if (zzddjVar == null) {
                    return;
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzch)).booleanValue() || this.zza.zzY != 2) {
                    return;
                }
                zzddjVar.zza();
                return;
            }
            throw new zzdnn("Adapter failed to show.");
        } catch (Throwable th) {
            throw new zzdnn(th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdno
    public final zzfkf zzb() {
        return this.zza;
    }

    public final void zzc(zzddj zzddjVar) {
        this.zzd = zzddjVar;
    }
}
