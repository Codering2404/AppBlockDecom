package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzakj {
    private static final long[] zza = {128, 64, 32, 16, 8, 4, 2, 1};
    private final byte[] zzb = new byte[8];
    private int zzc;
    private int zzd;

    public static int zzd(int i3) {
        int i4 = 0;
        while (i4 < 8) {
            int i5 = i4 + 1;
            if ((zza[i4] & ((long) i3)) != 0) {
                return i5;
            }
            i4 = i5;
        }
        return -1;
    }

    public static long zze(byte[] bArr, int i3, boolean z2) {
        long j3 = ((long) bArr[0]) & 255;
        if (z2) {
            j3 &= ~zza[i3 - 1];
        }
        for (int i4 = 1; i4 < i3; i4++) {
            j3 = (j3 << 8) | (((long) bArr[i4]) & 255);
        }
        return j3;
    }

    public final void zza() {
        this.zzc = 0;
        this.zzd = 0;
    }

    public final long zzb(zzafz zzafzVar, boolean z2, boolean z3, int i3) throws IOException {
        if (this.zzc == 0) {
            byte[] bArr = this.zzb;
            if (!zzafzVar.zzb(bArr, 0, 1, z2)) {
                return -1L;
            }
            int iZzd = zzd(bArr[0] & 255);
            this.zzd = iZzd;
            if (iZzd == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.zzc = 1;
        }
        int i4 = this.zzd;
        if (i4 > i3) {
            this.zzc = 0;
            return -2L;
        }
        if (i4 != 1) {
            zzafzVar.zzc(this.zzb, 1, i4 - 1);
        }
        this.zzc = 0;
        return zze(this.zzb, this.zzd, z3);
    }

    public final int zzc() {
        return this.zzd;
    }
}
