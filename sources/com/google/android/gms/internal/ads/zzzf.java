package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzzf {
    private final Random zza;
    private final int[] zzb;
    private final int[] zzc;

    public zzzf(int i3) {
        this(0, new Random());
    }

    public final int zza() {
        return this.zzb.length;
    }

    public final int zzb(int i3) {
        int i4 = this.zzc[i3] + 1;
        int[] iArr = this.zzb;
        if (i4 < iArr.length) {
            return iArr[i4];
        }
        return -1;
    }

    public final int zzc(int i3) {
        int i4 = this.zzc[i3] - 1;
        if (i4 >= 0) {
            return this.zzb[i4];
        }
        return -1;
    }

    public final int zzd() {
        int[] iArr = this.zzb;
        int length = iArr.length;
        if (length > 0) {
            return iArr[length - 1];
        }
        return -1;
    }

    public final int zze() {
        int[] iArr = this.zzb;
        if (iArr.length > 0) {
            return iArr[0];
        }
        return -1;
    }

    public final zzzf zzf(int i3, int i4) {
        int[] iArr = new int[i4];
        int[] iArr2 = new int[i4];
        int i5 = 0;
        while (i5 < i4) {
            Random random = this.zza;
            iArr[i5] = random.nextInt(this.zzb.length + 1);
            int i6 = i5 + 1;
            int iNextInt = random.nextInt(i6);
            iArr2[i5] = iArr2[iNextInt];
            iArr2[iNextInt] = i5;
            i5 = i6;
        }
        Arrays.sort(iArr);
        int[] iArr3 = this.zzb;
        int[] iArr4 = new int[iArr3.length + i4];
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < iArr3.length + i4; i9++) {
            if (i7 >= i4 || i8 != iArr[i7]) {
                int i10 = i8 + 1;
                int i11 = iArr3[i8];
                iArr4[i9] = i11;
                if (i11 >= 0) {
                    iArr4[i9] = i11 + i4;
                }
                i8 = i10;
            } else {
                iArr4[i9] = iArr2[i7];
                i7++;
            }
        }
        return new zzzf(iArr4, new Random(this.zza.nextLong()));
    }

    public final zzzf zzg() {
        return new zzzf(0, new Random(this.zza.nextLong()));
    }

    private zzzf(int i3, Random random) {
        this(new int[0], random);
    }

    private zzzf(int[] iArr, Random random) {
        this.zzb = iArr;
        this.zza = random;
        this.zzc = new int[iArr.length];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            this.zzc[iArr[i3]] = i3;
        }
    }
}
