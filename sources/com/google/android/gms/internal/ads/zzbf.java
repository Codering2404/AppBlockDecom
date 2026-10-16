package com.google.android.gms.internal.ads;

import android.util.Pair;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzbf {
    public static final zzbf zza = new zzbc();

    static {
        String str = zzfl.zza;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
    }

    protected zzbf() {
    }

    public final boolean equals(Object obj) {
        int iZzj;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbf)) {
            return false;
        }
        zzbf zzbfVar = (zzbf) obj;
        if (zzbfVar.zza() == zza() && zzbfVar.zzc() == zzc()) {
            zzbe zzbeVar = new zzbe();
            zzbd zzbdVar = new zzbd();
            zzbe zzbeVar2 = new zzbe();
            zzbd zzbdVar2 = new zzbd();
            for (int i3 = 0; i3 < zza(); i3++) {
                if (!zzb(i3, zzbeVar, 0L).equals(zzbfVar.zzb(i3, zzbeVar2, 0L))) {
                    return false;
                }
            }
            for (int i4 = 0; i4 < zzc(); i4++) {
                if (!zzd(i4, zzbdVar, true).equals(zzbfVar.zzd(i4, zzbdVar2, true))) {
                    return false;
                }
            }
            int iZzk = zzk(true);
            if (iZzk == zzbfVar.zzk(true) && (iZzj = zzj(true)) == zzbfVar.zzj(true)) {
                while (iZzk != iZzj) {
                    int iZzh = zzh(iZzk, 0, true);
                    if (iZzh != zzbfVar.zzh(iZzk, 0, true)) {
                        return false;
                    }
                    iZzk = iZzh;
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i3;
        zzbe zzbeVar = new zzbe();
        zzbd zzbdVar = new zzbd();
        int iZza = zza() + 217;
        int i4 = 0;
        while (true) {
            i3 = iZza * 31;
            if (i4 >= zza()) {
                break;
            }
            iZza = i3 + zzb(i4, zzbeVar, 0L).hashCode();
            i4++;
        }
        int iZzc = i3 + zzc();
        for (int i5 = 0; i5 < zzc(); i5++) {
            iZzc = (iZzc * 31) + zzd(i5, zzbdVar, true).hashCode();
        }
        int iZzk = zzk(true);
        while (iZzk != -1) {
            iZzc = (iZzc * 31) + iZzk;
            iZzk = zzh(iZzk, 0, true);
        }
        return iZzc;
    }

    public abstract int zza();

    public abstract zzbe zzb(int i3, zzbe zzbeVar, long j3);

    public abstract int zzc();

    public abstract zzbd zzd(int i3, zzbd zzbdVar, boolean z2);

    public abstract int zze(Object obj);

    public abstract Object zzf(int i3);

    public final boolean zzg() {
        return zza() == 0;
    }

    public int zzh(int i3, int i4, boolean z2) {
        if (i4 == 0) {
            if (i3 == zzj(z2)) {
                return -1;
            }
            return i3 + 1;
        }
        if (i4 == 1) {
            return i3;
        }
        if (i4 == 2) {
            return i3 == zzj(z2) ? zzk(z2) : i3 + 1;
        }
        throw new IllegalStateException();
    }

    public int zzi(int i3, int i4, boolean z2) {
        if (i3 == zzk(false)) {
            return -1;
        }
        return i3 - 1;
    }

    public int zzj(boolean z2) {
        if (zzg()) {
            return -1;
        }
        return zza() - 1;
    }

    public int zzk(boolean z2) {
        return zzg() ? -1 : 0;
    }

    public final int zzl(int i3, zzbd zzbdVar, zzbe zzbeVar, int i4, boolean z2) {
        int i5 = zzd(i3, zzbdVar, false).zzc;
        if (zzb(i5, zzbeVar, 0L).zzo != i3) {
            return i3 + 1;
        }
        int iZzh = zzh(i5, i4, z2);
        if (iZzh == -1) {
            return -1;
        }
        return zzb(iZzh, zzbeVar, 0L).zzn;
    }

    public final Pair zzm(zzbe zzbeVar, zzbd zzbdVar, int i3, long j3) {
        Pair pairZzn = zzn(zzbeVar, zzbdVar, i3, j3, 0L);
        pairZzn.getClass();
        return pairZzn;
    }

    public final Pair zzn(zzbe zzbeVar, zzbd zzbdVar, int i3, long j3, long j4) {
        zzgtj.zzm(i3, zza(), "index");
        zzb(i3, zzbeVar, j4);
        if (j3 == -9223372036854775807L) {
            long j5 = zzbeVar.zzl;
            j3 = 0;
        }
        int i4 = zzbeVar.zzn;
        zzd(i4, zzbdVar, false);
        while (i4 < zzbeVar.zzo) {
            long j6 = zzbdVar.zze;
            if (j3 == 0) {
                break;
            }
            int i5 = i4 + 1;
            long j7 = zzd(i5, zzbdVar, false).zze;
            if (j3 < 0) {
                break;
            }
            i4 = i5;
        }
        zzd(i4, zzbdVar, true);
        long j8 = zzbdVar.zze;
        long j9 = zzbdVar.zzd;
        if (j9 != -9223372036854775807L) {
            j3 = Math.min(j3, j9 - 1);
        }
        long jMax = Math.max(0L, j3);
        Object obj = zzbdVar.zzb;
        obj.getClass();
        return Pair.create(obj, Long.valueOf(jMax));
    }

    public zzbd zzo(Object obj, zzbd zzbdVar) {
        return zzd(zze(obj), zzbdVar, true);
    }
}
