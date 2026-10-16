package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgvu {
    static Object zza(int i3) {
        if (i3 >= 2 && i3 <= 1073741824 && Integer.highestOneBit(i3) == i3) {
            return i3 <= 256 ? new byte[i3] : i3 <= 65536 ? new short[i3] : new int[i3];
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 41);
        sb.append("must be power of 2 between 2^1 and 2^30: ");
        sb.append(i3);
        throw new IllegalArgumentException(sb.toString());
    }

    static int zzb(Object obj, int i3) {
        return obj instanceof byte[] ? ((byte[]) obj)[i3] & 255 : obj instanceof short[] ? (char) ((short[]) obj)[i3] : ((int[]) obj)[i3];
    }

    static void zzc(Object obj, int i3, int i4) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i3] = (byte) i4;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i3] = (short) i4;
        } else {
            ((int[]) obj)[i3] = i4;
        }
    }

    static int zzd(int i3) {
        return (i3 < 32 ? 4 : 2) * (i3 + 1);
    }

    static int zze(Object obj, Object obj2, int i3, Object obj3, int[] iArr, Object[] objArr, Object[] objArr2) {
        int i4;
        int i5;
        int iZzb = zzgwf.zzb(obj);
        int i6 = iZzb & i3;
        int iZzb2 = zzb(obj3, i6);
        if (iZzb2 != 0) {
            int i7 = ~i3;
            int i8 = iZzb & i7;
            int i9 = -1;
            while (true) {
                i4 = iZzb2 - 1;
                int i10 = iArr[i4];
                i5 = i10 & i3;
                if ((i10 & i7) != i8 || !Objects.equals(obj, objArr[i4]) || (objArr2 != null && !Objects.equals(obj2, objArr2[i4]))) {
                    if (i5 == 0) {
                        break;
                    }
                    i9 = i4;
                    iZzb2 = i5;
                } else {
                    break;
                }
            }
            if (i9 == -1) {
                zzc(obj3, i6, i5);
                return i4;
            }
            iArr[i9] = (iArr[i9] & i7) | (i5 & i3);
            return i4;
        }
        return -1;
    }
}
