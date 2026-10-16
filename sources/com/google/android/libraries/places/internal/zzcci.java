package com.google.android.libraries.places.internal;

import javax.security.auth.x500.X500Principal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcci {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f77554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f77555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f77556c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f77557d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f77558e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f77559f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private char[] f77560g;

    public zzcci(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f77554a = name;
        this.f77555b = name.length();
    }

    private final String b() {
        int i3;
        int i4;
        int i5;
        char c3;
        char c4;
        char c5;
        char c6;
        char c7;
        while (true) {
            i3 = this.f77556c;
            i4 = this.f77555b;
            if (i3 >= i4 || this.f77560g[i3] != ' ') {
                break;
            }
            this.f77556c = i3 + 1;
        }
        if (i3 == i4) {
            return null;
        }
        this.f77557d = i3;
        this.f77556c = i3 + 1;
        while (true) {
            i5 = this.f77556c;
            if (i5 >= i4 || (c7 = this.f77560g[i5]) == '=' || c7 == ' ') {
                break;
            }
            this.f77556c = i5 + 1;
        }
        if (i5 >= i4) {
            throw new IllegalStateException("Unexpected end of DN: ".concat(String.valueOf(this.f77554a)));
        }
        this.f77558e = i5;
        if (this.f77560g[i5] == ' ') {
            while (true) {
                i5 = this.f77556c;
                if (i5 >= i4 || (c6 = this.f77560g[i5]) == '=' || c6 != ' ') {
                    break;
                }
                this.f77556c = i5 + 1;
            }
            if (this.f77560g[i5] != '=' || i5 == i4) {
                throw new IllegalStateException("Unexpected end of DN: ".concat(String.valueOf(this.f77554a)));
            }
        }
        this.f77556c = i5 + 1;
        while (true) {
            int i6 = this.f77556c;
            if (i6 >= i4 || this.f77560g[i6] != ' ') {
                break;
            }
            this.f77556c = i6 + 1;
        }
        int i7 = this.f77558e;
        int i8 = this.f77557d;
        if (i7 - i8 > 4) {
            char[] cArr = this.f77560g;
            if (cArr[i8 + 3] == '.' && (((c3 = cArr[i8]) == 'O' || c3 == 'o') && (((c4 = cArr[i8 + 1]) == 'I' || c4 == 'i') && ((c5 = cArr[i8 + 2]) == 'D' || c5 == 'd')))) {
                i8 += 4;
                this.f77557d = i8;
            }
        }
        return new String(this.f77560g, i8, i7 - i8);
    }

    private final char c() {
        int i3;
        int i4;
        int i5 = this.f77556c + 1;
        this.f77556c = i5;
        int i6 = this.f77555b;
        if (i5 == i6) {
            throw new IllegalStateException("Unexpected end of DN: ".concat(String.valueOf(this.f77554a)));
        }
        char c3 = this.f77560g[i5];
        if (c3 != ' ' && c3 != '%' && c3 != '\\' && c3 != '_' && c3 != '\"' && c3 != '#') {
            switch (c3) {
                default:
                    switch (c3) {
                        case ';':
                        case '<':
                        case '=':
                        case '>':
                            break;
                        default:
                            int iD = d(i5);
                            this.f77556c++;
                            if (iD >= 128) {
                                if (iD < 192 || iD > 247) {
                                    iD = 63;
                                } else {
                                    if (iD <= 223) {
                                        i3 = iD & 31;
                                        i4 = 1;
                                    } else if (iD <= 239) {
                                        i3 = iD & 15;
                                        i4 = 2;
                                    } else {
                                        i3 = iD & 7;
                                        i4 = 3;
                                    }
                                    for (int i7 = 0; i7 < i4; i7++) {
                                        int i8 = this.f77556c;
                                        int i9 = i8 + 1;
                                        this.f77556c = i9;
                                        if (i9 != i6 && this.f77560g[i9] == '\\') {
                                            int i10 = i8 + 2;
                                            this.f77556c = i10;
                                            int iD2 = d(i10);
                                            this.f77556c++;
                                            if ((iD2 & 192) == 128) {
                                                i3 = (i3 << 6) + (iD2 & 63);
                                            }
                                        }
                                        iD = 63;
                                    }
                                    iD = (char) i3;
                                }
                            }
                            return (char) iD;
                    }
                case '*':
                case '+':
                case ',':
                    return c3;
            }
        }
        return c3;
    }

    private final int d(int i3) {
        int i4;
        int i5;
        int i6 = i3 + 1;
        if (i6 >= this.f77555b) {
            throw new IllegalStateException("Malformed DN: ".concat(String.valueOf(this.f77554a)));
        }
        char[] cArr = this.f77560g;
        char c3 = cArr[i3];
        if (c3 >= '0' && c3 <= '9') {
            i4 = c3 - '0';
        } else if (c3 >= 'a' && c3 <= 'f') {
            i4 = c3 - 'W';
        } else {
            if (c3 < 'A' || c3 > 'F') {
                throw new IllegalStateException("Malformed DN: ".concat(String.valueOf(this.f77554a)));
            }
            i4 = c3 - '7';
        }
        char c4 = cArr[i6];
        if (c4 >= '0' && c4 <= '9') {
            i5 = c4 - '0';
        } else if (c4 >= 'a' && c4 <= 'f') {
            i5 = c4 - 'W';
        } else {
            if (c4 < 'A' || c4 > 'F') {
                throw new IllegalStateException("Malformed DN: ".concat(String.valueOf(this.f77554a)));
            }
            i5 = c4 - '7';
        }
        return (i4 << 4) + i5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0081, code lost:
    
        r6 = r14.f77557d;
        r3 = new java.lang.String(r5, r6, r14.f77558e - r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0110, code lost:
    
        r14.f77558e = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String a(java.lang.String r15) {
        /*
            Method dump skipped, instruction units count: 487
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzcci.a(java.lang.String):java.lang.String");
    }
}
