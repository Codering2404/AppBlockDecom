package com.airbnb.lottie.parser.moshi;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.facebook.internal.ServerProtocol;
import java.io.EOFException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class JsonUtf8Reader extends JsonReader {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final ByteString f57035o = ByteString.e("'\\");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final ByteString f57036p = ByteString.e("\"\\");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final ByteString f57037q = ByteString.e("{}[]:, \n\t\r\f/\\;#=");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final ByteString f57038r = ByteString.e("\n\r");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final ByteString f57039s = ByteString.e("*/");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final BufferedSource f57040i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Buffer f57041j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f57042k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f57043l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f57044m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f57045n;

    JsonUtf8Reader(BufferedSource bufferedSource) {
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        }
        this.f57040i = bufferedSource;
        this.f57041j = bufferedSource.s();
        F(6);
    }

    private char A0() throws JsonEncodingException, EOFException {
        int i3;
        if (!this.f57040i.y(1L)) {
            throw N("Unterminated escape sequence");
        }
        byte b3 = this.f57041j.readByte();
        if (b3 == 10 || b3 == 34 || b3 == 39 || b3 == 47 || b3 == 92) {
            return (char) b3;
        }
        if (b3 == 98) {
            return '\b';
        }
        if (b3 == 102) {
            return '\f';
        }
        if (b3 == 110) {
            return '\n';
        }
        if (b3 == 114) {
            return '\r';
        }
        if (b3 == 116) {
            return '\t';
        }
        if (b3 != 117) {
            if (this.f57020f) {
                return (char) b3;
            }
            throw N("Invalid escape sequence: \\" + ((char) b3));
        }
        if (!this.f57040i.y(4L)) {
            throw new EOFException("Unterminated escape sequence at path " + g());
        }
        char c3 = 0;
        for (int i4 = 0; i4 < 4; i4++) {
            byte bR = this.f57041j.r(i4);
            char c4 = (char) (c3 << 4);
            if (bR >= 48 && bR <= 57) {
                i3 = bR - 48;
            } else if (bR >= 97 && bR <= 102) {
                i3 = bR - 87;
            } else {
                if (bR < 65 || bR > 70) {
                    throw N("\\u" + this.f57041j.m1(4L));
                }
                i3 = bR - 55;
            }
            c3 = (char) (c4 + i3);
        }
        this.f57041j.skip(4L);
        return c3;
    }

    private void O() throws JsonEncodingException {
        if (!this.f57020f) {
            throw N("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void O0(ByteString byteString) throws JsonEncodingException, EOFException {
        while (true) {
            long jN0 = this.f57040i.n0(byteString);
            if (jN0 == -1) {
                throw N("Unterminated string");
            }
            if (this.f57041j.r(jN0) != 92) {
                this.f57041j.skip(jN0 + 1);
                return;
            } else {
                this.f57041j.skip(jN0 + 1);
                A0();
            }
        }
    }

    private boolean R0() throws EOFException {
        BufferedSource bufferedSource = this.f57040i;
        ByteString byteString = f57039s;
        long jC0 = bufferedSource.c0(byteString);
        boolean z2 = jC0 != -1;
        Buffer buffer = this.f57041j;
        buffer.skip(z2 ? jC0 + ((long) byteString.C()) : buffer.size());
        return z2;
    }

    private int T() throws JsonEncodingException, EOFException {
        int[] iArr = this.f57017b;
        int i3 = this.f57016a;
        int i4 = iArr[i3 - 1];
        if (i4 == 1) {
            iArr[i3 - 1] = 2;
        } else if (i4 == 2) {
            int iG0 = g0(true);
            this.f57041j.readByte();
            if (iG0 != 44) {
                if (iG0 != 59) {
                    if (iG0 != 93) {
                        throw N("Unterminated array");
                    }
                    this.f57042k = 4;
                    return 4;
                }
                O();
            }
        } else {
            if (i4 == 3 || i4 == 5) {
                iArr[i3 - 1] = 4;
                if (i4 == 5) {
                    int iG02 = g0(true);
                    this.f57041j.readByte();
                    if (iG02 != 44) {
                        if (iG02 != 59) {
                            if (iG02 != 125) {
                                throw N("Unterminated object");
                            }
                            this.f57042k = 2;
                            return 2;
                        }
                        O();
                    }
                }
                int iG03 = g0(true);
                if (iG03 == 34) {
                    this.f57041j.readByte();
                    this.f57042k = 13;
                    return 13;
                }
                if (iG03 == 39) {
                    this.f57041j.readByte();
                    O();
                    this.f57042k = 12;
                    return 12;
                }
                if (iG03 != 125) {
                    O();
                    if (!e0((char) iG03)) {
                        throw N("Expected name");
                    }
                    this.f57042k = 14;
                    return 14;
                }
                if (i4 == 5) {
                    throw N("Expected name");
                }
                this.f57041j.readByte();
                this.f57042k = 2;
                return 2;
            }
            if (i4 == 4) {
                iArr[i3 - 1] = 5;
                int iG04 = g0(true);
                this.f57041j.readByte();
                if (iG04 != 58) {
                    if (iG04 != 61) {
                        throw N("Expected ':'");
                    }
                    O();
                    if (this.f57040i.y(1L) && this.f57041j.r(0L) == 62) {
                        this.f57041j.readByte();
                    }
                }
            } else if (i4 == 6) {
                iArr[i3 - 1] = 7;
            } else if (i4 == 7) {
                if (g0(false) == -1) {
                    this.f57042k = 18;
                    return 18;
                }
                O();
            } else if (i4 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iG05 = g0(true);
        if (iG05 == 34) {
            this.f57041j.readByte();
            this.f57042k = 9;
            return 9;
        }
        if (iG05 == 39) {
            O();
            this.f57041j.readByte();
            this.f57042k = 8;
            return 8;
        }
        if (iG05 != 44 && iG05 != 59) {
            if (iG05 == 91) {
                this.f57041j.readByte();
                this.f57042k = 3;
                return 3;
            }
            if (iG05 != 93) {
                if (iG05 == 123) {
                    this.f57041j.readByte();
                    this.f57042k = 1;
                    return 1;
                }
                int iW0 = w0();
                if (iW0 != 0) {
                    return iW0;
                }
                int iZ0 = z0();
                if (iZ0 != 0) {
                    return iZ0;
                }
                if (!e0(this.f57041j.r(0L))) {
                    throw N("Expected value");
                }
                O();
                this.f57042k = 10;
                return 10;
            }
            if (i4 == 1) {
                this.f57041j.readByte();
                this.f57042k = 4;
                return 4;
            }
        }
        if (i4 != 1 && i4 != 2) {
            throw N("Unexpected value");
        }
        O();
        this.f57042k = 7;
        return 7;
    }

    private void U0() throws EOFException {
        long jN0 = this.f57040i.n0(f57038r);
        Buffer buffer = this.f57041j;
        buffer.skip(jN0 != -1 ? jN0 + 1 : buffer.size());
    }

    private int V(String str, JsonReader.Options options) {
        int length = options.f57022a.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (str.equals(options.f57022a[i3])) {
                this.f57042k = 0;
                this.f57018c[this.f57016a - 1] = str;
                return i3;
            }
        }
        return -1;
    }

    private void X0() throws EOFException {
        long jN0 = this.f57040i.n0(f57037q);
        Buffer buffer = this.f57041j;
        if (jN0 == -1) {
            jN0 = buffer.size();
        }
        buffer.skip(jN0);
    }

    private boolean e0(int i3) throws JsonEncodingException {
        if (i3 == 9 || i3 == 10 || i3 == 12 || i3 == 13 || i3 == 32) {
            return false;
        }
        if (i3 != 35) {
            if (i3 == 44) {
                return false;
            }
            if (i3 != 47 && i3 != 61) {
                if (i3 == 123 || i3 == 125 || i3 == 58) {
                    return false;
                }
                if (i3 != 59) {
                    switch (i3) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        O();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
    
        r6.f57041j.skip(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
    
        if (r2 != 47) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
    
        if (r6.f57040i.y(2) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
    
        O();
        r3 = r6.f57041j.r(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0047, code lost:
    
        if (r3 == 42) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
    
        if (r3 == 47) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004c, code lost:
    
        r6.f57041j.readByte();
        r6.f57041j.readByte();
        U0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
    
        r6.f57041j.readByte();
        r6.f57041j.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0068, code lost:
    
        if (R0() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0071, code lost:
    
        throw N("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0074, code lost:
    
        if (r2 != 35) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0076, code lost:
    
        O();
        U0();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int g0(boolean r7) throws com.airbnb.lottie.parser.moshi.JsonEncodingException, java.io.EOFException {
        /*
            r6 = this;
            r0 = 0
        L1:
            r1 = r0
        L2:
            okio.BufferedSource r2 = r6.f57040i
            int r3 = r1 + 1
            long r4 = (long) r3
            boolean r2 = r2.y(r4)
            if (r2 == 0) goto L80
            okio.Buffer r2 = r6.f57041j
            long r4 = (long) r1
            byte r2 = r2.r(r4)
            r4 = 10
            if (r2 == r4) goto L7e
            r4 = 32
            if (r2 == r4) goto L7e
            r4 = 13
            if (r2 == r4) goto L7e
            r4 = 9
            if (r2 != r4) goto L25
            goto L7e
        L25:
            okio.Buffer r3 = r6.f57041j
            long r4 = (long) r1
            r3.skip(r4)
            r1 = 47
            if (r2 != r1) goto L72
            okio.BufferedSource r3 = r6.f57040i
            r4 = 2
            boolean r3 = r3.y(r4)
            if (r3 != 0) goto L3a
            goto L7d
        L3a:
            r6.O()
            okio.Buffer r3 = r6.f57041j
            r4 = 1
            byte r3 = r3.r(r4)
            r4 = 42
            if (r3 == r4) goto L5a
            if (r3 == r1) goto L4c
            goto L7d
        L4c:
            okio.Buffer r1 = r6.f57041j
            r1.readByte()
            okio.Buffer r1 = r6.f57041j
            r1.readByte()
            r6.U0()
            goto L1
        L5a:
            okio.Buffer r1 = r6.f57041j
            r1.readByte()
            okio.Buffer r1 = r6.f57041j
            r1.readByte()
            boolean r1 = r6.R0()
            if (r1 == 0) goto L6b
            goto L1
        L6b:
            java.lang.String r7 = "Unterminated comment"
            com.airbnb.lottie.parser.moshi.JsonEncodingException r7 = r6.N(r7)
            throw r7
        L72:
            r1 = 35
            if (r2 != r1) goto L7d
            r6.O()
            r6.U0()
            goto L1
        L7d:
            return r2
        L7e:
            r1 = r3
            goto L2
        L80:
            if (r7 != 0) goto L84
            r7 = -1
            return r7
        L84:
            java.io.EOFException r7 = new java.io.EOFException
            java.lang.String r0 = "End of input"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.JsonUtf8Reader.g0(boolean):int");
    }

    private String j0(ByteString byteString) throws JsonEncodingException, EOFException {
        StringBuilder sb = null;
        while (true) {
            long jN0 = this.f57040i.n0(byteString);
            if (jN0 == -1) {
                throw N("Unterminated string");
            }
            if (this.f57041j.r(jN0) != 92) {
                if (sb == null) {
                    String strM1 = this.f57041j.m1(jN0);
                    this.f57041j.readByte();
                    return strM1;
                }
                sb.append(this.f57041j.m1(jN0));
                this.f57041j.readByte();
                return sb.toString();
            }
            if (sb == null) {
                sb = new StringBuilder();
            }
            sb.append(this.f57041j.m1(jN0));
            this.f57041j.readByte();
            sb.append(A0());
        }
    }

    private String q0() {
        long jN0 = this.f57040i.n0(f57037q);
        return jN0 != -1 ? this.f57041j.m1(jN0) : this.f57041j.e0();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private int w0() throws EOFException {
        String str;
        String str2;
        int i3;
        byte bR = this.f57041j.r(0L);
        if (bR == 116 || bR == 84) {
            str = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
            str2 = "TRUE";
            i3 = 5;
        } else if (bR == 102 || bR == 70) {
            str = "false";
            str2 = "FALSE";
            i3 = 6;
        } else {
            if (bR != 110 && bR != 78) {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i3 = 7;
        }
        int length = str.length();
        int i4 = 1;
        while (i4 < length) {
            int i5 = i4 + 1;
            if (!this.f57040i.y(i5)) {
                return 0;
            }
            byte bR2 = this.f57041j.r(i4);
            if (bR2 != str.charAt(i4) && bR2 != str2.charAt(i4)) {
                return 0;
            }
            i4 = i5;
        }
        if (this.f57040i.y(length + 1) && e0(this.f57041j.r(length))) {
            return 0;
        }
        this.f57041j.skip(length);
        this.f57042k = i3;
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0089, code lost:
    
        if (e0(r1) != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x008b, code lost:
    
        if (r6 != 2) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x008d, code lost:
    
        if (r7 == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0093, code lost:
    
        if (r8 != Long.MIN_VALUE) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0095, code lost:
    
        if (r10 == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0099, code lost:
    
        if (r8 != r16) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x009b, code lost:
    
        if (r10 != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x009d, code lost:
    
        if (r10 == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00a0, code lost:
    
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a1, code lost:
    
        r19.f57043l = r8;
        r19.f57041j.skip(r5);
        r19.f57042k = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00ad, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ae, code lost:
    
        if (r6 == 2) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b0, code lost:
    
        if (r6 == 4) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00b3, code lost:
    
        if (r6 != 7) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00b6, code lost:
    
        return r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00b7, code lost:
    
        r19.f57044m = r5;
        r19.f57042k = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00bd, code lost:
    
        return 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00be, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int z0() throws java.io.EOFException {
        /*
            Method dump skipped, instruction units count: 221
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.JsonUtf8Reader.z0():int");
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public JsonReader.Token C() throws JsonEncodingException, EOFException {
        int iT = this.f57042k;
        if (iT == 0) {
            iT = T();
        }
        switch (iT) {
            case 1:
                return JsonReader.Token.BEGIN_OBJECT;
            case 2:
                return JsonReader.Token.END_OBJECT;
            case 3:
                return JsonReader.Token.BEGIN_ARRAY;
            case 4:
                return JsonReader.Token.END_ARRAY;
            case 5:
            case 6:
                return JsonReader.Token.BOOLEAN;
            case 7:
                return JsonReader.Token.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonReader.Token.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return JsonReader.Token.NAME;
            case 16:
            case 17:
                return JsonReader.Token.NUMBER;
            case 18:
                return JsonReader.Token.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int J(JsonReader.Options options) throws JsonEncodingException, EOFException {
        int iT = this.f57042k;
        if (iT == 0) {
            iT = T();
        }
        if (iT < 12 || iT > 15) {
            return -1;
        }
        if (iT == 15) {
            return V(this.f57045n, options);
        }
        int iI2 = this.f57040i.I2(options.f57023b);
        if (iI2 != -1) {
            this.f57042k = 0;
            this.f57018c[this.f57016a - 1] = options.f57022a[iI2];
            return iI2;
        }
        String str = this.f57018c[this.f57016a - 1];
        String strN = n();
        int iV = V(strN, options);
        if (iV == -1) {
            this.f57042k = 15;
            this.f57045n = strN;
            this.f57018c[this.f57016a - 1] = str;
        }
        return iV;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void K() throws JsonEncodingException, EOFException {
        if (this.f57021g) {
            throw new JsonDataException("Cannot skip unexpected " + C() + " at " + g());
        }
        int iT = this.f57042k;
        if (iT == 0) {
            iT = T();
        }
        if (iT == 14) {
            X0();
        } else if (iT == 13) {
            O0(f57036p);
        } else if (iT == 12) {
            O0(f57035o);
        } else if (iT != 15) {
            throw new JsonDataException("Expected a name but was " + C() + " at path " + g());
        }
        this.f57042k = 0;
        this.f57018c[this.f57016a - 1] = "null";
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void L() throws JsonEncodingException, EOFException {
        if (this.f57021g) {
            throw new JsonDataException("Cannot skip unexpected " + C() + " at " + g());
        }
        int i3 = 0;
        do {
            int iT = this.f57042k;
            if (iT == 0) {
                iT = T();
            }
            if (iT == 3) {
                F(1);
            } else if (iT == 1) {
                F(3);
            } else {
                if (iT == 4) {
                    i3--;
                    if (i3 < 0) {
                        throw new JsonDataException("Expected a value but was " + C() + " at path " + g());
                    }
                    this.f57016a--;
                } else if (iT == 2) {
                    i3--;
                    if (i3 < 0) {
                        throw new JsonDataException("Expected a value but was " + C() + " at path " + g());
                    }
                    this.f57016a--;
                } else if (iT == 14 || iT == 10) {
                    X0();
                } else if (iT == 9 || iT == 13) {
                    O0(f57036p);
                } else if (iT == 8 || iT == 12) {
                    O0(f57035o);
                } else if (iT == 17) {
                    this.f57041j.skip(this.f57044m);
                } else if (iT == 18) {
                    throw new JsonDataException("Expected a value but was " + C() + " at path " + g());
                }
                this.f57042k = 0;
            }
            i3++;
            this.f57042k = 0;
        } while (i3 != 0);
        int[] iArr = this.f57019d;
        int i4 = this.f57016a;
        int i5 = i4 - 1;
        iArr[i5] = iArr[i5] + 1;
        this.f57018c[i4 - 1] = "null";
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void b() throws JsonEncodingException, EOFException {
        int iT = this.f57042k;
        if (iT == 0) {
            iT = T();
        }
        if (iT == 3) {
            F(1);
            this.f57019d[this.f57016a - 1] = 0;
            this.f57042k = 0;
        } else {
            throw new JsonDataException("Expected BEGIN_ARRAY but was " + C() + " at path " + g());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void c() throws JsonEncodingException, EOFException {
        int iT = this.f57042k;
        if (iT == 0) {
            iT = T();
        }
        if (iT == 1) {
            F(3);
            this.f57042k = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_OBJECT but was " + C() + " at path " + g());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws EOFException {
        this.f57042k = 0;
        this.f57017b[0] = 8;
        this.f57016a = 1;
        this.f57041j.a();
        this.f57040i.close();
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void f() throws JsonEncodingException, EOFException {
        int iT = this.f57042k;
        if (iT == 0) {
            iT = T();
        }
        if (iT != 4) {
            throw new JsonDataException("Expected END_ARRAY but was " + C() + " at path " + g());
        }
        int i3 = this.f57016a;
        this.f57016a = i3 - 1;
        int[] iArr = this.f57019d;
        int i4 = i3 - 2;
        iArr[i4] = iArr[i4] + 1;
        this.f57042k = 0;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void i() throws JsonEncodingException, EOFException {
        int iT = this.f57042k;
        if (iT == 0) {
            iT = T();
        }
        if (iT != 2) {
            throw new JsonDataException("Expected END_OBJECT but was " + C() + " at path " + g());
        }
        int i3 = this.f57016a;
        int i4 = i3 - 1;
        this.f57016a = i4;
        this.f57018c[i4] = null;
        int[] iArr = this.f57019d;
        int i5 = i3 - 2;
        iArr[i5] = iArr[i5] + 1;
        this.f57042k = 0;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean j() throws JsonEncodingException, EOFException {
        int iT = this.f57042k;
        if (iT == 0) {
            iT = T();
        }
        return (iT == 2 || iT == 4 || iT == 18) ? false : true;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean k() throws JsonEncodingException, EOFException {
        int iT = this.f57042k;
        if (iT == 0) {
            iT = T();
        }
        if (iT == 5) {
            this.f57042k = 0;
            int[] iArr = this.f57019d;
            int i3 = this.f57016a - 1;
            iArr[i3] = iArr[i3] + 1;
            return true;
        }
        if (iT == 6) {
            this.f57042k = 0;
            int[] iArr2 = this.f57019d;
            int i4 = this.f57016a - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return false;
        }
        throw new JsonDataException("Expected a boolean but was " + C() + " at path " + g());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public double l() throws JsonEncodingException, EOFException {
        int iT = this.f57042k;
        if (iT == 0) {
            iT = T();
        }
        if (iT == 16) {
            this.f57042k = 0;
            int[] iArr = this.f57019d;
            int i3 = this.f57016a - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.f57043l;
        }
        if (iT == 17) {
            this.f57045n = this.f57041j.m1(this.f57044m);
        } else if (iT == 9) {
            this.f57045n = j0(f57036p);
        } else if (iT == 8) {
            this.f57045n = j0(f57035o);
        } else if (iT == 10) {
            this.f57045n = q0();
        } else if (iT != 11) {
            throw new JsonDataException("Expected a double but was " + C() + " at path " + g());
        }
        this.f57042k = 11;
        try {
            double d3 = Double.parseDouble(this.f57045n);
            if (this.f57020f || !(Double.isNaN(d3) || Double.isInfinite(d3))) {
                this.f57045n = null;
                this.f57042k = 0;
                int[] iArr2 = this.f57019d;
                int i4 = this.f57016a - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return d3;
            }
            throw new JsonEncodingException("JSON forbids NaN and infinities: " + d3 + " at path " + g());
        } catch (NumberFormatException unused) {
            throw new JsonDataException("Expected a double but was " + this.f57045n + " at path " + g());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int m() throws JsonEncodingException, EOFException {
        int iT = this.f57042k;
        if (iT == 0) {
            iT = T();
        }
        if (iT == 16) {
            long j3 = this.f57043l;
            int i3 = (int) j3;
            if (j3 == i3) {
                this.f57042k = 0;
                int[] iArr = this.f57019d;
                int i4 = this.f57016a - 1;
                iArr[i4] = iArr[i4] + 1;
                return i3;
            }
            throw new JsonDataException("Expected an int but was " + this.f57043l + " at path " + g());
        }
        if (iT == 17) {
            this.f57045n = this.f57041j.m1(this.f57044m);
        } else if (iT == 9 || iT == 8) {
            String strJ0 = iT == 9 ? j0(f57036p) : j0(f57035o);
            this.f57045n = strJ0;
            try {
                int i5 = Integer.parseInt(strJ0);
                this.f57042k = 0;
                int[] iArr2 = this.f57019d;
                int i6 = this.f57016a - 1;
                iArr2[i6] = iArr2[i6] + 1;
                return i5;
            } catch (NumberFormatException unused) {
            }
        } else if (iT != 11) {
            throw new JsonDataException("Expected an int but was " + C() + " at path " + g());
        }
        this.f57042k = 11;
        try {
            double d3 = Double.parseDouble(this.f57045n);
            int i7 = (int) d3;
            if (i7 == d3) {
                this.f57045n = null;
                this.f57042k = 0;
                int[] iArr3 = this.f57019d;
                int i8 = this.f57016a - 1;
                iArr3[i8] = iArr3[i8] + 1;
                return i7;
            }
            throw new JsonDataException("Expected an int but was " + this.f57045n + " at path " + g());
        } catch (NumberFormatException unused2) {
            throw new JsonDataException("Expected an int but was " + this.f57045n + " at path " + g());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String n() throws JsonEncodingException, EOFException {
        String strJ0;
        int iT = this.f57042k;
        if (iT == 0) {
            iT = T();
        }
        if (iT == 14) {
            strJ0 = q0();
        } else if (iT == 13) {
            strJ0 = j0(f57036p);
        } else if (iT == 12) {
            strJ0 = j0(f57035o);
        } else {
            if (iT != 15) {
                throw new JsonDataException("Expected a name but was " + C() + " at path " + g());
            }
            strJ0 = this.f57045n;
        }
        this.f57042k = 0;
        this.f57018c[this.f57016a - 1] = strJ0;
        return strJ0;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String r() throws JsonEncodingException, EOFException {
        String strM1;
        int iT = this.f57042k;
        if (iT == 0) {
            iT = T();
        }
        if (iT == 10) {
            strM1 = q0();
        } else if (iT == 9) {
            strM1 = j0(f57036p);
        } else if (iT == 8) {
            strM1 = j0(f57035o);
        } else if (iT == 11) {
            strM1 = this.f57045n;
            this.f57045n = null;
        } else if (iT == 16) {
            strM1 = Long.toString(this.f57043l);
        } else {
            if (iT != 17) {
                throw new JsonDataException("Expected a string but was " + C() + " at path " + g());
            }
            strM1 = this.f57041j.m1(this.f57044m);
        }
        this.f57042k = 0;
        int[] iArr = this.f57019d;
        int i3 = this.f57016a - 1;
        iArr[i3] = iArr[i3] + 1;
        return strM1;
    }

    public String toString() {
        return "JsonReader(" + this.f57040i + ")";
    }
}
