package com.google.android.recaptcha.internal;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zznv {
    zznv() {
    }

    public static final List zza(Object obj, long j3) {
        zznk zznkVar = (zznk) zzps.zzf(obj, j3);
        if (zznkVar.zzc()) {
            return zznkVar;
        }
        int size = zznkVar.size();
        zznk zznkVarZzd = zznkVar.zzd(size == 0 ? 10 : size + size);
        zzps.zzs(obj, j3, zznkVarZzd);
        return zznkVarZzd;
    }
}
