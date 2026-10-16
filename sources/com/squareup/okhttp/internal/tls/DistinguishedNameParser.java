package com.squareup.okhttp.internal.tls;

import javax.security.auth.x500.X500Principal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
final class DistinguishedNameParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f93440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f93441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f93442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f93443d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f93444e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f93445f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private char[] f93446g;

    public DistinguishedNameParser(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f93440a = name;
        this.f93441b = name.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0051, code lost:
    
        r2 = r8.f93443d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005b, code lost:
    
        return new java.lang.String(r1, r2, r8.f93444e - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a() {
        /*
            r8 = this;
            int r0 = r8.f93442c
            r8.f93443d = r0
            r8.f93444e = r0
        L6:
            int r0 = r8.f93442c
            int r1 = r8.f93441b
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f93446g
            int r2 = r8.f93443d
            int r3 = r8.f93444e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.f93446g
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L5c
            if (r2 == r5) goto L51
            r5 = 92
            if (r2 == r5) goto L3e
            if (r2 == r4) goto L51
            if (r2 == r3) goto L51
            int r3 = r8.f93444e
            int r4 = r3 + 1
            r8.f93444e = r4
            r1[r3] = r2
            int r0 = r0 + 1
            r8.f93442c = r0
            goto L6
        L3e:
            int r0 = r8.f93444e
            int r2 = r0 + 1
            r8.f93444e = r2
            char r2 = r8.d()
            r1[r0] = r2
            int r0 = r8.f93442c
            int r0 = r0 + 1
            r8.f93442c = r0
            goto L6
        L51:
            java.lang.String r0 = new java.lang.String
            int r2 = r8.f93443d
            int r3 = r8.f93444e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L5c:
            int r2 = r8.f93444e
            r8.f93445f = r2
            int r0 = r0 + 1
            r8.f93442c = r0
            int r0 = r2 + 1
            r8.f93444e = r0
            r1[r2] = r6
        L6a:
            int r0 = r8.f93442c
            int r1 = r8.f93441b
            if (r0 >= r1) goto L83
            char[] r2 = r8.f93446g
            char r7 = r2[r0]
            if (r7 != r6) goto L83
            int r1 = r8.f93444e
            int r7 = r1 + 1
            r8.f93444e = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.f93442c = r0
            goto L6a
        L83:
            if (r0 == r1) goto L8f
            char[] r1 = r8.f93446g
            char r0 = r1[r0]
            if (r0 == r3) goto L8f
            if (r0 == r4) goto L8f
            if (r0 != r5) goto L6
        L8f:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f93446g
            int r2 = r8.f93443d
            int r3 = r8.f93445f
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.tls.DistinguishedNameParser.a():java.lang.String");
    }

    private int c(int i3) {
        int i4;
        int i5;
        int i6 = i3 + 1;
        if (i6 >= this.f93441b) {
            throw new IllegalStateException("Malformed DN: " + this.f93440a);
        }
        char[] cArr = this.f93446g;
        char c3 = cArr[i3];
        if (c3 >= '0' && c3 <= '9') {
            i4 = c3 - '0';
        } else if (c3 >= 'a' && c3 <= 'f') {
            i4 = c3 - 'W';
        } else {
            if (c3 < 'A' || c3 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f93440a);
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
                throw new IllegalStateException("Malformed DN: " + this.f93440a);
            }
            i5 = c4 - '7';
        }
        return (i4 << 4) + i5;
    }

    private char d() {
        int i3 = this.f93442c + 1;
        this.f93442c = i3;
        if (i3 == this.f93441b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f93440a);
        }
        char c3 = this.f93446g[i3];
        if (c3 == ' ' || c3 == '%' || c3 == '\\' || c3 == '_' || c3 == '\"' || c3 == '#') {
            return c3;
        }
        switch (c3) {
            case '*':
            case '+':
            case ',':
                return c3;
            default:
                switch (c3) {
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                        return c3;
                    default:
                        return e();
                }
        }
    }

    private char e() {
        int i3;
        int i4;
        int iC = c(this.f93442c);
        this.f93442c++;
        if (iC < 128) {
            return (char) iC;
        }
        if (iC < 192 || iC > 247) {
            return '?';
        }
        if (iC <= 223) {
            i3 = iC & 31;
            i4 = 1;
        } else if (iC <= 239) {
            i3 = iC & 15;
            i4 = 2;
        } else {
            i3 = iC & 7;
            i4 = 3;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = this.f93442c;
            int i7 = i6 + 1;
            this.f93442c = i7;
            if (i7 == this.f93441b || this.f93446g[i7] != '\\') {
                return '?';
            }
            int i8 = i6 + 2;
            this.f93442c = i8;
            int iC2 = c(i8);
            this.f93442c++;
            if ((iC2 & 192) != 128) {
                return '?';
            }
            i3 = (i3 << 6) + (iC2 & 63);
        }
        return (char) i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
    
        r6.f93444e = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String f() {
        /*
            r6 = this;
            int r0 = r6.f93442c
            int r1 = r0 + 4
            int r2 = r6.f93441b
            java.lang.String r3 = "Unexpected end of DN: "
            if (r1 >= r2) goto L98
            r6.f93443d = r0
            int r0 = r0 + 1
            r6.f93442c = r0
        L10:
            int r0 = r6.f93442c
            int r1 = r6.f93441b
            if (r0 == r1) goto L54
            char[] r1 = r6.f93446g
            char r2 = r1[r0]
            r4 = 43
            if (r2 == r4) goto L54
            r4 = 44
            if (r2 == r4) goto L54
            r4 = 59
            if (r2 != r4) goto L27
            goto L54
        L27:
            r4 = 32
            if (r2 != r4) goto L42
            r6.f93444e = r0
            int r0 = r0 + 1
            r6.f93442c = r0
        L31:
            int r0 = r6.f93442c
            int r1 = r6.f93441b
            if (r0 >= r1) goto L56
            char[] r1 = r6.f93446g
            char r1 = r1[r0]
            if (r1 != r4) goto L56
            int r0 = r0 + 1
            r6.f93442c = r0
            goto L31
        L42:
            r4 = 65
            if (r2 < r4) goto L4f
            r4 = 70
            if (r2 > r4) goto L4f
            int r2 = r2 + 32
            char r2 = (char) r2
            r1[r0] = r2
        L4f:
            int r0 = r0 + 1
            r6.f93442c = r0
            goto L10
        L54:
            r6.f93444e = r0
        L56:
            int r0 = r6.f93444e
            int r1 = r6.f93443d
            int r0 = r0 - r1
            r2 = 5
            if (r0 < r2) goto L81
            r2 = r0 & 1
            if (r2 == 0) goto L81
            int r2 = r0 / 2
            byte[] r3 = new byte[r2]
            int r1 = r1 + 1
            r4 = 0
        L69:
            if (r4 >= r2) goto L77
            int r5 = r6.c(r1)
            byte r5 = (byte) r5
            r3[r4] = r5
            int r1 = r1 + 2
            int r4 = r4 + 1
            goto L69
        L77:
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.f93446g
            int r3 = r6.f93443d
            r1.<init>(r2, r3, r0)
            return r1
        L81:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r2 = r6.f93440a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L98:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r2 = r6.f93440a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.tls.DistinguishedNameParser.f():java.lang.String");
    }

    private String g() {
        int i3;
        int i4;
        int i5;
        int i6;
        char c3;
        int i7;
        int i8;
        char c4;
        char c5;
        while (true) {
            i3 = this.f93442c;
            i4 = this.f93441b;
            if (i3 >= i4 || this.f93446g[i3] != ' ') {
                break;
            }
            this.f93442c = i3 + 1;
        }
        if (i3 == i4) {
            return null;
        }
        this.f93443d = i3;
        this.f93442c = i3 + 1;
        while (true) {
            i5 = this.f93442c;
            i6 = this.f93441b;
            if (i5 >= i6 || (c5 = this.f93446g[i5]) == '=' || c5 == ' ') {
                break;
            }
            this.f93442c = i5 + 1;
        }
        if (i5 >= i6) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f93440a);
        }
        this.f93444e = i5;
        if (this.f93446g[i5] == ' ') {
            while (true) {
                i7 = this.f93442c;
                i8 = this.f93441b;
                if (i7 >= i8 || (c4 = this.f93446g[i7]) == '=' || c4 != ' ') {
                    break;
                }
                this.f93442c = i7 + 1;
            }
            if (this.f93446g[i7] != '=' || i7 == i8) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f93440a);
            }
        }
        this.f93442c++;
        while (true) {
            int i9 = this.f93442c;
            if (i9 >= this.f93441b || this.f93446g[i9] != ' ') {
                break;
            }
            this.f93442c = i9 + 1;
        }
        int i10 = this.f93444e;
        int i11 = this.f93443d;
        if (i10 - i11 > 4) {
            char[] cArr = this.f93446g;
            if (cArr[i11 + 3] == '.' && (((c3 = cArr[i11]) == 'O' || c3 == 'o') && ((cArr[i11 + 1] == 'I' || cArr[i11 + 1] == 'i') && (cArr[i11 + 2] == 'D' || cArr[i11 + 2] == 'd')))) {
                this.f93443d = i11 + 4;
            }
        }
        char[] cArr2 = this.f93446g;
        int i12 = this.f93443d;
        return new String(cArr2, i12, i10 - i12);
    }

    private String h() {
        int i3 = this.f93442c + 1;
        this.f93442c = i3;
        this.f93443d = i3;
        this.f93444e = i3;
        while (true) {
            int i4 = this.f93442c;
            if (i4 == this.f93441b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f93440a);
            }
            char[] cArr = this.f93446g;
            char c3 = cArr[i4];
            if (c3 == '\"') {
                this.f93442c = i4 + 1;
                while (true) {
                    int i5 = this.f93442c;
                    if (i5 >= this.f93441b || this.f93446g[i5] != ' ') {
                        break;
                    }
                    this.f93442c = i5 + 1;
                }
                char[] cArr2 = this.f93446g;
                int i6 = this.f93443d;
                return new String(cArr2, i6, this.f93444e - i6);
            }
            if (c3 == '\\') {
                cArr[this.f93444e] = d();
            } else {
                cArr[this.f93444e] = c3;
            }
            this.f93442c++;
            this.f93444e++;
        }
    }

    public String b(String str) {
        this.f93442c = 0;
        this.f93443d = 0;
        this.f93444e = 0;
        this.f93445f = 0;
        this.f93446g = this.f93440a.toCharArray();
        String strG = g();
        if (strG == null) {
            return null;
        }
        do {
            int i3 = this.f93442c;
            if (i3 == this.f93441b) {
                return null;
            }
            char c3 = this.f93446g[i3];
            String strA = c3 != '\"' ? c3 != '#' ? (c3 == '+' || c3 == ',' || c3 == ';') ? "" : a() : f() : h();
            if (str.equalsIgnoreCase(strG)) {
                return strA;
            }
            int i4 = this.f93442c;
            if (i4 >= this.f93441b) {
                return null;
            }
            char c4 = this.f93446g[i4];
            if (c4 != ',' && c4 != ';' && c4 != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f93440a);
            }
            this.f93442c = i4 + 1;
            strG = g();
        } while (strG != null);
        throw new IllegalStateException("Malformed DN: " + this.f93440a);
    }
}
