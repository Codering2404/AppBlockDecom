package com.google.common.escape;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class CharEscaper extends Escaper {
    protected CharEscaper() {
    }

    private static char[] d(char[] cArr, int i3, int i4) {
        if (i4 < 0) {
            throw new AssertionError("Cannot increase internal buffer any further");
        }
        char[] cArr2 = new char[i4];
        if (i3 > 0) {
            System.arraycopy(cArr, 0, cArr2, 0, i3);
        }
        return cArr2;
    }

    @Override // com.google.common.escape.Escaper
    public String a(String str) {
        Preconditions.t(str);
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (b(str.charAt(i3)) != null) {
                return c(str, i3);
            }
        }
        return str;
    }

    protected abstract char[] b(char c3);

    protected final String c(String str, int i3) {
        int length = str.length();
        char[] cArrA = Platform.a();
        int length2 = cArrA.length;
        int i4 = 0;
        int i5 = 0;
        while (i3 < length) {
            char[] cArrB = b(str.charAt(i3));
            if (cArrB != null) {
                int length3 = cArrB.length;
                int i6 = i3 - i4;
                int i7 = i5 + i6;
                int i8 = i7 + length3;
                if (length2 < i8) {
                    length2 = ((length - i3) * 2) + i8;
                    cArrA = d(cArrA, i5, length2);
                }
                if (i6 > 0) {
                    str.getChars(i4, i3, cArrA, i5);
                    i5 = i7;
                }
                if (length3 > 0) {
                    System.arraycopy(cArrB, 0, cArrA, i5, length3);
                    i5 += length3;
                }
                i4 = i3 + 1;
            }
            i3++;
        }
        int i9 = length - i4;
        if (i9 > 0) {
            int i10 = i9 + i5;
            if (length2 < i10) {
                cArrA = d(cArrA, i5, i10);
            }
            str.getChars(i4, length, cArrA, i5);
            i5 = i10;
        }
        return new String(cArrA, 0, i5);
    }
}
