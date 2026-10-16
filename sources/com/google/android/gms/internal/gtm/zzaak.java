package com.google.android.gms.internal.gtm;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzaak {
    zzaak() {
    }

    abstract int zza(Object obj);

    abstract int zzb(Object obj);

    abstract Object zzc(Object obj);

    abstract Object zzd(Object obj);

    abstract Object zze(Object obj, Object obj2);

    abstract Object zzf();

    abstract Object zzg(Object obj);

    abstract void zzh(Object obj, int i3, int i4);

    abstract void zzi(Object obj, int i3, long j3);

    abstract void zzj(Object obj, int i3, Object obj2);

    abstract void zzk(Object obj, int i3, zzud zzudVar);

    abstract void zzl(Object obj, int i3, long j3);

    abstract void zzm(Object obj);

    abstract void zzn(Object obj, Object obj2);

    abstract void zzo(Object obj, Object obj2);

    final boolean zzp(Object obj, zzzs zzzsVar) throws IOException {
        int iZzd = zzzsVar.zzd();
        int i3 = iZzd >>> 3;
        int i4 = iZzd & 7;
        if (i4 == 0) {
            zzl(obj, i3, zzzsVar.zzl());
            return true;
        }
        if (i4 == 1) {
            zzi(obj, i3, zzzsVar.zzk());
            return true;
        }
        if (i4 == 2) {
            zzk(obj, i3, zzzsVar.zzp());
            return true;
        }
        if (i4 != 3) {
            if (i4 == 4) {
                return false;
            }
            if (i4 != 5) {
                throw zzyg.zza();
            }
            zzh(obj, i3, zzzsVar.zzf());
            return true;
        }
        Object objZzf = zzf();
        int i5 = i3 << 3;
        while (zzzsVar.zzc() != Integer.MAX_VALUE && zzp(objZzf, zzzsVar)) {
        }
        if ((4 | i5) != zzzsVar.zzd()) {
            throw zzyg.zzb();
        }
        zzg(objZzf);
        zzj(obj, i3, objZzf);
        return true;
    }

    abstract boolean zzq(zzzs zzzsVar);

    abstract void zzr(Object obj, zzur zzurVar) throws IOException;

    abstract void zzs(Object obj, zzur zzurVar) throws IOException;
}
