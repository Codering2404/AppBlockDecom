package com.google.gson.stream;

import com.facebook.internal.ServerProtocol;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class JsonReader implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Reader f90545a;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f90553j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f90554k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f90555l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int[] f90556m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String[] f90558o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int[] f90559p;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f90546b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final char[] f90547c = new char[1024];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f90548d = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f90549f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f90550g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f90551h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f90552i = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f90557n = 1;

    static {
        JsonReaderInternalAccess.f90355a = new JsonReaderInternalAccess() { // from class: com.google.gson.stream.JsonReader.1
            @Override // com.google.gson.internal.JsonReaderInternalAccess
            public void a(JsonReader jsonReader) throws IOException {
                if (jsonReader instanceof JsonTreeReader) {
                    ((JsonTreeReader) jsonReader).B1();
                    return;
                }
                int i3 = jsonReader.f90552i;
                if (i3 == 0) {
                    i3 = jsonReader.i();
                }
                if (i3 == 13) {
                    jsonReader.f90552i = 9;
                    return;
                }
                if (i3 == 12) {
                    jsonReader.f90552i = 8;
                    return;
                }
                if (i3 == 14) {
                    jsonReader.f90552i = 10;
                    return;
                }
                throw new IllegalStateException("Expected a name but was " + jsonReader.j0() + jsonReader.F());
            }
        };
    }

    public JsonReader(Reader reader) {
        int[] iArr = new int[32];
        this.f90556m = iArr;
        iArr[0] = 6;
        this.f90558o = new String[32];
        this.f90559p = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.f90545a = reader;
    }

    private char A0() throws IOException {
        int i3;
        if (this.f90548d == this.f90549f && !l(1)) {
            throw i1("Unterminated escape sequence");
        }
        char[] cArr = this.f90547c;
        int i4 = this.f90548d;
        int i5 = i4 + 1;
        this.f90548d = i5;
        char c3 = cArr[i4];
        if (c3 == '\n') {
            this.f90550g++;
            this.f90551h = i5;
            return c3;
        }
        if (c3 == '\"' || c3 == '\'' || c3 == '/' || c3 == '\\') {
            return c3;
        }
        if (c3 == 'b') {
            return '\b';
        }
        if (c3 == 'f') {
            return '\f';
        }
        if (c3 == 'n') {
            return '\n';
        }
        if (c3 == 'r') {
            return '\r';
        }
        if (c3 == 't') {
            return '\t';
        }
        if (c3 != 'u') {
            throw i1("Invalid escape sequence");
        }
        if (i4 + 5 > this.f90549f && !l(4)) {
            throw i1("Unterminated escape sequence");
        }
        int i6 = this.f90548d;
        int i7 = i6 + 4;
        char c4 = 0;
        while (i6 < i7) {
            char c5 = this.f90547c[i6];
            char c6 = (char) (c4 << 4);
            if (c5 >= '0' && c5 <= '9') {
                i3 = c5 - '0';
            } else if (c5 >= 'a' && c5 <= 'f') {
                i3 = c5 - 'W';
            } else {
                if (c5 < 'A' || c5 > 'F') {
                    throw new NumberFormatException("\\u" + new String(this.f90547c, this.f90548d, 4));
                }
                i3 = c5 - '7';
            }
            c4 = (char) (c6 + i3);
            i6++;
        }
        this.f90548d += 4;
        return c4;
    }

    private boolean C(char c3) throws IOException {
        if (c3 == '\t' || c3 == '\n' || c3 == '\f' || c3 == '\r' || c3 == ' ') {
            return false;
        }
        if (c3 != '#') {
            if (c3 == ',') {
                return false;
            }
            if (c3 != '/' && c3 != '=') {
                if (c3 == '{' || c3 == '}' || c3 == ':') {
                    return false;
                }
                if (c3 != ';') {
                    switch (c3) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        c();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0076, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int O(boolean r9) throws java.io.IOException {
        /*
            r8 = this;
            char[] r0 = r8.f90547c
            int r1 = r8.f90548d
            int r2 = r8.f90549f
        L6:
            r3 = 1
            if (r1 != r2) goto L34
            r8.f90548d = r1
            boolean r1 = r8.l(r3)
            if (r1 != 0) goto L30
            if (r9 != 0) goto L15
            r9 = -1
            return r9
        L15:
            java.io.EOFException r9 = new java.io.EOFException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "End of input"
            r0.append(r1)
            java.lang.String r1 = r8.F()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r9.<init>(r0)
            throw r9
        L30:
            int r1 = r8.f90548d
            int r2 = r8.f90549f
        L34:
            int r4 = r1 + 1
            char r5 = r0[r1]
            r6 = 10
            if (r5 != r6) goto L45
            int r1 = r8.f90550g
            int r1 = r1 + r3
            r8.f90550g = r1
            r8.f90551h = r4
            goto Lb2
        L45:
            r6 = 32
            if (r5 == r6) goto Lb2
            r6 = 13
            if (r5 == r6) goto Lb2
            r6 = 9
            if (r5 != r6) goto L52
            goto Lb2
        L52:
            r6 = 47
            if (r5 != r6) goto L9d
            r8.f90548d = r4
            r7 = 2
            if (r4 != r2) goto L69
            r8.f90548d = r1
            boolean r1 = r8.l(r7)
            int r2 = r8.f90548d
            int r2 = r2 + r3
            r8.f90548d = r2
            if (r1 != 0) goto L69
            goto L76
        L69:
            r8.c()
            int r1 = r8.f90548d
            char r2 = r0[r1]
            r3 = 42
            if (r2 == r3) goto L83
            if (r2 == r6) goto L77
        L76:
            return r5
        L77:
            int r1 = r1 + 1
            r8.f90548d = r1
            r8.X0()
            int r1 = r8.f90548d
            int r2 = r8.f90549f
            goto L6
        L83:
            int r1 = r1 + 1
            r8.f90548d = r1
        */
        //  java.lang.String r1 = "*/"
        /*
            boolean r1 = r8.U0(r1)
            if (r1 == 0) goto L96
            int r1 = r8.f90548d
            int r1 = r1 + r7
            int r2 = r8.f90549f
            goto L6
        L96:
            java.lang.String r9 = "Unterminated comment"
            java.io.IOException r9 = r8.i1(r9)
            throw r9
        L9d:
            r1 = 35
            if (r5 != r1) goto Laf
            r8.f90548d = r4
            r8.c()
            r8.X0()
            int r1 = r8.f90548d
            int r2 = r8.f90549f
            goto L6
        Laf:
            r8.f90548d = r4
            return r5
        Lb2:
            r1 = r4
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.O(boolean):int");
    }

    private void R0(char c3) throws IOException {
        char[] cArr = this.f90547c;
        do {
            int i3 = this.f90548d;
            int i4 = this.f90549f;
            while (i3 < i4) {
                int i5 = i3 + 1;
                char c4 = cArr[i3];
                if (c4 == c3) {
                    this.f90548d = i5;
                    return;
                }
                if (c4 == '\\') {
                    this.f90548d = i5;
                    A0();
                    i3 = this.f90548d;
                    i4 = this.f90549f;
                } else {
                    if (c4 == '\n') {
                        this.f90550g++;
                        this.f90551h = i5;
                    }
                    i3 = i5;
                }
            }
            this.f90548d = i3;
        } while (l(1));
        throw i1("Unterminated string");
    }

    private boolean U0(String str) {
        int length = str.length();
        while (true) {
            if (this.f90548d + length > this.f90549f && !l(length)) {
                return false;
            }
            char[] cArr = this.f90547c;
            int i3 = this.f90548d;
            if (cArr[i3] != '\n') {
                for (int i4 = 0; i4 < length; i4++) {
                    if (this.f90547c[this.f90548d + i4] != str.charAt(i4)) {
                        break;
                    }
                }
                return true;
            }
            this.f90550g++;
            this.f90551h = i3 + 1;
            this.f90548d++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
    
        if (r1 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005c, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006a, code lost:
    
        r1.append(r0, r3, r2 - r3);
        r9.f90548d = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String V(char r10) throws java.io.IOException {
        /*
            r9 = this;
            char[] r0 = r9.f90547c
            r1 = 0
        L3:
            int r2 = r9.f90548d
            int r3 = r9.f90549f
        L7:
            r4 = r3
            r3 = r2
        L9:
            r5 = 16
            r6 = 1
            if (r2 >= r4) goto L5a
            int r7 = r2 + 1
            char r2 = r0[r2]
            if (r2 != r10) goto L28
            r9.f90548d = r7
            int r7 = r7 - r3
            int r7 = r7 - r6
            if (r1 != 0) goto L20
            java.lang.String r10 = new java.lang.String
            r10.<init>(r0, r3, r7)
            return r10
        L20:
            r1.append(r0, r3, r7)
            java.lang.String r10 = r1.toString()
            return r10
        L28:
            r8 = 92
            if (r2 != r8) goto L4d
            r9.f90548d = r7
            int r7 = r7 - r3
            int r2 = r7 + (-1)
            if (r1 != 0) goto L3e
            int r7 = r7 * 2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r4 = java.lang.Math.max(r7, r5)
            r1.<init>(r4)
        L3e:
            r1.append(r0, r3, r2)
            char r2 = r9.A0()
            r1.append(r2)
            int r2 = r9.f90548d
            int r3 = r9.f90549f
            goto L7
        L4d:
            r5 = 10
            if (r2 != r5) goto L58
            int r2 = r9.f90550g
            int r2 = r2 + r6
            r9.f90550g = r2
            r9.f90551h = r7
        L58:
            r2 = r7
            goto L9
        L5a:
            if (r1 != 0) goto L6a
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r4.<init>(r1)
            r1 = r4
        L6a:
            int r4 = r2 - r3
            r1.append(r0, r3, r4)
            r9.f90548d = r2
            boolean r2 = r9.l(r6)
            if (r2 == 0) goto L78
            goto L3
        L78:
            java.lang.String r10 = "Unterminated string"
            java.io.IOException r10 = r9.i1(r10)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.V(char):java.lang.String");
    }

    private void X0() {
        char c3;
        do {
            if (this.f90548d >= this.f90549f && !l(1)) {
                return;
            }
            char[] cArr = this.f90547c;
            int i3 = this.f90548d;
            int i4 = i3 + 1;
            this.f90548d = i4;
            c3 = cArr[i3];
            if (c3 == '\n') {
                this.f90550g++;
                this.f90551h = i4;
                return;
            }
        } while (c3 != '\r');
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
    
        c();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a1() throws java.io.IOException {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.f90548d
            int r2 = r1 + r0
            int r3 = r4.f90549f
            if (r2 >= r3) goto L51
            char[] r2 = r4.f90547c
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L4b
            r2 = 10
            if (r1 == r2) goto L4b
            r2 = 12
            if (r1 == r2) goto L4b
            r2 = 13
            if (r1 == r2) goto L4b
            r2 = 32
            if (r1 == r2) goto L4b
            r2 = 35
            if (r1 == r2) goto L48
            r2 = 44
            if (r1 == r2) goto L4b
            r2 = 47
            if (r1 == r2) goto L48
            r2 = 61
            if (r1 == r2) goto L48
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L4b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L4b
            r2 = 58
            if (r1 == r2) goto L4b
            r2 = 59
            if (r1 == r2) goto L48
            switch(r1) {
                case 91: goto L4b;
                case 92: goto L48;
                case 93: goto L4b;
                default: goto L45;
            }
        L45:
            int r0 = r0 + 1
            goto L1
        L48:
            r4.c()
        L4b:
            int r1 = r4.f90548d
            int r1 = r1 + r0
            r4.f90548d = r1
            return
        L51:
            int r1 = r1 + r0
            r4.f90548d = r1
            r0 = 1
            boolean r0 = r4.l(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.a1():void");
    }

    private void c() throws IOException {
        if (!this.f90546b) {
            throw i1("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void f() throws IOException {
        O(true);
        int i3 = this.f90548d;
        this.f90548d = i3 - 1;
        if (i3 + 4 <= this.f90549f || l(5)) {
            int i4 = this.f90548d;
            char[] cArr = this.f90547c;
            if (cArr[i4] == ')' && cArr[i4 + 1] == ']' && cArr[i4 + 2] == '}' && cArr[i4 + 3] == '\'' && cArr[i4 + 4] == '\n') {
                this.f90548d = i4 + 5;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
    
        c();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0044. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String g0() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = r1
        L3:
            int r3 = r6.f90548d
            int r4 = r3 + r2
            int r5 = r6.f90549f
            if (r4 >= r5) goto L4e
            char[] r4 = r6.f90547c
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L5c
            r4 = 10
            if (r3 == r4) goto L5c
            r4 = 12
            if (r3 == r4) goto L5c
            r4 = 13
            if (r3 == r4) goto L5c
            r4 = 32
            if (r3 == r4) goto L5c
            r4 = 35
            if (r3 == r4) goto L4a
            r4 = 44
            if (r3 == r4) goto L5c
            r4 = 47
            if (r3 == r4) goto L4a
            r4 = 61
            if (r3 == r4) goto L4a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5c
            r4 = 58
            if (r3 == r4) goto L5c
            r4 = 59
            if (r3 == r4) goto L4a
            switch(r3) {
                case 91: goto L5c;
                case 92: goto L4a;
                case 93: goto L5c;
                default: goto L47;
            }
        L47:
            int r2 = r2 + 1
            goto L3
        L4a:
            r6.c()
            goto L5c
        L4e:
            char[] r3 = r6.f90547c
            int r3 = r3.length
            if (r2 >= r3) goto L5e
            int r3 = r2 + 1
            boolean r3 = r6.l(r3)
            if (r3 == 0) goto L5c
            goto L3
        L5c:
            r1 = r2
            goto L7e
        L5e:
            if (r0 != 0) goto L6b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L6b:
            char[] r3 = r6.f90547c
            int r4 = r6.f90548d
            r0.append(r3, r4, r2)
            int r3 = r6.f90548d
            int r3 = r3 + r2
            r6.f90548d = r3
            r2 = 1
            boolean r2 = r6.l(r2)
            if (r2 != 0) goto L2
        L7e:
            if (r0 != 0) goto L8a
            java.lang.String r0 = new java.lang.String
            char[] r2 = r6.f90547c
            int r3 = r6.f90548d
            r0.<init>(r2, r3, r1)
            goto L95
        L8a:
            char[] r2 = r6.f90547c
            int r3 = r6.f90548d
            r0.append(r2, r3, r1)
            java.lang.String r0 = r0.toString()
        L95:
            int r2 = r6.f90548d
            int r2 = r2 + r1
            r6.f90548d = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.g0():java.lang.String");
    }

    private IOException i1(String str) throws MalformedJsonException {
        throw new MalformedJsonException(str + F());
    }

    private boolean l(int i3) throws IOException {
        int i4;
        int i5;
        char[] cArr = this.f90547c;
        int i6 = this.f90551h;
        int i7 = this.f90548d;
        this.f90551h = i6 - i7;
        int i8 = this.f90549f;
        if (i8 != i7) {
            int i9 = i8 - i7;
            this.f90549f = i9;
            System.arraycopy(cArr, i7, cArr, 0, i9);
        } else {
            this.f90549f = 0;
        }
        this.f90548d = 0;
        do {
            Reader reader = this.f90545a;
            int i10 = this.f90549f;
            int i11 = reader.read(cArr, i10, cArr.length - i10);
            if (i11 == -1) {
                return false;
            }
            i4 = this.f90549f + i11;
            this.f90549f = i4;
            if (this.f90550g == 0 && (i5 = this.f90551h) == 0 && i4 > 0 && cArr[0] == 65279) {
                this.f90548d++;
                this.f90551h = i5 + 1;
                i3++;
            }
        } while (i4 < i3);
        return true;
    }

    private String m(boolean z2) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i3 = 0;
        while (true) {
            int i4 = this.f90557n;
            if (i3 >= i4) {
                return sb.toString();
            }
            int i5 = this.f90556m[i3];
            if (i5 == 1 || i5 == 2) {
                int i6 = this.f90559p[i3];
                if (z2 && i6 > 0 && i3 == i4 - 1) {
                    i6--;
                }
                sb.append('[');
                sb.append(i6);
                sb.append(']');
            } else if (i5 == 3 || i5 == 4 || i5 == 5) {
                sb.append('.');
                String str = this.f90558o[i3];
                if (str != null) {
                    sb.append(str);
                }
            }
            i3++;
        }
    }

    private int q0() {
        String str;
        String str2;
        int i3;
        char c3 = this.f90547c[this.f90548d];
        if (c3 == 't' || c3 == 'T') {
            str = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
            str2 = "TRUE";
            i3 = 5;
        } else if (c3 == 'f' || c3 == 'F') {
            str = "false";
            str2 = "FALSE";
            i3 = 6;
        } else {
            if (c3 != 'n' && c3 != 'N') {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i3 = 7;
        }
        int length = str.length();
        for (int i4 = 1; i4 < length; i4++) {
            if (this.f90548d + i4 >= this.f90549f && !l(i4 + 1)) {
                return 0;
            }
            char c4 = this.f90547c[this.f90548d + i4];
            if (c4 != str.charAt(i4) && c4 != str2.charAt(i4)) {
                return 0;
            }
        }
        if ((this.f90548d + length < this.f90549f || l(length + 1)) && C(this.f90547c[this.f90548d + length])) {
            return 0;
        }
        this.f90548d += length;
        this.f90552i = i3;
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0093, code lost:
    
        if (C(r14) != false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0095, code lost:
    
        if (r9 != 2) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0097, code lost:
    
        if (r10 == 0) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x009d, code lost:
    
        if (r11 != Long.MIN_VALUE) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x009f, code lost:
    
        if (r13 == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a3, code lost:
    
        if (r11 != 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a5, code lost:
    
        if (r13 != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a7, code lost:
    
        if (r13 == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00aa, code lost:
    
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ab, code lost:
    
        r19.f90553j = r11;
        r19.f90548d += r8;
        r19.f90552i = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00b6, code lost:
    
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00b7, code lost:
    
        if (r9 == 2) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00ba, code lost:
    
        if (r9 == 4) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00bd, code lost:
    
        if (r9 != 7) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00c0, code lost:
    
        return r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00c1, code lost:
    
        r19.f90554k = r8;
        r19.f90552i = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00c7, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00c8, code lost:
    
        return r18;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int w0() {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.w0():int");
    }

    private void z0(int i3) {
        int i4 = this.f90557n;
        int[] iArr = this.f90556m;
        if (i4 == iArr.length) {
            int i5 = i4 * 2;
            this.f90556m = Arrays.copyOf(iArr, i5);
            this.f90559p = Arrays.copyOf(this.f90559p, i5);
            this.f90558o = (String[]) Arrays.copyOf(this.f90558o, i5);
        }
        int[] iArr2 = this.f90556m;
        int i6 = this.f90557n;
        this.f90557n = i6 + 1;
        iArr2[i6] = i3;
    }

    String F() {
        return " at line " + (this.f90550g + 1) + " column " + ((this.f90548d - this.f90551h) + 1) + " path " + g();
    }

    public boolean J() throws IOException {
        int i3 = this.f90552i;
        if (i3 == 0) {
            i3 = i();
        }
        if (i3 == 5) {
            this.f90552i = 0;
            int[] iArr = this.f90559p;
            int i4 = this.f90557n - 1;
            iArr[i4] = iArr[i4] + 1;
            return true;
        }
        if (i3 == 6) {
            this.f90552i = 0;
            int[] iArr2 = this.f90559p;
            int i5 = this.f90557n - 1;
            iArr2[i5] = iArr2[i5] + 1;
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + j0() + F());
    }

    public double K() throws IOException {
        int i3 = this.f90552i;
        if (i3 == 0) {
            i3 = i();
        }
        if (i3 == 15) {
            this.f90552i = 0;
            int[] iArr = this.f90559p;
            int i4 = this.f90557n - 1;
            iArr[i4] = iArr[i4] + 1;
            return this.f90553j;
        }
        if (i3 == 16) {
            this.f90555l = new String(this.f90547c, this.f90548d, this.f90554k);
            this.f90548d += this.f90554k;
        } else if (i3 == 8 || i3 == 9) {
            this.f90555l = V(i3 == 8 ? '\'' : '\"');
        } else if (i3 == 10) {
            this.f90555l = g0();
        } else if (i3 != 11) {
            throw new IllegalStateException("Expected a double but was " + j0() + F());
        }
        this.f90552i = 11;
        double d3 = Double.parseDouble(this.f90555l);
        if (!this.f90546b && (Double.isNaN(d3) || Double.isInfinite(d3))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + d3 + F());
        }
        this.f90555l = null;
        this.f90552i = 0;
        int[] iArr2 = this.f90559p;
        int i5 = this.f90557n - 1;
        iArr2[i5] = iArr2[i5] + 1;
        return d3;
    }

    public int L() throws IOException {
        int i3 = this.f90552i;
        if (i3 == 0) {
            i3 = i();
        }
        if (i3 == 15) {
            long j3 = this.f90553j;
            int i4 = (int) j3;
            if (j3 == i4) {
                this.f90552i = 0;
                int[] iArr = this.f90559p;
                int i5 = this.f90557n - 1;
                iArr[i5] = iArr[i5] + 1;
                return i4;
            }
            throw new NumberFormatException("Expected an int but was " + this.f90553j + F());
        }
        if (i3 == 16) {
            this.f90555l = new String(this.f90547c, this.f90548d, this.f90554k);
            this.f90548d += this.f90554k;
        } else {
            if (i3 != 8 && i3 != 9 && i3 != 10) {
                throw new IllegalStateException("Expected an int but was " + j0() + F());
            }
            if (i3 == 10) {
                this.f90555l = g0();
            } else {
                this.f90555l = V(i3 == 8 ? '\'' : '\"');
            }
            try {
                int i6 = Integer.parseInt(this.f90555l);
                this.f90552i = 0;
                int[] iArr2 = this.f90559p;
                int i7 = this.f90557n - 1;
                iArr2[i7] = iArr2[i7] + 1;
                return i6;
            } catch (NumberFormatException unused) {
            }
        }
        this.f90552i = 11;
        double d3 = Double.parseDouble(this.f90555l);
        int i8 = (int) d3;
        if (i8 != d3) {
            throw new NumberFormatException("Expected an int but was " + this.f90555l + F());
        }
        this.f90555l = null;
        this.f90552i = 0;
        int[] iArr3 = this.f90559p;
        int i9 = this.f90557n - 1;
        iArr3[i9] = iArr3[i9] + 1;
        return i8;
    }

    public long M() throws IOException {
        int i3 = this.f90552i;
        if (i3 == 0) {
            i3 = i();
        }
        if (i3 == 15) {
            this.f90552i = 0;
            int[] iArr = this.f90559p;
            int i4 = this.f90557n - 1;
            iArr[i4] = iArr[i4] + 1;
            return this.f90553j;
        }
        if (i3 == 16) {
            this.f90555l = new String(this.f90547c, this.f90548d, this.f90554k);
            this.f90548d += this.f90554k;
        } else {
            if (i3 != 8 && i3 != 9 && i3 != 10) {
                throw new IllegalStateException("Expected a long but was " + j0() + F());
            }
            if (i3 == 10) {
                this.f90555l = g0();
            } else {
                this.f90555l = V(i3 == 8 ? '\'' : '\"');
            }
            try {
                long j3 = Long.parseLong(this.f90555l);
                this.f90552i = 0;
                int[] iArr2 = this.f90559p;
                int i5 = this.f90557n - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return j3;
            } catch (NumberFormatException unused) {
            }
        }
        this.f90552i = 11;
        double d3 = Double.parseDouble(this.f90555l);
        long j4 = (long) d3;
        if (j4 != d3) {
            throw new NumberFormatException("Expected a long but was " + this.f90555l + F());
        }
        this.f90555l = null;
        this.f90552i = 0;
        int[] iArr3 = this.f90559p;
        int i6 = this.f90557n - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return j4;
    }

    public String N() throws IOException {
        String strV;
        int i3 = this.f90552i;
        if (i3 == 0) {
            i3 = i();
        }
        if (i3 == 14) {
            strV = g0();
        } else if (i3 == 12) {
            strV = V('\'');
        } else {
            if (i3 != 13) {
                throw new IllegalStateException("Expected a name but was " + j0() + F());
            }
            strV = V('\"');
        }
        this.f90552i = 0;
        this.f90558o[this.f90557n - 1] = strV;
        return strV;
    }

    public final void O0(boolean z2) {
        this.f90546b = z2;
    }

    public void T() throws IOException {
        int i3 = this.f90552i;
        if (i3 == 0) {
            i3 = i();
        }
        if (i3 == 7) {
            this.f90552i = 0;
            int[] iArr = this.f90559p;
            int i4 = this.f90557n - 1;
            iArr[i4] = iArr[i4] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + j0() + F());
    }

    public void a() throws IOException {
        int i3 = this.f90552i;
        if (i3 == 0) {
            i3 = i();
        }
        if (i3 == 3) {
            z0(1);
            this.f90559p[this.f90557n - 1] = 0;
            this.f90552i = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + j0() + F());
        }
    }

    public void b() throws IOException {
        int i3 = this.f90552i;
        if (i3 == 0) {
            i3 = i();
        }
        if (i3 == 1) {
            z0(3);
            this.f90552i = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + j0() + F());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f90552i = 0;
        this.f90556m[0] = 8;
        this.f90557n = 1;
        this.f90545a.close();
    }

    public String e0() throws IOException {
        String str;
        int i3 = this.f90552i;
        if (i3 == 0) {
            i3 = i();
        }
        if (i3 == 10) {
            str = g0();
        } else if (i3 == 8) {
            str = V('\'');
        } else if (i3 == 9) {
            str = V('\"');
        } else if (i3 == 11) {
            str = this.f90555l;
            this.f90555l = null;
        } else if (i3 == 15) {
            str = Long.toString(this.f90553j);
        } else {
            if (i3 != 16) {
                throw new IllegalStateException("Expected a string but was " + j0() + F());
            }
            str = new String(this.f90547c, this.f90548d, this.f90554k);
            this.f90548d += this.f90554k;
        }
        this.f90552i = 0;
        int[] iArr = this.f90559p;
        int i4 = this.f90557n - 1;
        iArr[i4] = iArr[i4] + 1;
        return str;
    }

    public String g() {
        return m(false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void h1() throws IOException {
        int i3 = 0;
        do {
            int i4 = this.f90552i;
            if (i4 == 0) {
                i4 = i();
            }
            switch (i4) {
                case 1:
                    z0(3);
                    i3++;
                    this.f90552i = 0;
                    break;
                case 2:
                    if (i3 == 0) {
                        this.f90558o[this.f90557n - 1] = null;
                    }
                    this.f90557n--;
                    i3--;
                    this.f90552i = 0;
                    break;
                case 3:
                    z0(1);
                    i3++;
                    this.f90552i = 0;
                    break;
                case 4:
                    this.f90557n--;
                    i3--;
                    this.f90552i = 0;
                    break;
                case 5:
                case 6:
                case 7:
                case 11:
                case 15:
                default:
                    this.f90552i = 0;
                    break;
                case 8:
                    R0('\'');
                    this.f90552i = 0;
                    break;
                case 9:
                    R0('\"');
                    this.f90552i = 0;
                    break;
                case 10:
                    a1();
                    this.f90552i = 0;
                    break;
                case 12:
                    R0('\'');
                    if (i3 == 0) {
                        this.f90558o[this.f90557n - 1] = "<skipped>";
                    }
                    this.f90552i = 0;
                    break;
                case 13:
                    R0('\"');
                    if (i3 == 0) {
                        this.f90558o[this.f90557n - 1] = "<skipped>";
                    }
                    this.f90552i = 0;
                    break;
                case 14:
                    a1();
                    if (i3 == 0) {
                        this.f90558o[this.f90557n - 1] = "<skipped>";
                    }
                    this.f90552i = 0;
                    break;
                case 16:
                    this.f90548d += this.f90554k;
                    this.f90552i = 0;
                    break;
                case 17:
                    break;
            }
            return;
        } while (i3 > 0);
        int[] iArr = this.f90559p;
        int i5 = this.f90557n - 1;
        iArr[i5] = iArr[i5] + 1;
    }

    int i() throws IOException {
        int iO;
        int[] iArr = this.f90556m;
        int i3 = this.f90557n;
        int i4 = iArr[i3 - 1];
        if (i4 == 1) {
            iArr[i3 - 1] = 2;
        } else if (i4 == 2) {
            int iO2 = O(true);
            if (iO2 != 44) {
                if (iO2 != 59) {
                    if (iO2 != 93) {
                        throw i1("Unterminated array");
                    }
                    this.f90552i = 4;
                    return 4;
                }
                c();
            }
        } else {
            if (i4 == 3 || i4 == 5) {
                iArr[i3 - 1] = 4;
                if (i4 == 5 && (iO = O(true)) != 44) {
                    if (iO != 59) {
                        if (iO != 125) {
                            throw i1("Unterminated object");
                        }
                        this.f90552i = 2;
                        return 2;
                    }
                    c();
                }
                int iO3 = O(true);
                if (iO3 == 34) {
                    this.f90552i = 13;
                    return 13;
                }
                if (iO3 == 39) {
                    c();
                    this.f90552i = 12;
                    return 12;
                }
                if (iO3 == 125) {
                    if (i4 == 5) {
                        throw i1("Expected name");
                    }
                    this.f90552i = 2;
                    return 2;
                }
                c();
                this.f90548d--;
                if (!C((char) iO3)) {
                    throw i1("Expected name");
                }
                this.f90552i = 14;
                return 14;
            }
            if (i4 == 4) {
                iArr[i3 - 1] = 5;
                int iO4 = O(true);
                if (iO4 != 58) {
                    if (iO4 != 61) {
                        throw i1("Expected ':'");
                    }
                    c();
                    if (this.f90548d < this.f90549f || l(1)) {
                        char[] cArr = this.f90547c;
                        int i5 = this.f90548d;
                        if (cArr[i5] == '>') {
                            this.f90548d = i5 + 1;
                        }
                    }
                }
            } else if (i4 == 6) {
                if (this.f90546b) {
                    f();
                }
                this.f90556m[this.f90557n - 1] = 7;
            } else if (i4 == 7) {
                if (O(false) == -1) {
                    this.f90552i = 17;
                    return 17;
                }
                c();
                this.f90548d--;
            } else if (i4 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iO5 = O(true);
        if (iO5 == 34) {
            this.f90552i = 9;
            return 9;
        }
        if (iO5 == 39) {
            c();
            this.f90552i = 8;
            return 8;
        }
        if (iO5 != 44 && iO5 != 59) {
            if (iO5 == 91) {
                this.f90552i = 3;
                return 3;
            }
            if (iO5 != 93) {
                if (iO5 == 123) {
                    this.f90552i = 1;
                    return 1;
                }
                this.f90548d--;
                int iQ0 = q0();
                if (iQ0 != 0) {
                    return iQ0;
                }
                int iW0 = w0();
                if (iW0 != 0) {
                    return iW0;
                }
                if (!C(this.f90547c[this.f90548d])) {
                    throw i1("Expected value");
                }
                c();
                this.f90552i = 10;
                return 10;
            }
            if (i4 == 1) {
                this.f90552i = 4;
                return 4;
            }
        }
        if (i4 != 1 && i4 != 2) {
            throw i1("Unexpected value");
        }
        c();
        this.f90548d--;
        this.f90552i = 7;
        return 7;
    }

    public void j() throws IOException {
        int i3 = this.f90552i;
        if (i3 == 0) {
            i3 = i();
        }
        if (i3 != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + j0() + F());
        }
        int i4 = this.f90557n;
        this.f90557n = i4 - 1;
        int[] iArr = this.f90559p;
        int i5 = i4 - 2;
        iArr[i5] = iArr[i5] + 1;
        this.f90552i = 0;
    }

    public JsonToken j0() throws IOException {
        int i3 = this.f90552i;
        if (i3 == 0) {
            i3 = i();
        }
        switch (i3) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public void k() throws IOException {
        int i3 = this.f90552i;
        if (i3 == 0) {
            i3 = i();
        }
        if (i3 != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + j0() + F());
        }
        int i4 = this.f90557n;
        int i5 = i4 - 1;
        this.f90557n = i5;
        this.f90558o[i5] = null;
        int[] iArr = this.f90559p;
        int i6 = i4 - 2;
        iArr[i6] = iArr[i6] + 1;
        this.f90552i = 0;
    }

    public String n() {
        return m(true);
    }

    public boolean r() throws IOException {
        int i3 = this.f90552i;
        if (i3 == 0) {
            i3 = i();
        }
        return (i3 == 2 || i3 == 4 || i3 == 17) ? false : true;
    }

    public String toString() {
        return getClass().getSimpleName() + F();
    }

    public final boolean z() {
        return this.f90546b;
    }
}
