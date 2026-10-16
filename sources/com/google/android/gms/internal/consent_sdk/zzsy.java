package com.google.android.gms.internal.consent_sdk;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzsy {
    static {
        if (zzsw.zzx() && zzsw.zzy()) {
            int i3 = zzpc.zza;
        }
    }

    static int zza(String str, byte[] bArr, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        char cCharAt;
        int length = str.length();
        int i8 = 0;
        while (true) {
            i5 = i3 + i4;
            if (i8 >= length || (i7 = i8 + i3) >= i5 || (cCharAt = str.charAt(i8)) >= 128) {
                break;
            }
            bArr[i7] = (byte) cCharAt;
            i8++;
        }
        if (i8 == length) {
            return i3 + length;
        }
        int i9 = i3 + i8;
        while (i8 < length) {
            char cCharAt2 = str.charAt(i8);
            if (cCharAt2 < 128 && i9 < i5) {
                bArr[i9] = (byte) cCharAt2;
                i9++;
            } else if (cCharAt2 < 2048 && i9 <= i5 - 2) {
                bArr[i9] = (byte) ((cCharAt2 >>> 6) | 960);
                bArr[i9 + 1] = (byte) ((cCharAt2 & '?') | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                i9 += 2;
            } else {
                if ((cCharAt2 >= 55296 && cCharAt2 <= 57343) || i9 > i5 - 3) {
                    if (i9 > i5 - 4) {
                        if (cCharAt2 < 55296 || cCharAt2 > 57343 || ((i6 = i8 + 1) != str.length() && Character.isSurrogatePair(cCharAt2, str.charAt(i6)))) {
                            throw new ArrayIndexOutOfBoundsException("Not enough space in output buffer to encode UTF-8 string");
                        }
                        throw new zzsx(i8, length);
                    }
                    int i10 = i8 + 1;
                    if (i10 != str.length()) {
                        char cCharAt3 = str.charAt(i10);
                        if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                            int i11 = i9 + 3;
                            int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                            bArr[i9] = (byte) ((codePoint >>> 18) | 240);
                            bArr[i9 + 1] = (byte) (((codePoint >>> 12) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                            bArr[i9 + 2] = (byte) (((codePoint >>> 6) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                            i9 += 4;
                            bArr[i11] = (byte) ((codePoint & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                            i8 = i10;
                        } else {
                            i8 = i10;
                        }
                    }
                    throw new zzsx(i8 - 1, length);
                }
                bArr[i9] = (byte) ((cCharAt2 >>> '\f') | 480);
                bArr[i9 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                bArr[i9 + 2] = (byte) ((cCharAt2 & '?') | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                i9 += 3;
            }
            i8++;
        }
        return i9;
    }

    static int zzb(String str) {
        int length = str.length();
        int i3 = 0;
        int i4 = 0;
        while (i4 < length && str.charAt(i4) < 128) {
            i4++;
        }
        int i5 = length;
        while (true) {
            if (i4 >= length) {
                break;
            }
            char cCharAt = str.charAt(i4);
            if (cCharAt < 2048) {
                i5 += (127 - cCharAt) >>> 31;
                i4++;
            } else {
                int length2 = str.length();
                while (i4 < length2) {
                    char cCharAt2 = str.charAt(i4);
                    if (cCharAt2 < 2048) {
                        i3 += (127 - cCharAt2) >>> 31;
                    } else {
                        i3 += 2;
                        if (cCharAt2 >= 55296 && cCharAt2 <= 57343) {
                            if (Character.codePointAt(str, i4) < 65536) {
                                throw new zzsx(i4, length2);
                            }
                            i4++;
                        }
                    }
                    i4++;
                }
                i5 += i3;
            }
        }
        if (i5 >= length) {
            return i5;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i5) + 4294967296L));
    }
}
