package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbct extends zzbdf {
    public zzbct(zzbbs zzbbsVar, String str, String str2, zzaxm zzaxmVar, int i3, int i4) {
        super(zzbbsVar, "IIcYtgV+jKyhXEWTRGryYoN4Hb3AaxkKFvJa61B8IsfExxFOrLfbygLFTq7UIHav", "0Td4x6cMqS7UG7AA2zcqm+bK2AW+gIwIgEtwqP1CguA=", zzaxmVar, i3, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        Boolean bool = (Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzdN);
        bool.booleanValue();
        zzbay zzbayVar = new zzbay((String) this.zze.invoke(null, this.zza.zzb(), bool));
        zzaxm zzaxmVar = this.zzd;
        synchronized (zzaxmVar) {
            zzaxmVar.zzc(zzbayVar.zza);
            zzaxmVar.zzP(zzbayVar.zzb);
        }
    }
}
