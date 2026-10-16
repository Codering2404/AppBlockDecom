package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhaf implements Serializable {
    private static final zzhaf zza = new zzhaf(new int[0], 0, 0);
    private final int[] zzb;
    private final int zzc;

    private zzhaf(int[] iArr, int i3, int i4) {
        this.zzb = iArr;
        this.zzc = i4;
    }

    public static zzhaf zza() {
        return zza;
    }

    public static zzhaf zzb(int i3, int i4, int i5) {
        return new zzhaf(new int[]{0, 2, 1}, 0, 3);
    }

    public static zzhaf zzc(int i3, int i4, int i5, int i6, int i7) {
        return new zzhaf(new int[]{0, 2, 1, 3, 4}, 0, 5);
    }

    public static zzhaf zzd(int i3, int i4, int i5, int i6, int i7, int i8) {
        return new zzhaf(new int[]{0, 2, 1, 5, 3, 4}, 0, 6);
    }

    public static zzhaf zze(int i3, int... iArr) {
        int length = iArr.length;
        int i4 = length + 1;
        int[] iArr2 = new int[i4];
        iArr2[0] = 0;
        System.arraycopy(iArr, 0, iArr2, 1, length);
        return new zzhaf(iArr2, 0, i4);
    }

    public static zzhaf zzf(int[] iArr) {
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        return new zzhaf(iArrCopyOf, 0, iArrCopyOf.length);
    }

    public static zzhae zzg(int i3) {
        zzgtj.zzd(i3 >= 0, "Invalid initialCapacity: %s", i3);
        return new zzhae(i3);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzhaf)) {
            return false;
        }
        zzhaf zzhafVar = (zzhaf) obj;
        int i3 = this.zzc;
        if (i3 != zzhafVar.zzc) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (zzi(i4) != zzhafVar.zzi(i4)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int iHashCode = 1;
        for (int i3 = 0; i3 < this.zzc; i3++) {
            iHashCode = (iHashCode * 31) + Integer.hashCode(this.zzb[i3]);
        }
        return iHashCode;
    }

    public final String toString() {
        int i3 = this.zzc;
        if (i3 == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(i3 * 5);
        sb.append('[');
        int[] iArr = this.zzb;
        sb.append(iArr[0]);
        for (int i4 = 1; i4 < i3; i4++) {
            sb.append(", ");
            sb.append(iArr[i4]);
        }
        sb.append(']');
        return sb.toString();
    }

    public final int zzh() {
        return this.zzc;
    }

    public final int zzi(int i3) {
        zzgtj.zzm(i3, this.zzc, "index");
        return this.zzb[i3];
    }

    /* synthetic */ zzhaf(int[] iArr, int i3, int i4, byte[] bArr) {
        this(iArr, 0, i4);
    }
}
