package com.google.android.gms.internal.auth;

import com.applovin.exoplayer2.common.base.Ascii;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhm extends zzhl {
    zzhm() {
    }

    @Override // com.google.android.gms.internal.auth.zzhl
    final int zza(int i3, byte[] bArr, int i4, int i5) {
        while (i4 < i5 && bArr[i4] >= 0) {
            i4++;
        }
        if (i4 >= i5) {
            return 0;
        }
        while (i4 < i5) {
            int i6 = i4 + 1;
            byte b3 = bArr[i4];
            if (b3 >= 0) {
                i4 = i6;
            } else {
                if (b3 < -32) {
                    if (i6 >= i5) {
                        return b3;
                    }
                    if (b3 >= -62) {
                        i4 += 2;
                        if (bArr[i6] > -65) {
                        }
                    }
                    return -1;
                }
                if (b3 >= -16) {
                    if (i6 >= i5 - 2) {
                        return zzhn.zza(bArr, i6, i5);
                    }
                    int i7 = i4 + 2;
                    byte b4 = bArr[i6];
                    if (b4 <= -65 && (((b3 << Ascii.FS) + (b4 + 112)) >> 30) == 0) {
                        int i8 = i4 + 3;
                        if (bArr[i7] <= -65) {
                            i4 += 4;
                            if (bArr[i8] > -65) {
                            }
                        }
                    }
                    return -1;
                }
                if (i6 >= i5 - 1) {
                    return zzhn.zza(bArr, i6, i5);
                }
                int i9 = i4 + 2;
                byte b5 = bArr[i6];
                if (b5 > -65 || (b3 == -32 && b5 < -96)) {
                    return -1;
                }
                if (b3 == -19 && b5 >= -96) {
                    return -1;
                }
                i4 += 3;
                if (bArr[i9] > -65) {
                    return -1;
                }
            }
        }
        return 0;
    }
}
