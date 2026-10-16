package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbcv extends zzbdf {
    private List zzh;
    private final Context zzi;

    public zzbcv(zzbbs zzbbsVar, String str, String str2, zzaxm zzaxmVar, int i3, int i4, Context context) {
        super(zzbbsVar, "XXF2CX++qjQzFfJDmqd+84h356GlStFLqQSTRbbce/csPkd7M5mpQw1l7igXWffL", "FGCYjW2JaOcRH3mqSkgHIxbWzEwOVje6sx286yuA1xM=", zzaxmVar, i3, 31);
        this.zzh = null;
        this.zzi = context;
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        zzaxm zzaxmVar = this.zzd;
        zzaxmVar.zzq(-1L);
        zzaxmVar.zzr(-1L);
        Context contextZzb = this.zzi;
        if (contextZzb == null) {
            contextZzb = this.zza.zzb();
        }
        if (this.zzh == null) {
            this.zzh = (List) this.zze.invoke(null, contextZzb);
        }
        List list = this.zzh;
        if (list == null || list.size() != 2) {
            return;
        }
        synchronized (zzaxmVar) {
            zzaxmVar.zzq(((Long) this.zzh.get(0)).longValue());
            zzaxmVar.zzr(((Long) this.zzh.get(1)).longValue());
        }
    }
}
