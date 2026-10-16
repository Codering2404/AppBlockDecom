package androidx.media3.extractor.ts;

import androidx.media3.common.util.ParsableByteArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class TsUtil {
    public static int a(byte[] bArr, int i3, int i4) {
        while (i3 < i4 && bArr[i3] != 71) {
            i3++;
        }
        return i3;
    }

    public static boolean b(byte[] bArr, int i3, int i4, int i5) {
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

    public static long c(ParsableByteArray parsableByteArray, int i3, int i4) {
        parsableByteArray.W(i3);
        if (parsableByteArray.a() < 5) {
            return -9223372036854775807L;
        }
        int iQ = parsableByteArray.q();
        if ((8388608 & iQ) != 0 || ((2096896 & iQ) >> 8) != i4 || (iQ & 32) == 0 || parsableByteArray.H() < 7 || parsableByteArray.a() < 7 || (parsableByteArray.H() & 16) != 16) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[6];
        parsableByteArray.l(bArr, 0, 6);
        return d(bArr);
    }

    private static long d(byte[] bArr) {
        return ((((long) bArr[0]) & 255) << 25) | ((((long) bArr[1]) & 255) << 17) | ((((long) bArr[2]) & 255) << 9) | ((((long) bArr[3]) & 255) << 1) | ((255 & ((long) bArr[4])) >> 7);
    }
}
