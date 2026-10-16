package com.google.common.escape;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class UnicodeEscaper extends Escaper {
    protected UnicodeEscaper() {
    }

    protected static int b(CharSequence charSequence, int i3, int i4) {
        Preconditions.t(charSequence);
        if (i3 >= i4) {
            throw new IndexOutOfBoundsException("Index exceeds specified range");
        }
        int i5 = i3 + 1;
        char cCharAt = charSequence.charAt(i3);
        if (cCharAt < 55296 || cCharAt > 57343) {
            return cCharAt;
        }
        if (cCharAt > 56319) {
            throw new IllegalArgumentException("Unexpected low surrogate character '" + cCharAt + "' with value " + ((int) cCharAt) + " at index " + i3 + " in '" + ((Object) charSequence) + "'");
        }
        if (i5 == i4) {
            return -cCharAt;
        }
        char cCharAt2 = charSequence.charAt(i5);
        if (Character.isLowSurrogate(cCharAt2)) {
            return Character.toCodePoint(cCharAt, cCharAt2);
        }
        throw new IllegalArgumentException("Expected low surrogate but got char '" + cCharAt2 + "' with value " + ((int) cCharAt2) + " at index " + i5 + " in '" + ((Object) charSequence) + "'");
    }

    private static char[] e(char[] cArr, int i3, int i4) {
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
        int iF = f(str, 0, length);
        return iF == length ? str : d(str, iF);
    }

    protected abstract char[] c(int i3);

    protected final String d(String str, int i3) {
        int length = str.length();
        char[] cArrA = Platform.a();
        int i4 = 0;
        int length2 = 0;
        while (i3 < length) {
            int iB = b(str, i3, length);
            if (iB < 0) {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
            char[] cArrC = c(iB);
            int i5 = (Character.isSupplementaryCodePoint(iB) ? 2 : 1) + i3;
            if (cArrC != null) {
                int i6 = i3 - i4;
                int i7 = length2 + i6;
                int length3 = cArrC.length + i7;
                if (cArrA.length < length3) {
                    cArrA = e(cArrA, length2, length3 + (length - i3) + 32);
                }
                if (i6 > 0) {
                    str.getChars(i4, i3, cArrA, length2);
                    length2 = i7;
                }
                if (cArrC.length > 0) {
                    System.arraycopy(cArrC, 0, cArrA, length2, cArrC.length);
                    length2 += cArrC.length;
                }
                i4 = i5;
            }
            i3 = f(str, i5, length);
        }
        int i8 = length - i4;
        if (i8 > 0) {
            int i9 = i8 + length2;
            if (cArrA.length < i9) {
                cArrA = e(cArrA, length2, i9);
            }
            str.getChars(i4, length, cArrA, length2);
            length2 = i9;
        }
        return new String(cArrA, 0, length2);
    }

    protected int f(CharSequence charSequence, int i3, int i4) {
        while (i3 < i4) {
            int iB = b(charSequence, i3, i4);
            if (iB < 0 || c(iB) != null) {
                break;
            }
            i3 += Character.isSupplementaryCodePoint(iB) ? 2 : 1;
        }
        return i3;
    }
}
