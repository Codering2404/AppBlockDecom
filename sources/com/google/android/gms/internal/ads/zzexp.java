package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzexp implements zzimu {
    public static zzexp zza() {
        return zzexo.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* synthetic */ Object zzb() {
        List arrayList = new ArrayList();
        zzbih zzbihVar = zzbiq.zznj;
        if (!((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbihVar)).isEmpty()) {
            arrayList = Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbihVar)).split(","));
        }
        zzinc.zzb(arrayList);
        return arrayList;
    }
}
