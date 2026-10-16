package com.google.android.gms.internal.p002firebaseauthapi;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzic {
    private static long zza(byte[] bArr, int i3, int i4) {
        return (zza(bArr, i3) >> i4) & 67108863;
    }

    private static long zza(byte[] bArr, int i3) {
        return ((long) (((bArr[i3 + 3] & 255) << 24) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16))) & 4294967295L;
    }

    private static void zza(byte[] bArr, long j3, int i3) {
        int i4 = 0;
        while (i4 < 4) {
            bArr[i3 + i4] = (byte) (255 & j3);
            i4++;
            j3 >>= 8;
        }
    }

    public static byte[] zza(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 32) {
            long jZza = zza(bArr, 0, 0) & 67108863;
            int i3 = 3;
            int i4 = 2;
            long jZza2 = zza(bArr, 3, 2) & 67108611;
            long jZza3 = zza(bArr, 6, 4) & 67092735;
            long jZza4 = zza(bArr, 9, 6) & 66076671;
            long jZza5 = zza(bArr, 12, 8) & 1048575;
            long j3 = jZza2 * 5;
            long j4 = jZza3 * 5;
            long j5 = jZza4 * 5;
            long j6 = jZza5 * 5;
            int i5 = 17;
            byte[] bArr3 = new byte[17];
            long j7 = 0;
            int i6 = 0;
            long j8 = 0;
            long j9 = 0;
            long j10 = 0;
            long j11 = 0;
            while (i6 < bArr2.length) {
                int iMin = Math.min(16, bArr2.length - i6);
                System.arraycopy(bArr2, i6, bArr3, 0, iMin);
                bArr3[iMin] = 1;
                if (iMin != 16) {
                    Arrays.fill(bArr3, iMin + 1, i5, (byte) 0);
                }
                long jZza6 = j11 + zza(bArr3, 0, 0);
                long jZza7 = j7 + zza(bArr3, i3, i4);
                long jZza8 = j8 + zza(bArr3, 6, 4);
                long jZza9 = j9 + zza(bArr3, 9, 6);
                long j12 = jZza2;
                long jZza10 = j10 + (zza(bArr3, 12, 8) | ((long) (bArr3[16] << Ascii.CAN)));
                long j13 = (jZza6 * jZza) + (jZza7 * j6) + (jZza8 * j5) + (jZza9 * j4) + (jZza10 * j3);
                long j14 = (jZza6 * j12) + (jZza7 * jZza) + (jZza8 * j6) + (jZza9 * j5) + (jZza10 * j4);
                long j15 = (jZza6 * jZza3) + (jZza7 * j12) + (jZza8 * jZza) + (jZza9 * j6) + (jZza10 * j5);
                long j16 = (jZza6 * jZza4) + (jZza7 * jZza3) + (jZza8 * j12) + (jZza9 * jZza) + (jZza10 * j6);
                long j17 = j14 + (j13 >> 26);
                long j18 = j15 + (j17 >> 26);
                long j19 = j16 + (j18 >> 26);
                long j20 = (jZza6 * jZza5) + (jZza7 * jZza4) + (jZza8 * jZza3) + (jZza9 * j12) + (jZza10 * jZza) + (j19 >> 26);
                long j21 = (j13 & 67108863) + ((j20 >> 26) * 5);
                j7 = (j17 & 67108863) + (j21 >> 26);
                i6 += 16;
                j8 = j18 & 67108863;
                j9 = j19 & 67108863;
                j10 = j20 & 67108863;
                i5 = 17;
                i3 = 3;
                j11 = j21 & 67108863;
                jZza2 = j12;
                i4 = 2;
            }
            long j22 = j8 + (j7 >> 26);
            long j23 = j22 & 67108863;
            long j24 = j9 + (j22 >> 26);
            long j25 = j24 & 67108863;
            long j26 = j10 + (j24 >> 26);
            long j27 = j26 & 67108863;
            long j28 = j11 + ((j26 >> 26) * 5);
            long j29 = j28 & 67108863;
            long j30 = (j7 & 67108863) + (j28 >> 26);
            long j31 = j29 + 5;
            long j32 = j31 & 67108863;
            long j33 = (j31 >> 26) + j30;
            long j34 = j23 + (j33 >> 26);
            long j35 = j25 + (j34 >> 26);
            long j36 = (j27 + (j35 >> 26)) - 67108864;
            long j37 = j36 >> 63;
            long j38 = ~j37;
            long j39 = (j30 & j37) | (j33 & 67108863 & j38);
            long j40 = (j23 & j37) | (j34 & 67108863 & j38);
            long j41 = (j25 & j37) | (j35 & 67108863 & j38);
            long j42 = ((j39 << 26) | (j29 & j37) | (j32 & j38)) & 4294967295L;
            long j43 = ((j39 >> 6) | (j40 << 20)) & 4294967295L;
            long j44 = ((j40 >> 12) | (j41 << 14)) & 4294967295L;
            long j45 = ((((j36 & j38) | (j27 & j37)) << 8) | (j41 >> 18)) & 4294967295L;
            long jZza11 = j42 + zza(bArr, 16);
            long j46 = jZza11 & 4294967295L;
            long jZza12 = j43 + zza(bArr, 20) + (jZza11 >> 32);
            long jZza13 = j44 + zza(bArr, 24) + (jZza12 >> 32);
            long jZza14 = (j45 + zza(bArr, 28) + (jZza13 >> 32)) & 4294967295L;
            byte[] bArr4 = new byte[16];
            zza(bArr4, j46, 0);
            zza(bArr4, jZza12 & 4294967295L, 4);
            zza(bArr4, jZza13 & 4294967295L, 8);
            zza(bArr4, jZza14, 12);
            return bArr4;
        }
        throw new IllegalArgumentException("The key length in bytes must be 32.");
    }
}
