package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaew {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final int[] zzc = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static zzaev zza(byte[] bArr) throws zzat {
        return zzb(new zzes(bArr, bArr.length), false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00c9, code lost:
    
        if (r11 != 3) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzaev zzb(com.google.android.gms.internal.ads.zzes r11, boolean r12) throws com.google.android.gms.internal.ads.zzat {
        /*
            Method dump skipped, instruction units count: 294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaew.zzb(com.google.android.gms.internal.ads.zzes, boolean):com.google.android.gms.internal.ads.zzaev");
    }

    private static int zzc(zzes zzesVar) {
        int iZzj = zzesVar.zzj(5);
        return iZzj == 31 ? zzesVar.zzj(6) + 32 : iZzj;
    }

    private static int zzd(zzes zzesVar) throws zzat {
        int iZzj = zzesVar.zzj(4);
        if (iZzj == 15) {
            if (zzesVar.zzc() >= 24) {
                return zzesVar.zzj(24);
            }
            throw zzat.zzb("AAC header insufficient data", null);
        }
        if (iZzj < 13) {
            return zzb[iZzj];
        }
        throw zzat.zzb("AAC header wrong Sampling Frequency Index", null);
    }
}
