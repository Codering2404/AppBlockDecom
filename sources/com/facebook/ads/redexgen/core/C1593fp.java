package com.facebook.ads.redexgen.core;

import android.graphics.Rect;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.stetho.dumpapp.Framer;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;
import javax.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1593fp {
    public static byte[] A0G;
    public static String[] A0H = {"YuGvtiviQVR", "ZhJp0z4dUN", "YWv4zGcwogafSGFsXYmLIXL4tbjSTGT", "UM7SABu2ufM", "2gPy2hJr9M", "yZRmnvTn4zHntgpYIACfXRb3ExDVKnv", "qUSRIBeTtwG", "WSvVNugGHbUgKJE0aBRLXmETVgvdQ"};
    public static final String A0I;
    public int A00;
    public int A01;
    public int A02;
    public long A03;

    @Nullable
    public AbstractRunnableC1135Wc A04;
    public C1594fq A05;
    public Map<String, Integer> A06;
    public boolean A07;
    public boolean A08;
    public final int A09;
    public final int A0A;
    public final Handler A0B;
    public final View A0C;
    public final C1648gi A0D;
    public final WeakReference<AbstractC1592fo> A0E;
    public final boolean A0F;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 17 out of bounds for length 13
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static int A08(Vector<Rect> vector) {
        int size = vector.size();
        int[] iArr = new int[size * 2];
        int[] iArr2 = new int[size * 2];
        boolean[][] zArr = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, size * 2, size * 2);
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            Rect rectElementAt = vector.elementAt(i5);
            int i6 = i3 + 1;
            iArr[i3] = rectElementAt.left;
            int i7 = i4 + 1;
            iArr2[i4] = rectElementAt.bottom;
            i3 = i6 + 1;
            iArr[i6] = rectElementAt.right;
            i4 = i7 + 1;
            iArr2[i7] = rectElementAt.top;
        }
        Arrays.sort(iArr);
        Arrays.sort(iArr2);
        for (int i8 = 0; i8 < size; i8++) {
            Rect rectElementAt2 = vector.elementAt(i8);
            int iA09 = A09(iArr, rectElementAt2.left);
            int iA092 = A09(iArr, rectElementAt2.right);
            int iA093 = A09(iArr2, rectElementAt2.top);
            int iA094 = A09(iArr2, rectElementAt2.bottom);
            for (int i9 = iA09 + 1; i9 <= iA092; i9++) {
                for (int i10 = iA093 + 1; i10 <= iA094; i10++) {
                    zArr[i9][i10] = true;
                }
            }
        }
        int i11 = 0;
        for (int i12 = 0; i12 < size * 2; i12++) {
            for (int i13 = 0; i13 < size * 2; i13++) {
                i11 += zArr[i12][i13] ? (iArr[i12] - iArr[i12 - 1]) * (iArr2[i13] - iArr2[i13 - 1]) : 0;
            }
        }
        return i11;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0097, code lost:
    
        if (r5 == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0099, code lost:
    
        A0N(r7, false, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a3, code lost:
    
        return new com.facebook.ads.redexgen.core.C1594fq(com.facebook.ads.redexgen.core.EnumC0872Lr.A0G);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b0, code lost:
    
        if (r5 == false) goto L26;
     */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 10
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.core.C1594fq A0E(android.view.View r7, int r8, com.facebook.ads.redexgen.core.C1648gi r9) {
        /*
            Method dump skipped, instruction units count: 659
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1593fp.A0E(android.view.View, int, com.facebook.ads.redexgen.X.gi):com.facebook.ads.redexgen.X.fq");
    }

    public static String A0H(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0G, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 32);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0M() {
        A0G = new byte[]{110, 118, 115, 124, Ascii.DEL, -76, 115, 115, 119, 110, -73, -63, 110, -121, -34, -48, -37, -49, -121, -39, -52, -56, -38, -42, -43, -95, -121, -69, -81, -9, -52, 126, -95, 93, -90, -80, 93, -84, -85, 93, -79, -84, -83, 93, -84, -93, 93, -79, -91, -94, 93, -119, -84, -96, -88, -80, -96, -81, -94, -94, -85, 107, -54, -24, -11, -11, -10, -5, -89, -18, -20, -5, -89, -13, -10, -22, -24, -5, -16, -10, -11, -89, -10, -11, -89, -6, -22, -7, -20, -20, -11, -75, -46, -3, -13, 1, -4, -75, 2, -82, -5, -17, -7, -13, -82, 1, -13, -4, 1, -13, -82, 2, -3, -82, 1, -13, 2, -82, -15, -10, -13, -15, -7, -82, -9, -4, 2, -13, 0, 4, -17, -6, -82, -12, -3, 0, -82, -4, -3, -4, -69, 0, -13, -2, -13, -17, 2, -82, -15, -10, -13, -15, -7, -13, 0, -68, -60, -34, -14, -32, -18, -38, -21, -35, -103, -30, -20, -103, -24, -37, -20, -19, -21, -18, -36, -19, -30, -25, -32, -103, -17, -30, -34, -16, -89, -70, -54, -39, -52, -52, -43, -121, -48, -38, -121, -43, -42, -37, -121, -48, -43, -37, -52, -39, -56, -54, -37, -48, -35, -52, -107, -120, -100, -103, 84, -88, -99, -105, -97, -103, -90, 84, -105, -107, -94, -94, -93, -88, 84, -106, -103, 84, -94, -103, -101, -107, -88, -99, -86, -103, -103, -84, -88, -70, 99, -16, -4, -6, -69, -13, -18, -16, -14, -17, -4, -4, -8, -69, -18, -15, 0, -69, -10, -5, 1, -14, -1, -5, -18, -7, -69, 3, -10, -14, 4, -69, -45, 2, -7, -7, -32, -16, -1, -14, -14, -5, -50, -15, -31, -4, -4, -7, -17, -18, -1, -3, -47, -12, -26, -7, -11, 7, -80, -8, -15, 3, -80, -7, -2, 6, -7, 3, -7, -14, -4, -11, -80, -12, -7, -3, -11, -2, 3, -7, -1, -2, 3, -80, -72, 7, -51, -40, -84, -49, -63, -44, -48, -30, -117, -45, -52, -34, -117, -39, -38, -117, -37, -52, -35, -48, -39, -33, -103, -86, 126, -95, -109, -90, -94, -76, 93, -90, -80, 93, -85, -78, -87, -87, 107, -87, 125, -96, -110, -91, -95, -77, 92, -91, -81, 92, -80, -85, -85, 92, -80, -82, -99, -86, -81, -84, -99, -82, -95, -86, -80, 106, -67, -111, -76, -90, -71, -75, -57, 112, -71, -61, 112, -58, -71, -61, -71, -78, -68, -75, 126, 10, -34, 1, -13, 6, 2, Ascii.DC4, -67, Ascii.CR, -2, Ascii.SI, 2, Ascii.VT, 17, -67, 6, Ascii.DLE, -67, Ascii.VT, Ascii.FF, 17, -67, Ascii.DLE, 2, 17, -67, 17, Ascii.FF, -67, -13, -26, -16, -26, -33, -23, -30, -53, -84, -128, -93, -107, -88, -92, -74, Framer.STDIN_REQUEST_FRAME_PREFIX, -75, -88, -78, -88, -95, -85, -92, Framer.STDIN_REQUEST_FRAME_PREFIX, -96, -79, -92, -96, Framer.STDIN_REQUEST_FRAME_PREFIX, -88, -78, Framer.STDIN_REQUEST_FRAME_PREFIX, -77, -82, -82, Framer.STDIN_REQUEST_FRAME_PREFIX, -78, -84, -96, -85, -85, Framer.STDIN_REQUEST_FRAME_PREFIX, -102, 100, 109, 113, -91, 100, 100, Framer.STDIN_REQUEST_FRAME_PREFIX, -75, -88, -78, -88, -95, -85, -92, 107, Framer.STDIN_REQUEST_FRAME_PREFIX, -94, -76, -79, -79, -92, -83, -77, Framer.STDIN_REQUEST_FRAME_PREFIX, -77, -89, -79, -92, -78, -89, -82, -85, -93, Framer.STDIN_REQUEST_FRAME_PREFIX, 100, 109, 113, -91, 100, 100, -100, -94, 118, -103, -117, -98, -102, -84, 85, -84, -98, -93, -103, -92, -84, 85, -98, -88, 85, -93, -92, -87, 85, -88, -102, -87, 85, -87, -92, 85, -117, 126, -120, 126, 119, -127, 122, 99, -110, -109, -104, 68, -102, -115, -119, -101, -123, -122, -112, -119, -32, -46, -96, -109, -113, -95, -117, -116, -106, -113, -13, -19, Ascii.NAK, 17, 2, -93, -95, -56, -70, -65, -75, -64, -56};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final synchronized String A0R() {
        return EnumC0872Lr.values()[this.A05.A01()].toString() + String.format(Locale.US, A0H(0, 9, 46), Float.valueOf(this.A05.A00() * 100.0f));
    }

    static {
        A0M();
        A0I = C1593fp.class.getSimpleName();
    }

    public C1593fp(View view, int i3, int i4, boolean z2, WeakReference<AbstractC1592fo> weakReference, C1648gi c1648gi) {
        this.A0B = new Handler();
        this.A01 = 0;
        this.A02 = 1000;
        this.A08 = true;
        this.A05 = new C1594fq(EnumC0872Lr.A0L);
        this.A06 = new HashMap();
        this.A03 = 0L;
        this.A00 = 0;
        this.A07 = true;
        this.A0D = c1648gi;
        this.A0C = view;
        if (this.A0C.getId() == -1) {
            YB.A0K(this.A0C);
        }
        this.A0A = i3;
        this.A0E = weakReference;
        this.A0F = z2;
        if (i4 < 0) {
            if (BuildConfigApi.isDebug()) {
                Log.w(A0I, A0H(211, 29, 20));
            }
            i4 = 0;
        }
        this.A09 = i4;
    }

    public C1593fp(View view, int i3, WeakReference<AbstractC1592fo> weakReference, C1648gi c1648gi) {
        this(view, i3, 0, false, weakReference, c1648gi);
    }

    public C1593fp(View view, int i3, boolean z2, WeakReference<AbstractC1592fo> weakReference, C1648gi c1648gi) {
        this(view, i3, 0, z2, weakReference, c1648gi);
    }

    public static float A00(View view) {
        float alpha = view.getAlpha();
        while (view.getParent() instanceof ViewGroup) {
            view = (View) view.getParent();
            float alpha2 = view.getAlpha();
            if (alpha2 < 0.0f) {
                alpha2 = 0.0f;
            }
            if (alpha2 > 1.0f) {
                alpha2 = 1.0f;
            }
            alpha *= alpha2;
        }
        return alpha;
    }

    public static int A01(int i3, View view) {
        int width = view.getWidth() * view.getHeight();
        float onePixelPercentage = width > 0 ? 100.0f / width : 100.0f;
        int viewArea = (int) Math.max(i3, Math.ceil(onePixelPercentage));
        return viewArea;
    }

    public static /* synthetic */ int A05(C1593fp c1593fp) {
        int i3 = c1593fp.A00;
        c1593fp.A00 = i3 + 1;
        return i3;
    }

    public static int A09(int[] iArr, int i3) {
        int i4 = 0;
        int mid = iArr.length;
        while (i4 < mid) {
            int low = mid - i4;
            int high = (low / 2) + i4;
            int low2 = iArr[high];
            if (low2 == i3) {
                return high;
            }
            int low3 = iArr[high];
            if (low3 > i3) {
                mid = high;
            } else {
                i4 = high + 1;
            }
        }
        return -1;
    }

    public static Vector<Rect> A0K(View view) {
        Vector<Rect> vector = new Vector<>();
        if (!(view.getParent() instanceof ViewGroup)) {
            return vector;
        }
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        for (int iIndexOfChild = viewGroup.indexOfChild(view) + 1; iIndexOfChild < viewGroup.getChildCount(); iIndexOfChild++) {
            View childAt = viewGroup.getChildAt(iIndexOfChild);
            if (A0H[0].length() == 13) {
                throw new RuntimeException();
            }
            String[] strArr = A0H;
            strArr[5] = "k1JcZ1wpbQO9ikEolBidSsMChjYk4Sl";
            strArr[2] = "tjbQFFO1F8PkdaxFL56rw4qlI30x63G";
            int childIndex = 1;
            boolean z2 = !(childAt instanceof C1496eF);
            if ((childAt instanceof C0796It) && AbstractC1595fr.A00(childAt)) {
                childIndex = 0;
            }
            if (z2 && childIndex != 0) {
                Vector<Rect> rectVector = A0L(childAt);
                vector.addAll(rectVector);
            }
        }
        Vector<Rect> rectVector2 = A0K(viewGroup);
        vector.addAll(rectVector2);
        return vector;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Vector<android.graphics.Rect> A0L(android.view.View r5) {
        /*
            java.util.Vector r3 = new java.util.Vector
            r3.<init>()
            boolean r0 = r5.isShown()
            if (r0 == 0) goto L14
            float r1 = r5.getAlpha()
            r0 = 0
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 > 0) goto L15
        L14:
            return r3
        L15:
            java.lang.Class r0 = r5.getClass()
            java.lang.String r4 = r0.getName()
            r2 = 245(0xf5, float:3.43E-43)
            r1 = 50
            r0 = 109(0x6d, float:1.53E-43)
            java.lang.String r0 = A0H(r2, r1, r0)
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L73
            android.graphics.drawable.Drawable r4 = r5.getBackground()
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.C1593fp.A0H
            r0 = 0
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 13
            if (r1 == r0) goto L85
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C1593fp.A0H
            java.lang.String r1 = "wSIkE0lymuYwIsZPrnhj"
            r0 = 7
            r2[r0] = r1
            if (r4 == 0) goto L73
            android.graphics.drawable.Drawable r0 = r5.getBackground()
            boolean r0 = r0 instanceof android.graphics.drawable.GradientDrawable
            if (r0 == 0) goto L73
            r1 = 1
        L50:
            boolean r0 = r5 instanceof android.view.ViewGroup
            if (r0 == 0) goto L76
            boolean r0 = com.facebook.ads.redexgen.core.AbstractC1595fr.A00(r5)
            if (r0 != 0) goto L5c
            if (r1 == 0) goto L76
        L5c:
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            r1 = 0
        L5f:
            int r0 = r5.getChildCount()
            if (r1 >= r0) goto L75
            android.view.View r0 = r5.getChildAt(r1)
            java.util.Vector r0 = A0L(r0)
            r3.addAll(r0)
            int r1 = r1 + 1
            goto L5f
        L73:
            r1 = 0
            goto L50
        L75:
            return r3
        L76:
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            boolean r0 = r5.getGlobalVisibleRect(r1)
            if (r0 == 0) goto L84
            r3.add(r1)
        L84:
            return r3
        L85:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1593fp.A0L(android.view.View):java.util.Vector");
    }

    public static void A0N(View view, boolean z2, String str) {
        if (BuildConfigApi.isDebug()) {
            String str2 = A0H(240, 5, 35) + view + A0H(9, 4, 46) + (z2 ? A0H(579, 8, 10) : A0H(565, 12, 4)) + A0H(13, 14, 71) + str;
        }
    }

    public final synchronized Map<String, String> A0S() {
        HashMap map;
        map = new HashMap();
        map.put(A0H(589, 3, 127), String.valueOf(this.A05.A01()));
        map.put(A0H(587, 2, 93), String.valueOf(this.A05.A00()));
        map.put(A0H(577, 2, 74), new JSONObject(this.A06).toString());
        map.put(A0H(592, 2, 13), Y1.A06(this.A03));
        Map<String, String> viewabilityData = this.A05.A03();
        map.putAll(viewabilityData);
        return map;
    }

    public final synchronized void A0T() {
        this.A05 = new C1594fq(EnumC0872Lr.A0L);
    }

    public final synchronized void A0U() {
        if (this.A04 != null) {
            A0V();
        }
        if (this.A07) {
            this.A0D.A0F().A3s();
        }
        this.A04 = new C03932j(this, this.A0D);
        this.A0B.postDelayed(this.A04, this.A01);
        this.A08 = false;
        this.A00 = 0;
        this.A05 = new C1594fq(EnumC0872Lr.A0L);
        this.A06 = new HashMap();
    }

    public final synchronized void A0V() {
        if (this.A07) {
            this.A0D.A0F().A3t();
        }
        this.A0B.removeCallbacks(this.A04);
        this.A04 = null;
        this.A08 = true;
        this.A00 = 0;
    }

    public final void A0W(int i3) {
        this.A01 = i3;
    }

    public final void A0X(int i3) {
        if (BuildConfigApi.isDebug() && !this.A0F) {
            Log.w(A0I, A0H(92, 64, 110));
        }
        this.A02 = i3;
    }

    public final void A0Y(boolean z2) {
        this.A07 = z2;
    }

    public final synchronized boolean A0Z() {
        return this.A08;
    }
}
