package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Set;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4v, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C04554v {
    public static byte[] A03;
    public static String[] A04 = {"RlBAQ9etSzb6rKOU0OwTULVtudJYJZp0", "XAmGWsEC26u1mjqUpAPP", "gKAOne2sLRpvkAzkWDtxdYOHT1y3K7xN", "iu", "f0TxnfWyKi4JtHzbatu6pF78XF274ljv", "5Aw1jR83b8etF7", "lH1Eai5bIm9O9MK22LfAWzb", "DxY4VOe5grYAJX95lLrlpegM3yyEwSTm"};
    public static final Set<Charset> A05;
    public static final char[] A06;
    public static final char[] A07;
    public byte[] A00;
    public int A01;
    public int A02;

    public static String A03(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 65);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A03 = new byte[]{64, 103, Ascii.DEL, 104, 101, 96, 109, 41, 92, 93, 79, 36, Framer.STDOUT_FRAME_PREFIX, 41, 122, 108, Framer.EXIT_FRAME_PREFIX, 124, 108, 103, 106, 108, 41, 106, 102, 103, 125, 96, 103, 124, 104, 125, 96, 102, 103, 41, 107, 112, 125, 108, 51, 41, 88, Ascii.DEL, 103, 112, 125, Framer.EXIT_FRAME_PREFIX, 117, Framer.STDOUT_FRAME_PREFIX, 68, 69, 87, 60, 41, Framer.STDOUT_FRAME_PREFIX, 98, 116, 96, 100, 116, Ascii.DEL, 114, 116, Framer.STDOUT_FRAME_PREFIX, 119, Framer.EXIT_FRAME_PREFIX, 99, 98, 101, Framer.STDOUT_FRAME_PREFIX, 115, 104, 101, 116, 43, Framer.STDOUT_FRAME_PREFIX, 2, 57, 38, 118, 52, 63, 34, 118, 56, 57, 34, 118, 44, 51, 36, 57, 108, 118, 38, Ascii.GS, 0, 6, 3, 3, Ascii.FS, 1, 7, Ascii.SYN, Ascii.ETB, 83, Ascii.DLE, Ascii.ESC, Ascii.DC2, 1, 0, Ascii.SYN, 7, 73, 83};
    }

    static {
        A04();
        A06 = new char[]{'\r', '\n'};
        A07 = new char[]{'\n'};
        A05 = MetaExoPlayerCustomizedCollections.A05(AbstractC1845k9.A01, AbstractC1845k9.A05, AbstractC1845k9.A02, AbstractC1845k9.A03, AbstractC1845k9.A04);
    }

    public C04554v() {
        this.A00 = C5C.A07;
    }

    public C04554v(int i3) {
        this.A00 = new byte[i3];
        this.A01 = i3;
    }

    public C04554v(byte[] bArr) {
        this.A00 = bArr;
        this.A01 = bArr.length;
    }

    public C04554v(byte[] bArr, int i3) {
        this.A00 = bArr;
        this.A01 = i3;
    }

    private char A00(Charset charset, char[] cArr) {
        char cA01;
        int i3;
        if ((charset.equals(AbstractC1845k9.A05) || charset.equals(AbstractC1845k9.A01)) && A07() >= 1) {
            cA01 = AbstractC2152pN.A01(AbstractC2266rc.A00(this.A00[this.A02]));
            i3 = 1;
        } else if ((charset.equals(AbstractC1845k9.A02) || charset.equals(AbstractC1845k9.A03)) && A07() >= 2) {
            cA01 = AbstractC2152pN.A00(this.A00[this.A02], this.A00[this.A02 + 1]);
            i3 = 2;
        } else {
            if (!charset.equals(AbstractC1845k9.A04) || A07() < 2) {
                return (char) 0;
            }
            cA01 = AbstractC2152pN.A00(this.A00[this.A02 + 1], this.A00[this.A02]);
            i3 = 2;
        }
        if (!AbstractC2152pN.A04(cArr, cA01)) {
            return (char) 0;
        }
        this.A02 += i3;
        char character = AbstractC2152pN.A01(cA01);
        return character;
    }

    /* JADX WARN: Incorrect condition in loop: B:9:0x0018 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int A01(java.nio.charset.Charset r5) {
        /*
            r4 = this;
            java.nio.charset.Charset r0 = com.facebook.ads.redexgen.core.AbstractC1845k9.A05
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L10
            java.nio.charset.Charset r0 = com.facebook.ads.redexgen.core.AbstractC1845k9.A01
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L75
        L10:
            r3 = 1
        L11:
            int r2 = r4.A02
        L13:
            int r1 = r4.A01
            int r0 = r3 + (-1)
            int r1 = r1 - r0
            if (r2 >= r1) goto L8f
            java.nio.charset.Charset r0 = com.facebook.ads.redexgen.core.AbstractC1845k9.A05
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L2a
            java.nio.charset.Charset r0 = com.facebook.ads.redexgen.core.AbstractC1845k9.A01
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L35
        L2a:
            byte[] r0 = r4.A00
            r0 = r0[r2]
            boolean r0 = com.facebook.ads.redexgen.core.C5C.A16(r0)
            if (r0 == 0) goto L35
            return r2
        L35:
            java.nio.charset.Charset r0 = com.facebook.ads.redexgen.core.AbstractC1845k9.A02
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L45
            java.nio.charset.Charset r0 = com.facebook.ads.redexgen.core.AbstractC1845k9.A03
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L58
        L45:
            byte[] r0 = r4.A00
            r0 = r0[r2]
            if (r0 != 0) goto L58
            byte[] r1 = r4.A00
            int r0 = r2 + 1
            r0 = r1[r0]
            boolean r0 = com.facebook.ads.redexgen.core.C5C.A16(r0)
            if (r0 == 0) goto L58
            return r2
        L58:
            java.nio.charset.Charset r0 = com.facebook.ads.redexgen.core.AbstractC1845k9.A04
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L73
            byte[] r1 = r4.A00
            int r0 = r2 + 1
            r0 = r1[r0]
            if (r0 != 0) goto L73
            byte[] r0 = r4.A00
            r0 = r0[r2]
            boolean r0 = com.facebook.ads.redexgen.core.C5C.A16(r0)
            if (r0 == 0) goto L73
            return r2
        L73:
            int r2 = r2 + r3
            goto L13
        L75:
            java.nio.charset.Charset r0 = com.facebook.ads.redexgen.core.AbstractC1845k9.A02
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L8d
            java.nio.charset.Charset r0 = com.facebook.ads.redexgen.core.AbstractC1845k9.A04
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L8d
            java.nio.charset.Charset r0 = com.facebook.ads.redexgen.core.AbstractC1845k9.A03
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L92
        L8d:
            r3 = 2
            goto L11
        L8f:
            int r0 = r4.A01
            return r0
        L92:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r2 = 95
            r1 = 21
            r0 = 50
            java.lang.String r0 = A03(r2, r1, r0)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.String r1 = r0.toString()
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C04554v.A01(java.nio.charset.Charset):int");
    }

    /* JADX WARN: Incorrect condition in loop: B:8:0x000c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String A02(char r5) {
        /*
            r4 = this;
            int r0 = r4.A07()
            if (r0 != 0) goto L8
            r0 = 0
            return r0
        L8:
            int r3 = r4.A02
        La:
            int r0 = r4.A01
            if (r3 >= r0) goto L17
            byte[] r0 = r4.A00
            r0 = r0[r3]
            if (r0 == r5) goto L17
            int r3 = r3 + 1
            goto La
        L17:
            byte[] r2 = r4.A00
            int r1 = r4.A02
            int r0 = r4.A02
            int r0 = r3 - r0
            java.lang.String r2 = com.facebook.ads.redexgen.core.C5C.A0r(r2, r1, r0)
            r4.A02 = r3
            int r1 = r4.A02
            int r0 = r4.A01
            if (r1 >= r0) goto L31
            int r0 = r4.A02
            int r0 = r0 + 1
            r4.A02 = r0
        L31:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C04554v.A02(char):java.lang.String");
    }

    private void A05(Charset charset) {
        if (A00(charset, A06) == '\r') {
            A00(charset, A07);
        }
    }

    public final double A06() {
        return Double.longBitsToDouble(A0P());
    }

    public final int A07() {
        return this.A01 - this.A02;
    }

    public final int A08() {
        return this.A00.length;
    }

    public final int A09() {
        return this.A02;
    }

    public final int A0A() {
        return this.A01;
    }

    public final int A0B() {
        return this.A00[this.A02] & 255;
    }

    public final int A0C() {
        byte[] bArr = this.A00;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        int i4 = (bArr[i3] & 255) << 24;
        byte[] bArr2 = this.A00;
        int i5 = this.A02;
        this.A02 = i5 + 1;
        int i6 = i4 | ((bArr2[i5] & 255) << 16);
        byte[] bArr3 = this.A00;
        int i7 = this.A02;
        this.A02 = i7 + 1;
        int i8 = i6 | ((bArr3[i7] & 255) << 8);
        byte[] bArr4 = this.A00;
        int i9 = this.A02;
        this.A02 = i9 + 1;
        return i8 | (bArr4[i9] & 255);
    }

    public final int A0D() {
        byte[] bArr = this.A00;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        int i4 = ((bArr[i3] & 255) << 24) >> 8;
        byte[] bArr2 = this.A00;
        int i5 = this.A02;
        this.A02 = i5 + 1;
        int i6 = i4 | ((bArr2[i5] & 255) << 8);
        byte[] bArr3 = this.A00;
        int i7 = this.A02;
        this.A02 = i7 + 1;
        return i6 | (bArr3[i7] & 255);
    }

    public final int A0E() {
        byte[] bArr = this.A00;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        int i4 = bArr[i3] & 255;
        byte[] bArr2 = this.A00;
        int i5 = this.A02;
        this.A02 = i5 + 1;
        int i6 = i4 | ((bArr2[i5] & 255) << 8);
        byte[] bArr3 = this.A00;
        int i7 = this.A02;
        this.A02 = i7 + 1;
        int i8 = i6 | ((bArr3[i7] & 255) << 16);
        byte[] bArr4 = this.A00;
        int i9 = this.A02;
        this.A02 = i9 + 1;
        return i8 | ((bArr4[i9] & 255) << 24);
    }

    public final int A0F() {
        int iA0E = A0E();
        if (iA0E >= 0) {
            return iA0E;
        }
        throw new IllegalStateException(A03(77, 18, 23) + iA0E);
    }

    public final int A0G() {
        byte[] bArr = this.A00;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        int i4 = bArr[i3] & 255;
        byte[] bArr2 = this.A00;
        int i5 = this.A02;
        this.A02 = i5 + 1;
        return i4 | ((bArr2[i5] & 255) << 8);
    }

    public final int A0H() {
        int b22 = A0I();
        int b12 = A0I();
        int b4 = A0I();
        int b3 = A0I();
        int b23 = (b22 << 21) | (b12 << 14);
        int b13 = b4 << 7;
        return b23 | b13 | b3;
    }

    public final int A0I() {
        byte[] bArr = this.A00;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        return bArr[i3] & 255;
    }

    public final int A0J() {
        byte[] bArr = this.A00;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        int i4 = (bArr[i3] & 255) << 8;
        byte[] bArr2 = this.A00;
        int i5 = this.A02;
        this.A02 = i5 + 1;
        int i6 = i4 | (bArr2[i5] & 255);
        int result = this.A02;
        this.A02 = result + 2;
        return i6;
    }

    public final int A0K() {
        byte[] bArr = this.A00;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        int i4 = (bArr[i3] & 255) << 16;
        byte[] bArr2 = this.A00;
        int i5 = this.A02;
        this.A02 = i5 + 1;
        int i6 = i4 | ((bArr2[i5] & 255) << 8);
        byte[] bArr3 = this.A00;
        int i7 = this.A02;
        this.A02 = i7 + 1;
        return i6 | (bArr3[i7] & 255);
    }

    public final int A0L() {
        int iA0C = A0C();
        if (iA0C >= 0) {
            return iA0C;
        }
        throw new IllegalStateException(A03(77, 18, 23) + iA0C);
    }

    public final int A0M() {
        byte[] bArr = this.A00;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        int i4 = (bArr[i3] & 255) << 8;
        byte[] bArr2 = this.A00;
        int i5 = this.A02;
        this.A02 = i5 + 1;
        return i4 | (bArr2[i5] & 255);
    }

    public final long A0N() {
        byte[] bArr = this.A00;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        long j3 = ((long) bArr[i3]) & 255;
        byte[] bArr2 = this.A00;
        int i4 = this.A02;
        this.A02 = i4 + 1;
        long j4 = j3 | ((((long) bArr2[i4]) & 255) << 8);
        byte[] bArr3 = this.A00;
        int i5 = this.A02;
        this.A02 = i5 + 1;
        long j5 = j4 | ((((long) bArr3[i5]) & 255) << 16);
        byte[] bArr4 = this.A00;
        int i6 = this.A02;
        this.A02 = i6 + 1;
        long j6 = j5 | ((((long) bArr4[i6]) & 255) << 24);
        byte[] bArr5 = this.A00;
        int i7 = this.A02;
        this.A02 = i7 + 1;
        long j7 = j6 | ((((long) bArr5[i7]) & 255) << 32);
        byte[] bArr6 = this.A00;
        int i8 = this.A02;
        this.A02 = i8 + 1;
        long j8 = j7 | ((((long) bArr6[i8]) & 255) << 40);
        byte[] bArr7 = this.A00;
        int i9 = this.A02;
        this.A02 = i9 + 1;
        long j9 = j8 | ((((long) bArr7[i9]) & 255) << 48);
        byte[] bArr8 = this.A00;
        int i10 = this.A02;
        this.A02 = i10 + 1;
        return j9 | ((255 & ((long) bArr8[i10])) << 56);
    }

    public final long A0O() {
        byte[] bArr = this.A00;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        long j3 = ((long) bArr[i3]) & 255;
        byte[] bArr2 = this.A00;
        int i4 = this.A02;
        this.A02 = i4 + 1;
        long j4 = j3 | ((((long) bArr2[i4]) & 255) << 8);
        byte[] bArr3 = this.A00;
        int i5 = this.A02;
        this.A02 = i5 + 1;
        long j5 = j4 | ((((long) bArr3[i5]) & 255) << 16);
        byte[] bArr4 = this.A00;
        int i6 = this.A02;
        this.A02 = i6 + 1;
        return j5 | ((255 & ((long) bArr4[i6])) << 24);
    }

    public final long A0P() {
        byte[] bArr = this.A00;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        long j3 = (((long) bArr[i3]) & 255) << 56;
        byte[] bArr2 = this.A00;
        int i4 = this.A02;
        this.A02 = i4 + 1;
        long j4 = j3 | ((((long) bArr2[i4]) & 255) << 48);
        byte[] bArr3 = this.A00;
        int i5 = this.A02;
        this.A02 = i5 + 1;
        long j5 = j4 | ((((long) bArr3[i5]) & 255) << 40);
        byte[] bArr4 = this.A00;
        int i6 = this.A02;
        this.A02 = i6 + 1;
        long j6 = j5 | ((((long) bArr4[i6]) & 255) << 32);
        byte[] bArr5 = this.A00;
        int i7 = this.A02;
        this.A02 = i7 + 1;
        long j7 = j6 | ((((long) bArr5[i7]) & 255) << 24);
        byte[] bArr6 = this.A00;
        int i8 = this.A02;
        this.A02 = i8 + 1;
        long j8 = j7 | ((((long) bArr6[i8]) & 255) << 16);
        byte[] bArr7 = this.A00;
        int i9 = this.A02;
        this.A02 = i9 + 1;
        long j9 = j8 | ((((long) bArr7[i9]) & 255) << 8);
        byte[] bArr8 = this.A00;
        int i10 = this.A02;
        this.A02 = i10 + 1;
        return j9 | (255 & ((long) bArr8[i10]));
    }

    public final long A0Q() {
        byte[] bArr = this.A00;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        long j3 = (((long) bArr[i3]) & 255) << 24;
        byte[] bArr2 = this.A00;
        int i4 = this.A02;
        this.A02 = i4 + 1;
        long j4 = j3 | ((((long) bArr2[i4]) & 255) << 16);
        byte[] bArr3 = this.A00;
        int i5 = this.A02;
        this.A02 = i5 + 1;
        long j5 = j4 | ((((long) bArr3[i5]) & 255) << 8);
        byte[] bArr4 = this.A00;
        int i6 = this.A02;
        this.A02 = i6 + 1;
        return j5 | (255 & ((long) bArr4[i6]));
    }

    public final long A0R() {
        long jA0P = A0P();
        if (jA0P >= 0) {
            return jA0P;
        }
        throw new IllegalStateException(A03(77, 18, 23) + jA0P);
    }

    public final long A0S() {
        int i3 = 0;
        byte[] bArr = this.A00;
        int length = this.A02;
        long j3 = bArr[length];
        int i4 = 7;
        while (A04[3].length() != 11) {
            A04[0] = "oMNWSgm03bScuVXxVZmUeRStw4NVi0TN";
            if (i4 >= 0) {
                int length2 = 1 << i4;
                long value = length2;
                if ((value & j3) == 0) {
                    if (i4 < 6) {
                        int length3 = 1 << i4;
                        j3 &= (long) (length3 - 1);
                        i3 = 7 - i4;
                    } else if (i4 == 7) {
                        i3 = 1;
                    }
                } else {
                    i4--;
                }
            }
            if (i3 != 0) {
                int i5 = 1;
                while (i5 < i3) {
                    byte[] bArr2 = this.A00;
                    int length4 = this.A02;
                    byte b3 = bArr2[length4 + i5];
                    if ((b3 & 192) == 128) {
                        int length5 = b3 & 63;
                        j3 = (j3 << 6) | ((long) length5);
                        if (A04[3].length() != 11) {
                            A04[2] = "QkYn4WhdN3Bc00ITVAtZ7M0H0JKEG2qx";
                            i5++;
                        } else {
                            i5++;
                        }
                    } else {
                        throw new NumberFormatException(A03(0, 42, 72) + j3);
                    }
                }
                int length6 = this.A02;
                this.A02 = length6 + i3;
                return j3;
            }
            throw new NumberFormatException(A03(42, 35, 80) + j3);
        }
        throw new RuntimeException();
    }

    public final String A0T() {
        return A0Y(AbstractC1845k9.A05);
    }

    public final String A0U() {
        return A02((char) 0);
    }

    public final String A0V(int i3) {
        if (i3 == 0) {
            return A03(0, 0, 97);
        }
        int i4 = i3;
        int stringLength = this.A02;
        int lastIndex = (stringLength + i3) - 1;
        int stringLength2 = this.A01;
        if (lastIndex < stringLength2) {
            int stringLength3 = this.A00[lastIndex];
            if (stringLength3 == 0) {
                i4--;
            }
        }
        byte[] bArr = this.A00;
        int stringLength4 = this.A02;
        String strA0r = C5C.A0r(bArr, stringLength4, i4);
        int stringLength5 = this.A02;
        this.A02 = stringLength5 + i3;
        return strA0r;
    }

    public final String A0W(int i3) {
        return A0X(i3, AbstractC1845k9.A05);
    }

    public final String A0X(int i3, Charset charset) {
        String str = new String(this.A00, this.A02, i3, charset);
        this.A02 += i3;
        return str;
    }

    public final String A0Y(Charset charset) {
        AbstractC04323y.A09(A05.contains(charset), A03(95, 21, 50) + charset);
        if (A07() == 0) {
            return null;
        }
        if (!charset.equals(AbstractC1845k9.A01)) {
            A0Z();
        }
        int iA01 = A01(charset);
        int lineLimit = this.A02;
        String strA0X = A0X(iA01 - lineLimit, charset);
        int i3 = this.A02;
        int lineLimit2 = this.A01;
        if (i3 == lineLimit2) {
            return strA0X;
        }
        A05(charset);
        return strA0X;
    }

    public final Charset A0Z() {
        if (A07() >= 3 && this.A00[this.A02] == -17 && this.A00[this.A02 + 1] == -69 && this.A00[this.A02 + 2] == -65) {
            this.A02 += 3;
            return AbstractC1845k9.A05;
        }
        if (A07() >= 2) {
            if (this.A00[this.A02] == -2) {
                byte[] bArr = this.A00;
                int i3 = this.A02;
                if (A04[0].charAt(23) != 't') {
                    throw new RuntimeException();
                }
                A04[1] = "9QZAaK9H1E15SkUu26Oe";
                if (bArr[i3 + 1] == -1) {
                    this.A02 += 2;
                    return AbstractC1845k9.A03;
                }
            }
            if (this.A00[this.A02] == -1 && this.A00[this.A02 + 1] == -2) {
                this.A02 += 2;
                return AbstractC1845k9.A04;
            }
            return null;
        }
        return null;
    }

    public final short A0a() {
        byte[] bArr = this.A00;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        int i4 = bArr[i3] & 255;
        byte[] bArr2 = this.A00;
        int i5 = this.A02;
        this.A02 = i5 + 1;
        return (short) (i4 | ((bArr2[i5] & 255) << 8));
    }

    public final short A0b() {
        byte[] bArr = this.A00;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        int i4 = (bArr[i3] & 255) << 8;
        byte[] bArr2 = this.A00;
        int i5 = this.A02;
        this.A02 = i5 + 1;
        return (short) (i4 | (bArr2[i5] & 255));
    }

    public final void A0c(int i3) {
        if (i3 > A08()) {
            this.A00 = Arrays.copyOf(this.A00, i3);
        }
    }

    public final void A0d(int i3) {
        A0j(A08() < i3 ? new byte[i3] : this.A00, i3);
        String[] strArr = A04;
        if (strArr[5].length() == strArr[6].length()) {
            throw new RuntimeException();
        }
        A04[3] = "3F79npZxDc4PfqkC8vfulVLdM";
    }

    public final void A0e(int i3) {
        AbstractC04323y.A07(i3 >= 0 && i3 <= this.A00.length);
        this.A01 = i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0f(int r5) {
        /*
            r4 = this;
            if (r5 < 0) goto L1e
            int r3 = r4.A01
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C04554v.A04
            r0 = 4
            r1 = r2[r0]
            r0 = 7
            r2 = r2[r0]
            r0 = 20
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L20
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L1e:
            r0 = 0
            goto L2a
        L20:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C04554v.A04
            java.lang.String r1 = "UMwuHioqOI4Z"
            r0 = 3
            r2[r0] = r1
            if (r5 > r3) goto L1e
            r0 = 1
        L2a:
            com.facebook.ads.redexgen.core.AbstractC04323y.A07(r0)
            r4.A02 = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C04554v.A0f(int):void");
    }

    public final void A0g(int i3) {
        A0f(this.A02 + i3);
    }

    public final void A0h(C04544u c04544u, int i3) {
        A0k(c04544u.A00, 0, i3);
        c04544u.A08(0);
    }

    public final void A0i(byte[] bArr) {
        A0j(bArr, bArr.length);
    }

    public final void A0j(byte[] bArr, int i3) {
        this.A00 = bArr;
        this.A01 = i3;
        this.A02 = 0;
    }

    public final void A0k(byte[] bArr, int i3, int i4) {
        System.arraycopy(this.A00, this.A02, bArr, i3, i4);
        this.A02 += i4;
    }

    public final byte[] A0l() {
        return this.A00;
    }
}
