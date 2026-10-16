package com.google.android.gms.internal.ads;

import com.facebook.ads.AdError;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzafb {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {AdError.CACHE_ERROR_CODE, AdError.SERVER_ERROR_CODE, 1920, 1601, 1600, AdError.NO_FILL_ERROR_CODE, 1000, 960, 800, 800, 480, RCHTTPStatusCodes.BAD_REQUEST, RCHTTPStatusCodes.BAD_REQUEST, 2048};

    /* JADX WARN: Removed duplicated region for block: B:145:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0292 A[PHI: r1 r5 r8
      0x0292: PHI (r1v4 int) = (r1v3 int), (r1v60 int) binds: [B:176:0x0294, B:169:0x026a] A[DONT_GENERATE, DONT_INLINE]
      0x0292: PHI (r5v3 int) = (r5v2 int), (r5v17 int) binds: [B:176:0x0294, B:169:0x026a] A[DONT_GENERATE, DONT_INLINE]
      0x0292: PHI (r8v3 int) = (r8v2 int), (r8v37 int) binds: [B:176:0x0294, B:169:0x026a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0382  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzv zza(com.google.android.gms.internal.ads.zzet r21, java.lang.String r22, java.lang.String r23, com.google.android.gms.internal.ads.zzq r24) throws com.google.android.gms.internal.ads.zzat {
        /*
            Method dump skipped, instruction units count: 974
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafb.zza(com.google.android.gms.internal.ads.zzet, java.lang.String, java.lang.String, com.google.android.gms.internal.ads.zzq):com.google.android.gms.internal.ads.zzv");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzafa zzb(com.google.android.gms.internal.ads.zzes r11) {
        /*
            r0 = 16
            int r1 = r11.zzj(r0)
            int r0 = r11.zzj(r0)
            r2 = 65535(0xffff, float:9.1834E-41)
            r3 = 4
            if (r0 != r2) goto L18
            r0 = 24
            int r0 = r11.zzj(r0)
            r2 = 7
            goto L19
        L18:
            r2 = r3
        L19:
            int r0 = r0 + r2
            r2 = 44097(0xac41, float:6.1793E-41)
            if (r1 != r2) goto L21
            int r0 = r0 + 2
        L21:
            r8 = r0
            r0 = 2
            int r1 = r11.zzj(r0)
            r2 = 0
            r4 = 3
            if (r1 != r4) goto L38
            r1 = r2
        L2c:
            int r5 = r11.zzj(r0)
            int r1 = r1 + r5
            boolean r5 = r11.zzi()
            if (r5 != 0) goto L3a
            int r1 = r1 + r4
        L38:
            r5 = r1
            goto L3e
        L3a:
            int r1 = r1 + 1
            int r1 = r1 << r0
            goto L2c
        L3e:
            r1 = 10
            int r1 = r11.zzj(r1)
            boolean r6 = r11.zzi()
            if (r6 == 0) goto L53
            int r6 = r11.zzj(r4)
            if (r6 <= 0) goto L53
            r11.zzh(r0)
        L53:
            boolean r6 = r11.zzi()
            r7 = 48000(0xbb80, float:6.7262E-41)
            r9 = 44100(0xac44, float:6.1797E-41)
            r10 = 1
            if (r10 == r6) goto L63
            r6 = r7
            r7 = r9
            goto L64
        L63:
            r6 = r7
        L64:
            int r11 = r11.zzj(r3)
            if (r7 != r9) goto L74
            r9 = 13
            if (r11 != r9) goto L74
            int[] r11 = com.google.android.gms.internal.ads.zzafb.zzb
            r2 = r11[r9]
        L72:
            r9 = r2
            goto La0
        L74:
            if (r7 != r6) goto L72
            r6 = 14
            if (r11 >= r6) goto L72
            int[] r2 = com.google.android.gms.internal.ads.zzafb.zzb
            r2 = r2[r11]
            int r1 = r1 % 5
            r6 = 8
            if (r1 == r10) goto L9b
            r9 = 11
            if (r1 == r0) goto L96
            if (r1 == r4) goto L9b
            if (r1 == r3) goto L8d
            goto L72
        L8d:
            if (r11 == r4) goto L93
            if (r11 == r6) goto L93
            if (r11 != r9) goto L72
        L93:
            int r2 = r2 + 1
            goto L72
        L96:
            if (r11 == r6) goto L93
            if (r11 != r9) goto L72
            goto L93
        L9b:
            if (r11 == r4) goto L93
            if (r11 != r6) goto L72
            goto L93
        La0:
            com.google.android.gms.internal.ads.zzafa r4 = new com.google.android.gms.internal.ads.zzafa
            r6 = 2
            r10 = 0
            r4.<init>(r5, r6, r7, r8, r9, r10)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafb.zzb(com.google.android.gms.internal.ads.zzes):com.google.android.gms.internal.ads.zzafa");
    }

    public static void zzc(int i3, zzet zzetVar) {
        zzetVar.zza(7);
        byte[] bArrZzi = zzetVar.zzi();
        bArrZzi[0] = -84;
        bArrZzi[1] = 64;
        bArrZzi[2] = -1;
        bArrZzi[3] = -1;
        bArrZzi[4] = (byte) ((i3 >> 16) & 255);
        bArrZzi[5] = (byte) ((i3 >> 8) & 255);
        bArrZzi[6] = (byte) (i3 & 255);
    }

    private static void zzd(zzes zzesVar, zzaez zzaezVar) throws zzat {
        int iZzj = zzesVar.zzj(5);
        zzesVar.zzh(2);
        if (zzesVar.zzi()) {
            zzesVar.zzh(5);
        }
        if (iZzj >= 7 && iZzj <= 10) {
            zzesVar.zzg();
        }
        if (zzesVar.zzi()) {
            int iZzj2 = zzesVar.zzj(3);
            if (zzaezVar.zzb == -1 && iZzj >= 0 && iZzj <= 15 && (iZzj2 == 0 || iZzj2 == 1)) {
                zzaezVar.zzb = iZzj;
            }
            if (zzesVar.zzi()) {
                zzf(zzesVar);
            }
        }
    }

    private static void zze(zzes zzesVar, zzaez zzaezVar) throws zzat {
        zzesVar.zzh(2);
        boolean zZzi = zzesVar.zzi();
        int iZzj = zzesVar.zzj(8);
        for (int i3 = 0; i3 < iZzj; i3++) {
            zzesVar.zzh(2);
            if (zzesVar.zzi()) {
                zzesVar.zzh(5);
            }
            if (zZzi) {
                zzesVar.zzh(24);
            } else {
                if (zzesVar.zzi()) {
                    if (!zzesVar.zzi()) {
                        zzesVar.zzh(4);
                    }
                    zzaezVar.zzc = zzesVar.zzj(6) + 1;
                }
                zzesVar.zzh(4);
            }
        }
        if (zzesVar.zzi()) {
            zzesVar.zzh(3);
            if (zzesVar.zzi()) {
                zzf(zzesVar);
            }
        }
    }

    private static void zzf(zzes zzesVar) throws zzat {
        int iZzj = zzesVar.zzj(6);
        if (iZzj < 2 || iZzj > 42) {
            throw zzat.zzc(String.format("Invalid language tag bytes number: %d. Must be between 2 and 42.", Integer.valueOf(iZzj)));
        }
        zzesVar.zzh(iZzj * 8);
    }

    private static boolean zzg(zzes zzesVar) {
        if (zzesVar.zzc() < 66) {
            return false;
        }
        zzesVar.zzh(66);
        return true;
    }
}
