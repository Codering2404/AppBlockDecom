package com.google.android.gms.internal.ads;

import android.util.Pair;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzakm implements zzakt {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;

    private zzakm(long[] jArr, long[] jArr2, long j3) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = j3 == -9223372036854775807L ? zzfl.zzs(jArr2[jArr2.length - 1]) : j3;
    }

    public static zzakm zze(long j3, zzajr zzajrVar, long j4) {
        int[] iArr = zzajrVar.zzd;
        int length = iArr.length;
        int i3 = length + 1;
        long[] jArr = new long[i3];
        long[] jArr2 = new long[i3];
        jArr[0] = j3;
        long j5 = 0;
        jArr2[0] = 0;
        for (int i4 = 1; i4 <= length; i4++) {
            int i5 = i4 - 1;
            j3 += (long) (zzajrVar.zzb + iArr[i5]);
            j5 += (long) (zzajrVar.zzc + zzajrVar.zze[i5]);
            jArr[i4] = j3;
            jArr2[i4] = j5;
        }
        return new zzakm(jArr, jArr2, j4);
    }

    private static Pair zzi(long j3, long[] jArr, long[] jArr2) {
        int iZzo = zzfl.zzo(jArr, j3, true, true);
        long j4 = jArr[iZzo];
        long j5 = jArr2[iZzo];
        int i3 = iZzo + 1;
        if (i3 == jArr.length) {
            return Pair.create(Long.valueOf(j4), Long.valueOf(j5));
        }
        return Pair.create(Long.valueOf(j3), Long.valueOf(((long) ((jArr[i3] == j4 ? 0.0d : (j3 - j4) / (r6 - j4)) * (jArr2[i3] - j5))) + j5));
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final boolean zzb() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final zzagz zzc(long j3) {
        String str = zzfl.zza;
        Pair pairZzi = zzi(zzfl.zzr(Math.max(0L, Math.min(j3, this.zzc))), this.zzb, this.zza);
        zzahc zzahcVar = new zzahc(zzfl.zzs(((Long) pairZzi.first).longValue()), ((Long) pairZzi.second).longValue());
        return new zzagz(zzahcVar, zzahcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzakt
    public final long zzf(long j3) {
        return zzfl.zzs(((Long) zzi(j3, this.zza, this.zzb).second).longValue());
    }

    @Override // com.google.android.gms.internal.ads.zzakt
    public final long zzg() {
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzakt
    public final int zzh() {
        return -2147483647;
    }
}
