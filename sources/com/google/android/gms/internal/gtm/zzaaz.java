package com.google.android.gms.internal.gtm;

import com.applovin.exoplayer2.common.base.Ascii;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaaz {
    private static final zzaaw zza;

    static {
        if (zzaau.zzx() && zzaau.zzy()) {
            int i3 = zzto.zza;
        }
        zza = new zzaax();
    }

    static /* bridge */ /* synthetic */ int zza(byte[] bArr, int i3, int i4) {
        int i5 = i4 - i3;
        byte b3 = bArr[i3 - 1];
        if (i5 == 0) {
            if (b3 > -12) {
                return -1;
            }
            return b3;
        }
        if (i5 == 1) {
            byte b4 = bArr[i3];
            if (b3 > -12 || b4 > -65) {
                return -1;
            }
            return (b4 << 8) ^ b3;
        }
        if (i5 != 2) {
            throw new AssertionError();
        }
        byte b5 = bArr[i3];
        byte b6 = bArr[i3 + 1];
        if (b3 > -12 || b5 > -65 || b6 > -65) {
            return -1;
        }
        return (b6 << Ascii.DLE) ^ ((b5 << 8) ^ b3);
    }

    static int zzb(CharSequence charSequence, byte[] bArr, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        char cCharAt;
        int length = charSequence.length();
        int i8 = 0;
        while (true) {
            i5 = i3 + i4;
            if (i8 >= length || (i7 = i8 + i3) >= i5 || (cCharAt = charSequence.charAt(i8)) >= 128) {
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
            char cCharAt2 = charSequence.charAt(i8);
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
                        if (cCharAt2 >= 55296 && cCharAt2 <= 57343 && ((i6 = i8 + 1) == charSequence.length() || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i6)))) {
                            throw new zzaay(i8, length);
                        }
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i9);
                    }
                    int i10 = i8 + 1;
                    if (i10 != charSequence.length()) {
                        char cCharAt3 = charSequence.charAt(i10);
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
                    throw new zzaay(i8 - 1, length);
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

    static int zzc(CharSequence charSequence) {
        int length = charSequence.length();
        int i3 = 0;
        int i4 = 0;
        while (i4 < length && charSequence.charAt(i4) < 128) {
            i4++;
        }
        int i5 = length;
        while (true) {
            if (i4 >= length) {
                break;
            }
            char cCharAt = charSequence.charAt(i4);
            if (cCharAt < 2048) {
                i5 += (127 - cCharAt) >>> 31;
                i4++;
            } else {
                int length2 = charSequence.length();
                while (i4 < length2) {
                    char cCharAt2 = charSequence.charAt(i4);
                    if (cCharAt2 < 2048) {
                        i3 += (127 - cCharAt2) >>> 31;
                    } else {
                        i3 += 2;
                        if (cCharAt2 >= 55296 && cCharAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i4) < 65536) {
                                throw new zzaay(i4, length2);
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

    static String zzd(byte[] bArr, int i3, int i4) throws zzyg {
        int i5;
        int length = bArr.length;
        if ((((length - i3) - i4) | i3 | i4) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(i3), Integer.valueOf(i4)));
        }
        int i6 = i3 + i4;
        char[] cArr = new char[i4];
        int i7 = 0;
        while (i3 < i6) {
            byte b3 = bArr[i3];
            if (!zzaav.zzd(b3)) {
                break;
            }
            i3++;
            cArr[i7] = (char) b3;
            i7++;
        }
        int i8 = i7;
        while (i3 < i6) {
            int i9 = i3 + 1;
            byte b4 = bArr[i3];
            if (zzaav.zzd(b4)) {
                cArr[i8] = (char) b4;
                i8++;
                i3 = i9;
                while (i3 < i6) {
                    byte b5 = bArr[i3];
                    if (zzaav.zzd(b5)) {
                        i3++;
                        cArr[i8] = (char) b5;
                        i8++;
                    }
                }
            } else {
                if (b4 < -32) {
                    if (i9 >= i6) {
                        throw zzyg.zzd();
                    }
                    i5 = i8 + 1;
                    i3 += 2;
                    zzaav.zzc(b4, bArr[i9], cArr, i8);
                } else if (b4 < -16) {
                    if (i9 >= i6 - 1) {
                        throw zzyg.zzd();
                    }
                    i5 = i8 + 1;
                    int i10 = i3 + 2;
                    i3 += 3;
                    zzaav.zzb(b4, bArr[i9], bArr[i10], cArr, i8);
                } else {
                    if (i9 >= i6 - 2) {
                        throw zzyg.zzd();
                    }
                    byte b6 = bArr[i9];
                    int i11 = i3 + 3;
                    byte b7 = bArr[i3 + 2];
                    i3 += 4;
                    zzaav.zza(b4, b6, b7, bArr[i11], cArr, i8);
                    i8 += 2;
                }
                i8 = i5;
            }
        }
        return new String(cArr, 0, i8);
    }

    static boolean zze(byte[] bArr) {
        return zza.zzb(bArr, 0, bArr.length);
    }

    static boolean zzf(byte[] bArr, int i3, int i4) {
        return zza.zzb(bArr, i3, i4);
    }
}
