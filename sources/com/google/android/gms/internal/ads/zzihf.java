package com.google.android.gms.internal.ads;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzihf {
    private static final zzihc zza;

    static {
        int i3 = zzicn.zza;
        zza = new zzihd();
    }

    static boolean zza(byte[] bArr) {
        return zza.zza(bArr, 0, bArr.length);
    }

    static boolean zzb(byte[] bArr, int i3, int i4) {
        return zza.zza(bArr, i3, i4);
    }

    static int zzc(String str) {
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
                try {
                    int length2 = str.length();
                    while (i4 < length2) {
                        char cCharAt2 = str.charAt(i4);
                        if (cCharAt2 < 2048) {
                            i3 += (127 - cCharAt2) >>> 31;
                        } else {
                            i3 += 2;
                            if (cCharAt2 >= 55296 && cCharAt2 <= 57343) {
                                if (Character.codePointAt(str, i4) < 65536) {
                                    throw new zzihe(i4, length2);
                                }
                                i4++;
                            }
                        }
                        i4++;
                    }
                    i5 += i3;
                } catch (zzihe unused) {
                    return str.getBytes(StandardCharsets.UTF_8).length;
                }
            }
        }
        if (i5 >= length) {
            return i5;
        }
        long j3 = ((long) i5) + 4294967296L;
        StringBuilder sb = new StringBuilder(String.valueOf(j3).length() + 34);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(j3);
        throw new IllegalArgumentException(sb.toString());
    }

    static int zzd(String str, byte[] bArr, int i3, int i4) {
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
                        return zzihc.zzb(str, bArr, i3, i4);
                    }
                    i8++;
                    if (i8 != str.length()) {
                        char cCharAt3 = str.charAt(i8);
                        if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                            int i10 = i9 + 3;
                            int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                            bArr[i9] = (byte) ((codePoint >>> 18) | 240);
                            bArr[i9 + 1] = (byte) (((codePoint >>> 12) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                            bArr[i9 + 2] = (byte) (((codePoint >>> 6) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                            i9 += 4;
                            bArr[i10] = (byte) ((codePoint & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                        }
                    }
                    return zzihc.zzb(str, bArr, i3, i4);
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

    static String zze(byte[] bArr, int i3, int i4) throws zziet {
        int i5;
        if (i4 == 0) {
            return "";
        }
        int length = bArr.length;
        if ((((length - i3) - i4) | i3 | i4) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(i3), Integer.valueOf(i4)));
        }
        int i6 = i3 + i4;
        char[] cArr = new char[i4];
        int i7 = 0;
        while (i3 < i6) {
            byte b3 = bArr[i3];
            if (!zzihb.zza(b3)) {
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
            if (zzihb.zza(b4)) {
                cArr[i8] = (char) b4;
                i8++;
                i3 = i9;
                while (i3 < i6) {
                    byte b5 = bArr[i3];
                    if (zzihb.zza(b5)) {
                        i3++;
                        cArr[i8] = (char) b5;
                        i8++;
                    }
                }
            } else {
                if (b4 < -32) {
                    if (i9 >= i6) {
                        throw new zziet("Protocol message had invalid UTF-8.");
                    }
                    i5 = i8 + 1;
                    i3 += 2;
                    zzihb.zzb(b4, bArr[i9], cArr, i8);
                } else if (b4 < -16) {
                    if (i9 >= i6 - 1) {
                        throw new zziet("Protocol message had invalid UTF-8.");
                    }
                    i5 = i8 + 1;
                    int i10 = i3 + 2;
                    i3 += 3;
                    zzihb.zzc(b4, bArr[i9], bArr[i10], cArr, i8);
                } else {
                    if (i9 >= i6 - 2) {
                        throw new zziet("Protocol message had invalid UTF-8.");
                    }
                    byte b6 = bArr[i9];
                    int i11 = i3 + 3;
                    byte b7 = bArr[i3 + 2];
                    i3 += 4;
                    zzihb.zzd(b4, b6, b7, bArr[i11], cArr, i8);
                    i8 += 2;
                }
                i8 = i5;
            }
        }
        return new String(cArr, 0, i8);
    }
}
