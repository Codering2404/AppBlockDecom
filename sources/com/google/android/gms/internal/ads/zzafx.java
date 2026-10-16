package com.google.android.gms.internal.ads;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzafx {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] zzc = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    private static final int[] zzd = {64, 112, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, 192, 224, Function.MAX_NARGS, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};
    private static final int[] zze = {8000, 16000, 32000, 64000, 128000, 22050, 44100, 88200, 176400, 352800, 12000, 24000, 48000, 96000, 192000, 384000};
    private static final int[] zzf = {5, 8, 10, 12};
    private static final int[] zzg = {6, 9, 12, 15};
    private static final int[] zzh = {2, 4, 6, 8};
    private static final int[] zzi = {9, 11, 13, 16};
    private static final int[] zzj = {5, 8, 10, 12};

    public static int zza(int i3) {
        if (i3 == 2147385345 || i3 == -25230976 || i3 == 536864768 || i3 == -14745368) {
            return 1;
        }
        if (i3 == 1683496997 || i3 == 622876772) {
            return 2;
        }
        if (i3 == 1078008818 || i3 == -233094848) {
            return 3;
        }
        return (i3 == 1908687592 || i3 == -398277519) ? 4 : 0;
    }

    public static zzv zzb(byte[] bArr, String str, String str2, int i3, String str3, zzq zzqVar) {
        zzes zzesVarZzi = zzi(bArr);
        zzesVarZzi.zzh(60);
        int i4 = zzb[zzesVarZzi.zzj(6)];
        int i5 = zzc[zzesVarZzi.zzj(4)];
        int iZzj = zzesVarZzi.zzj(5);
        int i6 = iZzj >= 29 ? -1 : (zzd[iZzj] * 1000) / 2;
        zzesVarZzi.zzh(10);
        int i7 = i4 + (zzesVarZzi.zzj(2) > 0 ? 1 : 0);
        zzt zztVar = new zzt();
        zztVar.zza(str);
        zztVar.zzn("video/mp2t");
        zztVar.zzo("audio/vnd.dts");
        zztVar.zzi(i6);
        zztVar.zzG(i7);
        zztVar.zzH(i5);
        zztVar.zzs(null);
        zztVar.zze(str2);
        zztVar.zzg(i3);
        return zztVar.zzO();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int zzc(byte[] r7) {
        /*
            r0 = 0
            r1 = r7[r0]
            r2 = -2
            r3 = 7
            r4 = 6
            r5 = 1
            r6 = 4
            if (r1 == r2) goto L4e
            r2 = -1
            if (r1 == r2) goto L3e
            r2 = 31
            if (r1 == r2) goto L26
            r1 = 5
            r1 = r7[r1]
            r1 = r1 & 3
            int r1 = r1 << 12
            r2 = r7[r4]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r7 = r7[r3]
        L1f:
            r7 = r7 & 240(0xf0, float:3.36E-43)
            int r7 = r7 >> r6
            r1 = r1 | r2
            r7 = r7 | r1
            int r7 = r7 + r5
            goto L5c
        L26:
            r0 = r7[r4]
            r0 = r0 & 3
            int r0 = r0 << 12
            r1 = r7[r3]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r2 = 8
            r7 = r7[r2]
        L35:
            r7 = r7 & 60
            int r7 = r7 >> 2
            r0 = r0 | r1
            r7 = r7 | r0
            int r7 = r7 + r5
            r0 = r5
            goto L5c
        L3e:
            r0 = r7[r3]
            r0 = r0 & 3
            int r0 = r0 << 12
            r1 = r7[r4]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r2 = 9
            r7 = r7[r2]
            goto L35
        L4e:
            r1 = r7[r6]
            r1 = r1 & 3
            int r1 = r1 << 12
            r2 = r7[r3]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r7 = r7[r4]
            goto L1f
        L5c:
            if (r0 == 0) goto L62
            int r7 = r7 * 16
            int r7 = r7 / 14
        L62:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafx.zzc(byte[]):int");
    }

    public static zzafw zzd(byte[] bArr) throws zzat {
        int iZzj;
        int i3;
        long jZzv;
        int i4;
        zzes zzesVarZzi = zzi(bArr);
        zzesVarZzi.zzh(40);
        int iZzj2 = zzesVarZzi.zzj(2);
        boolean zZzi = zzesVarZzi.zzi();
        int i5 = true != zZzi ? 16 : 20;
        zzesVarZzi.zzh(true != zZzi ? 8 : 12);
        int iZzj3 = zzesVarZzi.zzj(i5) + 1;
        boolean zZzi2 = zzesVarZzi.zzi();
        int iZzj4 = -1;
        int i6 = 0;
        if (zZzi2) {
            iZzj = zzesVarZzi.zzj(2);
            int iZzj5 = zzesVarZzi.zzj(3) + 1;
            if (zzesVarZzi.zzi()) {
                zzesVarZzi.zzh(36);
            }
            int iZzj6 = zzesVarZzi.zzj(3) + 1;
            int iZzj7 = zzesVarZzi.zzj(3) + 1;
            if (iZzj6 != 1 || iZzj7 != 1) {
                throw zzat.zzc("Multiple audio presentations or assets not supported");
            }
            int i7 = iZzj2 + 1;
            int iZzj8 = zzesVarZzi.zzj(i7);
            for (int i8 = 0; i8 < i7; i8++) {
                if (((iZzj8 >> i8) & 1) == 1) {
                    zzesVarZzi.zzh(8);
                }
            }
            int i9 = iZzj5 * 512;
            if (zzesVarZzi.zzi()) {
                zzesVarZzi.zzh(2);
                int iZzj9 = (zzesVarZzi.zzj(2) + 1) << 2;
                int iZzj10 = zzesVarZzi.zzj(2) + 1;
                while (i6 < iZzj10) {
                    zzesVarZzi.zzh(iZzj9);
                    i6++;
                }
            }
            i6 = i9;
        } else {
            iZzj = -1;
        }
        zzesVarZzi.zzh(i5);
        zzesVarZzi.zzh(12);
        if (zZzi2) {
            if (zzesVarZzi.zzi()) {
                zzesVarZzi.zzh(4);
            }
            if (zzesVarZzi.zzi()) {
                zzesVarZzi.zzh(24);
            }
            if (zzesVarZzi.zzi()) {
                zzesVarZzi.zzo(zzesVarZzi.zzj(10) + 1);
            }
            zzesVarZzi.zzh(5);
            i3 = zze[zzesVarZzi.zzj(4)];
            iZzj4 = zzesVarZzi.zzj(8) + 1;
        } else {
            i3 = -2147483647;
        }
        int i10 = i3;
        if (zZzi2) {
            if (iZzj == 0) {
                i4 = 32000;
            } else if (iZzj == 1) {
                i4 = 44100;
            } else {
                if (iZzj != 2) {
                    StringBuilder sb = new StringBuilder(String.valueOf(iZzj).length() + 51);
                    sb.append("Unsupported reference clock code in DTS HD header: ");
                    sb.append(iZzj);
                    throw zzat.zzb(sb.toString(), null);
                }
                i4 = 48000;
            }
            jZzv = zzfl.zzv(i6, 1000000L, i4, RoundingMode.DOWN);
        } else {
            jZzv = -9223372036854775807L;
        }
        return new zzafw("audio/vnd.dts.hd;profile=lbr", iZzj4, i10, iZzj3, jZzv, 0, null);
    }

    public static int zze(byte[] bArr) {
        zzes zzesVarZzi = zzi(bArr);
        zzesVarZzi.zzh(42);
        return zzesVarZzi.zzj(true != zzesVarZzi.zzi() ? 8 : 12) + 1;
    }

    public static zzafw zzf(byte[] bArr, AtomicInteger atomicInteger) throws zzat {
        long jZzv;
        int iZzj;
        AtomicInteger atomicInteger2;
        int i3;
        int i4;
        zzes zzesVarZzi = zzi(bArr);
        int iZzj2 = zzesVarZzi.zzj(32);
        int iZzh = zzh(zzesVarZzi, zzf, true);
        int i5 = iZzh + 1;
        char c3 = iZzj2 == 1078008818 ? (char) 1 : (char) 0;
        if (c3 == 0) {
            jZzv = -9223372036854775807L;
            iZzj = -2147483647;
        } else {
            if (!zzesVarZzi.zzi()) {
                throw zzat.zzc("Only supports full channel mask-based audio presentation");
            }
            int i6 = iZzh - 1;
            if (((bArr[iZzh] & 255) | ((char) (bArr[i6] << 8))) != zzfl.zzK(bArr, 0, i6, 65535)) {
                throw zzat.zzb("CRC check failed", null);
            }
            int iZzj3 = zzesVarZzi.zzj(2);
            if (iZzj3 == 0) {
                i3 = 512;
            } else if (iZzj3 == 1) {
                i3 = 480;
            } else {
                if (iZzj3 != 2) {
                    StringBuilder sb = new StringBuilder(String.valueOf(iZzj3).length() + 51);
                    sb.append("Unsupported base duration index in DTS UHD header: ");
                    sb.append(iZzj3);
                    throw zzat.zzb(sb.toString(), null);
                }
                i3 = 384;
            }
            int iZzj4 = zzesVarZzi.zzj(3) + 1;
            int iZzj5 = zzesVarZzi.zzj(2);
            if (iZzj5 == 0) {
                i4 = 32000;
            } else if (iZzj5 == 1) {
                i4 = 44100;
            } else {
                if (iZzj5 != 2) {
                    StringBuilder sb2 = new StringBuilder(String.valueOf(iZzj5).length() + 48);
                    sb2.append("Unsupported clock rate index in DTS UHD header: ");
                    sb2.append(iZzj5);
                    throw zzat.zzb(sb2.toString(), null);
                }
                i4 = 48000;
            }
            if (zzesVarZzi.zzi()) {
                zzesVarZzi.zzh(36);
            }
            iZzj = (1 << zzesVarZzi.zzj(2)) * i4;
            jZzv = zzfl.zzv(i3 * iZzj4, 1000000L, i4, RoundingMode.DOWN);
        }
        int i7 = iZzj;
        long j3 = jZzv;
        int iZzh2 = 0;
        for (char c4 = 0; c4 < c3; c4 = 1) {
            iZzh2 += zzh(zzesVarZzi, zzg, true);
        }
        for (int i8 = 0; i8 <= 0; i8++) {
            if (c3 != 0) {
                atomicInteger2 = atomicInteger;
                atomicInteger2.set(zzh(zzesVarZzi, zzh, true));
            } else {
                atomicInteger2 = atomicInteger;
            }
            iZzh2 += atomicInteger2.get() != 0 ? zzh(zzesVarZzi, zzi, true) : 0;
        }
        return new zzafw("audio/vnd.dts.uhd;profile=p2", 2, i7, i5 + iZzh2, j3, 0, null);
    }

    public static int zzg(byte[] bArr) {
        zzes zzesVarZzi = zzi(bArr);
        zzesVarZzi.zzh(32);
        return zzh(zzesVarZzi, zzj, true) + 1;
    }

    private static int zzh(zzes zzesVar, int[] iArr, boolean z2) {
        int i3 = 0;
        for (int i4 = 0; i4 < 3 && zzesVar.zzi(); i4++) {
            i3++;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            i5 += 1 << iArr[i6];
        }
        return i5 + zzesVar.zzj(iArr[i3]);
    }

    private static zzes zzi(byte[] bArr) {
        byte b3 = bArr[0];
        if (b3 == 127 || b3 == 100 || b3 == 64 || b3 == 113) {
            return new zzes(bArr, bArr.length);
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        byte b4 = bArrCopyOf[0];
        if (b4 == -2 || b4 == -1 || b4 == 37 || b4 == -14 || b4 == -24) {
            for (int i3 = 0; i3 < bArrCopyOf.length - 1; i3 += 2) {
                byte b5 = bArrCopyOf[i3];
                int i4 = i3 + 1;
                bArrCopyOf[i3] = bArrCopyOf[i4];
                bArrCopyOf[i4] = b5;
            }
        }
        int length = bArrCopyOf.length;
        zzes zzesVar = new zzes(bArrCopyOf, length);
        if (bArrCopyOf[0] == 31) {
            zzes zzesVar2 = new zzes(bArrCopyOf, length);
            while (zzesVar2.zzc() >= 16) {
                zzesVar2.zzh(2);
                zzesVar.zzp(zzesVar2.zzj(14), 14);
            }
        }
        zzesVar.zzb(bArrCopyOf, bArrCopyOf.length);
        return zzesVar;
    }
}
