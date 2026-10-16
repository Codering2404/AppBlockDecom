package com.google.android.gms.internal.measurement;

import com.applovin.exoplayer2.common.base.Ascii;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzos {
    public static final /* synthetic */ int zza = 0;

    static {
        if (zzop.zza() && zzop.zzb()) {
            int i3 = zzkv.zza;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0076 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x007a A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static boolean zza(byte[] r6, int r7, int r8) {
        /*
        L0:
            if (r7 >= r8) goto L9
            r0 = r6[r7]
            if (r0 < 0) goto L9
            int r7 = r7 + 1
            goto L0
        L9:
            if (r7 < r8) goto Ld
            goto L7a
        Ld:
            if (r7 >= r8) goto L7a
            int r0 = r7 + 1
            r1 = r6[r7]
            if (r1 >= 0) goto L78
            r2 = -32
            r3 = -65
            if (r1 >= r2) goto L29
            if (r0 < r8) goto L1e
            goto L57
        L1e:
            r2 = -62
            if (r1 < r2) goto L76
            int r7 = r7 + 2
            r0 = r6[r0]
            if (r0 <= r3) goto Ld
            goto L76
        L29:
            r4 = -16
            if (r1 >= r4) goto L4f
            int r4 = r8 + (-1)
            if (r0 < r4) goto L36
            int r1 = zzd(r6, r0, r8)
            goto L57
        L36:
            int r4 = r7 + 2
            r0 = r6[r0]
            if (r0 > r3) goto L76
            r5 = -96
            if (r1 != r2) goto L42
            if (r0 < r5) goto L76
        L42:
            r2 = -19
            if (r1 != r2) goto L48
            if (r0 >= r5) goto L76
        L48:
            int r7 = r7 + 3
            r0 = r6[r4]
            if (r0 <= r3) goto Ld
            goto L76
        L4f:
            int r2 = r8 + (-2)
            if (r0 < r2) goto L5a
            int r1 = zzd(r6, r0, r8)
        L57:
            if (r1 == 0) goto L7a
            goto L76
        L5a:
            int r2 = r7 + 2
            r0 = r6[r0]
            if (r0 > r3) goto L76
            int r1 = r1 << 28
            int r0 = r0 + 112
            int r1 = r1 + r0
            int r0 = r1 >> 30
            if (r0 != 0) goto L76
            int r0 = r7 + 3
            r1 = r6[r2]
            if (r1 > r3) goto L76
            int r7 = r7 + 4
            r0 = r6[r0]
            if (r0 > r3) goto L76
            goto Ld
        L76:
            r6 = 0
            return r6
        L78:
            r7 = r0
            goto Ld
        L7a:
            r6 = 1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzos.zza(byte[], int, int):boolean");
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
                                throw new zzor(i4, length2);
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
        long j3 = ((long) i5) + 4294967296L;
        StringBuilder sb = new StringBuilder(String.valueOf(j3).length() + 34);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(j3);
        throw new IllegalArgumentException(sb.toString());
    }

    static int zzc(String str, byte[] bArr, int i3, int i4) {
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
                        if (cCharAt2 >= 55296 && cCharAt2 <= 57343 && ((i6 = i8 + 1) == str.length() || !Character.isSurrogatePair(cCharAt2, str.charAt(i6)))) {
                            throw new zzor(i8, length);
                        }
                        StringBuilder sb = new StringBuilder(String.valueOf(cCharAt2).length() + 25 + String.valueOf(i9).length());
                        sb.append("Failed writing ");
                        sb.append(cCharAt2);
                        sb.append(" at index ");
                        sb.append(i9);
                        throw new ArrayIndexOutOfBoundsException(sb.toString());
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
                    throw new zzor(i8 - 1, length);
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

    static /* synthetic */ int zzd(byte[] bArr, int i3, int i4) {
        int i5 = i4 - i3;
        byte b3 = bArr[i3 - 1];
        if (i5 == 0) {
            if (b3 <= -12) {
                return b3;
            }
            return -1;
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
}
