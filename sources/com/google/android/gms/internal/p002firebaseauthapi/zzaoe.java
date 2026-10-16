package com.google.android.gms.internal.p002firebaseauthapi;

import com.applovin.exoplayer2.common.base.Ascii;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaoe extends zzaob {
    zzaoe() {
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaob
    final int zza(String str, byte[] bArr, int i3, int i4) {
        int i5;
        int i6;
        char cCharAt;
        int length = str.length();
        int i7 = i4 + i3;
        int i8 = 0;
        while (i8 < length && (i6 = i8 + i3) < i7 && (cCharAt = str.charAt(i8)) < 128) {
            bArr[i6] = (byte) cCharAt;
            i8++;
        }
        if (i8 == length) {
            return i3 + length;
        }
        int i9 = i3 + i8;
        while (i8 < length) {
            char cCharAt2 = str.charAt(i8);
            if (cCharAt2 < 128 && i9 < i7) {
                bArr[i9] = (byte) cCharAt2;
                i9++;
            } else if (cCharAt2 < 2048 && i9 <= i7 - 2) {
                int i10 = i9 + 1;
                bArr[i9] = (byte) ((cCharAt2 >>> 6) | 960);
                i9 += 2;
                bArr[i10] = (byte) ((cCharAt2 & '?') | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
            } else {
                if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i9 > i7 - 3) {
                    if (i9 > i7 - 4) {
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i5 = i8 + 1) == str.length() || !Character.isSurrogatePair(cCharAt2, str.charAt(i5)))) {
                            throw new zzaod(i8, length);
                        }
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i9);
                    }
                    int i11 = i8 + 1;
                    if (i11 != str.length()) {
                        char cCharAt3 = str.charAt(i11);
                        if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                            int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                            bArr[i9] = (byte) ((codePoint >>> 18) | 240);
                            bArr[i9 + 1] = (byte) (((codePoint >>> 12) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                            int i12 = i9 + 3;
                            bArr[i9 + 2] = (byte) (((codePoint >>> 6) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                            i9 += 4;
                            bArr[i12] = (byte) ((codePoint & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                            i8 = i11;
                        } else {
                            i8 = i11;
                        }
                    }
                    throw new zzaod(i8 - 1, length);
                }
                bArr[i9] = (byte) ((cCharAt2 >>> '\f') | 480);
                int i13 = i9 + 2;
                bArr[i9 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                i9 += 3;
                bArr[i13] = (byte) ((cCharAt2 & '?') | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
            }
            i8++;
        }
        return i9;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaob
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
            if (b3 < 0) {
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
                        return zzaoa.zza(bArr, i6, i5);
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
                    return zzaoa.zza(bArr, i6, i5);
                }
                int i9 = i4 + 2;
                byte b5 = bArr[i6];
                if (b5 <= -65 && ((b3 != -32 || b5 >= -96) && (b3 != -19 || b5 < -96))) {
                    i4 += 3;
                    if (bArr[i9] > -65) {
                    }
                }
                return -1;
            }
            i4 = i6;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaob
    final String zza(byte[] bArr, int i3, int i4) throws zzall {
        if ((i3 | i4 | ((bArr.length - i3) - i4)) >= 0) {
            int i5 = i3 + i4;
            char[] cArr = new char[i4];
            int i6 = 0;
            while (i3 < i5) {
                byte b3 = bArr[i3];
                if (b3 < 0) {
                    break;
                }
                i3++;
                zzaoc.zza(b3, cArr, i6);
                i6++;
            }
            int i7 = i6;
            while (i3 < i5) {
                int i8 = i3 + 1;
                byte b4 = bArr[i3];
                if (b4 >= 0) {
                    int i9 = i7 + 1;
                    zzaoc.zza(b4, cArr, i7);
                    int i10 = i8;
                    while (i10 < i5) {
                        byte b5 = bArr[i10];
                        if (b5 < 0) {
                            break;
                        }
                        i10++;
                        zzaoc.zza(b5, cArr, i9);
                        i9++;
                    }
                    i7 = i9;
                    i3 = i10;
                } else if (b4 < -32) {
                    if (i8 < i5) {
                        i3 += 2;
                        zzaoc.zza(b4, bArr[i8], cArr, i7);
                        i7++;
                    } else {
                        throw zzall.zzd();
                    }
                } else if (b4 < -16) {
                    if (i8 < i5 - 1) {
                        int i11 = i3 + 2;
                        i3 += 3;
                        zzaoc.zza(b4, bArr[i8], bArr[i11], cArr, i7);
                        i7++;
                    } else {
                        throw zzall.zzd();
                    }
                } else if (i8 < i5 - 2) {
                    byte b6 = bArr[i8];
                    int i12 = i3 + 3;
                    byte b7 = bArr[i3 + 2];
                    i3 += 4;
                    zzaoc.zza(b4, b6, b7, bArr[i12], cArr, i7);
                    i7 += 2;
                } else {
                    throw zzall.zzd();
                }
            }
            return new String(cArr, 0, i7);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i3), Integer.valueOf(i4)));
    }
}
