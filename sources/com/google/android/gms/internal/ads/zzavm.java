package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzavm {
    public static zzawm zza(final long j3) {
        return zzawm.zzf(new zzawe() { // from class: com.google.android.gms.internal.ads.zzavl
            @Override // java.util.function.Function
            public final /* synthetic */ Object apply(Object obj) {
                try {
                    ((zzawh) obj).zzb.zzb(zzawm.zzb(j3));
                    return Optional.empty();
                } catch (zzawc unused) {
                    return Optional.of(zzauw.zza);
                }
            }
        });
    }

    public static int zzb(long j3, zzawl zzawlVar, boolean z2) throws IOException {
        long[] jArr = {2000490107, 1476547902, 1834034217, 268849430, 1839467528, 4368198174L, 449620248, 1652701270, 1629190168};
        long j4 = jArr[0];
        long j5 = jArr[1];
        long j6 = jArr[2];
        long j7 = jArr[3];
        long j8 = jArr[4];
        long j9 = jArr[5];
        long j10 = jArr[6];
        long j11 = jArr[7];
        long j12 = j10 + (((((~j4) & j5) | j6) + ((j4 & j7) | j8)) - j9);
        long j13 = j11 % 1629190168;
        int i3 = ((((~1725868784) & 388366538) | 739792167) + ((1725868784 & 1395525853) | 1087913783)) - 2073845026;
        int i4 = 1550046828 % 184366026;
        int i5 = ((((~84870791) & 719462960) | 688752780) + ((84870791 & 317383283) | 806209731)) - 1437974767;
        int i6 = 2023762697 % 959200313;
        int i7 = ((((~294151249) & 1465191424) | 201912514) + ((294151249 & 1398095366) | 75641662)) - 1330100008;
        int i8 = 1583887958 % 619175679;
        long j14 = z2 ? (j3 >> ((((((~1375552878) & 930005102) | 1249030018) + ((1375552878 & 1024213116) | 136481682)) - 2090967727) ^ (2014126950 % 228698447))) ^ (j3 + j3) : j3;
        int i9 = 1;
        while (true) {
            long j15 = j12 ^ j13;
            long j16 = j14 >>> (i5 ^ i6);
            boolean z3 = j16 != 0 || i9 < 0;
            int i10 = (int) (j14 & j15);
            if (z3) {
                int i11 = i3 ^ i4;
                i10 = ((i10 | (i7 ^ i8)) << i11) >> i11;
            }
            zzawlVar.zza((byte) i10);
            if (!z3) {
                return i9;
            }
            i9++;
            j14 = j16;
        }
    }
}
