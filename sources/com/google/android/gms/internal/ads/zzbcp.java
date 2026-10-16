package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbcp extends zzbdf {
    private final zzbbk zzh;

    public zzbcp(zzbbs zzbbsVar, String str, String str2, zzaxm zzaxmVar, int i3, int i4, zzbbk zzbbkVar) {
        super(zzbbsVar, "/BhgxpXYgahRBmZkS3xjCzPdid3mZtzdZmJFkhACyEa2oS6asfWgI5KysEGcSPE9", "ngST2QkCVNtF272EQbVjeXMfCtACYPfIcakPMgsny7g=", zzaxmVar, i3, 94);
        this.zzh = zzbbkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        int iIntValue = ((Integer) this.zze.invoke(null, this.zzh.zzb())).intValue();
        zzaxm zzaxmVar = this.zzd;
        synchronized (zzaxmVar) {
            zzaxmVar.zzaj(zzaya.zza(iIntValue));
        }
    }
}
