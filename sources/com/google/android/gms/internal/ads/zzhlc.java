package com.google.android.gms.internal.ads;

import com.applovin.exoplayer2.common.base.Ascii;
import com.sun.jna.Function;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhlc {
    private static final zzhkx zzb = new zzhkx(new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    private static final zzhkz zzc = new zzhkz(new zzhla(new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}), new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    static final byte[] zza = {-19, -45, -11, 92, Ascii.SUB, 99, Ascii.DC2, 88, -42, -100, -9, -94, -34, -7, -34, Ascii.DC4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, Ascii.DLE};

    public static byte[] zza(byte[] bArr) {
        int i3;
        byte[] bArr2 = new byte[64];
        int i4 = 0;
        while (true) {
            if (i4 >= 32) {
                break;
            }
            int i5 = i4 + i4;
            bArr2[i5] = (byte) (bArr[i4] & Ascii.SI);
            bArr2[i5 + 1] = (byte) ((bArr[i4] & 255) >> 4);
            i4++;
        }
        int i6 = 0;
        int i7 = 0;
        while (i6 < 63) {
            byte b3 = (byte) (bArr2[i6] + i7);
            bArr2[i6] = b3;
            int i8 = (b3 + 8) >> 4;
            bArr2[i6] = (byte) (b3 - (i8 << 4));
            i6++;
            i7 = i8;
        }
        bArr2[63] = (byte) (bArr2[63] + i7);
        zzhkz zzhkzVar = new zzhkz(zzc);
        zzhlb zzhlbVar = new zzhlb();
        for (i3 = 1; i3 < 64; i3 += 2) {
            zzhkx zzhkxVar = new zzhkx(zzb);
            zzk(zzhkxVar, i3 / 2, bArr2[i3]);
            zzhlb.zza(zzhlbVar, zzhkzVar);
            zzg(zzhkzVar, zzhlbVar, zzhkxVar);
        }
        zzhla zzhlaVar = new zzhla();
        zzhla.zza(zzhlaVar, zzhkzVar);
        zzi(zzhkzVar, zzhlaVar);
        zzhla.zza(zzhlaVar, zzhkzVar);
        zzi(zzhkzVar, zzhlaVar);
        zzhla.zza(zzhlaVar, zzhkzVar);
        zzi(zzhkzVar, zzhlaVar);
        zzhla.zza(zzhlaVar, zzhkzVar);
        zzi(zzhkzVar, zzhlaVar);
        for (int i9 = 0; i9 < 64; i9 += 2) {
            zzhkx zzhkxVar2 = new zzhkx(zzb);
            zzk(zzhkxVar2, i9 / 2, bArr2[i9]);
            zzhlb.zza(zzhlbVar, zzhkzVar);
            zzg(zzhkzVar, zzhlbVar, zzhkxVar2);
        }
        zzhla zzhlaVar2 = new zzhla(zzhkzVar);
        long[] jArr = new long[10];
        zzhlj.zzf(jArr, zzhlaVar2.zza);
        long[] jArr2 = new long[10];
        zzhlj.zzf(jArr2, zzhlaVar2.zzb);
        long[] jArr3 = new long[10];
        zzhlj.zzf(jArr3, zzhlaVar2.zzc);
        long[] jArr4 = new long[10];
        zzhlj.zzf(jArr4, jArr3);
        long[] jArr5 = new long[10];
        zzhlj.zzb(jArr5, jArr2, jArr);
        zzhlj.zze(jArr5, jArr5, jArr3);
        long[] jArr6 = new long[10];
        zzhlj.zze(jArr6, jArr, jArr2);
        zzhlj.zze(jArr6, jArr6, zzhle.zza);
        zzhlj.zza(jArr6, jArr6, jArr4);
        zzhlj.zzc(jArr6, jArr6);
        if (MessageDigest.isEqual(zzhlj.zzh(jArr5), zzhlj.zzh(jArr6))) {
            return zzhlaVar2.zzb();
        }
        throw new IllegalStateException("arithmetic error in scalar multiplication");
    }

    public static byte[] zzb(byte[] bArr) throws GeneralSecurityException {
        MessageDigest messageDigest = (MessageDigest) zzhzz.zzd.zzb("SHA-512");
        messageDigest.update(bArr, 0, 32);
        byte[] bArrDigest = messageDigest.digest();
        bArrDigest[0] = (byte) (bArrDigest[0] & 248);
        int i3 = bArrDigest[31] & Ascii.DEL;
        bArrDigest[31] = (byte) i3;
        bArrDigest[31] = (byte) (i3 | 64);
        return bArrDigest;
    }

    public static boolean zzc(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        byte b3;
        byte[] bArr4 = bArr2;
        byte[] bArr5 = bArr3;
        if (bArr4.length != 64) {
            return false;
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr4, 32, 64);
        int i3 = 31;
        while (true) {
            if (i3 < 0) {
                break;
            }
            int i4 = bArrCopyOfRange[i3] & 255;
            int i5 = zza[i3] & 255;
            if (i4 == i5) {
                i3--;
                bArr4 = bArr2;
                bArr5 = bArr3;
            } else if (i4 < i5) {
                MessageDigest messageDigest = (MessageDigest) zzhzz.zzd.zzb("SHA-512");
                messageDigest.update(bArr4, 0, 32);
                messageDigest.update(bArr5);
                messageDigest.update(bArr);
                byte[] bArrDigest = messageDigest.digest();
                long jZzn = zzn(bArrDigest, 0) & 2097151;
                long jZzo = zzo(bArrDigest, 2) >> 5;
                long jZzn2 = zzn(bArrDigest, 5) >> 2;
                long jZzo2 = zzo(bArrDigest, 7) >> 7;
                long jZzo3 = zzo(bArrDigest, 10) >> 4;
                long jZzn3 = zzn(bArrDigest, 13) >> 1;
                long jZzo4 = zzo(bArrDigest, 15) >> 6;
                long jZzn4 = zzn(bArrDigest, 18) >> 3;
                long jZzn5 = zzn(bArrDigest, 21) & 2097151;
                long jZzo5 = zzo(bArrDigest, 23) >> 5;
                long jZzn6 = zzn(bArrDigest, 26) >> 2;
                long jZzo6 = zzo(bArrDigest, 28) >> 7;
                long jZzo7 = zzo(bArrDigest, 31) >> 4;
                long jZzn7 = zzn(bArrDigest, 34) >> 1;
                long jZzo8 = zzo(bArrDigest, 36) >> 6;
                long jZzn8 = zzn(bArrDigest, 39) >> 3;
                long jZzn9 = zzn(bArrDigest, 42) & 2097151;
                long jZzo9 = zzo(bArrDigest, 44) >> 5;
                long jZzn10 = (zzn(bArrDigest, 47) >> 2) & 2097151;
                long jZzo10 = (zzo(bArrDigest, 49) >> 7) & 2097151;
                long jZzo11 = (zzo(bArrDigest, 52) >> 4) & 2097151;
                long jZzn11 = (zzn(bArrDigest, 55) >> 1) & 2097151;
                long jZzo12 = (zzo(bArrDigest, 57) >> 6) & 2097151;
                long jZzo13 = zzo(bArrDigest, 60) >> 3;
                long j3 = (jZzo4 & 2097151) + (jZzn10 * 666643);
                long j4 = (j3 + 1048576) >> 21;
                long j5 = j4 << 21;
                long j6 = jZzn5 + (jZzo11 * 666643) + (jZzo10 * 470296) + (jZzn10 * 654183);
                long j7 = (j6 + 1048576) >> 21;
                long j8 = j7 << 21;
                long j9 = (((((jZzn6 & 2097151) + (jZzo12 * 666643)) + (jZzn11 * 470296)) + (jZzo11 * 654183)) - (jZzo10 * 997805)) + (jZzn10 * 136657);
                long j10 = (j9 + 1048576) >> 21;
                long j11 = j10 << 21;
                long j12 = (((((jZzo7 & 2097151) + (jZzo13 * 470296)) + (jZzo12 * 654183)) - (jZzn11 * 997805)) + (jZzo11 * 136657)) - (jZzo10 * 683901);
                long j13 = (j12 + 1048576) >> 21;
                long j14 = (((jZzo8 & 2097151) - (jZzo13 * 997805)) + (jZzo12 * 136657)) - (jZzn11 * 683901);
                long j15 = (j14 + 1048576) >> 21;
                long j16 = jZzn9 - (jZzo13 * 683901);
                long j17 = (j16 + 1048576) >> 21;
                long j18 = jZzn4 + (jZzo10 * 666643) + (jZzn10 * 470296) + j4;
                long j19 = (j18 + 1048576) >> 21;
                long j20 = j19 << 21;
                long j21 = (((((jZzo5 & 2097151) + (jZzn11 * 666643)) + (jZzo11 * 470296)) + (jZzo10 * 654183)) - (jZzn10 * 997805)) + j7;
                long j22 = (j21 + 1048576) >> 21;
                long j23 = j22 << 21;
                long j24 = (((((((jZzo6 & 2097151) + (jZzo13 * 666643)) + (jZzo12 * 470296)) + (jZzn11 * 654183)) - (jZzo11 * 997805)) + (jZzo10 * 136657)) - (jZzn10 * 683901)) + j10;
                long j25 = (j24 + 1048576) >> 21;
                long j26 = j25 << 21;
                long j27 = (((((jZzn7 & 2097151) + (jZzo13 * 654183)) - (jZzo12 * 997805)) + (jZzn11 * 136657)) - (jZzo11 * 683901)) + j13;
                long j28 = (j27 + 1048576) >> 21;
                long j29 = ((jZzn8 + (jZzo13 * 136657)) - (jZzo12 * 683901)) + j15;
                long j30 = (j29 + 1048576) >> 21;
                long j31 = (j12 - (j13 << 21)) + j25;
                long j32 = jZzn + (j31 * 666643);
                long j33 = (j32 + 1048576) >> 21;
                long j34 = j33 << 21;
                long j35 = (j14 - (j15 << 21)) + j28;
                long j36 = j27 - (j28 << 21);
                long j37 = (jZzn2 & 2097151) + (j35 * 666643) + (j36 * 470296) + (j31 * 654183);
                long j38 = (j37 + 1048576) >> 21;
                long j39 = j38 << 21;
                long j40 = (j16 - (j17 << 21)) + j30;
                long j41 = j29 - (j30 << 21);
                long j42 = (((((jZzo3 & 2097151) + (j40 * 666643)) + (j41 * 470296)) + (j35 * 654183)) - (j36 * 997805)) + (j31 * 136657);
                long j43 = (j42 + 1048576) >> 21;
                long j44 = j43 << 21;
                long j45 = (jZzo9 & 2097151) + j17;
                long j46 = (((((j3 - j5) + (j45 * 470296)) + (j40 * 654183)) - (j41 * 997805)) + (j35 * 136657)) - (j36 * 683901);
                long j47 = (j46 + 1048576) >> 21;
                long j48 = j47 << 21;
                long j49 = ((((j6 - j8) + j19) - (j45 * 997805)) + (j40 * 136657)) - (j41 * 683901);
                long j50 = (j49 + 1048576) >> 21;
                long j51 = j50 << 21;
                long j52 = ((j9 - j11) + j22) - (j45 * 683901);
                long j53 = (j52 + 1048576) >> 21;
                long j54 = (jZzo & 2097151) + (j36 * 666643) + (j31 * 470296) + j33;
                long j55 = (j54 + 1048576) >> 21;
                long j56 = (((((jZzo2 & 2097151) + (j41 * 666643)) + (j35 * 470296)) + (j36 * 654183)) - (j31 * 997805)) + j38;
                long j57 = (j56 + 1048576) >> 21;
                long j58 = (((((((jZzn3 & 2097151) + (j45 * 666643)) + (j40 * 470296)) + (j41 * 654183)) - (j35 * 997805)) + (j36 * 136657)) - (j31 * 683901)) + j43;
                long j59 = (j58 + 1048576) >> 21;
                long j60 = (((((j18 - j20) + (j45 * 654183)) - (j40 * 997805)) + (j41 * 136657)) - (j35 * 683901)) + j47;
                long j61 = (j60 + 1048576) >> 21;
                long j62 = (((j21 - j23) + (j45 * 136657)) - (j40 * 683901)) + j50;
                long j63 = (j62 + 1048576) >> 21;
                long j64 = (j24 - j26) + j53;
                long j65 = (j64 + 1048576) >> 21;
                long j66 = j65 << 21;
                long j67 = (j32 - j34) + (j65 * 666643);
                long j68 = j67 >> 21;
                long j69 = j68 << 21;
                long j70 = (j54 - (j55 << 21)) + (j65 * 470296) + j68;
                long j71 = j70 >> 21;
                long j72 = j71 << 21;
                long j73 = (j37 - j39) + j55 + (j65 * 654183) + j71;
                long j74 = j73 >> 21;
                long j75 = j74 << 21;
                long j76 = ((j56 - (j57 << 21)) - (j65 * 997805)) + j74;
                long j77 = j76 >> 21;
                long j78 = j77 << 21;
                long j79 = (j42 - j44) + j57 + (j65 * 136657) + j77;
                long j80 = j79 >> 21;
                long j81 = j80 << 21;
                long j82 = ((j58 - (j59 << 21)) - (j65 * 683901)) + j80;
                long j83 = j82 >> 21;
                long j84 = j83 << 21;
                long j85 = (j46 - j48) + j59 + j83;
                long j86 = j85 >> 21;
                long j87 = j86 << 21;
                long j88 = (j60 - (j61 << 21)) + j86;
                long j89 = j88 >> 21;
                long j90 = j89 << 21;
                long j91 = (j49 - j51) + j61 + j89;
                long j92 = j91 >> 21;
                long j93 = j92 << 21;
                long j94 = (j62 - (j63 << 21)) + j92;
                long j95 = j94 >> 21;
                long j96 = j95 << 21;
                long j97 = (j52 - (j53 << 21)) + j63 + j95;
                long j98 = j97 >> 21;
                long j99 = j98 << 21;
                long j100 = (j64 - j66) + j98;
                long j101 = j100 >> 21;
                long j102 = j101 << 21;
                long j103 = (j67 - j69) + (666643 * j101);
                long j104 = j103 >> 21;
                long j105 = j104 << 21;
                long j106 = (j70 - j72) + (470296 * j101) + j104;
                long j107 = j106 >> 21;
                long j108 = j107 << 21;
                long j109 = (j73 - j75) + (654183 * j101) + j107;
                long j110 = j109 >> 21;
                long j111 = j110 << 21;
                long j112 = ((j76 - j78) - (997805 * j101)) + j110;
                long j113 = j112 >> 21;
                long j114 = j113 << 21;
                long j115 = (j79 - j81) + (136657 * j101) + j113;
                long j116 = j115 >> 21;
                long j117 = ((j82 - j84) - (j101 * 683901)) + j116;
                long j118 = j117 >> 21;
                long j119 = j118 << 21;
                long j120 = (j85 - j87) + j118;
                long j121 = j120 >> 21;
                long j122 = j121 << 21;
                long j123 = (j88 - j90) + j121;
                long j124 = j123 >> 21;
                long j125 = j124 << 21;
                long j126 = (j91 - j93) + j124;
                long j127 = j126 >> 21;
                long j128 = j127 << 21;
                long j129 = (j94 - j96) + j127;
                long j130 = j129 >> 21;
                long j131 = j130 << 21;
                long j132 = (j97 - j99) + j130;
                long j133 = j132 >> 21;
                bArrDigest[0] = (byte) (j103 - j105);
                long j134 = j123 - j125;
                long j135 = j120 - j122;
                long j136 = j117 - j119;
                long j137 = j115 - (j116 << 21);
                long j138 = j112 - j114;
                long j139 = j109 - j111;
                long j140 = j106 - j108;
                bArrDigest[1] = (byte) (r8 >> 8);
                bArrDigest[2] = (byte) ((r8 >> 16) | (j140 << 5));
                bArrDigest[3] = (byte) (j140 >> 3);
                bArrDigest[4] = (byte) (j140 >> 11);
                bArrDigest[5] = (byte) ((j140 >> 19) | (j139 << 2));
                bArrDigest[6] = (byte) (j139 >> 6);
                bArrDigest[7] = (byte) ((j139 >> 14) | (j138 << 7));
                bArrDigest[8] = (byte) (j138 >> 1);
                bArrDigest[9] = (byte) (j138 >> 9);
                bArrDigest[10] = (byte) ((j138 >> 17) | (j137 << 4));
                bArrDigest[11] = (byte) (j137 >> 4);
                bArrDigest[12] = (byte) (j137 >> 12);
                bArrDigest[13] = (byte) ((j137 >> 20) | (j136 + j136));
                bArrDigest[14] = (byte) (j136 >> 7);
                bArrDigest[15] = (byte) ((j136 >> 15) | (j135 << 6));
                bArrDigest[16] = (byte) (j135 >> 2);
                bArrDigest[17] = (byte) (j135 >> 10);
                bArrDigest[18] = (byte) ((j135 >> 18) | (j134 << 3));
                long j141 = j132 - (j133 << 21);
                long j142 = (j100 - j102) + j133;
                long j143 = j129 - j131;
                bArrDigest[19] = (byte) (j134 >> 5);
                bArrDigest[20] = (byte) (j134 >> 13);
                bArrDigest[21] = (byte) (j126 - j128);
                bArrDigest[22] = (byte) (r6 >> 8);
                bArrDigest[23] = (byte) ((r6 >> 16) | (j143 << 5));
                bArrDigest[24] = (byte) (j143 >> 3);
                bArrDigest[25] = (byte) (j143 >> 11);
                bArrDigest[26] = (byte) ((j143 >> 19) | (j141 << 2));
                bArrDigest[27] = (byte) (j141 >> 6);
                bArrDigest[28] = (byte) ((j141 >> 14) | (j142 << 7));
                bArrDigest[29] = (byte) (j142 >> 1);
                bArrDigest[30] = (byte) (j142 >> 9);
                bArrDigest[31] = (byte) (j142 >> 17);
                long[] jArr = new long[10];
                long[] jArrZzg = zzhlj.zzg(bArr5);
                long[] jArr2 = new long[10];
                jArr2[0] = 1;
                long[] jArr3 = new long[10];
                long[] jArr4 = new long[10];
                long[] jArr5 = new long[10];
                long[] jArr6 = new long[10];
                long[] jArr7 = new long[10];
                zzhlj.zzf(jArr4, jArrZzg);
                zzhlj.zze(jArr5, jArr4, zzhle.zza);
                zzhlj.zzb(jArr4, jArr4, jArr2);
                zzhlj.zza(jArr5, jArr5, jArr2);
                long[] jArr8 = new long[10];
                zzhlj.zzf(jArr8, jArr5);
                zzhlj.zze(jArr8, jArr8, jArr5);
                zzhlj.zzf(jArr, jArr8);
                zzhlj.zze(jArr, jArr, jArr5);
                zzhlj.zze(jArr, jArr, jArr4);
                long[] jArr9 = new long[10];
                long[] jArr10 = new long[10];
                long[] jArr11 = new long[10];
                zzhlj.zzf(jArr9, jArr);
                zzhlj.zzf(jArr10, jArr9);
                zzhlj.zzf(jArr10, jArr10);
                zzhlj.zze(jArr10, jArr, jArr10);
                zzhlj.zze(jArr9, jArr9, jArr10);
                zzhlj.zzf(jArr9, jArr9);
                zzhlj.zze(jArr9, jArr10, jArr9);
                zzhlj.zzf(jArr10, jArr9);
                for (int i6 = 1; i6 < 5; i6++) {
                    zzhlj.zzf(jArr10, jArr10);
                }
                zzhlj.zze(jArr9, jArr10, jArr9);
                zzhlj.zzf(jArr10, jArr9);
                for (int i7 = 1; i7 < 10; i7++) {
                    zzhlj.zzf(jArr10, jArr10);
                }
                zzhlj.zze(jArr10, jArr10, jArr9);
                zzhlj.zzf(jArr11, jArr10);
                for (int i8 = 1; i8 < 20; i8++) {
                    zzhlj.zzf(jArr11, jArr11);
                }
                zzhlj.zze(jArr10, jArr11, jArr10);
                zzhlj.zzf(jArr10, jArr10);
                for (int i9 = 1; i9 < 10; i9++) {
                    zzhlj.zzf(jArr10, jArr10);
                }
                zzhlj.zze(jArr9, jArr10, jArr9);
                zzhlj.zzf(jArr10, jArr9);
                for (int i10 = 1; i10 < 50; i10++) {
                    zzhlj.zzf(jArr10, jArr10);
                }
                zzhlj.zze(jArr10, jArr10, jArr9);
                zzhlj.zzf(jArr11, jArr10);
                for (int i11 = 1; i11 < 100; i11++) {
                    zzhlj.zzf(jArr11, jArr11);
                }
                zzhlj.zze(jArr10, jArr11, jArr10);
                zzhlj.zzf(jArr10, jArr10);
                for (int i12 = 1; i12 < 50; i12++) {
                    zzhlj.zzf(jArr10, jArr10);
                }
                zzhlj.zze(jArr9, jArr10, jArr9);
                zzhlj.zzf(jArr9, jArr9);
                zzhlj.zzf(jArr9, jArr9);
                zzhlj.zze(jArr, jArr9, jArr);
                zzhlj.zze(jArr, jArr, jArr8);
                zzhlj.zze(jArr, jArr, jArr4);
                zzhlj.zzf(jArr6, jArr);
                zzhlj.zze(jArr6, jArr6, jArr5);
                zzhlj.zzb(jArr7, jArr6, jArr4);
                if (zze(jArr7)) {
                    zzhlj.zza(jArr7, jArr6, jArr4);
                    if (zze(jArr7)) {
                        throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. No square root exists for modulo 2^255-19");
                    }
                    zzhlj.zze(jArr, jArr, zzhle.zzc);
                }
                if (zze(jArr)) {
                    b3 = 255;
                } else {
                    b3 = 255;
                    if (((bArr3[31] & 255) >> 7) != 0) {
                        throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. Computed x is zero and encoded x's least significant bit is not zero");
                    }
                }
                if (zzf(jArr) == ((bArr3[31] & b3) >> 7)) {
                    zzm(jArr, jArr);
                }
                zzhlj.zze(jArr3, jArr, jArrZzg);
                zzhlb zzhlbVar = new zzhlb(new zzhla(jArr, jArrZzg, jArr2), jArr3);
                zzhky[] zzhkyVarArr = new zzhky[8];
                zzhkyVarArr[0] = new zzhky(zzhlbVar);
                zzhkz zzhkzVar = new zzhkz(new zzhla(), new long[10]);
                zzi(zzhkzVar, zzhlbVar.zza);
                zzhlb zzhlbVar2 = new zzhlb(zzhkzVar);
                for (int i13 = 1; i13 < 8; i13++) {
                    zzg(zzhkzVar, zzhlbVar2, zzhkyVarArr[i13 - 1]);
                    zzhkyVarArr[i13] = new zzhky(new zzhlb(zzhkzVar));
                }
                byte[] bArrZzl = zzl(bArrDigest);
                byte[] bArrZzl2 = zzl(bArrCopyOfRange);
                zzhkz zzhkzVar2 = new zzhkz(zzc);
                zzhlb zzhlbVar3 = new zzhlb();
                int i14 = b3;
                while (i14 >= 0 && bArrZzl[i14] == 0 && bArrZzl2[i14] == 0) {
                    i14--;
                }
                while (i14 >= 0) {
                    zzi(zzhkzVar2, new zzhla(zzhkzVar2));
                    byte b4 = bArrZzl[i14];
                    if (b4 > 0) {
                        zzhlb.zza(zzhlbVar3, zzhkzVar2);
                        zzg(zzhkzVar2, zzhlbVar3, zzhkyVarArr[bArrZzl[i14] / 2]);
                    } else if (b4 < 0) {
                        zzhlb.zza(zzhlbVar3, zzhkzVar2);
                        zzh(zzhkzVar2, zzhlbVar3, zzhkyVarArr[(-bArrZzl[i14]) / 2]);
                    }
                    byte b5 = bArrZzl2[i14];
                    if (b5 > 0) {
                        zzhlb.zza(zzhlbVar3, zzhkzVar2);
                        zzg(zzhkzVar2, zzhlbVar3, zzhle.zze[bArrZzl2[i14] / 2]);
                    } else if (b5 < 0) {
                        zzhlb.zza(zzhlbVar3, zzhkzVar2);
                        zzh(zzhkzVar2, zzhlbVar3, zzhle.zze[(-bArrZzl2[i14]) / 2]);
                    }
                    i14--;
                }
                byte[] bArrZzb = new zzhla(zzhkzVar2).zzb();
                for (int i15 = 0; i15 < 32; i15++) {
                    if (bArrZzb[i15] != bArr2[i15]) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static void zzd() {
        if (zzhle.zza == null) {
            throw new IllegalStateException("Could not initialize Ed25519.");
        }
    }

    static /* synthetic */ boolean zze(long[] jArr) {
        long[] jArr2 = new long[11];
        System.arraycopy(jArr, 0, jArr2, 0, 10);
        zzhlj.zzd(jArr2);
        byte[] bArrZzh = zzhlj.zzh(jArr2);
        for (int i3 = 0; i3 < 32; i3++) {
            if (bArrZzh[i3] != 0) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ int zzf(long[] jArr) {
        return zzhlj.zzh(jArr)[0] & 1;
    }

    private static void zzg(zzhkz zzhkzVar, zzhlb zzhlbVar, zzhkx zzhkxVar) {
        zzhla zzhlaVar = zzhlbVar.zza;
        zzhla zzhlaVar2 = zzhkzVar.zza;
        long[] jArr = new long[10];
        long[] jArr2 = zzhlaVar2.zza;
        long[] jArr3 = zzhlaVar.zzb;
        long[] jArr4 = zzhlaVar.zza;
        zzhlj.zza(jArr2, jArr3, jArr4);
        long[] jArr5 = zzhlaVar2.zzb;
        zzhlj.zzb(jArr5, jArr3, jArr4);
        zzhlj.zze(jArr5, jArr5, zzhkxVar.zzb);
        long[] jArr6 = zzhkxVar.zza;
        long[] jArr7 = zzhlaVar2.zzc;
        zzhlj.zze(jArr7, jArr2, jArr6);
        long[] jArr8 = zzhkzVar.zzb;
        zzhlj.zze(jArr8, zzhlbVar.zzb, zzhkxVar.zzc);
        zzhkxVar.zza(jArr2, zzhlaVar.zzc);
        zzhlj.zza(jArr, jArr2, jArr2);
        zzhlj.zzb(jArr2, jArr7, jArr5);
        zzhlj.zza(jArr5, jArr7, jArr5);
        zzhlj.zza(jArr7, jArr, jArr8);
        zzhlj.zzb(jArr8, jArr, jArr8);
    }

    private static void zzh(zzhkz zzhkzVar, zzhlb zzhlbVar, zzhkx zzhkxVar) {
        zzhla zzhlaVar = zzhlbVar.zza;
        zzhla zzhlaVar2 = zzhkzVar.zza;
        long[] jArr = new long[10];
        long[] jArr2 = zzhlaVar2.zza;
        long[] jArr3 = zzhlaVar.zzb;
        long[] jArr4 = zzhlaVar.zza;
        zzhlj.zza(jArr2, jArr3, jArr4);
        long[] jArr5 = zzhlaVar2.zzb;
        zzhlj.zzb(jArr5, jArr3, jArr4);
        zzhlj.zze(jArr5, jArr5, zzhkxVar.zza);
        long[] jArr6 = zzhkxVar.zzb;
        long[] jArr7 = zzhlaVar2.zzc;
        zzhlj.zze(jArr7, jArr2, jArr6);
        long[] jArr8 = zzhkzVar.zzb;
        zzhlj.zze(jArr8, zzhlbVar.zzb, zzhkxVar.zzc);
        zzhkxVar.zza(jArr2, zzhlaVar.zzc);
        zzhlj.zza(jArr, jArr2, jArr2);
        zzhlj.zzb(jArr2, jArr7, jArr5);
        zzhlj.zza(jArr5, jArr7, jArr5);
        zzhlj.zzb(jArr7, jArr, jArr8);
        zzhlj.zza(jArr8, jArr, jArr8);
    }

    private static void zzi(zzhkz zzhkzVar, zzhla zzhlaVar) {
        zzhla zzhlaVar2 = zzhkzVar.zza;
        long[] jArr = zzhlaVar2.zza;
        long[] jArr2 = zzhlaVar.zza;
        long[] jArr3 = new long[10];
        zzhlj.zzf(jArr, jArr2);
        long[] jArr4 = zzhlaVar2.zzc;
        long[] jArr5 = zzhlaVar.zzb;
        zzhlj.zzf(jArr4, jArr5);
        long[] jArr6 = zzhkzVar.zzb;
        zzhlj.zzf(jArr6, zzhlaVar.zzc);
        zzhlj.zza(jArr6, jArr6, jArr6);
        long[] jArr7 = zzhlaVar2.zzb;
        zzhlj.zza(jArr7, jArr2, jArr5);
        zzhlj.zzf(jArr3, jArr7);
        zzhlj.zza(jArr7, jArr4, jArr);
        zzhlj.zzb(jArr4, jArr4, jArr);
        zzhlj.zzb(jArr, jArr3, jArr7);
        zzhlj.zzb(jArr6, jArr6, jArr4);
    }

    private static int zzj(int i3, int i4) {
        int i5 = (~(i3 ^ i4)) & 255;
        int i6 = i5 & (i5 << 4);
        int i7 = i6 & (i6 << 2);
        return (i7 & (i7 + i7)) >> 7;
    }

    private static void zzk(zzhkx zzhkxVar, int i3, byte b3) {
        zzhkx[][] zzhkxVarArr = zzhle.zzd;
        int i4 = (b3 & 255) >> 7;
        int i5 = (-i4) & b3;
        int i6 = b3 - (i5 + i5);
        zzhkxVar.zzb(zzhkxVarArr[i3][0], zzj(i6, 1));
        zzhkxVar.zzb(zzhkxVarArr[i3][1], zzj(i6, 2));
        zzhkxVar.zzb(zzhkxVarArr[i3][2], zzj(i6, 3));
        zzhkxVar.zzb(zzhkxVarArr[i3][3], zzj(i6, 4));
        zzhkxVar.zzb(zzhkxVarArr[i3][4], zzj(i6, 5));
        zzhkxVar.zzb(zzhkxVarArr[i3][5], zzj(i6, 6));
        zzhkxVar.zzb(zzhkxVarArr[i3][6], zzj(i6, 7));
        zzhkxVar.zzb(zzhkxVarArr[i3][7], zzj(i6, 8));
        long[] jArr = zzhkxVar.zzc;
        long[] jArr2 = zzhkxVar.zza;
        long[] jArrCopyOf = Arrays.copyOf(zzhkxVar.zzb, 10);
        long[] jArrCopyOf2 = Arrays.copyOf(jArr2, 10);
        long[] jArrCopyOf3 = Arrays.copyOf(jArr, 10);
        zzm(jArrCopyOf3, jArrCopyOf3);
        zzhkxVar.zzb(new zzhkx(jArrCopyOf, jArrCopyOf2, jArrCopyOf3), i4);
    }

    private static byte[] zzl(byte[] bArr) {
        int i3;
        byte[] bArr2 = new byte[Function.MAX_NARGS];
        for (int i4 = 0; i4 < 256; i4++) {
            bArr2[i4] = (byte) (1 & ((bArr[i4 >> 3] & 255) >> (i4 & 7)));
        }
        for (int i5 = 0; i5 < 256; i5++) {
            if (bArr2[i5] != 0) {
                for (int i6 = 1; i6 <= 6 && (i3 = i5 + i6) < 256; i6++) {
                    byte b3 = bArr2[i3];
                    if (b3 != 0) {
                        byte b4 = bArr2[i5];
                        int i7 = b3 << i6;
                        int i8 = b4 + i7;
                        if (i8 <= 15) {
                            bArr2[i5] = (byte) i8;
                            bArr2[i3] = 0;
                        } else {
                            int i9 = b4 - i7;
                            if (i9 >= -15) {
                                bArr2[i5] = (byte) i9;
                                while (true) {
                                    if (i3 >= 256) {
                                        break;
                                    }
                                    if (bArr2[i3] == 0) {
                                        bArr2[i3] = 1;
                                        break;
                                    }
                                    bArr2[i3] = 0;
                                    i3++;
                                }
                            }
                        }
                    }
                }
            }
        }
        return bArr2;
    }

    private static void zzm(long[] jArr, long[] jArr2) {
        for (int i3 = 0; i3 < jArr2.length; i3++) {
            jArr[i3] = -jArr2[i3];
        }
    }

    private static long zzn(byte[] bArr, int i3) {
        return (((long) (bArr[i3 + 2] & 255)) << 16) | (bArr[i3] & 255) | (((long) (bArr[i3 + 1] & 255)) << 8);
    }

    private static long zzo(byte[] bArr, int i3) {
        return (((long) (bArr[i3 + 3] & 255)) << 24) | zzn(bArr, i3);
    }
}
