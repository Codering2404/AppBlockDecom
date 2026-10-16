package com.google.android.gms.internal.ads;

import com.applovin.exoplayer2.common.base.Ascii;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzihd extends zzihc {
    zzihd() {
    }

    @Override // com.google.android.gms.internal.ads.zzihc
    public final boolean zza(byte[] bArr, int i3, int i4) {
        while (i3 < i4 && bArr[i3] >= 0) {
            i3++;
        }
        if (i3 >= i4) {
            return true;
        }
        while (i3 < i4) {
            int i5 = i3 + 1;
            byte b3 = bArr[i3];
            if (b3 >= 0) {
                i3 = i5;
            } else {
                if (b3 < -32) {
                    if (i5 < i4 && b3 >= -62) {
                        i3 += 2;
                        if (bArr[i5] > -65) {
                        }
                    }
                    return false;
                }
                if (b3 >= -16) {
                    if (i5 >= i4 - 2) {
                        return false;
                    }
                    int i6 = i3 + 2;
                    byte b4 = bArr[i5];
                    if (b4 <= -65 && (((b3 << Ascii.FS) + (b4 + 112)) >> 30) == 0) {
                        int i7 = i3 + 3;
                        if (bArr[i6] <= -65) {
                            i3 += 4;
                            if (bArr[i7] > -65) {
                            }
                        }
                    }
                    return false;
                }
                if (i5 >= i4 - 1) {
                    return false;
                }
                int i8 = i3 + 2;
                byte b5 = bArr[i5];
                if (b5 > -65 || (b3 == -32 && b5 < -96)) {
                    return false;
                }
                if (b3 == -19 && b5 >= -96) {
                    return false;
                }
                i3 += 3;
                if (bArr[i8] > -65) {
                    return false;
                }
            }
        }
        return true;
    }
}
