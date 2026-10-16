package com.google.android.gms.internal.ads;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaki {
    private final zzet zza = new zzet(8);
    private int zzb;

    private final long zzb(zzafz zzafzVar) throws IOException {
        int i3;
        zzet zzetVar = this.zza;
        zzafp zzafpVar = (zzafp) zzafzVar;
        int i4 = 0;
        zzafpVar.zzh(zzetVar.zzi(), 0, 1, false);
        int i5 = zzetVar.zzi()[0] & 255;
        if (i5 == 0) {
            return Long.MIN_VALUE;
        }
        int i6 = ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        int i7 = 0;
        while (true) {
            i3 = i7 + 1;
            if ((i5 & i6) != 0) {
                break;
            }
            i6 >>= 1;
            i7 = i3;
        }
        int i8 = i5 & (~i6);
        zzafpVar.zzh(zzetVar.zzi(), 1, i7, false);
        while (i4 < i7) {
            i4++;
            i8 = (zzetVar.zzi()[i4] & 255) + (i8 << 8);
        }
        this.zzb += i3;
        return i8;
    }

    public final boolean zza(zzafz zzafzVar) throws IOException {
        long jZzo = zzafzVar.zzo();
        long j3 = 1024;
        if (jZzo != -1 && jZzo <= 1024) {
            j3 = jZzo;
        }
        zzet zzetVar = this.zza;
        zzafp zzafpVar = (zzafp) zzafzVar;
        zzafpVar.zzh(zzetVar.zzi(), 0, 4, false);
        this.zzb = 4;
        for (long jZzz = zzetVar.zzz(); jZzz != 440786851; jZzz = ((jZzz << 8) & (-256)) | ((long) (zzetVar.zzi()[0] & 255))) {
            int i3 = (int) j3;
            int i4 = this.zzb + 1;
            this.zzb = i4;
            if (i4 == i3) {
                return false;
            }
            zzafpVar.zzh(zzetVar.zzi(), 0, 1, false);
        }
        long jZzb = zzb(zzafzVar);
        long j4 = this.zzb;
        if (jZzb != Long.MIN_VALUE) {
            long j5 = j4 + jZzb;
            if (jZzo == -1 || j5 < jZzo) {
                while (true) {
                    long j6 = this.zzb;
                    if (j6 < j5) {
                        if (zzb(zzafzVar) == Long.MIN_VALUE) {
                            return false;
                        }
                        long jZzb2 = zzb(zzafzVar);
                        if (jZzb2 < 0) {
                            return false;
                        }
                        if (jZzb2 != 0) {
                            int i5 = (int) jZzb2;
                            zzafpVar.zzj(i5, false);
                            this.zzb += i5;
                        }
                    } else if (j6 == j5) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
