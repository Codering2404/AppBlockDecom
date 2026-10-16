package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState;
import com.facebook.ads.internal.util.parcelable.WrappedParcelable;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1718hr extends R2 implements RE {
    public static byte[] A0F;
    public static String[] A0G = {"ZTDwmEtle1avZIcEXO6Ngzge8j05pfT9", "s1YfUPq4amp3sGXTr0KOnMWCCCkrB2x5", "RLSriKm", "hA4l3MFFurEjuKvfb479JjwTp2cnC09n", "5GFF521rSn4TdhEStccPhauxYrt7NMVp", "XQN2s9DMc1xKucEpv2CitIAcNHBR8E7y", "8ubGCSX", "EFysGv6XChRnXfWxG2n7d2ksHTdYT6om"};
    public int A00;
    public int A01;
    public int A02;
    public LinearLayoutManager$SavedState A03;
    public AbstractC0992Qm A04;
    public boolean A05;
    public int A06;
    public C0988Qh A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public final C0986Qf A0D;
    public final C0987Qg A0E;

    public static String A0T(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0F, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 91);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0V() {
        A0F = new byte[]{Ascii.US, Ascii.CAN, 0, Ascii.ETB, Ascii.SUB, Ascii.US, Ascii.DC2, 86, Ascii.EM, 4, Ascii.US, 19, Ascii.CAN, 2, Ascii.ETB, 2, Ascii.US, Ascii.EM, Ascii.CAN, 76};
    }

    static {
        A0V();
    }

    public C1718hr(Context context) {
        this(context, 1, false);
    }

    public C1718hr(Context context, int i3, boolean z2) {
        this.A0A = false;
        this.A05 = false;
        this.A0C = false;
        this.A0B = true;
        this.A01 = -1;
        this.A02 = Integer.MIN_VALUE;
        this.A03 = null;
        this.A0D = new C0986Qf(this);
        this.A0E = new C0987Qg();
        this.A06 = 2;
        A2C(i3);
        A0h(z2);
        A1T(true);
    }

    private final int A04(int i3, RA ra, RH rh) {
        if (A0Y() == 0 || i3 == 0) {
            return 0;
        }
        this.A07.A0B = true;
        A2B();
        int absDy = i3 > 0 ? 1 : -1;
        int consumed = Math.abs(i3);
        A0Y(absDy, consumed, true, rh);
        int i4 = this.A07.A07;
        int layoutDirection = A07(ra, this.A07, rh, false);
        int i5 = i4 + layoutDirection;
        if (i5 < 0) {
            return 0;
        }
        int absDy2 = consumed > i5 ? absDy * i5 : i3;
        int layoutDirection2 = -absDy2;
        this.A04.A0J(layoutDirection2);
        this.A07.A04 = absDy2;
        return absDy2;
    }

    private int A05(int i3, RA ra, RH rh, boolean z2) {
        int fixOffset;
        int gap = this.A04.A07() - i3;
        if (gap > 0) {
            int i4 = -A04(-gap, ra, rh);
            int i5 = i3 + i4;
            if (z2 && (fixOffset = this.A04.A07() - i5) > 0) {
                this.A04.A0J(fixOffset);
                return fixOffset + i4;
            }
            return i4;
        }
        return 0;
    }

    private int A06(int i3, RA ra, RH rh, boolean z2) {
        int iA0A;
        int gap = i3 - this.A04.A0A();
        if (gap > 0) {
            int i4 = -A04(gap, ra, rh);
            int i5 = i3 + i4;
            if (z2 && (iA0A = i5 - this.A04.A0A()) > 0) {
                this.A04.A0J(-iA0A);
                return i4 - iA0A;
            }
            return i4;
        }
        return 0;
    }

    private final int A07(RA ra, C0988Qh c0988Qh, RH rh, boolean z2) {
        int i3 = c0988Qh.A00;
        int start = c0988Qh.A07;
        if (start != Integer.MIN_VALUE) {
            int start2 = c0988Qh.A00;
            if (start2 < 0) {
                int i4 = c0988Qh.A07;
                int start3 = c0988Qh.A00;
                c0988Qh.A07 = i4 + start3;
            }
            A0e(ra, c0988Qh);
        }
        int i5 = c0988Qh.A00;
        int start4 = c0988Qh.A02;
        int i6 = i5 + start4;
        C0987Qg c0987Qg = this.A0E;
        while (true) {
            if ((!c0988Qh.A09 && i6 <= 0) || !c0988Qh.A05(rh)) {
                break;
            }
            c0987Qg.A00();
            A2F(ra, rh, c0988Qh, c0987Qg);
            if (!c0987Qg.A01) {
                int i7 = c0988Qh.A06;
                int remainingSpace = c0987Qg.A00;
                int start5 = c0988Qh.A05;
                c0988Qh.A06 = i7 + (remainingSpace * start5);
                if (!c0987Qg.A03 || this.A07.A08 != null || !rh.A07()) {
                    int remainingSpace2 = c0988Qh.A00;
                    int start6 = c0987Qg.A00;
                    c0988Qh.A00 = remainingSpace2 - start6;
                    int start7 = c0987Qg.A00;
                    i6 -= start7;
                }
                int start8 = c0988Qh.A07;
                if (start8 != Integer.MIN_VALUE) {
                    int remainingSpace3 = c0988Qh.A07;
                    int start9 = c0987Qg.A00;
                    c0988Qh.A07 = remainingSpace3 + start9;
                    int start10 = c0988Qh.A00;
                    if (start10 < 0) {
                        int remainingSpace4 = c0988Qh.A07;
                        int start11 = c0988Qh.A00;
                        c0988Qh.A07 = remainingSpace4 + start11;
                    }
                    A0e(ra, c0988Qh);
                }
                if (z2 && c0987Qg.A02) {
                    break;
                }
            } else {
                break;
            }
        }
        int start12 = c0988Qh.A00;
        return i3 - start12;
    }

    private int A08(RH rh) {
        if (A0Y() == 0) {
            return 0;
        }
        A2B();
        return RL.A00(rh, this.A04, A0R(!this.A0B, true), A0Q(!this.A0B, true), this, this.A0B);
    }

    private int A0A(RH rh) {
        if (A0Y() != 0) {
            A2B();
            return RL.A02(rh, this.A04, A0R(!this.A0B, true), A0Q(!this.A0B, true), this, this.A0B, this.A05);
        }
        if (A0G[3].charAt(25) != '2') {
            throw new RuntimeException();
        }
        A0G[1] = "J9JFedtgHh7lzsKv2wGVe5URJzbGPRgH";
        return 0;
    }

    private int A0B(RH rh) {
        if (A0Y() == 0) {
            return 0;
        }
        A2B();
        return RL.A01(rh, this.A04, A0R(!this.A0B, true), A0Q(!this.A0B, true), this, this.A0B);
    }

    private final int A0C(RH rh) {
        if (rh.A06()) {
            return this.A04.A0B();
        }
        return 0;
    }

    private View A0D() {
        return A0H(0, A0Y());
    }

    private View A0E() {
        return A0H(A0Y() - 1, -1);
    }

    private View A0F() {
        return A0v(this.A05 ? 0 : A0Y() - 1);
    }

    private View A0G() {
        return A0v(this.A05 ? A0Y() - 1 : 0);
    }

    private final View A0H(int i3, int i4) {
        int next;
        int acceptableBoundsFlag;
        int preferredBoundsFlag;
        A2B();
        if (i4 > i3) {
            next = 1;
        } else {
            next = i4 < i3 ? -1 : 0;
        }
        if (next == 0) {
            return A0v(i3);
        }
        int preferredBoundsFlag2 = this.A04.A0F(A0v(i3));
        int next2 = this.A04.A0A();
        if (preferredBoundsFlag2 < next2) {
            acceptableBoundsFlag = 16644;
            preferredBoundsFlag = 16388;
        } else {
            acceptableBoundsFlag = 4161;
            preferredBoundsFlag = 4097;
        }
        int next3 = this.A00;
        if (next3 == 0) {
            return super.A04.A00(i3, i4, acceptableBoundsFlag, preferredBoundsFlag);
        }
        return super.A05.A00(i3, i4, acceptableBoundsFlag, preferredBoundsFlag);
    }

    private final View A0I(int i3, int i4, boolean z2, boolean z3) {
        int i5;
        A2B();
        int i6 = 0;
        if (z2) {
            i5 = 24579;
        } else {
            i5 = 320;
        }
        if (z3) {
            i6 = 320;
        }
        int i7 = this.A00;
        int acceptableBoundsFlag = A0G[5].charAt(29);
        if (acceptableBoundsFlag != 69) {
            throw new RuntimeException();
        }
        A0G[5] = "CO2lCdhiUyNnJNyVLVKK7uQ85cne8EHP";
        if (i7 == 0) {
            return super.A04.A00(i3, i4, i5, i6);
        }
        return super.A05.A00(i3, i4, i5, i6);
    }

    private View A0J(RA ra, RH rh) {
        return A2A(ra, rh, 0, A0Y(), rh.A03());
    }

    private View A0L(RA ra, RH rh) {
        return A2A(ra, rh, A0Y() - 1, -1, rh.A03());
    }

    private View A0M(RA ra, RH rh) {
        return this.A05 ? A0D() : A0E();
    }

    private View A0N(RA ra, RH rh) {
        return this.A05 ? A0E() : A0D();
    }

    private View A0O(RA ra, RH rh) {
        return this.A05 ? A0J(ra, rh) : A0L(ra, rh);
    }

    private View A0P(RA ra, RH rh) {
        return this.A05 ? A0L(ra, rh) : A0J(ra, rh);
    }

    private View A0Q(boolean z2, boolean z3) {
        if (this.A05) {
            return A0I(0, A0Y(), z2, z3);
        }
        return A0I(A0Y() - 1, -1, z2, z3);
    }

    private View A0R(boolean z2, boolean z3) {
        if (this.A05) {
            return A0I(A0Y() - 1, -1, z2, z3);
        }
        return A0I(0, A0Y(), z2, z3);
    }

    private final C0988Qh A0S() {
        return new C0988Qh();
    }

    private void A0U() {
        if (this.A00 == 1 || !A2H()) {
            this.A05 = this.A0A;
        } else {
            this.A05 = !this.A0A;
        }
    }

    private void A0W(int i3, int i4) {
        this.A07.A00 = this.A04.A07() - i4;
        this.A07.A03 = this.A05 ? -1 : 1;
        this.A07.A01 = i3;
        this.A07.A05 = 1;
        this.A07.A06 = i4;
        this.A07.A07 = Integer.MIN_VALUE;
    }

    private void A0X(int i3, int i4) {
        this.A07.A00 = i4 - this.A04.A0A();
        this.A07.A01 = i3;
        this.A07.A03 = this.A05 ? 1 : -1;
        this.A07.A05 = -1;
        this.A07.A06 = i4;
        this.A07.A07 = Integer.MIN_VALUE;
    }

    private void A0Y(int i3, int i4, boolean z2, RH rh) {
        int iA0A;
        this.A07.A09 = A0i();
        this.A07.A02 = A0C(rh);
        this.A07.A05 = i3;
        if (i3 == 1) {
            this.A07.A02 += this.A04.A08();
            View viewA0F = A0F();
            C0988Qh c0988Qh = this.A07;
            if (!this.A05) {
                i = 1;
            }
            c0988Qh.A03 = i;
            this.A07.A01 = A0r(viewA0F) + this.A07.A03;
            this.A07.A06 = this.A04.A0C(viewA0F);
            iA0A = this.A04.A0C(viewA0F) - this.A04.A07();
        } else {
            View viewA0G = A0G();
            this.A07.A02 += this.A04.A0A();
            this.A07.A03 = this.A05 ? 1 : -1;
            this.A07.A01 = A0r(viewA0G) + this.A07.A03;
            this.A07.A06 = this.A04.A0F(viewA0G);
            iA0A = (-this.A04.A0F(viewA0G)) + this.A04.A0A();
        }
        this.A07.A00 = i4;
        if (z2) {
            C0988Qh c0988Qh2 = this.A07;
            int scrollingOffset = c0988Qh2.A00;
            c0988Qh2.A00 = scrollingOffset - iA0A;
        }
        this.A07.A07 = iA0A;
    }

    private void A0Z(C0986Qf c0986Qf) {
        A0W(c0986Qf.A01, c0986Qf.A00);
    }

    private void A0a(C0986Qf c0986Qf) {
        A0X(c0986Qf.A01, c0986Qf.A00);
    }

    private void A0b(RA ra, int i3) {
        int iA0Y = A0Y();
        if (i3 < 0) {
            return;
        }
        int iA06 = this.A04.A06() - i3;
        boolean z2 = this.A05;
        int limit = A0G[3].charAt(25);
        if (limit != 50) {
            throw new RuntimeException();
        }
        A0G[1] = "5eQap7viEGWOuRbzagNYDGjkAWEMIhVp";
        if (z2) {
            for (int i4 = 0; i4 < iA0Y; i4++) {
                View viewA0v = A0v(i4);
                int childCount = this.A04.A0F(viewA0v);
                if (childCount >= iA06) {
                    int childCount2 = this.A04.A0H(viewA0v);
                    if (childCount2 >= iA06) {
                    }
                }
                int limit2 = A0G[4].length();
                if (limit2 != 13) {
                    String[] strArr = A0G;
                    strArr[6] = "EiwXPaP";
                    strArr[2] = "4OvxlWI";
                    A0d(ra, 0, i4);
                    return;
                }
                A0d(ra, 0, i4);
                return;
            }
            return;
        }
        for (int i5 = iA0Y - 1; i5 >= 0; i5--) {
            View viewA0v2 = A0v(i5);
            int childCount3 = this.A04.A0F(viewA0v2);
            if (childCount3 >= iA06) {
                int childCount4 = this.A04.A0H(viewA0v2);
                if (childCount4 >= iA06) {
                }
            }
            int childCount5 = iA0Y - 1;
            A0d(ra, childCount5, i5);
            return;
        }
    }

    private void A0c(RA ra, int i3) {
        if (i3 < 0) {
            return;
        }
        int iA0Y = A0Y();
        if (this.A05) {
            for (int i4 = iA0Y - 1; i4 >= 0; i4--) {
                View viewA0v = A0v(i4);
                AbstractC0992Qm abstractC0992Qm = this.A04;
                int childCount = A0G[5].charAt(29);
                if (childCount != 69) {
                    throw new RuntimeException();
                }
                A0G[3] = "CCkneFsBnjHsOQTiipl2DNgji2H70UcR";
                int limit = abstractC0992Qm.A0C(viewA0v);
                if (limit <= i3) {
                    int limit2 = this.A04.A0G(viewA0v);
                    if (limit2 <= i3) {
                    }
                }
                int limit3 = iA0Y - 1;
                A0d(ra, limit3, i4);
                return;
            }
            return;
        }
        for (int i5 = 0; i5 < iA0Y; i5++) {
            View viewA0v2 = A0v(i5);
            int limit4 = this.A04.A0C(viewA0v2);
            if (limit4 <= i3) {
                int limit5 = this.A04.A0G(viewA0v2);
                if (limit5 <= i3) {
                }
            }
            A0d(ra, 0, i5);
            return;
        }
    }

    private void A0d(RA ra, int i3, int i4) {
        if (i3 == i4) {
            return;
        }
        if (i4 > i3) {
            for (int i5 = i4 - 1; i5 >= i3; i5--) {
                A16(i5, ra);
            }
            return;
        }
        while (i3 > i4) {
            A16(i3, ra);
            i3--;
        }
    }

    private void A0e(RA ra, C0988Qh c0988Qh) {
        if (!c0988Qh.A0B || c0988Qh.A09) {
            return;
        }
        if (c0988Qh.A05 == -1) {
            A0b(ra, c0988Qh.A07);
        } else {
            A0c(ra, c0988Qh.A07);
        }
    }

    private void A0f(RA ra, RH rh, int scrapExtraEnd, int scrapExtraEnd2) {
        if (!rh.A08() || A0Y() == 0 || rh.A07() || !A24()) {
            return;
        }
        int iA0D = 0;
        int scrapExtraStart = 0;
        List<RK> listA0J = ra.A0J();
        int i3 = listA0J.size();
        int iA0r = A0r(A0v(0));
        for (int scrapSize = 0; scrapSize < i3; scrapSize++) {
            RK rk = listA0J.get(scrapSize);
            if (!rk.A0g()) {
                int direction = 1;
                if ((rk.A0O() < iA0r) != this.A05) {
                    direction = -1;
                }
                if (direction == -1) {
                    iA0D += this.A04.A0D(rk.A0H);
                } else {
                    scrapExtraStart += this.A04.A0D(rk.A0H);
                }
            }
        }
        this.A07.A08 = listA0J;
        if (iA0D > 0) {
            A0X(A0r(A0G()), scrapExtraEnd);
            this.A07.A02 = iA0D;
            this.A07.A00 = 0;
            this.A07.A04();
            A07(ra, this.A07, rh, false);
        }
        if (scrapExtraStart > 0) {
            A0W(A0r(A0F()), scrapExtraEnd2);
            this.A07.A02 = scrapExtraStart;
            this.A07.A00 = 0;
            this.A07.A04();
            A07(ra, this.A07, rh, false);
        }
        this.A07.A08 = null;
    }

    private void A0g(RA ra, RH rh, C0986Qf c0986Qf) {
        if (A0k(rh, c0986Qf) || A0j(ra, rh, c0986Qf)) {
            return;
        }
        c0986Qf.A02();
        c0986Qf.A01 = this.A0C ? rh.A03() - 1 : 0;
    }

    private final void A0h(boolean z2) {
        A20(null);
        if (z2 == this.A0A) {
            return;
        }
        this.A0A = z2;
        A10();
    }

    private final boolean A0i() {
        return this.A04.A09() == 0 && this.A04.A06() == 0;
    }

    private boolean A0j(RA ra, RH rh, C0986Qf c0986Qf) {
        View viewA0P;
        int iA0A;
        if (A0Y() == 0) {
            return false;
        }
        View viewA0u = A0u();
        if (viewA0u != null && c0986Qf.A06(viewA0u, rh)) {
            c0986Qf.A05(viewA0u);
            return true;
        }
        if (this.A08 != this.A0C) {
            return false;
        }
        if (c0986Qf.A02) {
            viewA0P = A0O(ra, rh);
        } else {
            viewA0P = A0P(ra, rh);
        }
        if (viewA0P == null) {
            return false;
        }
        c0986Qf.A04(viewA0P);
        if (!rh.A07() && A24()) {
            if (this.A04.A0F(viewA0P) >= this.A04.A07() || this.A04.A0C(viewA0P) < this.A04.A0A()) {
                if (c0986Qf.A02) {
                    iA0A = this.A04.A07();
                } else {
                    iA0A = this.A04.A0A();
                }
                c0986Qf.A00 = iA0A;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b2, code lost:
    
        if ((r7 - r6) < 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b4, code lost:
    
        r10.A00 = r8.A04.A0A();
        r10.A02 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00be, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c7, code lost:
    
        if ((r7 - r6) < 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ca, code lost:
    
        r1 = r8.A04.A07() - r8.A04.A0C(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d7, code lost:
    
        if (r1 >= 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d9, code lost:
    
        r10.A00 = r8.A04.A07();
        r10.A02 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00e3, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e6, code lost:
    
        if (r10.A02 == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00e8, code lost:
    
        r1 = r8.A04.A0C(r5);
        r1 = r1 + r8.A04.A05();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00f5, code lost:
    
        r10.A00 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00f8, code lost:
    
        r1 = r8.A04.A0F(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A0k(com.facebook.ads.redexgen.core.RH r9, com.facebook.ads.redexgen.core.C0986Qf r10) {
        /*
            Method dump skipped, instruction units count: 347
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1718hr.A0k(com.facebook.ads.redexgen.X.RH, com.facebook.ads.redexgen.X.Qf):boolean");
    }

    @Override // com.facebook.ads.redexgen.core.R2
    public int A1f(int i3, RA ra, RH rh) {
        if (this.A00 == 1) {
            return 0;
        }
        return A04(i3, ra, rh);
    }

    @Override // com.facebook.ads.redexgen.core.R2
    public int A1g(int i3, RA ra, RH rh) {
        if (this.A00 == 0) {
            return 0;
        }
        return A04(i3, ra, rh);
    }

    @Override // com.facebook.ads.redexgen.core.R2
    public final int A1h(RH rh) {
        return A08(rh);
    }

    @Override // com.facebook.ads.redexgen.core.R2
    public final int A1i(RH rh) {
        return A0A(rh);
    }

    @Override // com.facebook.ads.redexgen.core.R2
    public final int A1j(RH rh) {
        return A0B(rh);
    }

    @Override // com.facebook.ads.redexgen.core.R2
    public final int A1k(RH rh) {
        return A08(rh);
    }

    @Override // com.facebook.ads.redexgen.core.R2
    public final int A1l(RH rh) {
        return A0A(rh);
    }

    @Override // com.facebook.ads.redexgen.core.R2
    public final int A1m(RH rh) {
        return A0B(rh);
    }

    @Override // com.facebook.ads.redexgen.core.R2
    public final Parcelable A1n() {
        if (this.A03 != null) {
            return new WrappedParcelable(new LinearLayoutManager$SavedState(this.A03));
        }
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = new LinearLayoutManager$SavedState();
        if (A0Y() > 0) {
            A2B();
            boolean didLayoutFromEnd = this.A08 ^ this.A05;
            linearLayoutManager$SavedState.A02 = didLayoutFromEnd;
            if (didLayoutFromEnd) {
                View refChild = A0F();
                linearLayoutManager$SavedState.A00 = this.A04.A07() - this.A04.A0C(refChild);
                linearLayoutManager$SavedState.A01 = A0r(refChild);
            } else {
                View viewA0G = A0G();
                linearLayoutManager$SavedState.A01 = A0r(viewA0G);
                linearLayoutManager$SavedState.A00 = this.A04.A0F(viewA0G) - this.A04.A0A();
            }
        } else {
            linearLayoutManager$SavedState.A00();
        }
        return new WrappedParcelable(linearLayoutManager$SavedState);
    }

    @Override // com.facebook.ads.redexgen.core.R2
    public final View A1o(int i3) {
        int firstChild = A0Y();
        if (firstChild == 0) {
            return null;
        }
        int childCount = i3 - A0r(A0v(0));
        if (childCount >= 0 && childCount < firstChild) {
            View viewA0v = A0v(childCount);
            if (A0r(viewA0v) == i3) {
                return viewA0v;
            }
        }
        return super.A1o(i3);
    }

    @Override // com.facebook.ads.redexgen.core.R2
    public View A1p(View view, int i3, RA ra, RH rh) {
        int maxScroll;
        View nextFocus;
        View viewA0F;
        A0U();
        if (A0Y() == 0 || (maxScroll = A29(i3)) == Integer.MIN_VALUE) {
            return null;
        }
        A2B();
        A2B();
        int layoutDir = this.A04.A0B();
        A0Y(maxScroll, (int) (layoutDir * 0.33333334f), false, rh);
        this.A07.A07 = Integer.MIN_VALUE;
        this.A07.A0B = false;
        A07(ra, this.A07, rh, true);
        if (maxScroll == -1) {
            nextFocus = A0N(ra, rh);
        } else {
            nextFocus = A0M(ra, rh);
        }
        if (maxScroll == -1) {
            viewA0F = A0G();
        } else {
            viewA0F = A0F();
        }
        if (viewA0F.hasFocusable()) {
            if (nextFocus == null) {
                return null;
            }
            return viewA0F;
        }
        return nextFocus;
    }

    @Override // com.facebook.ads.redexgen.core.R2
    public R3 A1q() {
        return new R3(-2, -2);
    }

    @Override // com.facebook.ads.redexgen.core.R2
    public void A1r(int i3) {
        this.A01 = i3;
        this.A02 = Integer.MIN_VALUE;
        if (this.A03 != null) {
            this.A03.A00();
        }
        A10();
    }

    @Override // com.facebook.ads.redexgen.core.R2
    public final void A1s(int i3, int i4, RH rh, R0 r02) {
        if (this.A00 != 0) {
            i3 = i4;
        }
        int delta = A0Y();
        if (delta == 0 || i3 == 0) {
            return;
        }
        A2B();
        int i5 = i3 > 0 ? 1 : -1;
        int delta2 = Math.abs(i3);
        A0Y(i5, delta2, true, rh);
        A2G(rh, this.A07, r02);
    }

    @Override // com.facebook.ads.redexgen.core.R2
    public final void A1t(int i3, R0 r02) {
        boolean z2;
        int direction;
        if (this.A03 != null && this.A03.A01()) {
            z2 = this.A03.A02;
            direction = this.A03.A01;
        } else {
            A0U();
            z2 = this.A05;
            if (this.A01 == -1) {
                direction = z2 ? i3 - 1 : 0;
            } else {
                direction = this.A01;
            }
        }
        int anchorPos = z2 ? -1 : 1;
        for (int i4 = 0; i4 < this.A06 && direction >= 0 && direction < i3; i4++) {
            r02.A42(direction, 0);
            direction += anchorPos;
        }
    }

    @Override // com.facebook.ads.redexgen.core.R2
    public final void A1u(Parcelable parcelable) {
        ClassLoader classLoader;
        if (!(parcelable instanceof WrappedParcelable) || (classLoader = getClass().getClassLoader()) == null) {
            return;
        }
        Parcelable state = ((WrappedParcelable) parcelable).unwrap(classLoader);
        if (state instanceof LinearLayoutManager$SavedState) {
            this.A03 = (LinearLayoutManager$SavedState) state;
            A10();
        }
    }

    @Override // com.facebook.ads.redexgen.core.R2
    public final void A1v(AccessibilityEvent accessibilityEvent) {
        super.A1v(accessibilityEvent);
        if (A0Y() > 0) {
            accessibilityEvent.setFromIndex(A26());
            if (A0G[1].charAt(13) == 'I') {
                throw new RuntimeException();
            }
            String[] strArr = A0G;
            strArr[6] = "JM0e54P";
            strArr[2] = "62qYDCA";
            accessibilityEvent.setToIndex(A27());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0250  */
    @Override // com.facebook.ads.redexgen.core.R2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A1w(com.facebook.ads.redexgen.core.RA r10, com.facebook.ads.redexgen.core.RH r11) {
        /*
            Method dump skipped, instruction units count: 608
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1718hr.A1w(com.facebook.ads.redexgen.X.RA, com.facebook.ads.redexgen.X.RH):void");
    }

    @Override // com.facebook.ads.redexgen.core.R2
    public void A1x(RH rh) {
        super.A1x(rh);
        this.A03 = null;
        this.A01 = -1;
        this.A02 = Integer.MIN_VALUE;
        this.A0D.A03();
    }

    @Override // com.facebook.ads.redexgen.core.R2
    public final void A1y(C7M c7m, RA ra) {
        super.A1y(c7m, ra);
        if (this.A09) {
            A1K(ra);
            ra.A0P();
        }
    }

    @Override // com.facebook.ads.redexgen.core.R2
    public void A1z(C7M c7m, RH rh, int i3) {
        C1717hq linearSmoothScroller = new C1717hq(c7m.getContext());
        linearSmoothScroller.A0A(i3);
        A1N(linearSmoothScroller);
    }

    @Override // com.facebook.ads.redexgen.core.R2
    public final void A20(String str) {
        if (this.A03 == null) {
            super.A20(str);
        }
    }

    @Override // com.facebook.ads.redexgen.core.R2
    public final boolean A21() {
        return (A0a() == 1073741824 || A0k() == 1073741824 || !A1U()) ? false : true;
    }

    @Override // com.facebook.ads.redexgen.core.R2
    public final boolean A22() {
        return this.A00 == 0;
    }

    @Override // com.facebook.ads.redexgen.core.R2
    public final boolean A23() {
        return this.A00 == 1;
    }

    @Override // com.facebook.ads.redexgen.core.R2
    public boolean A24() {
        return this.A03 == null && this.A08 == this.A0C;
    }

    public final int A25() {
        View child = A0I(0, A0Y(), true, false);
        if (child == null) {
            return -1;
        }
        return A0r(child);
    }

    public final int A26() {
        View child = A0I(0, A0Y(), false, true);
        if (child == null) {
            return -1;
        }
        return A0r(child);
    }

    public final int A27() {
        View child = A0I(A0Y() - 1, -1, false, true);
        if (child == null) {
            return -1;
        }
        return A0r(child);
    }

    public final int A28() {
        return this.A00;
    }

    public final int A29(int i3) {
        switch (i3) {
            case 1:
                if (this.A00 == 1) {
                    return -1;
                }
                boolean zA2H = A2H();
                if (A0G[4].length() != 13) {
                    A0G[7] = "JFBGAdvw0W46p1IiHd184rfjlhxsbjRk";
                    return zA2H ? 1 : -1;
                }
                break;
            case 2:
                return (this.A00 != 1 && A2H()) ? -1 : 1;
            case 17:
                if (this.A00 == 0) {
                    return -1;
                }
                return Integer.MIN_VALUE;
            case 33:
                if (this.A00 == 1) {
                    return -1;
                }
                return Integer.MIN_VALUE;
            case 66:
                int i4 = this.A00;
                String[] strArr = A0G;
                if (strArr[6].length() == strArr[2].length()) {
                    A0G[0] = "A4gNOGqmCbgTlyYHXDAs3UqrHjABAhAn";
                    return i4 == 0 ? 1 : Integer.MIN_VALUE;
                }
                break;
            case 130:
                return this.A00 == 1 ? 1 : Integer.MIN_VALUE;
            default:
                return Integer.MIN_VALUE;
        }
        throw new RuntimeException();
    }

    public View A2A(RA ra, RH rh, int i3, int i4, int i5) {
        A2B();
        View view = null;
        View view2 = null;
        int iA0A = this.A04.A0A();
        int boundsEnd = this.A04.A07();
        int boundsStart = i4 > i3 ? 1 : -1;
        while (i3 != i4) {
            View outOfBoundsMatch = A0v(i3);
            int iA0r = A0r(outOfBoundsMatch);
            if (iA0r >= 0 && iA0r < i5) {
                if (((R3) outOfBoundsMatch.getLayoutParams()).A02()) {
                    if (view == null) {
                        view = outOfBoundsMatch;
                    }
                } else if (this.A04.A0F(outOfBoundsMatch) >= boundsEnd || this.A04.A0C(outOfBoundsMatch) < iA0A) {
                    if (view2 == null) {
                        view2 = outOfBoundsMatch;
                    }
                } else {
                    return outOfBoundsMatch;
                }
            }
            i3 += boundsStart;
        }
        return view2 != null ? view2 : view;
    }

    public final void A2B() {
        if (this.A07 == null) {
            C0988Qh c0988QhA0S = A0S();
            if (A0G[3].charAt(25) != '2') {
                throw new RuntimeException();
            }
            A0G[7] = "6FRvOBuqOIFmnj4QgnBJgNDOjl7oudHL";
            this.A07 = c0988QhA0S;
        }
        if (this.A04 == null) {
            this.A04 = AbstractC0992Qm.A02(this, this.A00);
        }
    }

    public final void A2C(int i3) {
        if (i3 == 0 || i3 == 1) {
            A20(null);
            if (i3 == this.A00) {
                return;
            }
            this.A00 = i3;
            this.A04 = null;
            A10();
            return;
        }
        throw new IllegalArgumentException(A0T(0, 20, 45) + i3);
    }

    public final void A2D(int i3, int i4) {
        this.A01 = i3;
        this.A02 = i4;
        if (this.A03 != null) {
            this.A03.A00();
        }
        A10();
    }

    public void A2E(RA ra, RH rh, C0986Qf c0986Qf, int i3) {
    }

    public void A2F(RA ra, RH rh, C0988Qh c0988Qh, C0987Qg c0987Qg) {
        int iA0i;
        int right;
        int iA0g;
        int iA0E;
        View viewA03 = c0988Qh.A03(ra);
        if (viewA03 == null) {
            c0987Qg.A01 = true;
            return;
        }
        R3 r3 = (R3) viewA03.getLayoutParams();
        if (c0988Qh.A08 == null) {
            if (this.A05 == (c0988Qh.A05 == -1)) {
                A19(viewA03);
            } else {
                A1B(viewA03, 0);
            }
        } else {
            boolean z2 = this.A05;
            int bottom = c0988Qh.A05;
            if (z2 == (bottom == -1)) {
                A18(viewA03);
            } else {
                A1A(viewA03, 0);
            }
        }
        A1C(viewA03, 0, 0);
        c0987Qg.A00 = this.A04.A0D(viewA03);
        if (this.A00 == 1) {
            if (A2H()) {
                iA0E = A0j() - A0h();
                iA0g = iA0E - this.A04.A0E(viewA03);
            } else {
                iA0g = A0g();
                iA0E = this.A04.A0E(viewA03) + iA0g;
            }
            if (c0988Qh.A05 == -1) {
                right = c0988Qh.A06;
                iA0i = c0988Qh.A06 - c0987Qg.A00;
            } else {
                iA0i = c0988Qh.A06;
                right = c0988Qh.A06 + c0987Qg.A00;
            }
        } else {
            iA0i = A0i();
            right = this.A04.A0E(viewA03) + iA0i;
            int bottom2 = c0988Qh.A05;
            if (bottom2 == -1) {
                iA0E = c0988Qh.A06;
                int i3 = c0988Qh.A06;
                int bottom3 = c0987Qg.A00;
                iA0g = i3 - bottom3;
            } else {
                iA0g = c0988Qh.A06;
                int i4 = c0988Qh.A06;
                int bottom4 = c0987Qg.A00;
                iA0E = i4 + bottom4;
            }
        }
        A1D(viewA03, iA0g, iA0i, iA0E, right);
        if (r3.A02() || r3.A01()) {
            c0987Qg.A03 = true;
        }
        c0987Qg.A02 = viewA03.hasFocusable();
    }

    public void A2G(RH rh, C0988Qh c0988Qh, R0 r02) {
        int i3 = c0988Qh.A01;
        if (i3 >= 0) {
            int pos = rh.A03();
            if (i3 < pos) {
                int pos2 = c0988Qh.A07;
                r02.A42(i3, Math.max(0, pos2));
            }
        }
    }

    public final boolean A2H() {
        return A0c() == 1;
    }

    @Override // com.facebook.ads.redexgen.core.RE
    public final PointF A56(int i3) {
        if (A0Y() == 0) {
            return null;
        }
        boolean z2 = i3 < A0r(A0v(0));
        boolean z3 = this.A05;
        int firstChildPos = A0G[4].length();
        if (firstChildPos == 13) {
            throw new RuntimeException();
        }
        A0G[7] = "FFnbbIQmxzlcCB5QJgqtb02Njm6aLfkX";
        int i4 = z2 != z3 ? -1 : 1;
        int direction = this.A00;
        if (direction == 0) {
            return new PointF(i4, 0.0f);
        }
        return new PointF(0.0f, i4);
    }
}
