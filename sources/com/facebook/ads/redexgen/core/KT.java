package com.facebook.ads.redexgen.core;

import android.text.Layout;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class KT {
    public static byte[] A0J;
    public static String[] A0K = {"Usxox1Jpg4zI1D26A46628IJoKVIfDOb", "DJj4Y7Lf5wmbgFbmipnyENDrbENW0zBu", "xAirbBVx6sN", "JUHzrsF6PskbrsOcxUQeRZ6EJgAR84BH", "g21uR390", "sct5cBRRGNi", "fSzYgZjiZ3zjw2rk03FKz0970uetzuqd", "YzsQQs1"};
    public float A00;
    public int A02;
    public int A04;
    public Layout.Alignment A0C;
    public Layout.Alignment A0D;
    public KI A0E;
    public String A0F;
    public String A0G;
    public boolean A0H;
    public boolean A0I;
    public int A07 = -1;
    public int A0B = -1;
    public int A03 = -1;
    public int A06 = -1;
    public int A05 = -1;
    public int A09 = -1;
    public int A08 = -1;
    public int A0A = -1;
    public float A01 = Float.MAX_VALUE;

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0J, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 111);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A0J = new byte[]{-24, 7, 9, 17, Ascii.CR, Ascii.CAN, Ascii.NAK, Ascii.ESC, Ascii.DC4, 10, -58, 9, Ascii.NAK, Ascii.DC2, Ascii.NAK, Ascii.CAN, -58, Ascii.SO, 7, Ascii.EM, -58, Ascii.DC4, Ascii.NAK, Ascii.SUB, -58, 8, Ascii.VT, Ascii.VT, Ascii.DC4, -58, 10, Ascii.VT, Ascii.FF, Ascii.SI, Ascii.DC4, Ascii.VT, 10, -44, -27, Ascii.SO, Ascii.CR, 19, -65, 2, Ascii.SO, Ascii.VT, Ascii.SO, 17, -65, 7, 0, Ascii.DC2, -65, Ascii.CR, Ascii.SO, 19, -65, 1, 4, 4, Ascii.CR, -65, 3, 4, 5, 8, Ascii.CR, 4, 3, -51};
    }

    static {
        A02();
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.facebook.ads.redexgen.core.KT A00(com.facebook.ads.redexgen.core.KT r6, boolean r7) {
        /*
            Method dump skipped, instruction units count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.KT.A00(com.facebook.ads.redexgen.X.KT, boolean):com.facebook.ads.redexgen.X.KT");
    }

    public final float A03() {
        return this.A00;
    }

    public final float A04() {
        return this.A01;
    }

    public final int A05() {
        if (this.A0H) {
            return this.A02;
        }
        throw new IllegalStateException(A01(0, 38, 55));
    }

    public final int A06() {
        if (this.A0I) {
            return this.A04;
        }
        throw new IllegalStateException(A01(38, 32, 48));
    }

    public final int A07() {
        return this.A05;
    }

    public final int A08() {
        return this.A08;
    }

    public final int A09() {
        return this.A09;
    }

    public final int A0A() {
        if (this.A03 == -1 && this.A06 == -1) {
            return -1;
        }
        int i3 = (this.A03 == 1 ? 1 : 0) | (this.A06 == 1 ? 2 : 0);
        String[] strArr = A0K;
        if (strArr[2].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0K;
        strArr2[2] = "pc7acbLDMjB";
        strArr2[5] = "xuQHQFUerHu";
        return i3;
    }

    public final Layout.Alignment A0B() {
        return this.A0C;
    }

    public final Layout.Alignment A0C() {
        return this.A0D;
    }

    public final KI A0D() {
        return this.A0E;
    }

    public final KT A0E(float f3) {
        this.A00 = f3;
        return this;
    }

    public final KT A0F(float f3) {
        this.A01 = f3;
        return this;
    }

    public final KT A0G(int i3) {
        this.A02 = i3;
        this.A0H = true;
        return this;
    }

    public final KT A0H(int i3) {
        this.A04 = i3;
        this.A0I = true;
        return this;
    }

    public final KT A0I(int i3) {
        this.A05 = i3;
        return this;
    }

    public final KT A0J(int i3) {
        this.A08 = i3;
        return this;
    }

    public final KT A0K(int i3) {
        this.A09 = i3;
        return this;
    }

    public final KT A0L(Layout.Alignment alignment) {
        this.A0C = alignment;
        return this;
    }

    public final KT A0M(Layout.Alignment alignment) {
        this.A0D = alignment;
        return this;
    }

    public final KT A0N(KI ki) {
        this.A0E = ki;
        return this;
    }

    public final KT A0O(KT kt) {
        return A00(kt, true);
    }

    public final KT A0P(String str) {
        this.A0F = str;
        return this;
    }

    public final KT A0Q(String str) {
        this.A0G = str;
        return this;
    }

    public final KT A0R(boolean z2) {
        this.A03 = z2 ? 1 : 0;
        return this;
    }

    public final KT A0S(boolean z2) {
        this.A06 = z2 ? 1 : 0;
        return this;
    }

    public final KT A0T(boolean z2) {
        this.A07 = z2 ? 1 : 0;
        return this;
    }

    public final KT A0U(boolean z2) {
        this.A0A = z2 ? 1 : 0;
        return this;
    }

    public final KT A0V(boolean z2) {
        this.A0B = z2 ? 1 : 0;
        return this;
    }

    public final String A0W() {
        return this.A0F;
    }

    public final String A0X() {
        return this.A0G;
    }

    public final boolean A0Y() {
        return this.A0A == 1;
    }

    public final boolean A0Z() {
        return this.A0H;
    }

    public final boolean A0a() {
        return this.A0I;
    }

    public final boolean A0b() {
        return this.A07 == 1;
    }

    public final boolean A0c() {
        return this.A0B == 1;
    }
}
