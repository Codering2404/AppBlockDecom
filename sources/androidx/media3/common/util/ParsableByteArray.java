package androidx.media3.common.util;

import com.google.common.collect.ImmutableSet;
import com.google.common.primitives.Chars;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CheckReturnValue;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
public final class ParsableByteArray {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final char[] f41580d = {'\r', '\n'};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final char[] f41581e = {'\n'};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ImmutableSet f41582f = ImmutableSet.E(StandardCharsets.US_ASCII, StandardCharsets.UTF_8, StandardCharsets.UTF_16, StandardCharsets.UTF_16BE, StandardCharsets.UTF_16LE);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f41583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f41584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f41585c;

    public ParsableByteArray() {
        this.f41583a = Util.f41614f;
    }

    private void Y(Charset charset) {
        if (m(charset, f41580d) == '\r') {
            m(charset, f41581e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int d(java.nio.charset.Charset r5) {
        /*
            r4 = this;
            java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.UTF_8
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L43
            java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.US_ASCII
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L11
            goto L43
        L11:
            java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.UTF_16
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L41
            java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.UTF_16LE
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L41
            java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.UTF_16BE
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L2a
            goto L41
        L2a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unsupported charset: "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r0.<init>(r5)
            throw r0
        L41:
            r0 = 2
            goto L44
        L43:
            r0 = 1
        L44:
            int r1 = r4.f41584b
        L46:
            int r2 = r4.f41585c
            int r3 = r0 + (-1)
            int r3 = r2 - r3
            if (r1 >= r3) goto La5
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.UTF_8
            boolean r2 = r5.equals(r2)
            if (r2 != 0) goto L5e
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.US_ASCII
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L69
        L5e:
            byte[] r2 = r4.f41583a
            r2 = r2[r1]
            boolean r2 = androidx.media3.common.util.Util.E0(r2)
            if (r2 == 0) goto L69
            goto La2
        L69:
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.UTF_16
            boolean r2 = r5.equals(r2)
            if (r2 != 0) goto L79
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.UTF_16BE
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L8a
        L79:
            byte[] r2 = r4.f41583a
            r3 = r2[r1]
            if (r3 != 0) goto L8a
            int r3 = r1 + 1
            r2 = r2[r3]
            boolean r2 = androidx.media3.common.util.Util.E0(r2)
            if (r2 == 0) goto L8a
            goto La2
        L8a:
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.UTF_16LE
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto La3
            byte[] r2 = r4.f41583a
            int r3 = r1 + 1
            r3 = r2[r3]
            if (r3 != 0) goto La3
            r2 = r2[r1]
            boolean r2 = androidx.media3.common.util.Util.E0(r2)
            if (r2 == 0) goto La3
        La2:
            return r1
        La3:
            int r1 = r1 + r0
            goto L46
        La5:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.util.ParsableByteArray.d(java.nio.charset.Charset):int");
    }

    private int i(Charset charset) {
        byte b3;
        byte b4;
        byte b5 = 1;
        if ((charset.equals(StandardCharsets.UTF_8) || charset.equals(StandardCharsets.US_ASCII)) && a() >= 1) {
            b3 = this.f41583a[this.f41584b];
            b4 = 0;
        } else {
            if ((charset.equals(StandardCharsets.UTF_16) || charset.equals(StandardCharsets.UTF_16BE)) && a() >= 2) {
                byte[] bArr = this.f41583a;
                int i3 = this.f41584b;
                b4 = bArr[i3];
                b3 = bArr[i3 + 1];
            } else {
                if (!charset.equals(StandardCharsets.UTF_16LE) || a() < 2) {
                    return 0;
                }
                byte[] bArr2 = this.f41583a;
                int i4 = this.f41584b;
                b4 = bArr2[i4 + 1];
                b3 = bArr2[i4];
            }
            b5 = 2;
        }
        return Ints.h(b4, b3, (byte) 0, b5);
    }

    private char m(Charset charset, char[] cArr) {
        int i3 = i(charset);
        if (i3 == 0) {
            return (char) 0;
        }
        char c3 = (char) (i3 >> 16);
        if (!Chars.c(cArr, c3)) {
            return (char) 0;
        }
        this.f41584b += i3 & 65535;
        return c3;
    }

    public long A() {
        byte[] bArr = this.f41583a;
        int i3 = this.f41584b;
        int i4 = i3 + 1;
        this.f41584b = i4;
        long j3 = (((long) bArr[i3]) & 255) << 56;
        int i5 = i3 + 2;
        this.f41584b = i5;
        long j4 = j3 | ((((long) bArr[i4]) & 255) << 48);
        int i6 = i3 + 3;
        this.f41584b = i6;
        long j5 = j4 | ((((long) bArr[i5]) & 255) << 40);
        int i7 = i3 + 4;
        this.f41584b = i7;
        long j6 = j5 | ((((long) bArr[i6]) & 255) << 32);
        int i8 = i3 + 5;
        this.f41584b = i8;
        long j7 = j6 | ((((long) bArr[i7]) & 255) << 24);
        int i9 = i3 + 6;
        this.f41584b = i9;
        long j8 = j7 | ((((long) bArr[i8]) & 255) << 16);
        int i10 = i3 + 7;
        this.f41584b = i10;
        long j9 = j8 | ((((long) bArr[i9]) & 255) << 8);
        this.f41584b = i3 + 8;
        return (((long) bArr[i10]) & 255) | j9;
    }

    public String B() {
        return n((char) 0);
    }

    public String C(int i3) {
        if (i3 == 0) {
            return "";
        }
        int i4 = this.f41584b;
        int i5 = (i4 + i3) - 1;
        String strL = Util.L(this.f41583a, i4, (i5 >= this.f41585c || this.f41583a[i5] != 0) ? i3 : i3 - 1);
        this.f41584b += i3;
        return strL;
    }

    public short D() {
        byte[] bArr = this.f41583a;
        int i3 = this.f41584b;
        int i4 = i3 + 1;
        this.f41584b = i4;
        int i5 = (bArr[i3] & 255) << 8;
        this.f41584b = i3 + 2;
        return (short) ((bArr[i4] & 255) | i5);
    }

    public String E(int i3) {
        return F(i3, StandardCharsets.UTF_8);
    }

    public String F(int i3, Charset charset) {
        String str = new String(this.f41583a, this.f41584b, i3, charset);
        this.f41584b += i3;
        return str;
    }

    public int G() {
        return (H() << 21) | (H() << 14) | (H() << 7) | H();
    }

    public int H() {
        byte[] bArr = this.f41583a;
        int i3 = this.f41584b;
        this.f41584b = i3 + 1;
        return bArr[i3] & 255;
    }

    public int I() {
        byte[] bArr = this.f41583a;
        int i3 = this.f41584b;
        int i4 = i3 + 1;
        this.f41584b = i4;
        int i5 = (bArr[i3] & 255) << 8;
        this.f41584b = i3 + 2;
        int i6 = (bArr[i4] & 255) | i5;
        this.f41584b = i3 + 4;
        return i6;
    }

    public long J() {
        byte[] bArr = this.f41583a;
        int i3 = this.f41584b;
        int i4 = i3 + 1;
        this.f41584b = i4;
        long j3 = (((long) bArr[i3]) & 255) << 24;
        int i5 = i3 + 2;
        this.f41584b = i5;
        long j4 = j3 | ((((long) bArr[i4]) & 255) << 16);
        int i6 = i3 + 3;
        this.f41584b = i6;
        long j5 = j4 | ((((long) bArr[i5]) & 255) << 8);
        this.f41584b = i3 + 4;
        return (((long) bArr[i6]) & 255) | j5;
    }

    public int K() {
        byte[] bArr = this.f41583a;
        int i3 = this.f41584b;
        int i4 = i3 + 1;
        this.f41584b = i4;
        int i5 = (bArr[i3] & 255) << 16;
        int i6 = i3 + 2;
        this.f41584b = i6;
        int i7 = ((bArr[i4] & 255) << 8) | i5;
        this.f41584b = i3 + 3;
        return (bArr[i6] & 255) | i7;
    }

    public int L() {
        int iQ = q();
        if (iQ >= 0) {
            return iQ;
        }
        throw new IllegalStateException("Top bit not zero: " + iQ);
    }

    public int M() {
        return Ints.d(N());
    }

    public long N() {
        long j3 = 0;
        for (int i3 = 0; i3 < 9; i3++) {
            if (this.f41584b == this.f41585c) {
                throw new IllegalStateException("Attempting to read a byte over the limit.");
            }
            long jH = H();
            j3 |= (127 & jH) << (i3 * 7);
            if ((jH & 128) == 0) {
                return j3;
            }
        }
        return j3;
    }

    public long O() {
        long jA = A();
        if (jA >= 0) {
            return jA;
        }
        throw new IllegalStateException("Top bit not zero: " + jA);
    }

    public int P() {
        byte[] bArr = this.f41583a;
        int i3 = this.f41584b;
        int i4 = i3 + 1;
        this.f41584b = i4;
        int i5 = (bArr[i3] & 255) << 8;
        this.f41584b = i3 + 2;
        return (bArr[i4] & 255) | i5;
    }

    public long Q() {
        int i3;
        int i4;
        long j3 = this.f41583a[this.f41584b];
        int i5 = 7;
        while (true) {
            if (i5 < 0) {
                break;
            }
            int i6 = 1 << i5;
            if ((((long) i6) & j3) != 0) {
                i5--;
            } else if (i5 < 6) {
                j3 &= (long) (i6 - 1);
                i4 = 7 - i5;
            } else if (i5 == 7) {
                i4 = 1;
            }
        }
        i4 = 0;
        if (i4 == 0) {
            throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j3);
        }
        for (i3 = 1; i3 < i4; i3++) {
            byte b3 = this.f41583a[this.f41584b + i3];
            if ((b3 & 192) != 128) {
                throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j3);
            }
            j3 = (j3 << 6) | ((long) (b3 & 63));
        }
        this.f41584b += i4;
        return j3;
    }

    public Charset R() {
        if (a() >= 3) {
            byte[] bArr = this.f41583a;
            int i3 = this.f41584b;
            if (bArr[i3] == -17 && bArr[i3 + 1] == -69 && bArr[i3 + 2] == -65) {
                this.f41584b = i3 + 3;
                return StandardCharsets.UTF_8;
            }
        }
        if (a() < 2) {
            return null;
        }
        byte[] bArr2 = this.f41583a;
        int i4 = this.f41584b;
        byte b3 = bArr2[i4];
        if (b3 == -2 && bArr2[i4 + 1] == -1) {
            this.f41584b = i4 + 2;
            return StandardCharsets.UTF_16BE;
        }
        if (b3 != -1 || bArr2[i4 + 1] != -2) {
            return null;
        }
        this.f41584b = i4 + 2;
        return StandardCharsets.UTF_16LE;
    }

    public void S(int i3) {
        U(b() < i3 ? new byte[i3] : this.f41583a, i3);
    }

    public void T(byte[] bArr) {
        U(bArr, bArr.length);
    }

    public void U(byte[] bArr, int i3) {
        this.f41583a = bArr;
        this.f41585c = i3;
        this.f41584b = 0;
    }

    public void V(int i3) {
        Assertions.a(i3 >= 0 && i3 <= this.f41583a.length);
        this.f41585c = i3;
    }

    public void W(int i3) {
        Assertions.a(i3 >= 0 && i3 <= this.f41585c);
        this.f41584b = i3;
    }

    public void X(int i3) {
        W(this.f41584b + i3);
    }

    public int a() {
        return this.f41585c - this.f41584b;
    }

    public int b() {
        return this.f41583a.length;
    }

    public void c(int i3) {
        if (i3 > b()) {
            this.f41583a = Arrays.copyOf(this.f41583a, i3);
        }
    }

    public byte[] e() {
        return this.f41583a;
    }

    public int f() {
        return this.f41584b;
    }

    public int g() {
        return this.f41585c;
    }

    public char h(Charset charset) {
        Assertions.b(f41582f.contains(charset), "Unsupported charset: " + charset);
        return (char) (i(charset) >> 16);
    }

    public int j() {
        return this.f41583a[this.f41584b] & 255;
    }

    public void k(ParsableBitArray parsableBitArray, int i3) {
        l(parsableBitArray.f41576a, 0, i3);
        parsableBitArray.p(0);
    }

    public void l(byte[] bArr, int i3, int i4) {
        System.arraycopy(this.f41583a, this.f41584b, bArr, i3, i4);
        this.f41584b += i4;
    }

    public String n(char c3) {
        if (a() == 0) {
            return null;
        }
        int i3 = this.f41584b;
        while (i3 < this.f41585c && this.f41583a[i3] != c3) {
            i3++;
        }
        byte[] bArr = this.f41583a;
        int i4 = this.f41584b;
        String strL = Util.L(bArr, i4, i3 - i4);
        this.f41584b = i3;
        if (i3 < this.f41585c) {
            this.f41584b = i3 + 1;
        }
        return strL;
    }

    public double o() {
        return Double.longBitsToDouble(A());
    }

    public float p() {
        return Float.intBitsToFloat(q());
    }

    public int q() {
        byte[] bArr = this.f41583a;
        int i3 = this.f41584b;
        int i4 = i3 + 1;
        this.f41584b = i4;
        int i5 = (bArr[i3] & 255) << 24;
        int i6 = i3 + 2;
        this.f41584b = i6;
        int i7 = ((bArr[i4] & 255) << 16) | i5;
        int i8 = i3 + 3;
        this.f41584b = i8;
        int i9 = i7 | ((bArr[i6] & 255) << 8);
        this.f41584b = i3 + 4;
        return (bArr[i8] & 255) | i9;
    }

    public int r() {
        byte[] bArr = this.f41583a;
        int i3 = this.f41584b;
        int i4 = i3 + 1;
        this.f41584b = i4;
        int i5 = ((bArr[i3] & 255) << 24) >> 8;
        int i6 = i3 + 2;
        this.f41584b = i6;
        int i7 = ((bArr[i4] & 255) << 8) | i5;
        this.f41584b = i3 + 3;
        return (bArr[i6] & 255) | i7;
    }

    public String s() {
        return t(StandardCharsets.UTF_8);
    }

    public String t(Charset charset) {
        Assertions.b(f41582f.contains(charset), "Unsupported charset: " + charset);
        if (a() == 0) {
            return null;
        }
        if (!charset.equals(StandardCharsets.US_ASCII)) {
            R();
        }
        String strF = F(d(charset) - this.f41584b, charset);
        if (this.f41584b == this.f41585c) {
            return strF;
        }
        Y(charset);
        return strF;
    }

    public int u() {
        byte[] bArr = this.f41583a;
        int i3 = this.f41584b;
        int i4 = i3 + 1;
        this.f41584b = i4;
        int i5 = bArr[i3] & 255;
        int i6 = i3 + 2;
        this.f41584b = i6;
        int i7 = ((bArr[i4] & 255) << 8) | i5;
        int i8 = i3 + 3;
        this.f41584b = i8;
        int i9 = i7 | ((bArr[i6] & 255) << 16);
        this.f41584b = i3 + 4;
        return ((bArr[i8] & 255) << 24) | i9;
    }

    public long v() {
        byte[] bArr = this.f41583a;
        int i3 = this.f41584b;
        int i4 = i3 + 1;
        this.f41584b = i4;
        long j3 = ((long) bArr[i3]) & 255;
        int i5 = i3 + 2;
        this.f41584b = i5;
        long j4 = j3 | ((((long) bArr[i4]) & 255) << 8);
        int i6 = i3 + 3;
        this.f41584b = i6;
        long j5 = j4 | ((((long) bArr[i5]) & 255) << 16);
        int i7 = i3 + 4;
        this.f41584b = i7;
        long j6 = j5 | ((((long) bArr[i6]) & 255) << 24);
        int i8 = i3 + 5;
        this.f41584b = i8;
        long j7 = j6 | ((((long) bArr[i7]) & 255) << 32);
        int i9 = i3 + 6;
        this.f41584b = i9;
        long j8 = j7 | ((((long) bArr[i8]) & 255) << 40);
        int i10 = i3 + 7;
        this.f41584b = i10;
        long j9 = j8 | ((((long) bArr[i9]) & 255) << 48);
        this.f41584b = i3 + 8;
        return ((((long) bArr[i10]) & 255) << 56) | j9;
    }

    public short w() {
        byte[] bArr = this.f41583a;
        int i3 = this.f41584b;
        int i4 = i3 + 1;
        this.f41584b = i4;
        int i5 = bArr[i3] & 255;
        this.f41584b = i3 + 2;
        return (short) (((bArr[i4] & 255) << 8) | i5);
    }

    public long x() {
        byte[] bArr = this.f41583a;
        int i3 = this.f41584b;
        int i4 = i3 + 1;
        this.f41584b = i4;
        long j3 = ((long) bArr[i3]) & 255;
        int i5 = i3 + 2;
        this.f41584b = i5;
        long j4 = j3 | ((((long) bArr[i4]) & 255) << 8);
        int i6 = i3 + 3;
        this.f41584b = i6;
        long j5 = j4 | ((((long) bArr[i5]) & 255) << 16);
        this.f41584b = i3 + 4;
        return ((((long) bArr[i6]) & 255) << 24) | j5;
    }

    public int y() {
        int iU = u();
        if (iU >= 0) {
            return iU;
        }
        throw new IllegalStateException("Top bit not zero: " + iU);
    }

    public int z() {
        byte[] bArr = this.f41583a;
        int i3 = this.f41584b;
        int i4 = i3 + 1;
        this.f41584b = i4;
        int i5 = bArr[i3] & 255;
        this.f41584b = i3 + 2;
        return ((bArr[i4] & 255) << 8) | i5;
    }

    public ParsableByteArray(int i3) {
        this.f41583a = new byte[i3];
        this.f41585c = i3;
    }

    public ParsableByteArray(byte[] bArr) {
        this.f41583a = bArr;
        this.f41585c = bArr.length;
    }

    public ParsableByteArray(byte[] bArr, int i3) {
        this.f41583a = bArr;
        this.f41585c = i3;
    }
}
