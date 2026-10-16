package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzifb {
    zzifb() {
    }

    public static final List zza(Object obj, long j3) {
        zzieq zzieqVar = (zzieq) zziha.zzm(obj, j3);
        if (zzieqVar.zza()) {
            return zzieqVar;
        }
        int size = zzieqVar.size();
        zzieq zzieqVarZzh = zzieqVar.zzh(size == 0 ? 10 : size + size);
        zziha.zzn(obj, j3, zzieqVarZzh);
        return zzieqVarZzh;
    }
}
