package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzakv {
    public final zzagv zza;
    public final long zzb;
    public final long zzc;
    public final zzakr zzd;
    public final int zze;
    public final int zzf;
    public final long[] zzg;

    private zzakv(zzagv zzagvVar, long j3, long j4, long[] jArr, zzakr zzakrVar, int i3, int i4) {
        this.zza = new zzagv(zzagvVar);
        this.zzb = j3;
        this.zzc = j4;
        this.zzg = jArr;
        this.zzd = zzakrVar;
        this.zze = i3;
        this.zzf = i4;
    }

    public static zzakv zza(zzagv zzagvVar, zzet zzetVar) {
        long[] jArr;
        int i3;
        int i4;
        int iZzB = zzetVar.zzB();
        int iZzH = (iZzB & 1) != 0 ? zzetVar.zzH() : -1;
        long jZzz = (iZzB & 2) != 0 ? zzetVar.zzz() : -1L;
        zzakr zzakrVarZzb = null;
        if ((iZzB & 4) == 4) {
            long[] jArr2 = new long[100];
            for (int i5 = 0; i5 < 100; i5++) {
                jArr2[i5] = zzetVar.zzs();
            }
            jArr = jArr2;
        } else {
            jArr = null;
        }
        if ((iZzB & 8) != 0) {
            zzetVar.zzk(4);
        }
        if (zzetVar.zzd() >= 24) {
            zzetVar.zzk(11);
            zzakrVarZzb = zzakr.zzb(Float.intBitsToFloat(zzetVar.zzB()), zzetVar.zzt(), zzetVar.zzt());
            zzetVar.zzk(2);
            int iZzx = zzetVar.zzx();
            i4 = iZzx & 4095;
            i3 = iZzx >> 12;
        } else {
            i3 = -1;
            i4 = -1;
        }
        return new zzakv(zzagvVar, iZzH, jZzz, jArr, zzakrVarZzb, i3, i4);
    }

    public final long zzb() {
        long j3 = this.zzb;
        if (j3 == -1 || j3 == 0) {
            return -9223372036854775807L;
        }
        return zzfl.zzt((j3 * ((long) r4.zzg)) - 1, this.zza.zzd);
    }
}
