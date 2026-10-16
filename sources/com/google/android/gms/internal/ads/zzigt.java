package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzigt {
    private static volatile int zza = 100;

    zzigt() {
    }

    abstract void zza(Object obj, int i3, long j3);

    abstract void zzb(Object obj, int i3, int i4);

    abstract void zzc(Object obj, int i3, long j3);

    abstract void zzd(Object obj, int i3, zzida zzidaVar);

    abstract void zze(Object obj, int i3, Object obj2);

    abstract Object zzf();

    abstract Object zzg(Object obj);

    abstract Object zzh(Object obj);

    abstract void zzi(Object obj, Object obj2);

    abstract void zzj(Object obj);

    final boolean zzk(Object obj, zzigc zzigcVar, int i3) throws IOException {
        int iZzc = zzigcVar.zzc();
        int i4 = iZzc >>> 3;
        int i5 = iZzc & 7;
        if (i5 == 0) {
            zza(obj, i4, zzigcVar.zzh());
            return true;
        }
        if (i5 == 1) {
            zzc(obj, i4, zzigcVar.zzj());
            return true;
        }
        if (i5 == 2) {
            zzd(obj, i4, zzigcVar.zzq());
            return true;
        }
        if (i5 != 3) {
            if (i5 == 4) {
                if (i3 != 0) {
                    return false;
                }
                throw new zziet("Protocol message end-group tag did not match expected tag.");
            }
            if (i5 != 5) {
                throw new zzies("Protocol message tag had invalid wire type.");
            }
            zzb(obj, i4, zzigcVar.zzk());
            return true;
        }
        Object objZzf = zzf();
        int i6 = i4 << 3;
        int i7 = i3 + 1;
        if (i7 >= zza) {
            throw new zziet("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        while (zzigcVar.zzb() != Integer.MAX_VALUE && zzk(objZzf, zzigcVar, i7)) {
        }
        if ((i6 | 4) != zzigcVar.zzc()) {
            throw new zziet("Protocol message end-group tag did not match expected tag.");
        }
        zze(obj, i4, zzg(objZzf));
        return true;
    }
}
