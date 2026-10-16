package com.google.android.gms.internal.ads;

import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzimp {
    final LinkedHashMap zza;

    zzimp(int i3) {
        this.zza = zzimr.zzc(i3);
    }

    final zzimp zza(Object obj, zzind zzindVar) {
        zzinc.zza(obj, "key");
        zzinc.zza(zzindVar, "provider");
        this.zza.put(obj, zzindVar);
        return this;
    }
}
