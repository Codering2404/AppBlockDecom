package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaml {
    public final zzami zza;
    public final int zzb;
    public final long[] zzc;
    public final int[] zzd;
    public final int zze;
    public final long[] zzf;
    public final int[] zzg;
    public final int[] zzh;
    public final long zzi;
    public final boolean zzj;

    public zzaml(zzami zzamiVar, long[] jArr, int[] iArr, int i3, long[] jArr2, int[] iArr2, int[] iArr3, boolean z2, long j3, int i4) {
        int length = iArr.length;
        int length2 = jArr2.length;
        zzgtj.zza(length == length2);
        zzgtj.zza(jArr.length == length2);
        int length3 = iArr2.length;
        zzgtj.zza(length3 == length2);
        this.zza = zzamiVar;
        this.zzc = jArr;
        this.zzd = iArr;
        this.zze = i3;
        this.zzf = jArr2;
        this.zzg = iArr2;
        this.zzh = iArr3;
        this.zzj = z2;
        this.zzi = j3;
        this.zzb = i4;
        if (length3 > 0) {
            int i5 = length3 - 1;
            iArr2[i5] = iArr2[i5] | 536870912;
        }
    }

    public final int zza(long j3) {
        int i3 = 0;
        if (this.zzj) {
            return zzfl.zzo(this.zzf, j3, true, false);
        }
        int[] iArr = this.zzh;
        int length = iArr.length - 1;
        int i4 = -1;
        while (i3 <= length) {
            int i5 = ((length - i3) / 2) + i3;
            if (this.zzf[iArr[i5]] <= j3) {
                i3 = i5 + 1;
                i4 = i5;
            } else {
                length = i5 - 1;
            }
        }
        if (i4 == -1) {
            return -1;
        }
        long[] jArr = this.zzf;
        long j4 = jArr[iArr[i4]];
        if (j4 == j3) {
            while (i4 > 0) {
                int i6 = i4 - 1;
                if (jArr[iArr[i6]] != j4) {
                    break;
                }
                i4 = i6;
            }
        }
        return iArr[i4];
    }

    public final int zzb(long j3) {
        int i3 = 0;
        if (this.zzj) {
            return zzfl.zzq(this.zzf, j3, true, false);
        }
        int[] iArr = this.zzh;
        int length = iArr.length - 1;
        int i4 = -1;
        while (i3 <= length) {
            int i5 = ((length - i3) / 2) + i3;
            if (this.zzf[iArr[i5]] >= j3) {
                length = i5 - 1;
                i4 = i5;
            } else {
                i3 = i5 + 1;
            }
        }
        if (i4 == -1) {
            return -1;
        }
        long[] jArr = this.zzf;
        long j4 = jArr[iArr[i4]];
        if (j4 == j3) {
            while (i4 < iArr.length - 1) {
                int i6 = i4 + 1;
                if (jArr[iArr[i6]] != j4) {
                    break;
                }
                i4 = i6;
            }
        }
        return iArr[i4];
    }
}
