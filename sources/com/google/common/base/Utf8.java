package com.google.common.base;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Utf8 {
    public static int a(CharSequence charSequence) {
        int length = charSequence.length();
        int i3 = 0;
        while (i3 < length && charSequence.charAt(i3) < 128) {
            i3++;
        }
        int iB = length;
        while (true) {
            if (i3 < length) {
                char cCharAt = charSequence.charAt(i3);
                if (cCharAt >= 2048) {
                    iB += b(charSequence, i3);
                    break;
                }
                iB += (127 - cCharAt) >>> 31;
                i3++;
            } else {
                break;
            }
        }
        if (iB >= length) {
            return iB;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) iB) + 4294967296L));
    }

    private static int b(CharSequence charSequence, int i3) {
        int length = charSequence.length();
        int i4 = 0;
        while (i3 < length) {
            char cCharAt = charSequence.charAt(i3);
            if (cCharAt < 2048) {
                i4 += (127 - cCharAt) >>> 31;
            } else {
                i4 += 2;
                if (55296 <= cCharAt && cCharAt <= 57343) {
                    if (Character.codePointAt(charSequence, i3) == cCharAt) {
                        throw new IllegalArgumentException(c(i3));
                    }
                    i3++;
                }
            }
            i3++;
        }
        return i4;
    }

    private static String c(int i3) {
        return "Unpaired surrogate at index " + i3;
    }
}
