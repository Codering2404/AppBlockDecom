package com.google.common.collect;

import com.google.common.base.Objects;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class CompactHashing {
    static Object a(int i3) {
        if (i3 >= 2 && i3 <= 1073741824 && Integer.highestOneBit(i3) == i3) {
            return i3 <= 256 ? new byte[i3] : i3 <= 65536 ? new short[i3] : new int[i3];
        }
        throw new IllegalArgumentException("must be power of 2 between 2^1 and 2^30: " + i3);
    }

    static int b(int i3, int i4) {
        return i3 & (~i4);
    }

    static int c(int i3, int i4) {
        return i3 & i4;
    }

    static int d(int i3, int i4, int i5) {
        return (i3 & (~i5)) | (i4 & i5);
    }

    static int e(int i3) {
        return (i3 < 32 ? 4 : 2) * (i3 + 1);
    }

    static int f(Object obj, Object obj2, int i3, Object obj3, int[] iArr, Object[] objArr, Object[] objArr2) {
        int i4;
        int i5;
        int iD = Hashing.d(obj);
        int i6 = iD & i3;
        int iH = h(obj3, i6);
        if (iH == 0) {
            return -1;
        }
        int iB = b(iD, i3);
        int i7 = -1;
        while (true) {
            i4 = iH - 1;
            i5 = iArr[i4];
            if (b(i5, i3) == iB && Objects.a(obj, objArr[i4]) && (objArr2 == null || Objects.a(obj2, objArr2[i4]))) {
                break;
            }
            int iC = c(i5, i3);
            if (iC == 0) {
                return -1;
            }
            i7 = i4;
            iH = iC;
        }
        int iC2 = c(i5, i3);
        if (i7 == -1) {
            i(obj3, i6, iC2);
            return i4;
        }
        iArr[i7] = d(iArr[i7], iC2, i3);
        return i4;
    }

    static void g(Object obj) {
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
    }

    static int h(Object obj, int i3) {
        return obj instanceof byte[] ? ((byte[]) obj)[i3] & 255 : obj instanceof short[] ? ((short[]) obj)[i3] & 65535 : ((int[]) obj)[i3];
    }

    static void i(Object obj, int i3, int i4) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i3] = (byte) i4;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i3] = (short) i4;
        } else {
            ((int[]) obj)[i3] = i4;
        }
    }

    static int j(int i3) {
        return Math.max(4, Hashing.a(i3 + 1, 1.0d));
    }
}
