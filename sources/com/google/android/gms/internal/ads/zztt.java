package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zztt implements zztj {
    protected zztt(zzts zztsVar) {
    }

    protected static int zza(int i3, int i4, int i5) {
        return zzhah.zza(((((long) i3) * ((long) i4)) * ((long) i5)) / 1000000);
    }

    protected static final int zzb(int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = 250000;
        if (i5 == 0) {
            int iZza = zza(250000, i7, i6);
            int iZza2 = zza(750000, i7, i6);
            String str = zzfl.zza;
            return Math.max(iZza, Math.min(i3 * 4, iZza2));
        }
        if (i5 == 1) {
            return zzhah.zza((((long) zzc(i4)) * 50000000) / 1000000);
        }
        if (i4 == 5) {
            i9 = 500000;
        } else if (i4 == 8) {
            i9 = 1000000;
            i4 = 8;
        }
        return zzhah.zza((((long) i9) * ((long) (i8 != -1 ? zzgzz.zzb(i8, 8, RoundingMode.CEILING) : zzc(i4)))) / 1000000);
    }

    private static int zzc(int i3) {
        int iZzf = zzagc.zzf(i3);
        zzgtj.zzi(iZzf != -2147483647);
        return iZzf;
    }
}
