package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfew implements zzimu {
    public static zzfcn zza(Context context, zzces zzcesVar, zzcet zzcetVar, Object obj, zzfdp zzfdpVar, zzfej zzfejVar, zzimo zzimoVar, zzimo zzimoVar2, zzimo zzimoVar3, zzimo zzimoVar4, zzimo zzimoVar5, zzimo zzimoVar6, zzimo zzimoVar7, Executor executor, zzfqg zzfqgVar) {
        HashSet hashSet = new HashSet();
        hashSet.add((zzfec) obj);
        hashSet.add(zzfdpVar);
        hashSet.add(zzfejVar);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzgM)).booleanValue()) {
            hashSet.add((zzfck) zzimoVar.zzb());
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzgN)).booleanValue()) {
            hashSet.add((zzfck) zzimoVar2.zzb());
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzgP)).booleanValue()) {
            hashSet.add((zzfck) zzimoVar4.zzb());
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzgQ)).booleanValue()) {
            hashSet.add((zzfck) zzimoVar5.zzb());
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzdV)).booleanValue()) {
            hashSet.add((zzfck) zzimoVar7.zzb());
        }
        return new zzfcn(context, executor, hashSet, zzfqgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        throw null;
    }
}
