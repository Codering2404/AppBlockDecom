package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import com.facebook.internal.Utility;
import com.facebook.stetho.dumpapp.Framer;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class R2 {
    public static byte[] A0I;
    public static String[] A0J = {"xyZ8yvYzp3wrHAf7Yx6bEToOMuLBTkeJ", "zRc0P2oS", "sxpemPSbJ0zjH5L170Fpc8WIJnMfTOYM", "JLvxwq6R3Maitb0M5MelMbaPMbiMlz5H", "qno0WD9sdyP92Tf9SwtsGsNlEh6m7cws", "isTf1gingqqcw8OSNjwv80foOygzMJYI", "cYtNYfyLYrQzxoivZChv", "OeXF3cqFYKXlQ2ABbzPAkdUOYZHirWRh"};
    public int A00;
    public QQ A01;
    public RF A02;
    public C7M A03;
    public boolean A08;
    public int A0A;
    public int A0B;
    public int A0C;
    public int A0D;
    public final RN A0G = new C1710hj(this);
    public final RN A0H = new C1708hh(this);
    public RP A04 = new RP(this.A0G);
    public RP A05 = new RP(this.A0H);
    public boolean A09 = false;
    public boolean A07 = false;
    public boolean A06 = false;
    public boolean A0F = true;
    public boolean A0E = true;

    public static String A09(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0I, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 20);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0A() {
        A0I = new byte[]{99, -122, -122, -121, -122, 66, Framer.EXIT_FRAME_PREFIX, -117, -121, -103, 66, -118, -125, -107, 66, 116, -121, -123, -101, -123, -114, -121, -108, Framer.EXIT_FRAME_PREFIX, -117, -121, -103, 66, -125, -107, 66, -110, -125, -108, -121, -112, -106, 66, -124, -105, -106, 66, -104, -117, -121, -103, 66, -117, -107, 66, -112, -111, -106, 66, -125, 66, -108, -121, -125, -114, 66, -123, -118, -117, -114, -122, 80, 66, 119, -112, -120, -117, -114, -106, -121, -108, -121, -122, 66, -117, -112, -122, -121, -102, 92, -88, -58, -45, -45, -44, -39, -123, -46, -44, -37, -54, -123, -58, -123, -56, -51, -50, -47, -55, -123, -53, -41, -44, -46, -123, -45, -44, -45, -110, -54, -35, -50, -40, -39, -50, -45, -52, -123, -50, -45, -55, -54, -35, -97};
    }

    public abstract int A1f(int i3, RA ra, RH rh);

    public abstract int A1g(int i3, RA ra, RH rh);

    public abstract int A1h(RH rh);

    public abstract int A1i(RH rh);

    public abstract int A1j(RH rh);

    public abstract int A1k(RH rh);

    public abstract int A1l(RH rh);

    public abstract int A1m(RH rh);

    public abstract Parcelable A1n();

    public abstract View A1p(View view, int i3, RA ra, RH rh);

    public abstract R3 A1q();

    public abstract void A1r(int i3);

    public abstract void A1s(int i3, int i4, RH rh, R0 r02);

    public abstract void A1t(int i3, R0 r02);

    public abstract void A1u(Parcelable parcelable);

    public abstract void A1w(RA ra, RH rh);

    public abstract void A1z(C7M c7m, RH rh, int i3);

    public abstract boolean A21();

    public abstract boolean A22();

    public abstract boolean A23();

    public abstract boolean A24();

    static {
        A0A();
    }

    public static int A02(int i3, int i4, int i5) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        switch (mode) {
            case Integer.MIN_VALUE:
                int iMax = Math.max(i4, i5);
                int size2 = A0J[1].length();
                if (size2 != 8) {
                    throw new RuntimeException();
                }
                A0J[1] = "W1fJ2ceK";
                int mode2 = Math.min(size, iMax);
                return mode2;
            case 1073741824:
                return size;
            default:
                int mode3 = Math.max(i4, i5);
                return mode3;
        }
    }

    public static int A03(int i3, int i4, int i5, int i6, boolean z2) {
        int iMax = Math.max(0, i3 - i5);
        int i7 = 0;
        int resultMode = 0;
        if (z2) {
            if (i6 >= 0) {
                i7 = i6;
                resultMode = 1073741824;
            } else if (i6 == -1) {
                switch (i4) {
                    case Integer.MIN_VALUE:
                    case 1073741824:
                        i7 = iMax;
                        resultMode = i4;
                        break;
                    case 0:
                        i7 = 0;
                        resultMode = 0;
                        break;
                }
            } else if (i6 == -2) {
                i7 = 0;
                resultMode = 0;
            }
        } else if (i6 >= 0) {
            i7 = i6;
            resultMode = 1073741824;
        } else if (i6 == -1) {
            i7 = iMax;
            resultMode = i4;
        } else if (i6 == -2) {
            i7 = iMax;
            resultMode = (i4 == Integer.MIN_VALUE || i4 == 1073741824) ? Integer.MIN_VALUE : 0;
        }
        int size = View.MeasureSpec.makeMeasureSpec(i7, resultMode);
        return size;
    }

    private final int A04(View view) {
        return ((R3) view.getLayoutParams()).A03.bottom;
    }

    private final int A05(View view) {
        return ((R3) view.getLayoutParams()).A03.left;
    }

    private final int A06(View view) {
        return ((R3) view.getLayoutParams()).A03.right;
    }

    private final int A07(View view) {
        return ((R3) view.getLayoutParams()).A03.top;
    }

    private final int A08(RA ra, RH rh) {
        return 0;
    }

    private final void A0B(int i3) {
        A0E(i3, A0v(i3));
    }

    private final void A0C(int i3) {
        View child = A0v(i3);
        if (child != null) {
            this.A01.A0D(i3);
        }
    }

    private final void A0D(int i3, int i4) {
        View view = A0v(i3);
        if (view != null) {
            A0B(i3);
            A0G(view, i4);
            String[] strArr = A0J;
            if (strArr[2].charAt(30) != strArr[5].charAt(30)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0J;
            strArr2[0] = "fev5lwy8caKDFGGcVLFTWETO5UF90dOq";
            strArr2[7] = "EDoCIrgXqzBYQTf4WlngJinORtzJmrfl";
            return;
        }
        throw new IllegalArgumentException(A09(85, 44, 81) + i3 + this.A03.toString());
    }

    private void A0E(int i3, View view) {
        this.A01.A0C(i3);
    }

    private final void A0F(View view) {
        this.A01.A0F(view);
    }

    private final void A0G(View view, int i3) {
        A0H(view, i3, (R3) view.getLayoutParams());
    }

    private final void A0H(View view, int i3, R3 r3) {
        RK rkA0F = C7M.A0F(view);
        if (rkA0F.A0g()) {
            this.A03.A0t.A09(rkA0F);
        } else {
            this.A03.A0t.A0A(rkA0F);
        }
        this.A01.A0H(view, i3, r3, rkA0F.A0g());
    }

    private void A0I(View view, int i3, boolean z2) {
        RK rkA0F = C7M.A0F(view);
        if (z2 || rkA0F.A0g()) {
            this.A03.A0t.A09(rkA0F);
        } else {
            this.A03.A0t.A0A(rkA0F);
        }
        R3 r3 = (R3) view.getLayoutParams();
        if (rkA0F.A0m() || rkA0F.A0h()) {
            if (rkA0F.A0h()) {
                rkA0F.A0Y();
            } else {
                rkA0F.A0U();
            }
            this.A01.A0H(view, i3, view.getLayoutParams(), false);
        } else {
            ViewParent parent = view.getParent();
            C7M c7m = this.A03;
            if (A0J[3].charAt(19) == 'k') {
                throw new RuntimeException();
            }
            A0J[4] = "uqKRxBtg59XPGVJDkfwEUsBOgdJYSppJ";
            if (parent == c7m) {
                int currentIndex = this.A01.A07(view);
                if (i3 == -1) {
                    i3 = this.A01.A05();
                }
                if (currentIndex != -1) {
                    if (currentIndex != i3) {
                        this.A03.A06.A0D(currentIndex, i3);
                    }
                } else {
                    throw new IllegalStateException(A09(0, 85, 14) + this.A03.indexOfChild(view) + this.A03.A1J());
                }
            } else {
                this.A01.A0I(view, i3, false);
                r3.A01 = true;
                RF rf = this.A02;
                if (A0J[4].charAt(12) == 'v') {
                    throw new RuntimeException();
                }
                A0J[6] = "si9YLNjLFs";
                if (rf != null && this.A02.A0F()) {
                    this.A02.A0C(view);
                }
            }
        }
        if (r3.A02) {
            View view2 = rkA0F.A0H;
            if (A0J[1].length() != 8) {
                throw new RuntimeException();
            }
            A0J[1] = "bg493IDm";
            view2.invalidate();
            r3.A02 = false;
        }
    }

    private final void A0J(View view, Rect rect) {
        C7M.A0o(view, rect);
    }

    private void A0L(RA ra, int i3, View view) {
        RK rkA0F = C7M.A0F(view);
        if (rkA0F.A0l()) {
            return;
        }
        if (rkA0F.A0f()) {
            boolean zA0g = rkA0F.A0g();
            if (A0J[3].charAt(19) == 'k') {
                throw new RuntimeException();
            }
            String[] strArr = A0J;
            strArr[2] = "wfzQKDpvqCerNRZHLtQvgaB031c5C1YU";
            strArr[5] = "KgFz3HBRwd8cETJWtdM1PF8pjKUjBKYl";
            if (!zA0g && !this.A03.A04.A0M()) {
                A0C(i3);
                ra.A0X(rkA0F);
                return;
            }
        }
        A0B(i3);
        ra.A0S(view);
        this.A03.A0t.A0C(rkA0F);
    }

    private final void A0M(RA ra, RH rh, AccessibilityEvent accessibilityEvent) {
        if (this.A03 == null || accessibilityEvent == null) {
            return;
        }
        boolean z2 = true;
        if (!this.A03.canScrollVertically(1) && !this.A03.canScrollVertically(-1) && !this.A03.canScrollHorizontally(-1) && !this.A03.canScrollHorizontally(1)) {
            z2 = false;
        }
        accessibilityEvent.setScrollable(z2);
        if (this.A03.A04 != null) {
            accessibilityEvent.setItemCount(this.A03.A04.A0B());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A0N(com.facebook.ads.redexgen.core.RA r6, com.facebook.ads.redexgen.core.RH r7, com.facebook.ads.redexgen.core.Q6 r8) {
        /*
            r5 = this;
            com.facebook.ads.redexgen.X.7M r0 = r5.A03
            r1 = -1
            boolean r0 = r0.canScrollVertically(r1)
            r3 = 1
            if (r0 != 0) goto L2d
            com.facebook.ads.redexgen.X.7M r0 = r5.A03
            boolean r4 = r0.canScrollHorizontally(r1)
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.R2.A0J
            r0 = 3
            r1 = r1[r0]
            r0 = 19
            char r1 = r1.charAt(r0)
            r0 = 107(0x6b, float:1.5E-43)
            if (r1 == r0) goto L8e
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.R2.A0J
            java.lang.String r1 = "KDPDh71uiY9dw6lSrmH00w2HuhKAvOYl"
            r0 = 2
            r2[r0] = r1
            java.lang.String r1 = "F84YzGx02ov8ufnexIEGkhiaGhnINbYS"
            r0 = 5
            r2[r0] = r1
            if (r4 == 0) goto L35
        L2d:
            r0 = 8192(0x2000, float:1.148E-41)
            r8.A0N(r0)
            r8.A0R(r3)
        L35:
            com.facebook.ads.redexgen.X.7M r0 = r5.A03
            boolean r0 = r0.canScrollVertically(r3)
            if (r0 != 0) goto L5b
            com.facebook.ads.redexgen.X.7M r4 = r5.A03
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.R2.A0J
            r0 = 3
            r1 = r1[r0]
            r0 = 19
            char r1 = r1.charAt(r0)
            r0 = 107(0x6b, float:1.5E-43)
            if (r1 == r0) goto L7b
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.R2.A0J
            java.lang.String r1 = "8s5rDkFpP"
            r0 = 6
            r2[r0] = r1
            boolean r0 = r4.canScrollHorizontally(r3)
            if (r0 == 0) goto L63
        L5b:
            r0 = 4096(0x1000, float:5.74E-42)
            r8.A0N(r0)
            r8.A0R(r3)
        L63:
            int r3 = r5.A0t(r6, r7)
            int r2 = r5.A0s(r6, r7)
            boolean r1 = r5.A0R(r6, r7)
            int r0 = r5.A08(r6, r7)
            com.facebook.ads.redexgen.X.Q3 r0 = com.facebook.ads.redexgen.core.Q3.A00(r3, r2, r1, r0)
            r8.A0P(r0)
            return
        L7b:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.R2.A0J
            java.lang.String r1 = "3WqpoC752q4h2Wya5fT3BPHdY3ZkhgYP"
            r0 = 2
            r2[r0] = r1
            java.lang.String r1 = "HauWKBzmz4VUJQZuXSWVI1MWGOc6zBYt"
            r0 = 5
            r2[r0] = r1
            boolean r0 = r4.canScrollHorizontally(r3)
            if (r0 == 0) goto L63
            goto L5b
        L8e:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.R2.A0N(com.facebook.ads.redexgen.X.RA, com.facebook.ads.redexgen.X.RH, com.facebook.ads.redexgen.X.Q6):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0O(RF rf) {
        if (this.A02 == rf) {
            this.A02 = null;
        }
    }

    private final boolean A0P() {
        return this.A02 != null && this.A02.A0F();
    }

    public static boolean A0Q(int i3, int i4, int i5) {
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        if (i5 > 0 && i3 != i5) {
            return false;
        }
        switch (mode) {
            case Integer.MIN_VALUE:
                if (size >= i3) {
                }
                break;
            case 0:
                break;
            case 1073741824:
                if (size == i3) {
                }
                break;
        }
        return false;
    }

    private final boolean A0R(RA ra, RH rh) {
        return false;
    }

    private final boolean A0S(RA ra, RH rh, int i3, Bundle bundle) {
        if (this.A03 == null) {
            return false;
        }
        int hScroll = 0;
        int i4 = 0;
        switch (i3) {
            case 4096:
                if (this.A03.canScrollVertically(1)) {
                    int hScroll2 = A0Z();
                    int vScroll = A0i();
                    int hScroll3 = hScroll2 - vScroll;
                    int vScroll2 = A0f();
                    hScroll = hScroll3 - vScroll2;
                }
                if (this.A03.canScrollHorizontally(1)) {
                    int iA0j = A0j();
                    int vScroll3 = A0g();
                    int i5 = iA0j - vScroll3;
                    int vScroll4 = A0h();
                    i4 = i5 - vScroll4;
                }
                break;
            case Utility.DEFAULT_STREAM_BUFFER_SIZE /* 8192 */:
                if (this.A03.canScrollVertically(-1)) {
                    int hScroll4 = A0Z();
                    int vScroll5 = A0i();
                    int hScroll5 = hScroll4 - vScroll5;
                    int vScroll6 = A0f();
                    hScroll = -(hScroll5 - vScroll6);
                }
                if (this.A03.canScrollHorizontally(-1)) {
                    int iA0j2 = A0j();
                    int vScroll7 = A0g();
                    int i6 = iA0j2 - vScroll7;
                    int vScroll8 = A0h();
                    i4 = -(i6 - vScroll8);
                }
                break;
        }
        if (hScroll == 0 && i4 == 0) {
            return false;
        }
        this.A03.scrollBy(i4, hScroll);
        return true;
    }

    private final boolean A0T(RA ra, RH rh, View view, int i3, Bundle bundle) {
        return false;
    }

    private boolean A0U(C7M c7m, int i3, int i4) {
        View focusedChild = c7m.getFocusedChild();
        if (focusedChild == null) {
            return false;
        }
        int parentBottom = A0g();
        int parentRight = A0i();
        int parentTop = A0j();
        int parentTop2 = parentTop - A0h();
        int parentLeft = A0Z();
        int parentLeft2 = parentLeft - A0f();
        Rect rect = this.A03.A0p;
        A0J(focusedChild, rect);
        if (rect.left - i3 >= parentTop2 || rect.right - i3 <= parentBottom || rect.top - i4 >= parentLeft2 || rect.bottom - i4 <= parentRight) {
            return false;
        }
        return true;
    }

    @Deprecated
    private final boolean A0V(C7M c7m, View view, View view2) {
        return A0P() || c7m.A1s();
    }

    private int[] A0W(View view, Rect rect) {
        int[] iArr = new int[2];
        int offScreenRight = A0g();
        int offScreenTop = A0i();
        int dy = A0j() - A0h();
        int offScreenLeft = A0Z() - A0f();
        int childBottom = (view.getLeft() + rect.left) - view.getScrollX();
        int childRight = (view.getTop() + rect.top) - view.getScrollY();
        int childLeft = rect.width() + childBottom;
        int parentLeft = rect.height();
        int parentBottom = Math.min(0, childBottom - offScreenRight);
        int parentRight = Math.min(0, childRight - offScreenTop);
        int parentTop = Math.max(0, childLeft - dy);
        int parentLeft2 = Math.max(0, (parentLeft + childRight) - offScreenLeft);
        if (A0c() == 1) {
            if (parentTop == 0) {
                parentTop = Math.max(parentBottom, childLeft - dy);
            }
        } else {
            parentTop = parentBottom != 0 ? parentBottom : Math.min(childBottom - offScreenRight, parentTop);
        }
        if (parentRight == 0) {
            parentRight = Math.min(childRight - offScreenTop, parentLeft2);
        }
        iArr[0] = parentTop;
        iArr[1] = parentRight;
        return iArr;
    }

    public final int A0X() {
        return -1;
    }

    public final int A0Y() {
        if (this.A01 != null) {
            return this.A01.A05();
        }
        return 0;
    }

    public final int A0Z() {
        return this.A0A;
    }

    public final int A0a() {
        return this.A0B;
    }

    public final int A0b() {
        AbstractC0996Qq a3;
        if (this.A03 != null) {
            C7M c7m = this.A03;
            if (A0J[3].charAt(19) == 'k') {
                throw new RuntimeException();
            }
            A0J[4] = "NhHtbEzlhB3n2IblVpNcmlHtdyAdrFMd";
            a3 = c7m.getAdapter();
        } else {
            a3 = null;
        }
        if (a3 != null) {
            return a3.A0B();
        }
        return 0;
    }

    public final int A0c() {
        return Ph.A01(this.A03);
    }

    public final int A0d() {
        return Ph.A02(this.A03);
    }

    public final int A0e() {
        return Ph.A03(this.A03);
    }

    public final int A0f() {
        if (this.A03 != null) {
            return this.A03.getPaddingBottom();
        }
        return 0;
    }

    public final int A0g() {
        if (this.A03 != null) {
            return this.A03.getPaddingLeft();
        }
        return 0;
    }

    public final int A0h() {
        if (this.A03 != null) {
            return this.A03.getPaddingRight();
        }
        return 0;
    }

    public final int A0i() {
        if (this.A03 != null) {
            return this.A03.getPaddingTop();
        }
        return 0;
    }

    public final int A0j() {
        return this.A0C;
    }

    public final int A0k() {
        return this.A0D;
    }

    public final int A0l(View view) {
        return view.getBottom() + A04(view);
    }

    public final int A0m(View view) {
        return view.getLeft() - A05(view);
    }

    public final int A0n(View view) {
        Rect rect = ((R3) view.getLayoutParams()).A03;
        return view.getMeasuredHeight() + rect.top + rect.bottom;
    }

    public final int A0o(View view) {
        Rect rect = ((R3) view.getLayoutParams()).A03;
        return view.getMeasuredWidth() + rect.left + rect.right;
    }

    public final int A0p(View view) {
        return view.getRight() + A06(view);
    }

    public final int A0q(View view) {
        return view.getTop() - A07(view);
    }

    public final int A0r(View view) {
        return ((R3) view.getLayoutParams()).A00();
    }

    public int A0s(RA ra, RH rh) {
        if (this.A03 == null || this.A03.A04 == null || !A22()) {
            return 1;
        }
        return this.A03.A04.A0B();
    }

    public int A0t(RA ra, RH rh) {
        if (this.A03 == null || this.A03.A04 == null || !A23()) {
            return 1;
        }
        return this.A03.A04.A0B();
    }

    public final View A0u() {
        View focusedChild;
        if (this.A03 == null || (focusedChild = this.A03.getFocusedChild()) == null || this.A01.A0K(focusedChild)) {
            return null;
        }
        return focusedChild;
    }

    public final View A0v(int i3) {
        if (this.A01 != null) {
            return this.A01.A09(i3);
        }
        return null;
    }

    public final View A0w(View view, int i3) {
        return null;
    }

    public R3 A0x(Context context, AttributeSet attributeSet) {
        return new R3(context, attributeSet);
    }

    public R3 A0y(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof R3) {
            return new R3((R3) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new R3((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new R3(layoutParams);
    }

    public final void A0z() {
        if (this.A02 != null) {
            this.A02.A09();
        }
    }

    public final void A10() {
        if (this.A03 != null) {
            this.A03.requestLayout();
        }
    }

    public final void A11(int i3) {
        if (this.A03 != null) {
            this.A03.A1V(i3);
        }
    }

    public final void A12(int i3) {
        if (this.A03 != null) {
            this.A03.A1W(i3);
        }
    }

    public final void A13(int i3, int i4) {
        this.A0C = View.MeasureSpec.getSize(i3);
        this.A0D = View.MeasureSpec.getMode(i3);
        if (this.A0D == 0 && !C7M.A1B) {
            this.A0C = 0;
        }
        this.A0A = View.MeasureSpec.getSize(i4);
        this.A0B = View.MeasureSpec.getMode(i4);
        if (this.A0B == 0 && !C7M.A1B) {
            this.A0A = 0;
        }
    }

    public final void A14(int i3, int i4) {
        int iA0Y = A0Y();
        if (iA0Y == 0) {
            this.A03.A1c(i3, i4);
            String[] strArr = A0J;
            String str = strArr[2];
            String str2 = strArr[5];
            int iCharAt = str.charAt(30);
            int count = str2.charAt(30);
            if (iCharAt != count) {
                throw new RuntimeException();
            }
            A0J[1] = "XwkGDyjU";
            return;
        }
        int i5 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int i6 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int maxY = Integer.MIN_VALUE;
        int maxX = Integer.MIN_VALUE;
        for (int i7 = 0; i7 < iA0Y; i7++) {
            View viewA0v = A0v(i7);
            Rect rect = this.A03.A0p;
            A0J(viewA0v, rect);
            int count2 = rect.left;
            if (count2 < i5) {
                i5 = rect.left;
            }
            int count3 = rect.right;
            if (count3 > maxY) {
                maxY = rect.right;
            }
            int count4 = rect.top;
            if (count4 < i6) {
                i6 = rect.top;
            }
            int count5 = rect.bottom;
            if (count5 > maxX) {
                maxX = rect.bottom;
            }
        }
        this.A03.A0p.set(i5, i6, maxY, maxX);
        A17(this.A03.A0p, i3, i4);
    }

    public final void A15(int i3, int i4) {
        this.A03.setMeasuredDimension(i3, i4);
    }

    public final void A16(int i3, RA ra) {
        View view = A0v(i3);
        A0C(i3);
        ra.A0T(view);
    }

    public void A17(Rect rect, int i3, int i4) {
        int usedHeight = rect.width() + A0g() + A0h();
        int iHeight = rect.height();
        int usedWidth = A0i();
        int i5 = iHeight + usedWidth;
        int usedWidth2 = A0f();
        int width = i5 + usedWidth2;
        int usedWidth3 = A0e();
        int usedHeight2 = A02(i3, usedHeight, usedWidth3);
        int usedWidth4 = A0d();
        A15(usedHeight2, A02(i4, width, usedWidth4));
    }

    public final void A18(View view) {
        A1A(view, -1);
    }

    public final void A19(View view) {
        A1B(view, -1);
    }

    public final void A1A(View view, int i3) {
        A0I(view, i3, true);
    }

    public final void A1B(View view, int i3) {
        A0I(view, i3, false);
    }

    public final void A1C(View view, int i3, int i4) {
        R3 r3 = (R3) view.getLayoutParams();
        Rect rectA1D = this.A03.A1D(view);
        int i5 = i3 + rectA1D.left + rectA1D.right;
        int i6 = i4 + rectA1D.top + rectA1D.bottom;
        int iA03 = A03(A0j(), A0k(), A0g() + A0h() + r3.leftMargin + r3.rightMargin + i5, r3.width, A22());
        int iA0Z = A0Z();
        int iA0a = A0a();
        int widthSpec = A0i();
        int iA032 = A03(iA0Z, iA0a, widthSpec + A0f() + r3.topMargin + r3.bottomMargin + i6, r3.height, A23());
        if (A1Y(view, iA03, iA032, r3)) {
            view.measure(iA03, iA032);
        }
    }

    public final void A1D(View view, int i3, int i4, int i5, int i6) {
        R3 r3 = (R3) view.getLayoutParams();
        Rect rect = r3.A03;
        view.layout(rect.left + i3 + r3.leftMargin, rect.top + i4 + r3.topMargin, (i5 - rect.right) - r3.rightMargin, (i6 - rect.bottom) - r3.bottomMargin);
    }

    public final void A1E(View view, Q6 q6) {
        RK rkA0F = C7M.A0F(view);
        if (rkA0F != null) {
            boolean zA0g = rkA0F.A0g();
            if (A0J[4].charAt(12) == 'v') {
                throw new RuntimeException();
            }
            A0J[1] = "uJMRqraa";
            if (!zA0g && !this.A01.A0K(rkA0F.A0H)) {
                A1M(this.A03.A0r, this.A03.A0s, view, q6);
            }
        }
    }

    public final void A1F(View view, RA ra) {
        A0F(view);
        ra.A0T(view);
    }

    public final void A1G(View view, boolean z2, Rect rect) {
        Matrix matrix;
        if (z2) {
            Rect rect2 = ((R3) view.getLayoutParams()).A03;
            rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
        } else {
            rect.set(0, 0, view.getWidth(), view.getHeight());
        }
        C7M c7m = this.A03;
        String[] strArr = A0J;
        if (strArr[0].charAt(23) != strArr[7].charAt(23)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0J;
        strArr2[0] = "0LJ8GvUexdNG1AG11Ii0XfPOyD5lBlCr";
        strArr2[7] = "NwYNIOYDHD2wNBVOHxFlNgVOQtOI4Jp5";
        if (c7m != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
            RectF rectF = this.A03.A0q;
            rectF.set(rect);
            matrix.mapRect(rectF);
            int iFloor = (int) Math.floor(rectF.left);
            int iFloor2 = (int) Math.floor(rectF.top);
            double d3 = rectF.right;
            if (A0J[6].length() == 15) {
                throw new RuntimeException();
            }
            String[] strArr3 = A0J;
            strArr3[0] = "AxZOVdXnwoPa2hByvRQIxFpOdsFmpigD";
            strArr3[7] = "eNbgBcin3tlOsNhY3b3xdMmObUbY1NrP";
            rect.set(iFloor, iFloor2, (int) Math.ceil(d3), (int) Math.ceil(rectF.bottom));
        }
        rect.offset(view.getLeft(), view.getTop());
    }

    public final void A1H(Q6 q6) {
        A0N(this.A03.A0r, this.A03.A0s, q6);
    }

    public final void A1I(RA ra) {
        int iA0E = ra.A0E();
        for (int i3 = iA0E - 1; i3 >= 0; i3--) {
            View viewA0F = ra.A0F(i3);
            RK rkA0F = C7M.A0F(viewA0F);
            if (!rkA0F.A0l()) {
                rkA0F.A0d(false);
                if (rkA0F.A0i()) {
                    this.A03.removeDetachedView(viewA0F, false);
                }
                if (this.A03.A05 != null) {
                    this.A03.A05.A0L(rkA0F);
                }
                rkA0F.A0d(true);
                ra.A0R(viewA0F);
            }
        }
        ra.A0L();
        if (iA0E > 0) {
            this.A03.invalidate();
        }
    }

    public final void A1J(RA ra) {
        int childCount = A0Y();
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            A0L(ra, i3, A0v(i3));
        }
    }

    public final void A1K(RA ra) {
        for (int iA0Y = A0Y() - 1; iA0Y >= 0; iA0Y--) {
            if (!C7M.A0F(A0v(iA0Y)).A0l()) {
                A16(iA0Y, ra);
            }
        }
    }

    public void A1L(RA ra, RH rh, int i3, int i4) {
        this.A03.A1c(i3, i4);
    }

    public void A1M(RA ra, RH rh, View view, Q6 q6) {
        Q4 itemInfo = Q4.A00(A23() ? A0r(view) : 0, 1, A22() ? A0r(view) : 0, 1, false, false);
        q6.A0Q(itemInfo);
    }

    public final void A1N(RF rf) {
        if (this.A02 != null) {
            RF rf2 = this.A02;
            if (A0J[4].charAt(12) == 'v') {
                throw new RuntimeException();
            }
            A0J[6] = "G";
            if (rf != rf2 && this.A02.A0F()) {
                RF rf3 = this.A02;
                if (A0J[6].length() != 15) {
                    A0J[3] = "jdqDA9lv9LoPYcF6nkiuFYbBQf2p3Jna";
                    rf3.A09();
                } else {
                    String[] strArr = A0J;
                    strArr[0] = "CfhUeeIqQu1BzHSX9SgRD70OnW7YoiZA";
                    strArr[7] = "rBLjTriW7e2LTgD4knhZEnVORkWVeovT";
                    rf3.A09();
                }
            }
        }
        this.A02 = rf;
        this.A02.A0D(this.A03, this);
    }

    public void A1O(C7M c7m) {
    }

    public final void A1P(C7M c7m) {
        this.A07 = true;
    }

    public final void A1Q(C7M c7m) {
        A13(View.MeasureSpec.makeMeasureSpec(c7m.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(c7m.getHeight(), 1073741824));
    }

    public final void A1R(C7M c7m) {
        if (c7m == null) {
            this.A03 = null;
            this.A01 = null;
            this.A0C = 0;
            this.A0A = 0;
        } else {
            this.A03 = c7m;
            this.A01 = c7m.A01;
            this.A0C = c7m.getWidth();
            this.A0A = c7m.getHeight();
        }
        this.A0D = 1073741824;
        this.A0B = 1073741824;
    }

    public final void A1S(C7M c7m, RA ra) {
        this.A07 = false;
        A1y(c7m, ra);
    }

    public final void A1T(boolean z2) {
        this.A06 = z2;
    }

    public final boolean A1U() {
        int iA0Y = A0Y();
        for (int i3 = 0; i3 < iA0Y; i3++) {
            ViewGroup.LayoutParams layoutParams = A0v(i3).getLayoutParams();
            int childCount = layoutParams.width;
            if (childCount < 0) {
                int childCount2 = layoutParams.height;
                if (childCount2 < 0) {
                    return true;
                }
            }
        }
        if (A0J[4].charAt(12) == 'v') {
            throw new RuntimeException();
        }
        A0J[3] = "WAOKNqtGQ8ovYE750tJA7vys4k4qcWl2";
        return false;
    }

    public final boolean A1V() {
        return this.A03 != null && this.A03.A0B;
    }

    public final boolean A1W() {
        return this.A0E;
    }

    public final boolean A1X(int i3, Bundle bundle) {
        return A0S(this.A03.A0r, this.A03.A0s, i3, bundle);
    }

    public final boolean A1Y(View view, int i3, int i4, R3 r3) {
        if (!view.isLayoutRequested()) {
            boolean z2 = this.A0F;
            String[] strArr = A0J;
            if (strArr[0].charAt(23) != strArr[7].charAt(23)) {
                throw new RuntimeException();
            }
            A0J[4] = "WuiXnf3Uz62WBJXd3E4QIRzbwyGUV3fL";
            if (z2 && A0Q(view.getWidth(), i3, r3.width) && A0Q(view.getHeight(), i4, r3.height)) {
                return false;
            }
        }
        return true;
    }

    public final boolean A1Z(View view, int i3, Bundle bundle) {
        return A0T(this.A03.A0r, this.A03.A0s, view, i3, bundle);
    }

    public boolean A1a(R3 r3) {
        return r3 != null;
    }

    public final boolean A1b(C7M c7m, View view, Rect rect, boolean z2) {
        return A1c(c7m, view, rect, z2, false);
    }

    public final boolean A1c(C7M c7m, View view, Rect rect, boolean z2, boolean z3) {
        int[] scrollAmount = A0W(view, rect);
        int i3 = scrollAmount[0];
        int i4 = scrollAmount[1];
        if ((z3 && !A0U(c7m, i3, i4)) || (i3 == 0 && i4 == 0)) {
            return false;
        }
        if (z2) {
            c7m.scrollBy(i3, i4);
        } else {
            c7m.A1e(i3, i4);
        }
        return true;
    }

    public final boolean A1d(C7M c7m, RH rh, View view, View view2) {
        return A0V(c7m, view, view2);
    }

    public final boolean A1e(C7M c7m, ArrayList<View> views, int i3, int i4) {
        return false;
    }

    public View A1o(int i3) {
        int iA0Y = A0Y();
        for (int i4 = 0; i4 < iA0Y; i4++) {
            View child = A0v(i4);
            RK rkA0F = C7M.A0F(child);
            if (rkA0F != null) {
                int childCount = rkA0F.A0O();
                if (childCount == i3 && !rkA0F.A0l() && (this.A03.A0s.A07() || !rkA0F.A0g())) {
                    return child;
                }
            }
        }
        return null;
    }

    public void A1v(AccessibilityEvent accessibilityEvent) {
        A0M(this.A03.A0r, this.A03.A0s, accessibilityEvent);
    }

    public void A1x(RH rh) {
    }

    public void A1y(C7M c7m, RA ra) {
    }

    public void A20(String str) {
        if (this.A03 != null) {
            this.A03.A1n(str);
        }
    }
}
