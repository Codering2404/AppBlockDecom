package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ep {
    public static int a(byte[] bArr, int i3, int i4) {
        while (i3 < i4 && bArr[i3] != 71) {
            i3++;
        }
        return i3;
    }

    public static boolean a(byte[] bArr, int i3, int i4, int i5) {
        int i6 = 0;
        for (int i7 = -4; i7 <= 4; i7++) {
            int i8 = (i7 * 188) + i5;
            if (i8 < i3 || i8 >= i4 || bArr[i8] != 71) {
                i6 = 0;
            } else {
                i6++;
                if (i6 == 5) {
                    return true;
                }
            }
        }
        return false;
    }

    public static long a(ah ahVar, int i3, int i4) {
        ahVar.f(i3);
        if (ahVar.a() < 5) {
            return -9223372036854775807L;
        }
        int iJ = ahVar.j();
        if ((8388608 & iJ) != 0 || ((2096896 & iJ) >> 8) != i4 || (iJ & 32) == 0 || ahVar.w() < 7 || ahVar.a() < 7 || (ahVar.w() & 16) != 16) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[6];
        ahVar.a(bArr, 0, 6);
        return a(bArr);
    }

    private static long a(byte[] bArr) {
        return ((((long) bArr[0]) & 255) << 25) | ((((long) bArr[1]) & 255) << 17) | ((((long) bArr[2]) & 255) << 9) | ((((long) bArr[3]) & 255) << 1) | ((255 & ((long) bArr[4])) >> 7);
    }
}
