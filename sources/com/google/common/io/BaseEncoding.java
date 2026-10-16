package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class BaseEncoding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final BaseEncoding f85182a = new Base64Encoding("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final BaseEncoding f85183b = new Base64Encoding("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final BaseEncoding f85184c = new StandardBaseEncoding("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final BaseEncoding f85185d = new StandardBaseEncoding("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final BaseEncoding f85186e = new Base16Encoding("base16()", "0123456789ABCDEF");

    /* JADX INFO: renamed from: com.google.common.io.BaseEncoding$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends ByteSink {
    }

    /* JADX INFO: renamed from: com.google.common.io.BaseEncoding$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 extends ByteSource {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CharSource f85187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BaseEncoding f85188b;

        @Override // com.google.common.io.ByteSource
        public InputStream a() {
            return this.f85188b.f(this.f85187a.a());
        }
    }

    /* JADX INFO: renamed from: com.google.common.io.BaseEncoding$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass5 extends Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Appendable f85195a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Writer f85196b;

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f85196b.close();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            this.f85196b.flush();
        }

        @Override // java.io.Writer
        public void write(int i3) throws IOException {
            this.f85195a.append((char) i3);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i3, int i4) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Alphabet {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f85197a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final char[] f85198b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f85199c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f85200d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final int f85201e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final int f85202f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final byte[] f85203g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean[] f85204h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final boolean f85205i;

        Alphabet(String str, char[] cArr) {
            this(str, cArr, b(cArr), false);
        }

        private static byte[] b(char[] cArr) {
            byte[] bArr = new byte[ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD];
            Arrays.fill(bArr, (byte) -1);
            for (int i3 = 0; i3 < cArr.length; i3++) {
                char c3 = cArr[i3];
                boolean z2 = true;
                Preconditions.f(c3 < 128, "Non-ASCII character: %s", c3);
                if (bArr[c3] != -1) {
                    z2 = false;
                }
                Preconditions.f(z2, "Duplicate character: %s", c3);
                bArr[c3] = (byte) i3;
            }
            return bArr;
        }

        int c(char c3) throws DecodingException {
            if (c3 > 127) {
                throw new DecodingException("Unrecognized character: 0x" + Integer.toHexString(c3));
            }
            byte b3 = this.f85203g[c3];
            if (b3 != -1) {
                return b3;
            }
            if (c3 <= ' ' || c3 == 127) {
                throw new DecodingException("Unrecognized character: 0x" + Integer.toHexString(c3));
            }
            throw new DecodingException("Unrecognized character: " + c3);
        }

        char d(int i3) {
            return this.f85198b[i3];
        }

        boolean e(int i3) {
            return this.f85204h[i3 % this.f85201e];
        }

        public boolean equals(Object obj) {
            if (obj instanceof Alphabet) {
                Alphabet alphabet = (Alphabet) obj;
                if (this.f85205i == alphabet.f85205i && Arrays.equals(this.f85198b, alphabet.f85198b)) {
                    return true;
                }
            }
            return false;
        }

        public boolean f(char c3) {
            byte[] bArr = this.f85203g;
            return c3 < bArr.length && bArr[c3] != -1;
        }

        public int hashCode() {
            return Arrays.hashCode(this.f85198b) + (this.f85205i ? 1231 : 1237);
        }

        public String toString() {
            return this.f85197a;
        }

        private Alphabet(String str, char[] cArr, byte[] bArr, boolean z2) {
            this.f85197a = (String) Preconditions.t(str);
            this.f85198b = (char[]) Preconditions.t(cArr);
            try {
                int iH = IntMath.h(cArr.length, RoundingMode.UNNECESSARY);
                this.f85200d = iH;
                int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(iH);
                int i3 = 1 << (3 - iNumberOfTrailingZeros);
                this.f85201e = i3;
                this.f85202f = iH >> iNumberOfTrailingZeros;
                this.f85199c = cArr.length - 1;
                this.f85203g = bArr;
                boolean[] zArr = new boolean[i3];
                for (int i4 = 0; i4 < this.f85202f; i4++) {
                    zArr[IntMath.d(i4 * 8, this.f85200d, RoundingMode.CEILING)] = true;
                }
                this.f85204h = zArr;
                this.f85205i = z2;
            } catch (ArithmeticException e3) {
                throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e3);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Base16Encoding extends StandardBaseEncoding {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final char[] f85206h;

        Base16Encoding(String str, String str2) {
            this(new Alphabet(str, str2.toCharArray()));
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        int e(byte[] bArr, CharSequence charSequence) throws DecodingException {
            Preconditions.t(bArr);
            if (charSequence.length() % 2 == 1) {
                throw new DecodingException("Invalid input length " + charSequence.length());
            }
            int i3 = 0;
            int i4 = 0;
            while (i3 < charSequence.length()) {
                bArr[i4] = (byte) ((this.f85210f.c(charSequence.charAt(i3)) << 4) | this.f85210f.c(charSequence.charAt(i3 + 1)));
                i3 += 2;
                i4++;
            }
            return i4;
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        void i(Appendable appendable, byte[] bArr, int i3, int i4) throws IOException {
            Preconditions.t(appendable);
            Preconditions.y(i3, i3 + i4, bArr.length);
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = bArr[i3 + i5] & 255;
                appendable.append(this.f85206h[i6]);
                appendable.append(this.f85206h[i6 | Function.MAX_NARGS]);
            }
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding
        BaseEncoding s(Alphabet alphabet, Character ch) {
            return new Base16Encoding(alphabet);
        }

        private Base16Encoding(Alphabet alphabet) {
            super(alphabet, null);
            this.f85206h = new char[512];
            Preconditions.d(alphabet.f85198b.length == 16);
            for (int i3 = 0; i3 < 256; i3++) {
                this.f85206h[i3] = alphabet.d(i3 >>> 4);
                this.f85206h[i3 | Function.MAX_NARGS] = alphabet.d(i3 & 15);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Base64Encoding extends StandardBaseEncoding {
        Base64Encoding(String str, String str2, Character ch) {
            this(new Alphabet(str, str2.toCharArray()), ch);
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        int e(byte[] bArr, CharSequence charSequence) throws DecodingException {
            Preconditions.t(bArr);
            CharSequence charSequenceP = p(charSequence);
            if (!this.f85210f.e(charSequenceP.length())) {
                throw new DecodingException("Invalid input length " + charSequenceP.length());
            }
            int i3 = 0;
            int i4 = 0;
            while (i3 < charSequenceP.length()) {
                int i5 = i3 + 2;
                int iC = (this.f85210f.c(charSequenceP.charAt(i3)) << 18) | (this.f85210f.c(charSequenceP.charAt(i3 + 1)) << 12);
                int i6 = i4 + 1;
                bArr[i4] = (byte) (iC >>> 16);
                if (i5 < charSequenceP.length()) {
                    int i7 = i3 + 3;
                    int iC2 = iC | (this.f85210f.c(charSequenceP.charAt(i5)) << 6);
                    int i8 = i4 + 2;
                    bArr[i6] = (byte) ((iC2 >>> 8) & 255);
                    if (i7 < charSequenceP.length()) {
                        i3 += 4;
                        i4 += 3;
                        bArr[i8] = (byte) ((iC2 | this.f85210f.c(charSequenceP.charAt(i7))) & 255);
                    } else {
                        i4 = i8;
                        i3 = i7;
                    }
                } else {
                    i4 = i6;
                    i3 = i5;
                }
            }
            return i4;
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        void i(Appendable appendable, byte[] bArr, int i3, int i4) throws IOException {
            Preconditions.t(appendable);
            int i5 = i3 + i4;
            Preconditions.y(i3, i5, bArr.length);
            while (i4 >= 3) {
                int i6 = i3 + 2;
                int i7 = ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3] & 255) << 16);
                i3 += 3;
                int i8 = i7 | (bArr[i6] & 255);
                appendable.append(this.f85210f.d(i8 >>> 18));
                appendable.append(this.f85210f.d((i8 >>> 12) & 63));
                appendable.append(this.f85210f.d((i8 >>> 6) & 63));
                appendable.append(this.f85210f.d(i8 & 63));
                i4 -= 3;
            }
            if (i3 < i5) {
                r(appendable, bArr, i3, i5 - i3);
            }
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding
        BaseEncoding s(Alphabet alphabet, Character ch) {
            return new Base64Encoding(alphabet, ch);
        }

        private Base64Encoding(Alphabet alphabet, Character ch) {
            super(alphabet, ch);
            Preconditions.d(alphabet.f85198b.length == 64);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class DecodingException extends IOException {
        DecodingException(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SeparatedBaseEncoding extends BaseEncoding {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final BaseEncoding f85207f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final String f85208g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final int f85209h;

        SeparatedBaseEncoding(BaseEncoding baseEncoding, String str, int i3) {
            this.f85207f = (BaseEncoding) Preconditions.t(baseEncoding);
            this.f85208g = (String) Preconditions.t(str);
            this.f85209h = i3;
            Preconditions.h(i3 > 0, "Cannot add a separator after every %s chars", i3);
        }

        @Override // com.google.common.io.BaseEncoding
        int e(byte[] bArr, CharSequence charSequence) {
            StringBuilder sb = new StringBuilder(charSequence.length());
            for (int i3 = 0; i3 < charSequence.length(); i3++) {
                char cCharAt = charSequence.charAt(i3);
                if (this.f85208g.indexOf(cCharAt) < 0) {
                    sb.append(cCharAt);
                }
            }
            return this.f85207f.e(bArr, sb);
        }

        @Override // com.google.common.io.BaseEncoding
        public InputStream f(Reader reader) {
            return this.f85207f.f(BaseEncoding.k(reader, this.f85208g));
        }

        @Override // com.google.common.io.BaseEncoding
        void i(Appendable appendable, byte[] bArr, int i3, int i4) {
            this.f85207f.i(BaseEncoding.o(appendable, this.f85208g, this.f85209h), bArr, i3, i4);
        }

        @Override // com.google.common.io.BaseEncoding
        int l(int i3) {
            return this.f85207f.l(i3);
        }

        @Override // com.google.common.io.BaseEncoding
        int m(int i3) {
            int iM = this.f85207f.m(i3);
            return iM + (this.f85208g.length() * IntMath.d(Math.max(0, iM - 1), this.f85209h, RoundingMode.FLOOR));
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding n() {
            return this.f85207f.n().q(this.f85208g, this.f85209h);
        }

        @Override // com.google.common.io.BaseEncoding
        CharSequence p(CharSequence charSequence) {
            return this.f85207f.p(charSequence);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding q(String str, int i3) {
            throw new UnsupportedOperationException("Already have a separator");
        }

        public String toString() {
            return this.f85207f + ".withSeparator(\"" + this.f85208g + "\", " + this.f85209h + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class StandardBaseEncoding extends BaseEncoding {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final Alphabet f85210f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Character f85211g;

        /* JADX INFO: renamed from: com.google.common.io.BaseEncoding$StandardBaseEncoding$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 extends OutputStream {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f85212a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f85213b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f85214c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ Writer f85215d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ StandardBaseEncoding f85216f;

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                int i3 = this.f85213b;
                if (i3 > 0) {
                    int i4 = this.f85212a;
                    Alphabet alphabet = this.f85216f.f85210f;
                    this.f85215d.write(alphabet.d((i4 << (alphabet.f85200d - i3)) & alphabet.f85199c));
                    this.f85214c++;
                    if (this.f85216f.f85211g != null) {
                        while (true) {
                            int i5 = this.f85214c;
                            StandardBaseEncoding standardBaseEncoding = this.f85216f;
                            if (i5 % standardBaseEncoding.f85210f.f85201e == 0) {
                                break;
                            }
                            this.f85215d.write(standardBaseEncoding.f85211g.charValue());
                            this.f85214c++;
                        }
                    }
                }
                this.f85215d.close();
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() throws IOException {
                this.f85215d.flush();
            }

            @Override // java.io.OutputStream
            public void write(int i3) throws IOException {
                this.f85212a = (i3 & 255) | (this.f85212a << 8);
                this.f85213b += 8;
                while (true) {
                    int i4 = this.f85213b;
                    Alphabet alphabet = this.f85216f.f85210f;
                    int i5 = alphabet.f85200d;
                    if (i4 < i5) {
                        return;
                    }
                    this.f85215d.write(alphabet.d((this.f85212a >> (i4 - i5)) & alphabet.f85199c));
                    this.f85214c++;
                    this.f85213b -= this.f85216f.f85210f.f85200d;
                }
            }
        }

        StandardBaseEncoding(String str, String str2, Character ch) {
            this(new Alphabet(str, str2.toCharArray()), ch);
        }

        @Override // com.google.common.io.BaseEncoding
        int e(byte[] bArr, CharSequence charSequence) throws DecodingException {
            Alphabet alphabet;
            Preconditions.t(bArr);
            CharSequence charSequenceP = p(charSequence);
            if (!this.f85210f.e(charSequenceP.length())) {
                throw new DecodingException("Invalid input length " + charSequenceP.length());
            }
            int i3 = 0;
            int i4 = 0;
            while (i3 < charSequenceP.length()) {
                long jC = 0;
                int i5 = 0;
                int i6 = 0;
                while (true) {
                    alphabet = this.f85210f;
                    if (i5 >= alphabet.f85201e) {
                        break;
                    }
                    jC <<= alphabet.f85200d;
                    if (i3 + i5 < charSequenceP.length()) {
                        jC |= (long) this.f85210f.c(charSequenceP.charAt(i6 + i3));
                        i6++;
                    }
                    i5++;
                }
                int i7 = alphabet.f85202f;
                int i8 = (i7 * 8) - (i6 * alphabet.f85200d);
                int i9 = (i7 - 1) * 8;
                while (i9 >= i8) {
                    bArr[i4] = (byte) ((jC >>> i9) & 255);
                    i9 -= 8;
                    i4++;
                }
                i3 += this.f85210f.f85201e;
            }
            return i4;
        }

        public boolean equals(Object obj) {
            if (obj instanceof StandardBaseEncoding) {
                StandardBaseEncoding standardBaseEncoding = (StandardBaseEncoding) obj;
                if (this.f85210f.equals(standardBaseEncoding.f85210f) && Objects.equals(this.f85211g, standardBaseEncoding.f85211g)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.io.BaseEncoding
        public InputStream f(final Reader reader) {
            Preconditions.t(reader);
            return new InputStream(this) { // from class: com.google.common.io.BaseEncoding.StandardBaseEncoding.2

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f85217a = 0;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                int f85218b = 0;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                int f85219c = 0;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                boolean f85220d = false;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ StandardBaseEncoding f85222g;

                {
                    this.f85222g = this;
                }

                @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    reader.close();
                }

                /* JADX WARN: Code restructure failed: missing block: B:24:0x0074, code lost:
                
                    throw new com.google.common.io.BaseEncoding.DecodingException("Padding cannot start at index " + r4.f85219c);
                 */
                @Override // java.io.InputStream
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public int read() throws java.io.IOException {
                    /*
                        r4 = this;
                    L0:
                        java.io.Reader r0 = r2
                        int r0 = r0.read()
                        r1 = -1
                        if (r0 != r1) goto L34
                        boolean r0 = r4.f85220d
                        if (r0 != 0) goto L33
                        com.google.common.io.BaseEncoding$StandardBaseEncoding r0 = r4.f85222g
                        com.google.common.io.BaseEncoding$Alphabet r0 = r0.f85210f
                        int r2 = r4.f85219c
                        boolean r0 = r0.e(r2)
                        if (r0 == 0) goto L1a
                        goto L33
                    L1a:
                        com.google.common.io.BaseEncoding$DecodingException r0 = new com.google.common.io.BaseEncoding$DecodingException
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder
                        r1.<init>()
                        java.lang.String r2 = "Invalid input length "
                        r1.append(r2)
                        int r2 = r4.f85219c
                        r1.append(r2)
                        java.lang.String r1 = r1.toString()
                        r0.<init>(r1)
                        throw r0
                    L33:
                        return r1
                    L34:
                        int r1 = r4.f85219c
                        r2 = 1
                        int r1 = r1 + r2
                        r4.f85219c = r1
                        char r0 = (char) r0
                        com.google.common.io.BaseEncoding$StandardBaseEncoding r1 = r4.f85222g
                        java.lang.Character r1 = r1.f85211g
                        if (r1 == 0) goto L78
                        char r1 = r1.charValue()
                        if (r1 != r0) goto L78
                        boolean r0 = r4.f85220d
                        if (r0 != 0) goto L75
                        int r0 = r4.f85219c
                        if (r0 == r2) goto L5c
                        com.google.common.io.BaseEncoding$StandardBaseEncoding r1 = r4.f85222g
                        com.google.common.io.BaseEncoding$Alphabet r1 = r1.f85210f
                        int r0 = r0 + (-1)
                        boolean r0 = r1.e(r0)
                        if (r0 == 0) goto L5c
                        goto L75
                    L5c:
                        com.google.common.io.BaseEncoding$DecodingException r0 = new com.google.common.io.BaseEncoding$DecodingException
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder
                        r1.<init>()
                        java.lang.String r2 = "Padding cannot start at index "
                        r1.append(r2)
                        int r2 = r4.f85219c
                        r1.append(r2)
                        java.lang.String r1 = r1.toString()
                        r0.<init>(r1)
                        throw r0
                    L75:
                        r4.f85220d = r2
                        goto L0
                    L78:
                        boolean r1 = r4.f85220d
                        if (r1 != 0) goto La4
                        int r1 = r4.f85217a
                        com.google.common.io.BaseEncoding$StandardBaseEncoding r2 = r4.f85222g
                        com.google.common.io.BaseEncoding$Alphabet r2 = r2.f85210f
                        int r3 = r2.f85200d
                        int r1 = r1 << r3
                        r4.f85217a = r1
                        int r0 = r2.c(r0)
                        r0 = r0 | r1
                        r4.f85217a = r0
                        int r1 = r4.f85218b
                        com.google.common.io.BaseEncoding$StandardBaseEncoding r2 = r4.f85222g
                        com.google.common.io.BaseEncoding$Alphabet r2 = r2.f85210f
                        int r2 = r2.f85200d
                        int r1 = r1 + r2
                        r4.f85218b = r1
                        r2 = 8
                        if (r1 < r2) goto L0
                        int r1 = r1 - r2
                        r4.f85218b = r1
                        int r0 = r0 >> r1
                        r0 = r0 & 255(0xff, float:3.57E-43)
                        return r0
                    La4:
                        com.google.common.io.BaseEncoding$DecodingException r1 = new com.google.common.io.BaseEncoding$DecodingException
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder
                        r2.<init>()
                        java.lang.String r3 = "Expected padding character but found '"
                        r2.append(r3)
                        r2.append(r0)
                        java.lang.String r0 = "' at index "
                        r2.append(r0)
                        int r0 = r4.f85219c
                        r2.append(r0)
                        java.lang.String r0 = r2.toString()
                        r1.<init>(r0)
                        throw r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.BaseEncoding.StandardBaseEncoding.AnonymousClass2.read():int");
                }

                @Override // java.io.InputStream
                public int read(byte[] bArr, int i3, int i4) throws IOException {
                    int i5 = i4 + i3;
                    Preconditions.y(i3, i5, bArr.length);
                    int i6 = i3;
                    while (i6 < i5) {
                        int i7 = read();
                        if (i7 == -1) {
                            int i8 = i6 - i3;
                            if (i8 == 0) {
                                return -1;
                            }
                            return i8;
                        }
                        bArr[i6] = (byte) i7;
                        i6++;
                    }
                    return i6 - i3;
                }
            };
        }

        public int hashCode() {
            return this.f85210f.hashCode() ^ Objects.hashCode(this.f85211g);
        }

        @Override // com.google.common.io.BaseEncoding
        void i(Appendable appendable, byte[] bArr, int i3, int i4) throws IOException {
            Preconditions.t(appendable);
            Preconditions.y(i3, i3 + i4, bArr.length);
            int i5 = 0;
            while (i5 < i4) {
                r(appendable, bArr, i3 + i5, Math.min(this.f85210f.f85202f, i4 - i5));
                i5 += this.f85210f.f85202f;
            }
        }

        @Override // com.google.common.io.BaseEncoding
        int l(int i3) {
            return (int) (((((long) this.f85210f.f85200d) * ((long) i3)) + 7) / 8);
        }

        @Override // com.google.common.io.BaseEncoding
        int m(int i3) {
            Alphabet alphabet = this.f85210f;
            return alphabet.f85201e * IntMath.d(i3, alphabet.f85202f, RoundingMode.CEILING);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding n() {
            return this.f85211g == null ? this : s(this.f85210f, null);
        }

        @Override // com.google.common.io.BaseEncoding
        CharSequence p(CharSequence charSequence) {
            Preconditions.t(charSequence);
            Character ch = this.f85211g;
            if (ch == null) {
                return charSequence;
            }
            char cCharValue = ch.charValue();
            int length = charSequence.length() - 1;
            while (length >= 0 && charSequence.charAt(length) == cCharValue) {
                length--;
            }
            return charSequence.subSequence(0, length + 1);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding q(String str, int i3) {
            for (int i4 = 0; i4 < str.length(); i4++) {
                Preconditions.m(!this.f85210f.f(str.charAt(i4)), "Separator (%s) cannot contain alphabet characters", str);
            }
            Character ch = this.f85211g;
            if (ch != null) {
                Preconditions.m(str.indexOf(ch.charValue()) < 0, "Separator (%s) cannot contain padding character", str);
            }
            return new SeparatedBaseEncoding(this, str, i3);
        }

        void r(Appendable appendable, byte[] bArr, int i3, int i4) throws IOException {
            Preconditions.t(appendable);
            Preconditions.y(i3, i3 + i4, bArr.length);
            int i5 = 0;
            Preconditions.d(i4 <= this.f85210f.f85202f);
            long j3 = 0;
            for (int i6 = 0; i6 < i4; i6++) {
                j3 = (j3 | ((long) (bArr[i3 + i6] & 255))) << 8;
            }
            int i7 = ((i4 + 1) * 8) - this.f85210f.f85200d;
            while (i5 < i4 * 8) {
                Alphabet alphabet = this.f85210f;
                appendable.append(alphabet.d(((int) (j3 >>> (i7 - i5))) & alphabet.f85199c));
                i5 += this.f85210f.f85200d;
            }
            if (this.f85211g != null) {
                while (i5 < this.f85210f.f85202f * 8) {
                    appendable.append(this.f85211g.charValue());
                    i5 += this.f85210f.f85200d;
                }
            }
        }

        BaseEncoding s(Alphabet alphabet, Character ch) {
            return new StandardBaseEncoding(alphabet, ch);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("BaseEncoding.");
            sb.append(this.f85210f);
            if (8 % this.f85210f.f85200d != 0) {
                if (this.f85211g == null) {
                    sb.append(".omitPadding()");
                } else {
                    sb.append(".withPadChar('");
                    sb.append(this.f85211g);
                    sb.append("')");
                }
            }
            return sb.toString();
        }

        StandardBaseEncoding(Alphabet alphabet, Character ch) {
            this.f85210f = (Alphabet) Preconditions.t(alphabet);
            Preconditions.m(ch == null || !alphabet.f(ch.charValue()), "Padding character %s was already in alphabet", ch);
            this.f85211g = ch;
        }
    }

    BaseEncoding() {
    }

    public static BaseEncoding a() {
        return f85186e;
    }

    public static BaseEncoding b() {
        return f85182a;
    }

    private static byte[] j(byte[] bArr, int i3) {
        if (i3 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, 0, bArr2, 0, i3);
        return bArr2;
    }

    static Reader k(final Reader reader, final String str) {
        Preconditions.t(reader);
        Preconditions.t(str);
        return new Reader() { // from class: com.google.common.io.BaseEncoding.3
            @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                reader.close();
            }

            @Override // java.io.Reader
            public int read() throws IOException {
                int i3;
                do {
                    i3 = reader.read();
                    if (i3 == -1) {
                        break;
                    }
                } while (str.indexOf((char) i3) >= 0);
                return i3;
            }

            @Override // java.io.Reader
            public int read(char[] cArr, int i3, int i4) {
                throw new UnsupportedOperationException();
            }
        };
    }

    static Appendable o(Appendable appendable, String str, int i3) {
        Preconditions.t(appendable);
        Preconditions.t(str);
        Preconditions.d(i3 > 0);
        return new Appendable(i3, appendable, str) { // from class: com.google.common.io.BaseEncoding.4

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f85191a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f85192b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Appendable f85193c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f85194d;

            {
                this.f85192b = i3;
                this.f85193c = appendable;
                this.f85194d = str;
                this.f85191a = i3;
            }

            @Override // java.lang.Appendable
            public Appendable append(char c3) throws IOException {
                if (this.f85191a == 0) {
                    this.f85193c.append(this.f85194d);
                    this.f85191a = this.f85192b;
                }
                this.f85193c.append(c3);
                this.f85191a--;
                return this;
            }

            @Override // java.lang.Appendable
            public Appendable append(CharSequence charSequence, int i4, int i5) {
                throw new UnsupportedOperationException();
            }

            @Override // java.lang.Appendable
            public Appendable append(CharSequence charSequence) {
                throw new UnsupportedOperationException();
            }
        };
    }

    public final byte[] c(CharSequence charSequence) {
        try {
            return d(charSequence);
        } catch (DecodingException e3) {
            throw new IllegalArgumentException(e3);
        }
    }

    final byte[] d(CharSequence charSequence) {
        CharSequence charSequenceP = p(charSequence);
        byte[] bArr = new byte[l(charSequenceP.length())];
        return j(bArr, e(bArr, charSequenceP));
    }

    abstract int e(byte[] bArr, CharSequence charSequence);

    public abstract InputStream f(Reader reader);

    public String g(byte[] bArr) {
        return h(bArr, 0, bArr.length);
    }

    public final String h(byte[] bArr, int i3, int i4) {
        Preconditions.y(i3, i3 + i4, bArr.length);
        StringBuilder sb = new StringBuilder(m(i4));
        try {
            i(sb, bArr, i3, i4);
            return sb.toString();
        } catch (IOException e3) {
            throw new AssertionError(e3);
        }
    }

    abstract void i(Appendable appendable, byte[] bArr, int i3, int i4);

    abstract int l(int i3);

    abstract int m(int i3);

    public abstract BaseEncoding n();

    CharSequence p(CharSequence charSequence) {
        return (CharSequence) Preconditions.t(charSequence);
    }

    public abstract BaseEncoding q(String str, int i3);
}
