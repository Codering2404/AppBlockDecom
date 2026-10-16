package com.google.android.recaptcha.internal;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzpl {
    private static volatile int zza = 100;

    zzpl() {
    }

    abstract Object zza(Object obj);

    abstract Object zzb();

    abstract Object zzc(Object obj);

    abstract void zzd(Object obj, int i3, int i4);

    abstract void zze(Object obj, int i3, long j3);

    abstract void zzf(Object obj, int i3, Object obj2);

    abstract void zzg(Object obj, int i3, zzle zzleVar);

    abstract void zzh(Object obj, int i3, long j3);

    abstract void zzi(Object obj);

    abstract void zzj(Object obj, Object obj2);

    final boolean zzk(Object obj, zzov zzovVar, int i3) throws IOException {
        int iZzd = zzovVar.zzd();
        int i4 = iZzd >>> 3;
        int i5 = iZzd & 7;
        if (i5 == 0) {
            zzh(obj, i4, zzovVar.zzl());
            return true;
        }
        if (i5 == 1) {
            zze(obj, i4, zzovVar.zzk());
            return true;
        }
        if (i5 == 2) {
            zzg(obj, i4, zzovVar.zzp());
            return true;
        }
        if (i5 != 3) {
            if (i5 == 4) {
                return false;
            }
            if (i5 != 5) {
                throw new zznm("Protocol message tag had invalid wire type.");
            }
            zzd(obj, i4, zzovVar.zzf());
            return true;
        }
        Object objZzb = zzb();
        int i6 = i4 << 3;
        int i7 = i3 + 1;
        if (i7 >= zza) {
            throw new zznn("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        while (zzovVar.zzc() != Integer.MAX_VALUE && zzk(objZzb, zzovVar, i7)) {
        }
        if ((i6 | 4) != zzovVar.zzd()) {
            throw new zznn("Protocol message end-group tag did not match expected tag.");
        }
        zzf(obj, i4, zzc(objZzb));
        return true;
    }
}
