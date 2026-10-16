package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbcy extends zzbdf {
    public zzbcy(zzbbs zzbbsVar, String str, String str2, zzaxm zzaxmVar, int i3, int i4) {
        super(zzbbsVar, "Qz9CKMoDCHphOXPELo049qp61nrfn738aUeATKOiX7hq+kw0ujtW3xI/vlQKBh37", "bze+wYBAHEMh8JSXqo0+D4B3Aq+R4fX2jHr7eo7ufbY=", zzaxmVar, i3, 51);
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        zzaxm zzaxmVar = this.zzd;
        synchronized (zzaxmVar) {
            zzbbn zzbbnVar = new zzbbn((String) this.zze.invoke(null, null));
            zzaxmVar.zzF(zzbbnVar.zza.longValue());
            zzaxmVar.zzG(zzbbnVar.zzb.longValue());
        }
    }
}
