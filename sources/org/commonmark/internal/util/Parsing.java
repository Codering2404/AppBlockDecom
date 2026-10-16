package org.commonmark.internal.util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class Parsing {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f145510a = 4;

    public static int a(int i3) {
        return 4 - (i3 % 4);
    }

    public static int b(char c3, CharSequence charSequence, int i3) {
        int length = charSequence.length();
        while (i3 < length) {
            if (charSequence.charAt(i3) == c3) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public static int c(CharSequence charSequence, int i3) {
        int length = charSequence.length();
        while (i3 < length) {
            char cCharAt = charSequence.charAt(i3);
            if (cCharAt == '\n' || cCharAt == '\r') {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    private static int d(CharSequence charSequence, int i3) {
        int length = charSequence.length();
        while (i3 < length) {
            char cCharAt = charSequence.charAt(i3);
            if (cCharAt != ' ') {
                switch (cCharAt) {
                    case '\t':
                    case '\n':
                    case 11:
                    case '\f':
                    case '\r':
                        break;
                    default:
                        return i3;
                }
            }
            i3++;
        }
        return -1;
    }

    public static boolean e(CharSequence charSequence) {
        int length = charSequence.length();
        return m(' ', charSequence, 0, length) != length;
    }

    public static boolean f(CharSequence charSequence) {
        return d(charSequence, 0) == -1;
    }

    public static boolean g(char c3) {
        switch (c3) {
            case '!':
            case '\"':
            case '#':
            case '$':
            case '%':
            case '&':
            case '\'':
            case '(':
            case ')':
            case '*':
            case '+':
            case ',':
            case '-':
            case '.':
            case '/':
                return true;
            default:
                switch (c3) {
                    case ':':
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                    case '?':
                    case '@':
                        return true;
                    default:
                        switch (c3) {
                            case '[':
                            case '\\':
                            case ']':
                            case '^':
                            case '_':
                            case '`':
                                return true;
                            default:
                                switch (c3) {
                                    case '{':
                                    case '|':
                                    case '}':
                                    case '~':
                                        return true;
                                    default:
                                        return false;
                                }
                        }
                }
        }
    }

    public static boolean h(CharSequence charSequence, int i3) {
        return Character.isLetter(Character.codePointAt(charSequence, i3));
    }

    public static boolean i(int i3) {
        int type = Character.getType(i3);
        if (type != 29 && type != 30) {
            switch (type) {
                default:
                    if (i3 != 36 && i3 != 43 && i3 != 94 && i3 != 96 && i3 != 124 && i3 != 126) {
                        switch (i3) {
                            case 60:
                            case 61:
                            case 62:
                                break;
                            default:
                                return false;
                        }
                    }
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                    return true;
            }
        }
        return true;
    }

    public static boolean j(CharSequence charSequence, int i3) {
        if (i3 >= charSequence.length()) {
            return false;
        }
        char cCharAt = charSequence.charAt(i3);
        return cCharAt == '\t' || cCharAt == ' ';
    }

    public static boolean k(int i3) {
        return i3 == 9 || i3 == 10 || i3 == 12 || i3 == 13 || i3 == 32 || Character.getType(i3) == 12;
    }

    public static CharSequence l(CharSequence charSequence) {
        int length = charSequence.length();
        StringBuilder sb = null;
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = charSequence.charAt(i3);
            if (cCharAt == 0) {
                if (sb == null) {
                    sb = new StringBuilder(length);
                    sb.append(charSequence, 0, i3);
                }
                sb.append((char) 65533);
            } else if (sb != null) {
                sb.append(cCharAt);
            }
        }
        return sb != null ? sb.toString() : charSequence;
    }

    public static int m(char c3, CharSequence charSequence, int i3, int i4) {
        while (i3 < i4) {
            if (charSequence.charAt(i3) != c3) {
                return i3;
            }
            i3++;
        }
        return i4;
    }

    public static int n(char c3, CharSequence charSequence, int i3, int i4) {
        while (i3 >= i4) {
            if (charSequence.charAt(i3) != c3) {
                return i3;
            }
            i3--;
        }
        return i4 - 1;
    }

    public static int o(CharSequence charSequence, int i3, int i4) {
        while (i3 < i4) {
            char cCharAt = charSequence.charAt(i3);
            if (cCharAt != '\t' && cCharAt != ' ') {
                return i3;
            }
            i3++;
        }
        return i4;
    }

    public static int p(CharSequence charSequence, int i3, int i4) {
        while (i3 >= i4) {
            char cCharAt = charSequence.charAt(i3);
            if (cCharAt != '\t' && cCharAt != ' ') {
                return i3;
            }
            i3--;
        }
        return i4 - 1;
    }
}
