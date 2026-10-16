package com.google.common.base;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Ascii {
    public static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        int iB;
        int length = charSequence.length();
        if (charSequence == charSequence2) {
            return true;
        }
        if (length != charSequence2.length()) {
            return false;
        }
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = charSequence.charAt(i3);
            char cCharAt2 = charSequence2.charAt(i3);
            if (cCharAt != cCharAt2 && ((iB = b(cCharAt)) >= 26 || iB != b(cCharAt2))) {
                return false;
            }
        }
        return true;
    }

    private static int b(char c3) {
        return (char) ((c3 | ' ') - 97);
    }

    public static boolean c(char c3) {
        return c3 >= 'a' && c3 <= 'z';
    }

    public static boolean d(char c3) {
        return c3 >= 'A' && c3 <= 'Z';
    }

    public static String e(String str) {
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            if (d(str.charAt(i3))) {
                char[] charArray = str.toCharArray();
                while (i3 < length) {
                    char c3 = charArray[i3];
                    if (d(c3)) {
                        charArray[i3] = (char) (c3 ^ ' ');
                    }
                    i3++;
                }
                return String.valueOf(charArray);
            }
            i3++;
        }
        return str;
    }

    public static char f(char c3) {
        return c(c3) ? (char) (c3 ^ ' ') : c3;
    }

    public static String g(String str) {
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            if (c(str.charAt(i3))) {
                char[] charArray = str.toCharArray();
                while (i3 < length) {
                    char c3 = charArray[i3];
                    if (c(c3)) {
                        charArray[i3] = (char) (c3 ^ ' ');
                    }
                    i3++;
                }
                return String.valueOf(charArray);
            }
            i3++;
        }
        return str;
    }

    public static String h(CharSequence charSequence, int i3, String str) {
        Preconditions.t(charSequence);
        int length = i3 - str.length();
        Preconditions.i(length >= 0, "maxLength (%s) must be >= length of the truncation indicator (%s)", i3, str.length());
        int length2 = charSequence.length();
        CharSequence charSequence2 = charSequence;
        if (length2 <= i3) {
            String string = charSequence.toString();
            int length3 = string.length();
            charSequence2 = string;
            if (length3 <= i3) {
                return string;
            }
        }
        StringBuilder sb = new StringBuilder(i3);
        sb.append(charSequence2, 0, length);
        sb.append(str);
        return sb.toString();
    }
}
