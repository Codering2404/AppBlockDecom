package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzabd {
    private final int[] zza;
    private final zzzn[] zzb;
    private final int[] zzc;
    private final int[][][] zzd;
    private final zzzn zze;

    zzabd(String[] strArr, int[] iArr, zzzn[] zzznVarArr, int[] iArr2, int[][][] iArr3, zzzn zzznVar) {
        this.zza = iArr;
        this.zzb = zzznVarArr;
        this.zzd = iArr3;
        this.zzc = iArr2;
        this.zze = zzznVar;
    }

    public final int zza(int i3) {
        return this.zza[i3];
    }

    public final zzzn zzb(int i3) {
        return this.zzb[i3];
    }

    public final int zzc(int i3, int i4, int i5) {
        return this.zzd[i3][i4][i5];
    }

    public final int zzd(int i3, int i4, boolean z2) {
        zzzn[] zzznVarArr = this.zzb;
        int i5 = zzznVarArr[i3].zza(i4).zza;
        int[] iArr = new int[i5];
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < i5; i8++) {
            if ((this.zzd[i3][i4][i8] & 7) == 4) {
                iArr[i7] = i8;
                i7++;
            }
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, i7);
        String str = null;
        int i9 = 0;
        int iMin = 16;
        boolean z3 = false;
        while (i6 < iArrCopyOf.length) {
            String str2 = zzznVarArr[i3].zza(i4).zza(iArrCopyOf[i6]).zzp;
            int i10 = i9 + 1;
            if (i9 == 0) {
                str = str2;
            } else {
                z3 |= !Objects.equals(str, str2);
            }
            iMin = Math.min(iMin, this.zzd[i3][i4][i6] & 24);
            i6++;
            i9 = i10;
        }
        return z3 ? Math.min(iMin, this.zzc[i3]) : iMin;
    }

    public final zzzn zze() {
        return this.zze;
    }
}
