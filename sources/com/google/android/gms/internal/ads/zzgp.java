package com.google.android.gms.internal.ads;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgp {
    public static final byte[] zza = {0, 0, 0, 1};
    public static final float[] zzb = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object zzc = new Object();
    private static int[] zzd = new int[10];

    public static int zza(byte[] bArr, int i3) {
        int i4;
        synchronized (zzc) {
            int i5 = 0;
            int i6 = 0;
            while (i5 < i3) {
                while (true) {
                    try {
                        if (i5 >= i3 - 2) {
                            i5 = i3;
                            break;
                        }
                        int i7 = i5 + 1;
                        if (bArr[i5] == 0 && bArr[i7] == 0 && bArr[i5 + 2] == 3) {
                            break;
                        }
                        i5 = i7;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (i5 < i3) {
                    int[] iArr = zzd;
                    int length = iArr.length;
                    if (length <= i6) {
                        zzd = Arrays.copyOf(iArr, length + length);
                    }
                    zzd[i6] = i5;
                    i5 += 3;
                    i6++;
                }
            }
            i4 = i3 - i6;
            int i8 = 0;
            int i9 = 0;
            for (int i10 = 0; i10 < i6; i10++) {
                int i11 = zzd[i10] - i8;
                System.arraycopy(bArr, i8, bArr, i9, i11);
                int i12 = i9 + i11;
                int i13 = i12 + 1;
                bArr[i12] = 0;
                i9 = i12 + 2;
                bArr[i13] = 0;
                i8 += i11 + 3;
            }
            System.arraycopy(bArr, i8, bArr, i9, i4 - i9);
        }
        return i4;
    }

    public static boolean zzb(zzv zzvVar, byte[] bArr, int i3) {
        String strZzq = zzq(zzvVar);
        if (strZzq == null) {
            return false;
        }
        int iHashCode = strZzq.hashCode();
        if (iHashCode != -1662541442) {
            return iHashCode != 1331836730 ? iHashCode == 1331856911 && strZzq.equals("video/vvc") && ((bArr[5] & 248) >> 3) == 23 : strZzq.equals("video/avc") && (bArr[4] & Ascii.US) == 6;
        }
        if (strZzq.equals("video/hevc") && ((bArr[4] & 126) >> 1) == 39) {
            return true;
        }
        return false;
    }

    public static int zzc(zzv zzvVar) {
        String strZzq = zzq(zzvVar);
        if (Objects.equals(strZzq, "video/avc")) {
            return 1;
        }
        return (Objects.equals(strZzq, "video/hevc") || Objects.equals(strZzq, "video/vvc")) ? 2 : 0;
    }

    public static boolean zzd(byte[] bArr, int i3, int i4, zzv zzvVar) {
        String str = zzvVar.zzp;
        if (Objects.equals(str, "video/avc")) {
            byte b3 = bArr[4];
            if (((b3 & 96) >> 5) != 0) {
                return true;
            }
            int i5 = b3 & Ascii.US;
            return (i5 == 1 || i5 == 9 || i5 == 14) ? false : true;
        }
        if (Objects.equals(str, "video/hevc")) {
            zzgd zzgdVarZzl = zzl(new zzgw(bArr, 4, i4 + 4));
            int i6 = zzgdVarZzl.zza;
            if (i6 == 35) {
                return false;
            }
            return (i6 <= 14 && i6 % 2 == 0 && zzgdVarZzl.zzc == zzvVar.zzG + (-1)) ? false : true;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x016c A[PHI: r2
      0x016c: PHI (r2v6 int) = (r2v4 int), (r2v3 int) binds: [B:87:0x0171, B:83:0x0168] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x016f A[PHI: r2
      0x016f: PHI (r2v4 int) = (r2v3 int), (r2v3 int), (r2v3 int), (r2v3 int), (r2v3 int), (r2v7 int) binds: [B:74:0x0156, B:76:0x015a, B:78:0x015e, B:80:0x0162, B:82:0x0166, B:84:0x016a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x017e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzgo zze(byte[] r32, int r33, int r34) {
        /*
            Method dump skipped, instruction units count: 646
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgp.zze(byte[], int, int):com.google.android.gms.internal.ads.zzgo");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:307:0x05e2  */
    /* JADX WARN: Removed duplicated region for block: B:525:0x05f7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0145  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzgm zzf(byte[] r35, int r36, int r37) {
        /*
            Method dump skipped, instruction units count: 2155
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgp.zzf(byte[], int, int):com.google.android.gms.internal.ads.zzgm");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzgj zzg(byte[] r36, int r37, int r38, com.google.android.gms.internal.ads.zzgm r39) {
        /*
            Method dump skipped, instruction units count: 1040
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgp.zzg(byte[], int, int, com.google.android.gms.internal.ads.zzgm):com.google.android.gms.internal.ads.zzgj");
    }

    public static zzgn zzh(byte[] bArr, int i3, int i4) {
        zzgw zzgwVar = new zzgw(bArr, 4, i4);
        int iZzg = zzgwVar.zzg();
        int iZzg2 = zzgwVar.zzg();
        zzgwVar.zza();
        return new zzgn(iZzg, iZzg2, zzgwVar.zze());
    }

    public static int zzi(byte[] bArr, int i3, int i4, boolean[] zArr) {
        int i5 = i4 - i3;
        zzgtj.zzi(i5 >= 0);
        if (i5 == 0) {
            return i4;
        }
        if (zArr[0]) {
            zzj(zArr);
            return i3 - 3;
        }
        if (i5 > 1 && zArr[1] && bArr[i3] == 1) {
            zzj(zArr);
            return i3 - 2;
        }
        if (i5 > 2 && zArr[2] && bArr[i3] == 0 && bArr[i3 + 1] == 1) {
            zzj(zArr);
            return i3 - 1;
        }
        int i6 = i4 - 1;
        int i7 = i3 + 2;
        while (i7 < i6) {
            byte b3 = bArr[i7];
            if ((b3 & 254) == 0) {
                int i8 = i7 - 2;
                if (bArr[i8] == 0 && bArr[i7 - 1] == 0 && b3 == 1) {
                    zzj(zArr);
                    return i8;
                }
                i7 = i8;
            }
            i7 += 3;
        }
        zArr[0] = i5 <= 2 ? !(i5 != 2 ? !(zArr[1] && bArr[i6] == 1) : !(zArr[2] && bArr[i4 + (-2)] == 0 && bArr[i6] == 1)) : bArr[i4 + (-3)] == 0 && bArr[i4 + (-2)] == 0 && bArr[i6] == 1;
        zArr[1] = i5 <= 1 ? zArr[2] && bArr[i6] == 0 : bArr[i4 + (-2)] == 0 && bArr[i6] == 0;
        zArr[2] = bArr[i6] == 0;
        return i4;
    }

    public static void zzj(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static String zzk(List list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            byte[] bArr = (byte[]) list.get(i3);
            int length = bArr.length;
            if (length > 3) {
                boolean[] zArr = new boolean[3];
                int i4 = zzgwm.zzd;
                zzgwj zzgwjVar = new zzgwj();
                int i5 = 0;
                while (true) {
                    int length2 = bArr.length;
                    if (i5 >= length2) {
                        break;
                    }
                    int iZzi = zzi(bArr, i5, length2, zArr);
                    if (iZzi != length2) {
                        zzgwjVar.zzf(Integer.valueOf(iZzi));
                    }
                    i5 = iZzi + 3;
                }
                zzgwm zzgwmVarZzi = zzgwjVar.zzi();
                for (int i6 = 0; i6 < zzgwmVarZzi.size(); i6++) {
                    if (((Integer) zzgwmVarZzi.get(i6)).intValue() + 3 < length) {
                        zzgw zzgwVar = new zzgw(bArr, ((Integer) zzgwmVarZzi.get(i6)).intValue() + 3, length);
                        zzgd zzgdVarZzl = zzl(zzgwVar);
                        if (zzgdVarZzl.zza == 33 && zzgdVarZzl.zzb == 0) {
                            zzgwVar.zzb(4);
                            int iZzf = zzgwVar.zzf(3);
                            zzgwVar.zza();
                            zzge zzgeVarZzm = zzm(zzgwVar, true, iZzf, null);
                            return zzdq.zzc(zzgeVarZzm.zza, zzgeVarZzm.zzb, zzgeVarZzm.zzc, zzgeVarZzm.zzd, zzgeVarZzm.zze, zzgeVarZzm.zzf);
                        }
                    }
                }
            }
        }
        return null;
    }

    private static zzgd zzl(zzgw zzgwVar) {
        zzgwVar.zza();
        return new zzgd(zzgwVar.zzf(6), zzgwVar.zzf(6), zzgwVar.zzf(3) - 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.google.android.gms.internal.ads.zzge zzm(com.google.android.gms.internal.ads.zzgw r18, boolean r19, int r20, com.google.android.gms.internal.ads.zzge r21) {
        /*
            r0 = r18
            r1 = r20
            r2 = r21
            r3 = 6
            int[] r4 = new int[r3]
            r5 = 8
            r6 = 0
            if (r19 == 0) goto L41
            r2 = 2
            int r2 = r0.zzf(r2)
            boolean r7 = r0.zze()
            r8 = 5
            int r8 = r0.zzf(r8)
            r9 = r6
            r10 = r9
        L1e:
            r11 = 32
            if (r9 >= r11) goto L2e
            boolean r11 = r0.zze()
            if (r11 == 0) goto L2b
            r11 = 1
            int r11 = r11 << r9
            r10 = r10 | r11
        L2b:
            int r9 = r9 + 1
            goto L1e
        L2e:
            r9 = r6
        L2f:
            if (r9 >= r3) goto L3a
            int r11 = r0.zzf(r5)
            r4[r9] = r11
            int r9 = r9 + 1
            goto L2f
        L3a:
            r12 = r2
        L3b:
            r16 = r4
            r13 = r7
            r14 = r8
            r15 = r10
            goto L55
        L41:
            if (r2 == 0) goto L4f
            int r3 = r2.zza
            boolean r7 = r2.zzb
            int r8 = r2.zzc
            int r10 = r2.zzd
            int[] r4 = r2.zze
            r12 = r3
            goto L3b
        L4f:
            r16 = r4
            r12 = r6
            r13 = r12
            r14 = r13
            r15 = r14
        L55:
            int r17 = r0.zzf(r5)
            r2 = r6
        L5a:
            if (r6 >= r1) goto L6f
            boolean r3 = r0.zze()
            if (r3 == 0) goto L64
            int r2 = r2 + 88
        L64:
            boolean r3 = r0.zze()
            if (r3 == 0) goto L6c
            int r2 = r2 + 8
        L6c:
            int r6 = r6 + 1
            goto L5a
        L6f:
            r0.zzb(r2)
            if (r1 <= 0) goto L79
            int r5 = r5 - r1
            int r5 = r5 + r5
            r0.zzb(r5)
        L79:
            com.google.android.gms.internal.ads.zzge r11 = new com.google.android.gms.internal.ads.zzge
            r11.<init>(r12, r13, r14, r15, r16, r17)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgp.zzm(com.google.android.gms.internal.ads.zzgw, boolean, int, com.google.android.gms.internal.ads.zzge):com.google.android.gms.internal.ads.zzge");
    }

    private static int zzn(int i3, int i4, int i5, int i6) {
        int i7 = 2;
        if (i4 != 1 && i4 != 2) {
            i7 = 1;
        }
        return i3 - (i7 * (i5 + i6));
    }

    private static int zzo(int i3, int i4, int i5, int i6) {
        return i3 - ((i4 == 1 ? 2 : 1) * (i5 + i6));
    }

    private static void zzp(zzgw zzgwVar) {
        int iZzg = zzgwVar.zzg() + 1;
        zzgwVar.zzb(8);
        for (int i3 = 0; i3 < iZzg; i3++) {
            zzgwVar.zzg();
            zzgwVar.zzg();
            zzgwVar.zza();
        }
        zzgwVar.zzb(20);
    }

    private static String zzq(zzv zzvVar) {
        String str;
        String str2 = zzvVar.zzp;
        if (Objects.equals(str2, "video/dolby-vision") && (str = zzvVar.zzk) != null) {
            if (str.startsWith("dva1") || str.startsWith("dvav")) {
                return "video/avc";
            }
            if (str.startsWith("dvh1") || str.startsWith("dvhe")) {
                return "video/hevc";
            }
        }
        return str2;
    }
}
