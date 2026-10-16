package com.google.android.libraries.places.internal;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbek {
    zzbek() {
    }

    public static final List a(Object obj, long j3) {
        zzbea zzbeaVar = (zzbea) zzbgf.s(obj, j3);
        if (zzbeaVar.zza()) {
            return zzbeaVar;
        }
        int size = zzbeaVar.size();
        zzbea zzbeaVarZzg = zzbeaVar.zzg(size == 0 ? 10 : size + size);
        zzbgf.t(obj, j3, zzbeaVarZzg);
        return zzbeaVarZzg;
    }
}
