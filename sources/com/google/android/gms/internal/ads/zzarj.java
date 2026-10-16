package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzarj {
    public static int zza(byte[] bArr, int i3, int i4) {
        while (i3 < i4 && bArr[i3] != 71) {
            i3++;
        }
        return i3;
    }

    public static long zzb(zzet zzetVar, int i3, int i4) {
        zzetVar.zzh(i3);
        if (zzetVar.zzd() < 5) {
            return -9223372036854775807L;
        }
        int iZzB = zzetVar.zzB();
        if ((8388608 & iZzB) != 0 || ((iZzB >> 8) & 8191) != i4 || (iZzB & 32) == 0 || zzetVar.zzs() < 7 || zzetVar.zzd() < 7 || (zzetVar.zzs() & 16) != 16) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[6];
        zzetVar.zzm(bArr, 0, 6);
        long j3 = bArr[0];
        long j4 = bArr[1];
        long j5 = bArr[2];
        long j6 = bArr[3] & 255;
        return ((j3 & 255) << 25) | ((j4 & 255) << 17) | ((j5 & 255) << 9) | (j6 + j6) | ((((long) bArr[4]) & 255) >> 7);
    }
}
