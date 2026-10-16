package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public abstract class AbstractJsonLexer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f143035a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f143037c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JsonPath f143036b = new JsonPath();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private StringBuilder f143038d = new StringBuilder();

    private final int B(CharSequence charSequence, int i3) {
        char cCharAt = charSequence.charAt(i3);
        if ('0' <= cCharAt && cCharAt < ':') {
            return cCharAt - '0';
        }
        if ('a' <= cCharAt && cCharAt < 'g') {
            return cCharAt - 'W';
        }
        if ('A' <= cCharAt && cCharAt < 'G') {
            return cCharAt - '7';
        }
        x(this, "Invalid toHexChar char '" + cCharAt + "' in unicode escape", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final String N() {
        String str = this.f143037c;
        Intrinsics.checkNotNull(str);
        this.f143037c = null;
        return str;
    }

    public static /* synthetic */ boolean Q(AbstractJsonLexer abstractJsonLexer, boolean z2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryConsumeNull");
        }
        if ((i3 & 1) != 0) {
            z2 = true;
        }
        return abstractJsonLexer.P(z2);
    }

    private final boolean S() {
        return D().charAt(this.f143035a - 1) != '\"';
    }

    private final int a(int i3) {
        int iJ = J(i3);
        if (iJ == -1) {
            x(this, "Expected escape sequence to continue, got EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int i4 = iJ + 1;
        char cCharAt = D().charAt(iJ);
        if (cCharAt == 'u') {
            return c(D(), i4);
        }
        char cB = AbstractJsonLexerKt.b(cCharAt);
        if (cB != 0) {
            this.f143038d.append(cB);
            return i4;
        }
        x(this, "Invalid escaped char '" + cCharAt + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final int b(int i3, int i4) {
        d(i3, i4);
        return a(i4 + 1);
    }

    private final int c(CharSequence charSequence, int i3) {
        int i4 = i3 + 4;
        if (i4 < charSequence.length()) {
            this.f143038d.append((char) ((B(charSequence, i3) << 12) + (B(charSequence, i3 + 1) << 8) + (B(charSequence, i3 + 2) << 4) + B(charSequence, i3 + 3)));
            return i4;
        }
        this.f143035a = i3;
        u();
        if (this.f143035a + 4 < charSequence.length()) {
            return c(charSequence, this.f143035a);
        }
        x(this, "Unexpected EOF during unicode escape", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final boolean f(int i3) {
        int iJ = J(i3);
        if (iJ >= D().length() || iJ == -1) {
            x(this, "EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int i4 = iJ + 1;
        int iCharAt = D().charAt(iJ) | ' ';
        if (iCharAt == 102) {
            h("alse", i4);
            return false;
        }
        if (iCharAt == 116) {
            h("rue", i4);
            return true;
        }
        x(this, "Expected valid boolean literal prefix, but had '" + q() + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final void h(String str, int i3) {
        if (D().length() - i3 < str.length()) {
            x(this, "Unexpected end of boolean literal", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int length = str.length();
        for (int i4 = 0; i4 < length; i4++) {
            if (str.charAt(i4) != (D().charAt(i3 + i4) | ' ')) {
                x(this, "Expected valid boolean literal prefix, but had '" + q() + '\'', 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
        }
        this.f143035a = i3 + str.length();
    }

    private static final double n(long j3, boolean z2) {
        if (!z2) {
            return Math.pow(10.0d, -j3);
        }
        if (z2) {
            return Math.pow(10.0d, j3);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final String s(int i3, int i4) {
        d(i3, i4);
        String string = this.f143038d.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        this.f143038d.setLength(0);
        return string;
    }

    public static /* synthetic */ Void x(AbstractJsonLexer abstractJsonLexer, String str, int i3, String str2, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
        }
        if ((i4 & 2) != 0) {
            i3 = abstractJsonLexer.f143035a;
        }
        if ((i4 & 4) != 0) {
            str2 = "";
        }
        return abstractJsonLexer.w(str, i3, str2);
    }

    public static /* synthetic */ Void z(AbstractJsonLexer abstractJsonLexer, byte b3, boolean z2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
        }
        if ((i3 & 2) != 0) {
            z2 = true;
        }
        return abstractJsonLexer.y(b3, z2);
    }

    public final void A(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        w("Encountered an unknown key '" + key + '\'', StringsKt.u0(M(0, this.f143035a), key, 0, false, 6, null), "Use 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.");
        throw new KotlinNothingValueException();
    }

    protected final StringBuilder C() {
        return this.f143038d;
    }

    protected abstract CharSequence D();

    public final boolean E() {
        return H() != 10;
    }

    protected final boolean F(char c3) {
        return (c3 == ',' || c3 == ':' || c3 == ']' || c3 == '}') ? false : true;
    }

    public abstract String G(String str, boolean z2);

    public byte H() {
        CharSequence charSequenceD = D();
        int i3 = this.f143035a;
        while (true) {
            int iJ = J(i3);
            if (iJ == -1) {
                this.f143035a = iJ;
                return (byte) 10;
            }
            char cCharAt = charSequenceD.charAt(iJ);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != ' ') {
                this.f143035a = iJ;
                return AbstractJsonLexerKt.a(cCharAt);
            }
            i3 = iJ + 1;
        }
    }

    public final String I(boolean z2) {
        String strO;
        byte bH = H();
        if (z2) {
            if (bH != 1 && bH != 0) {
                return null;
            }
            strO = q();
        } else {
            if (bH != 1) {
                return null;
            }
            strO = o();
        }
        this.f143037c = strO;
        return strO;
    }

    public abstract int J(int i3);

    public final void K(boolean z2) {
        ArrayList arrayList = new ArrayList();
        byte bH = H();
        if (bH != 8 && bH != 6) {
            q();
            return;
        }
        while (true) {
            byte bH2 = H();
            if (bH2 != 1) {
                if (bH2 == 8 || bH2 == 6) {
                    arrayList.add(Byte.valueOf(bH2));
                } else if (bH2 == 9) {
                    if (((Number) CollectionsKt.last((List) arrayList)).byteValue() != 8) {
                        throw JsonExceptionsKt.f(this.f143035a, "found ] instead of } at path: " + this.f143036b, D());
                    }
                    CollectionsKt.removeLast(arrayList);
                } else if (bH2 == 7) {
                    if (((Number) CollectionsKt.last((List) arrayList)).byteValue() != 6) {
                        throw JsonExceptionsKt.f(this.f143035a, "found } instead of ] at path: " + this.f143036b, D());
                    }
                    CollectionsKt.removeLast(arrayList);
                } else if (bH2 == 10) {
                    x(this, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
                j();
                if (arrayList.size() == 0) {
                    return;
                }
            } else if (z2) {
                q();
            } else {
                i();
            }
        }
    }

    public abstract int L();

    public String M(int i3, int i4) {
        return D().subSequence(i3, i4).toString();
    }

    public final boolean O() {
        int iL = L();
        CharSequence charSequenceD = D();
        if (iL >= charSequenceD.length() || iL == -1 || charSequenceD.charAt(iL) != ',') {
            return false;
        }
        this.f143035a++;
        return true;
    }

    public final boolean P(boolean z2) {
        int iJ = J(L());
        int length = D().length() - iJ;
        if (length < 4 || iJ == -1) {
            return false;
        }
        for (int i3 = 0; i3 < 4; i3++) {
            if ("null".charAt(i3) != D().charAt(iJ + i3)) {
                return false;
            }
        }
        if (length > 4 && AbstractJsonLexerKt.a(D().charAt(iJ + 4)) == 0) {
            return false;
        }
        if (!z2) {
            return true;
        }
        this.f143035a = iJ + 4;
        return true;
    }

    protected final void R(char c3) {
        int i3 = this.f143035a;
        if (i3 > 0 && c3 == '\"') {
            try {
                this.f143035a = i3 - 1;
                String strQ = q();
                this.f143035a = i3;
                if (Intrinsics.areEqual(strQ, "null")) {
                    w("Expected string literal but 'null' literal was found", this.f143035a - 1, "Use 'coerceInputValues = true' in 'Json {}' builder to coerce nulls if property has a default value.");
                    throw new KotlinNothingValueException();
                }
            } catch (Throwable th) {
                this.f143035a = i3;
                throw th;
            }
        }
        z(this, AbstractJsonLexerKt.a(c3), false, 2, null);
        throw new KotlinNothingValueException();
    }

    protected void d(int i3, int i4) {
        this.f143038d.append(D(), i3, i4);
    }

    public abstract boolean e();

    public final boolean g() {
        boolean z2;
        int iL = L();
        if (iL == D().length()) {
            x(this, "EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        if (D().charAt(iL) == '\"') {
            iL++;
            z2 = true;
        } else {
            z2 = false;
        }
        boolean zF = f(iL);
        if (!z2) {
            return zF;
        }
        if (this.f143035a == D().length()) {
            x(this, "EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        if (D().charAt(this.f143035a) == '\"') {
            this.f143035a++;
            return zF;
        }
        x(this, "Expected closing quotation mark", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    public abstract String i();

    public abstract byte j();

    public final byte k(byte b3) {
        byte bJ = j();
        if (bJ == b3) {
            return bJ;
        }
        z(this, b3, false, 2, null);
        throw new KotlinNothingValueException();
    }

    public abstract void l(char c3);

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01f1, code lost:
    
        x(r18, "Expected numeric literal", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0201, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x011a, code lost:
    
        x(r18, "Unexpected symbol '" + r15 + "' in numeric literal", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x013e, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x013f, code lost:
    
        if (r2 == r1) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0141, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0143, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0144, code lost:
    
        if (r1 == r2) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0146, code lost:
    
        if (r9 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x014a, code lost:
    
        if (r1 == (r2 - 1)) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x014c, code lost:
    
        if (r0 == false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x014e, code lost:
    
        if (r4 == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0158, code lost:
    
        if (D().charAt(r2) != '\"') goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x015a, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x015f, code lost:
    
        x(r18, "Expected closing quotation mark", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x016f, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0170, code lost:
    
        x(r18, "EOF", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0180, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0181, code lost:
    
        r18.f143035a = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0183, code lost:
    
        if (r8 == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0185, code lost:
    
        r1 = r10 * n(r12, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x018f, code lost:
    
        if (r1 > 9.223372036854776E18d) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0195, code lost:
    
        if (r1 < (-9.223372036854776E18d)) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x019d, code lost:
    
        if (java.lang.Math.floor(r1) != r1) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x019f, code lost:
    
        r10 = (long) r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01a1, code lost:
    
        x(r18, "Can't convert " + r1 + " to Long", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01c3, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01c4, code lost:
    
        x(r18, "Numeric value overflow", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01d4, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01d5, code lost:
    
        if (r9 == false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01d7, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01dc, code lost:
    
        if (r10 == Long.MIN_VALUE) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01df, code lost:
    
        return -r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01e0, code lost:
    
        x(r18, "Numeric value overflow", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01f0, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long m() {
        /*
            Method dump skipped, instruction units count: 531
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.AbstractJsonLexer.m():long");
    }

    public final String o() {
        return this.f143037c != null ? N() : i();
    }

    protected final String p(CharSequence source, int i3, int i4) {
        Intrinsics.checkNotNullParameter(source, "source");
        char cCharAt = source.charAt(i4);
        boolean z2 = false;
        while (cCharAt != '\"') {
            if (cCharAt == '\\') {
                int iJ = J(b(i3, i4));
                if (iJ == -1) {
                    x(this, "Unexpected EOF", iJ, null, 4, null);
                    throw new KotlinNothingValueException();
                }
                z2 = true;
                i3 = iJ;
                i4 = i3;
            } else {
                i4++;
                if (i4 >= source.length()) {
                    d(i3, i4);
                    int iJ2 = J(i4);
                    if (iJ2 == -1) {
                        x(this, "Unexpected EOF", iJ2, null, 4, null);
                        throw new KotlinNothingValueException();
                    }
                    i3 = iJ2;
                    i4 = i3;
                    z2 = true;
                } else {
                    continue;
                }
            }
            cCharAt = source.charAt(i4);
        }
        String strM = !z2 ? M(i3, i4) : s(i3, i4);
        this.f143035a = i4 + 1;
        return strM;
    }

    public final String q() {
        if (this.f143037c != null) {
            return N();
        }
        int iL = L();
        if (iL >= D().length() || iL == -1) {
            x(this, "EOF", iL, null, 4, null);
            throw new KotlinNothingValueException();
        }
        byte bA = AbstractJsonLexerKt.a(D().charAt(iL));
        if (bA == 1) {
            return o();
        }
        if (bA != 0) {
            x(this, "Expected beginning of the string, but got " + D().charAt(iL), 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        boolean z2 = false;
        while (AbstractJsonLexerKt.a(D().charAt(iL)) == 0) {
            iL++;
            if (iL >= D().length()) {
                d(this.f143035a, iL);
                int iJ = J(iL);
                if (iJ == -1) {
                    this.f143035a = iL;
                    return s(0, 0);
                }
                iL = iJ;
                z2 = true;
            }
        }
        String strM = !z2 ? M(this.f143035a, iL) : s(this.f143035a, iL);
        this.f143035a = iL;
        return strM;
    }

    public final String r() {
        String strQ = q();
        if (!Intrinsics.areEqual(strQ, "null") || !S()) {
            return strQ;
        }
        x(this, "Unexpected 'null' value instead of string literal", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    public final void t() {
        this.f143037c = null;
    }

    public String toString() {
        return "JsonReader(source='" + ((Object) D()) + "', currentPosition=" + this.f143035a + ')';
    }

    public final void v() {
        if (j() == 10) {
            return;
        }
        x(this, "Expected EOF after parsing, but had " + D().charAt(this.f143035a - 1) + " instead", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    public final Void w(String message, int i3, String hint) {
        String str;
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(hint, "hint");
        if (hint.length() == 0) {
            str = "";
        } else {
            str = '\n' + hint;
        }
        throw JsonExceptionsKt.f(i3, message + " at path: " + this.f143036b.a() + str, D());
    }

    public final Void y(byte b3, boolean z2) {
        String strC = AbstractJsonLexerKt.c(b3);
        int i3 = z2 ? this.f143035a - 1 : this.f143035a;
        x(this, "Expected " + strC + ", but had '" + ((this.f143035a == D().length() || i3 < 0) ? "EOF" : String.valueOf(D().charAt(i3))) + "' instead", i3, null, 4, null);
        throw new KotlinNothingValueException();
    }

    public void u() {
    }
}
