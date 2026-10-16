package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzanu<T, B> {
    private static volatile int zza = 100;

    zzanu() {
    }

    abstract int zza(T t2);

    abstract B zza();

    abstract T zza(T t2, T t3);

    abstract void zza(B b3, int i3, int i4);

    abstract void zza(B b3, int i3, long j3);

    abstract void zza(B b3, int i3, zzajv zzajvVar);

    abstract void zza(B b3, int i3, T t2);

    abstract void zza(T t2, zzaol zzaolVar) throws IOException;

    abstract boolean zza(zzanc zzancVar);

    final boolean zza(B b3, zzanc zzancVar, int i3) throws IOException {
        int iZzd = zzancVar.zzd();
        int i4 = iZzd >>> 3;
        int i5 = iZzd & 7;
        if (i5 == 0) {
            zzb(b3, i4, zzancVar.zzl());
            return true;
        }
        if (i5 == 1) {
            zza(b3, i4, zzancVar.zzk());
            return true;
        }
        if (i5 == 2) {
            zza((Object) b3, i4, zzancVar.zzp());
            return true;
        }
        if (i5 != 3) {
            if (i5 == 4) {
                if (i3 != 0) {
                    return false;
                }
                throw zzall.zzb();
            }
            if (i5 != 5) {
                throw zzall.zza();
            }
            zza((Object) b3, i4, zzancVar.zzf());
            return true;
        }
        B bZza = zza();
        int i6 = 4 | (i4 << 3);
        int i7 = i3 + 1;
        if (i7 >= zza) {
            throw zzall.zzh();
        }
        while (zzancVar.zzc() != Integer.MAX_VALUE && zza(bZza, zzancVar, i7)) {
        }
        if (i6 != zzancVar.zzd()) {
            throw zzall.zzb();
        }
        zza(b3, i4, zze(bZza));
        return true;
    }

    abstract int zzb(T t2);

    abstract void zzb(B b3, int i3, long j3);

    abstract void zzb(T t2, zzaol zzaolVar) throws IOException;

    abstract void zzb(Object obj, B b3);

    abstract B zzc(Object obj);

    abstract void zzc(Object obj, T t2);

    abstract T zzd(Object obj);

    abstract T zze(B b3);

    abstract void zzf(Object obj);
}
