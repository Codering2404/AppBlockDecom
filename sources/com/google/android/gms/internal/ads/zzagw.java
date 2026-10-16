package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzagw {
    private static final String[] zza = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};
    private static final int[] zzb = {44100, 48000, 32000};
    private static final int[] zzc = {32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};
    private static final int[] zzd = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};
    private static final int[] zze = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};
    private static final int[] zzf = {32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};
    private static final int[] zzg = {8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000};

    public static int zza(int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        if (!zzl(i3) || (i4 = (i3 >>> 19) & 3) == 1 || (i5 = (i3 >>> 17) & 3) == 0 || (i6 = (i3 >>> 12) & 15) == 0 || i6 == 15 || (i7 = (i3 >>> 10) & 3) == 3) {
            return -1;
        }
        int i8 = i6 - 1;
        int i9 = zzb[i7];
        if (i4 == 2) {
            i9 /= 2;
        } else if (i4 == 0) {
            i9 /= 4;
        }
        int i10 = (i3 >>> 9) & 1;
        if (i5 == 3) {
            return ((((i4 == 3 ? zzc[i8] : zzd[i8]) * 12) / i9) + i10) * 4;
        }
        int i11 = i4 == 3 ? i5 == 2 ? zze[i8] : zzf[i8] : zzg[i8];
        if (i4 == 3) {
            return ((i11 * 144) / i9) + i10;
        }
        return (((i5 == 1 ? 72 : 144) * i11) / i9) + i10;
    }

    public static int zzb(int i3) {
        int i4;
        int i5;
        if (!zzl(i3) || (i4 = (i3 >>> 19) & 3) == 1 || (i5 = (i3 >>> 17) & 3) == 0) {
            return -1;
        }
        int i6 = i3 >>> 12;
        int i7 = (i3 >>> 10) & 3;
        int i8 = i6 & 15;
        if (i8 == 0 || i8 == 15 || i7 == 3) {
            return -1;
        }
        return zzm(i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzl(int i3) {
        return (i3 & (-2097152)) == -2097152;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzm(int i3, int i4) {
        return i4 != 1 ? i4 != 2 ? 384 : 1152 : i3 == 3 ? 1152 : 576;
    }
}
