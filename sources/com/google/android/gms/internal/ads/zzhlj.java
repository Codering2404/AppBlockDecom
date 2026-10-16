package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhlj {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {0, 3, 6, 9, 12, 16, 19, 22, 25, 28};
    private static final int[] zzc = {0, 2, 3, 5, 6, 0, 1, 3, 4, 6};
    private static final int[] zzd = {67108863, 33554431};
    private static final int[] zze = {26, 25};

    static void zza(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i3 = 0; i3 < 10; i3++) {
            jArr[i3] = jArr2[i3] + jArr3[i3];
        }
    }

    static void zzb(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i3 = 0; i3 < 10; i3++) {
            jArr[i3] = jArr2[i3] - jArr3[i3];
        }
    }

    static void zzc(long[] jArr, long[] jArr2) {
        int length = jArr.length;
        if (length != 19) {
            long[] jArr3 = new long[19];
            System.arraycopy(jArr, 0, jArr3, 0, length);
            jArr = jArr3;
        }
        long j3 = jArr[8];
        long j4 = jArr[18];
        long j5 = j3 + (j4 << 4);
        jArr[8] = j5;
        long j6 = j5 + j4 + j4;
        jArr[8] = j6;
        jArr[8] = j6 + j4;
        long j7 = jArr[7];
        long j8 = jArr[17];
        long j9 = j7 + (j8 << 4);
        jArr[7] = j9;
        long j10 = j9 + j8 + j8;
        jArr[7] = j10;
        jArr[7] = j10 + j8;
        long j11 = jArr[6];
        long j12 = jArr[16];
        long j13 = j11 + (j12 << 4);
        jArr[6] = j13;
        long j14 = j13 + j12 + j12;
        jArr[6] = j14;
        jArr[6] = j14 + j12;
        long j15 = jArr[5];
        long j16 = jArr[15];
        long j17 = j15 + (j16 << 4);
        jArr[5] = j17;
        long j18 = j17 + j16 + j16;
        jArr[5] = j18;
        jArr[5] = j18 + j16;
        long j19 = jArr[4];
        long j20 = jArr[14];
        long j21 = j19 + (j20 << 4);
        jArr[4] = j21;
        long j22 = j21 + j20 + j20;
        jArr[4] = j22;
        jArr[4] = j22 + j20;
        long j23 = jArr[3];
        long j24 = jArr[13];
        long j25 = j23 + (j24 << 4);
        jArr[3] = j25;
        long j26 = j25 + j24 + j24;
        jArr[3] = j26;
        jArr[3] = j26 + j24;
        long j27 = jArr[2];
        long j28 = jArr[12];
        long j29 = j27 + (j28 << 4);
        jArr[2] = j29;
        long j30 = j29 + j28 + j28;
        jArr[2] = j30;
        jArr[2] = j30 + j28;
        long j31 = jArr[1];
        long j32 = jArr[11];
        long j33 = j31 + (j32 << 4);
        jArr[1] = j33;
        long j34 = j33 + j32 + j32;
        jArr[1] = j34;
        jArr[1] = j34 + j32;
        long j35 = jArr[0];
        long j36 = jArr[10];
        long j37 = j35 + (j36 << 4);
        jArr[0] = j37;
        long j38 = j37 + j36 + j36;
        jArr[0] = j38;
        jArr[0] = j38 + j36;
        zzd(jArr);
        System.arraycopy(jArr, 0, jArr2, 0, 10);
    }

    static void zzd(long[] jArr) {
        jArr[10] = 0;
        int i3 = 0;
        while (i3 < 10) {
            long j3 = jArr[i3];
            long j4 = j3 / 67108864;
            jArr[i3] = j3 - (j4 << 26);
            int i4 = i3 + 1;
            long j5 = jArr[i4] + j4;
            jArr[i4] = j5;
            long j6 = j5 / 33554432;
            jArr[i4] = j5 - (j6 << 25);
            i3 += 2;
            jArr[i3] = jArr[i3] + j6;
        }
        long j7 = jArr[0];
        long j8 = jArr[10];
        long j9 = j7 + (j8 << 4);
        jArr[0] = j9;
        long j10 = j9 + j8 + j8;
        jArr[0] = j10;
        long j11 = j10 + j8;
        jArr[0] = j11;
        jArr[10] = 0;
        long j12 = j11 / 67108864;
        jArr[0] = j11 - (j12 << 26);
        jArr[1] = jArr[1] + j12;
    }

    static void zze(long[] jArr, long[] jArr2, long[] jArr3) {
        long j3 = jArr2[0];
        long j4 = jArr3[0];
        long j5 = j3 * j4;
        long j6 = jArr3[1];
        long j7 = jArr2[1];
        long j8 = (j3 * j6) + (j7 * j4);
        long j9 = jArr3[2];
        long j10 = jArr2[2];
        long j11 = ((j7 + j7) * j6) + (j3 * j9) + (j10 * j4);
        long j12 = jArr3[3];
        long j13 = jArr2[3];
        long j14 = (j7 * j9) + (j10 * j6) + (j3 * j12) + (j13 * j4);
        long j15 = jArr3[4];
        long j16 = jArr2[4];
        long j17 = (j7 * j12) + (j13 * j6);
        long j18 = (j10 * j9) + j17 + j17 + (j3 * j15) + (j16 * j4);
        long j19 = jArr3[5];
        long j20 = jArr2[5];
        long j21 = (j10 * j12) + (j13 * j9) + (j7 * j15) + (j16 * j6) + (j3 * j19) + (j20 * j4);
        long j22 = jArr3[6];
        long j23 = jArr2[6];
        long j24 = (j13 * j12) + (j7 * j19) + (j20 * j6);
        long j25 = j24 + j24 + (j10 * j15) + (j16 * j9) + (j3 * j22) + (j23 * j4);
        long j26 = jArr3[7];
        long j27 = jArr2[7];
        long j28 = (j13 * j15) + (j16 * j12) + (j10 * j19) + (j20 * j9) + (j7 * j22) + (j23 * j6) + (j3 * j26) + (j27 * j4);
        long j29 = jArr3[8];
        long j30 = jArr2[8];
        long j31 = (j13 * j19) + (j20 * j12) + (j7 * j26) + (j27 * j6);
        long j32 = (j16 * j15) + j31 + j31 + (j10 * j22) + (j23 * j9) + (j3 * j29) + (j30 * j4);
        long j33 = jArr3[9];
        long j34 = jArr2[9];
        long j35 = (j16 * j19) + (j20 * j15) + (j13 * j22) + (j23 * j12) + (j10 * j26) + (j27 * j9) + (j7 * j29) + (j30 * j6) + (j3 * j33) + (j4 * j34);
        long j36 = (j20 * j19) + (j13 * j26) + (j27 * j12) + (j7 * j33) + (j6 * j34);
        long j37 = (j20 * j26) + (j27 * j19) + (j13 * j33) + (j12 * j34);
        long j38 = (j27 * j26) + (j20 * j33) + (j19 * j34);
        long j39 = (j27 * j29) + (j30 * j26) + (j23 * j33) + (j22 * j34);
        long j40 = (j27 * j33) + (j26 * j34);
        zzc(new long[]{j5, j8, j11, j14, j18, j21, j25, j28, j32, j35, j36 + j36 + (j16 * j22) + (j23 * j15) + (j10 * j29) + (j30 * j9), (j20 * j22) + (j23 * j19) + (j16 * j26) + (j27 * j15) + (j13 * j29) + (j30 * j12) + (j10 * j33) + (j9 * j34), (j23 * j22) + j37 + j37 + (j16 * j29) + (j30 * j15), (j23 * j26) + (j27 * j22) + (j20 * j29) + (j30 * j19) + (j16 * j33) + (j15 * j34), j38 + j38 + (j23 * j29) + (j30 * j22), j39, (j30 * j29) + j40 + j40, (j30 * j33) + (j29 * j34), (j34 + j34) * j33}, jArr);
    }

    static void zzf(long[] jArr, long[] jArr2) {
        long j3 = jArr2[0];
        long j4 = j3 * j3;
        long j5 = jArr2[1];
        long j6 = (j3 + j3) * j5;
        long j7 = jArr2[2];
        long j8 = (j5 * j5) + (j3 * j7);
        long j9 = jArr2[3];
        long j10 = (j5 * j7) + (j3 * j9);
        long j11 = jArr2[4];
        long j12 = (j7 * j7) + (j5 * 4 * j9) + ((j3 + j3) * j11);
        long j13 = jArr2[5];
        long j14 = (j7 * j9) + (j5 * j11) + (j3 * j13);
        long j15 = jArr2[6];
        long j16 = (j9 * j9) + (j7 * j11) + (j3 * j15) + ((j5 + j5) * j13);
        long j17 = jArr2[7];
        long j18 = (j9 * j11) + (j7 * j13) + (j5 * j15) + (j3 * j17);
        long j19 = jArr2[8];
        long j20 = (j5 * j17) + (j9 * j13);
        long j21 = (j7 * j15) + (j3 * j19) + j20 + j20;
        long j22 = (j11 * j11) + j21 + j21;
        long j23 = jArr2[9];
        long j24 = (j11 * j13) + (j9 * j15) + (j7 * j17) + (j5 * j19) + (j3 * j23);
        long j25 = (j9 * j17) + (j5 * j23);
        long j26 = (j13 * j13) + (j11 * j15) + (j7 * j19) + j25 + j25;
        long j27 = (j13 * j15) + (j11 * j17) + (j9 * j19) + (j7 * j23);
        long j28 = (j13 * j17) + (j9 * j23);
        long j29 = (j11 * j19) + j28 + j28;
        long j30 = (j15 * j17) + (j13 * j19) + (j11 * j23);
        long j31 = (j17 * j17) + (j15 * j19) + ((j13 + j13) * j23);
        long j32 = (j17 * j19) + (j15 * j23);
        zzc(new long[]{j4, j6, j8 + j8, j10 + j10, j12, j14 + j14, j16 + j16, j18 + j18, j22, j24 + j24, j26 + j26, j27 + j27, (j15 * j15) + j29 + j29, j30 + j30, j31 + j31, j32 + j32, (j19 * j19) + (j17 * 4 * j23), (j19 + j19) * j23, (j23 + j23) * j23}, jArr);
    }

    static long[] zzg(byte[] bArr) {
        long[] jArr = new long[10];
        for (int i3 = 0; i3 < 10; i3++) {
            int i4 = zzb[i3];
            int i5 = bArr[i4] & 255;
            int i6 = bArr[i4 + 1] & 255;
            long j3 = ((long) i5) | (((long) i6) << 8);
            jArr[i3] = (((j3 | (((long) (bArr[i4 + 2] & 255)) << 16)) | (((long) (bArr[i4 + 3] & 255)) << 24)) >> zzc[i3]) & ((long) zzd[i3 & 1]);
        }
        return jArr;
    }

    public static byte[] zzh(long[] jArr) {
        int i3;
        long[] jArrCopyOf = Arrays.copyOf(jArr, 10);
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i5 >= 2) {
                break;
            }
            int i6 = 0;
            while (i6 < 9) {
                long j3 = jArrCopyOf[i6];
                int i7 = zze[i6 & 1];
                int i8 = -((int) (((j3 >> 31) & j3) >> i7));
                jArrCopyOf[i6] = j3 + ((long) (i8 << i7));
                i6++;
                jArrCopyOf[i6] = jArrCopyOf[i6] - ((long) i8);
            }
            long j4 = jArrCopyOf[9];
            int i9 = -((int) (((j4 >> 31) & j4) >> 25));
            jArrCopyOf[9] = j4 + ((long) (i9 << 25));
            jArrCopyOf[0] = jArrCopyOf[0] - (((long) i9) * 19);
            i5++;
        }
        long j5 = jArrCopyOf[0];
        int i10 = -((int) (((j5 >> 31) & j5) >> 26));
        jArrCopyOf[0] = j5 + ((long) (i10 << 26));
        jArrCopyOf[1] = jArrCopyOf[1] - ((long) i10);
        int i11 = 0;
        while (i11 < 2) {
            int i12 = i4;
            while (i12 < 9) {
                long j6 = jArrCopyOf[i12];
                int i13 = i12 & 1;
                int i14 = i4;
                long j7 = j6 >> zze[i13];
                jArrCopyOf[i12] = j6 & ((long) zzd[i13]);
                i12++;
                jArrCopyOf[i12] = jArrCopyOf[i12] + ((long) ((int) j7));
                i4 = i14;
                i11 = i11;
            }
            i11++;
        }
        int i15 = i4;
        long j8 = jArrCopyOf[9];
        jArrCopyOf[9] = j8 & 33554431;
        jArrCopyOf[i15] = jArrCopyOf[i15] + (((long) ((int) (j8 >> 25))) * 19);
        int i16 = ~((((int) r2) - 67108845) >> 31);
        for (int i17 = 1; i17 < 10; i17++) {
            int i18 = ~(((int) jArrCopyOf[i17]) ^ zzd[i17 & 1]);
            int i19 = i18 & (i18 << 16);
            int i20 = i19 & (i19 << 8);
            int i21 = i20 & (i20 << 4);
            int i22 = i21 & (i21 << 2);
            i16 &= (i22 & (i22 + i22)) >> 31;
        }
        jArrCopyOf[i15] = jArrCopyOf[i15] - ((long) (67108845 & i16));
        long j9 = 33554431 & i16;
        jArrCopyOf[1] = jArrCopyOf[1] - j9;
        for (i3 = 2; i3 < 10; i3 += 2) {
            jArrCopyOf[i3] = jArrCopyOf[i3] - ((long) (67108863 & i16));
            int i23 = i3 + 1;
            jArrCopyOf[i23] = jArrCopyOf[i23] - j9;
        }
        for (int i24 = i15; i24 < 10; i24++) {
            jArrCopyOf[i24] = jArrCopyOf[i24] << zzc[i24];
        }
        byte[] bArr = new byte[32];
        for (int i25 = i15; i25 < 10; i25++) {
            int i26 = zzb[i25];
            long j10 = bArr[i26];
            long j11 = jArrCopyOf[i25];
            bArr[i26] = (byte) (j10 | (j11 & 255));
            bArr[i26 + 1] = (byte) (((long) bArr[r5]) | ((j11 >> 8) & 255));
            bArr[i26 + 2] = (byte) (((long) bArr[r5]) | ((j11 >> 16) & 255));
            bArr[i26 + 3] = (byte) (((long) bArr[r4]) | ((j11 >> 24) & 255));
        }
        return bArr;
    }
}
