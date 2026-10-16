package com.facebook.ads.redexgen.core;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.Layout;
import android.transition.AutoTransition;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class YB {
    public static byte[] A00;
    public static String[] A01 = {"aXQ8cQ350VCAT2mitcvykUGHubvGx6C9", "NAK0YApfoevBcA8nU2", "YHwKc8bJ3fYIczYaga21kucMEh7K8adi", "qYAOAoZ496ND8", "6pHjubFxbGGqNA8P9d", "3r9qhhsI1oDbETggKvxV5tdwn", "sRn13xQSljRP603ULBb8dNJbjS", "vNgqutu69Vtz3tnibxv52jRaXo"};
    public static final int A02;
    public static final int A03;
    public static final ConcurrentHashMap<Integer, Integer> A04;
    public static final AtomicInteger A05;

    public static String A0C(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 15);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0D() {
        A00 = new byte[]{118, -127, -123, 125, 118, -35, -37, -26, -26, -33, -20, -50, -13, -22, -33, -127, -118, -121, -127, -119, 125, -111, -115, -109, -112, -127, -125, -43, -40, -37, -29, -44, -31, -44, -45, -50, -46, -37, -40, -46, -38, -50, -45, -44, -37, -48, -24, -50, -36, -30, -39, -34, -28, -43, -30, -29, -28, -39, -28, -39, -47, -36, -125, -115, 121, 125, 123, 125, 121, -128, -125, -122, -114, Ascii.DEL, -116, 121, 125, -122, -125, 125, -123, -115, 121, -119, -120, 121, 125, -114, 123, -99, -89, -109, -105, -90, -103, -107, -88, -99, -86, -103, -109, -107, -89, -109, -105, -88, -107, -109, -86, 102, -50, -63, -45, -67, -50, -64, -63, -64, -69, -46, -59, -64, -63, -53, -12, -15, -28, -15, -10, -15, -81, -17, -25, -26, -21, -9, -17, -38, -56, -43, -38, -108, -38, -52, -39, -48, -51, -108, -44, -52, -53, -48, -36, -44, -66, -73, -78, -70, -66, -82, -110, -83, -42, -44, -58, -45, -60, -51, -54, -60, -52};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 9 out of bounds for length 9
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static boolean A0i(C1648gi c1648gi, EnumC0897Mq enumC0897Mq, Map<String, String> map) {
        String str = map.get(A0C(89, 21, 37));
        boolean z2 = str != null && str.equals(Boolean.TRUE.toString());
        if (z2 && (A0h(c1648gi, enumC0897Mq) || A0f(enumC0897Mq, map))) {
            return true;
        }
        String str2 = map.get(A0C(62, 27, 11));
        return z2 && (str2 != null && str2.equals(Boolean.TRUE.toString())) && A0g(enumC0897Mq, map);
    }

    static {
        A0D();
        A03 = P3.A02(-1, 0);
        A02 = P3.A02(-16777216, 115);
        A05 = new AtomicInteger(1);
        A04 = new ConcurrentHashMap<>();
    }

    public static int A00() {
        int i3;
        int newValue;
        do {
            i3 = A05.get();
            newValue = i3 + 1;
            if (newValue > 16777215) {
                newValue = 1;
            }
        } while (!A05.compareAndSet(i3, newValue));
        return i3;
    }

    public static int A01(int i3) {
        return (int) TypedValue.applyDimension(2, i3, XX.A04);
    }

    public static int A02(int i3) {
        if (A0e(i3)) {
            return P3.A05(i3, -1, 0.4f);
        }
        return P3.A05(i3, -16777216, 0.2f);
    }

    public static int A03(TextView textView) {
        Layout layout;
        int lineCount;
        if (textView == null || textView.getLayout() == null || (lineCount = (layout = textView.getLayout()).getLineCount()) <= 0) {
            return 0;
        }
        double ellipsisCount = layout.getEllipsisCount(lineCount - 1);
        double ellipsisCount2 = ellipsisCount / (((double) textView.getText().length()) - ellipsisCount);
        if (A01[3].length() == 20) {
            throw new RuntimeException();
        }
        A01[3] = "IkK7ljd8WWfE470H6O9Fo";
        return (int) Math.ceil(ellipsisCount2);
    }

    public static int A04(TextView textView, int i3) {
        int lineHeightTitle = A03(textView);
        int lines = 0;
        int extraLinesRequired = textView.getLineHeight();
        while (i3 > extraLinesRequired && lines < lineHeightTitle) {
            lines++;
            i3 -= extraLinesRequired;
        }
        return lines;
    }

    public static Drawable A05(int i3, int i4) {
        return A08(i3, A02(i3), i4);
    }

    public static Drawable A06(int i3, int i4) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i3);
        gradientDrawable.setCornerRadius(i4);
        return gradientDrawable;
    }

    public static Drawable A07(int i3, int i4) {
        float[] fArr = new float[8];
        Arrays.fill(fArr, i4);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, null, null));
        shapeDrawable.getPaint().setColor(i3);
        return shapeDrawable;
    }

    public static Drawable A08(int i3, int i4, int i5) {
        return A09(i3, i4, i3, i5);
    }

    public static Drawable A09(int i3, int i4, int i5, int i6) {
        return new RippleDrawable(ColorStateList.valueOf(i4), A06(i3, i6), A07(i5, i6));
    }

    public static Drawable A0A(int i3, float[] fArr) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i3);
        gradientDrawable.setCornerRadii(fArr);
        return gradientDrawable;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0005 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.widget.TextView A0B(android.view.ViewGroup r4) {
        /*
            r1 = 0
        L1:
            int r0 = r4.getChildCount()
            if (r1 >= r0) goto L3d
            android.view.View r3 = r4.getChildAt(r1)
            boolean r0 = r3 instanceof android.widget.TextView
            if (r0 == 0) goto L2b
            android.widget.TextView r3 = (android.widget.TextView) r3
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.YB.A01
            r0 = 3
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 20
            if (r1 == r0) goto L37
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.YB.A01
            java.lang.String r1 = "6RJtTYzLBnUcHRvsTatmkmWKIun16hlE"
            r0 = 0
            r2[r0] = r1
            java.lang.String r1 = "BwINbhkVgYMYeGJED3O8k6L5SNrYNN6g"
            r0 = 2
            r2[r0] = r1
            return r3
        L2b:
            boolean r0 = r3 instanceof android.view.ViewGroup
            if (r0 == 0) goto L34
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            A0B(r3)
        L34:
            int r1 = r1 + 1
            goto L1
        L37:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L3d:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.YB.A0B(android.view.ViewGroup):android.widget.TextView");
    }

    public static void A0E(float f3, LinearLayout linearLayout) {
        linearLayout.setOutlineProvider(new Y9(f3));
        linearLayout.setClipToOutline(true);
    }

    public static void A0F(int i3, View view) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.8f, 1.0f, 0.8f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(i3 / 3);
        scaleAnimation.setInterpolator(new AccelerateInterpolator());
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration((i3 / 3) * 2);
        scaleAnimation2.setInterpolator(new BounceInterpolator());
        scaleAnimation.setAnimationListener(new QA(view, scaleAnimation2));
        view.startAnimation(scaleAnimation);
    }

    public static void A0G(int i3, View view) {
        Integer viewId = A04.get(Integer.valueOf(i3));
        if (viewId != null) {
            view.setId(viewId.intValue());
        } else {
            A0K(view);
        }
    }

    public static void A0H(View view) {
        A0O(view, 8);
    }

    public static void A0I(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            A0W((ViewGroup) parent);
        }
    }

    public static void A0J(View view) {
        if (view == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (A01[3].length() == 20) {
            throw new RuntimeException();
        }
        A01[3] = "DU33ZJN3ug5gIBKNKyYbqVVAVCFz";
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
    }

    public static void A0K(View view) {
        if (view == null) {
            return;
        }
        view.setId(View.generateViewId());
    }

    public static void A0L(View view) {
        A0O(view, 0);
    }

    public static void A0M(View view, float f3, float f4, int i3) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, A0C(0, 5, 6), f3, f4);
        objectAnimatorOfFloat.setDuration(i3);
        objectAnimatorOfFloat.start();
    }

    public static void A0N(View view, int i3) {
        view.setBackground(new ColorDrawable(i3));
    }

    public static void A0O(View view, int i3) {
        if (view != null) {
            view.setVisibility(i3);
        }
    }

    public static void A0P(View view, int i3, int i4) {
        A0V(view, A06(i3, i4));
    }

    public static void A0Q(View view, int i3, int i4) {
        A0V(view, A08(i3, A02(i3), i4));
    }

    public static void A0R(View view, int i3, int i4, int i5) {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{A03, A02});
        gradientDrawable.setCornerRadius(i3);
        gradientDrawable.setStroke(i4, i5);
        A0V(view, gradientDrawable);
    }

    public static void A0S(View view, int i3, int i4, int i5) {
        A0V(view, A09(i3, A02(i3), i4, i5));
    }

    public static void A0T(View view, int i3, float[] fArr) {
        A0V(view, A0A(i3, fArr));
    }

    public static void A0U(View view, Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{A03, A02});
        gradientDrawable.setCornerRadius(0.0f);
        A0V(view, gradientDrawable);
    }

    public static void A0V(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static void A0W(ViewGroup viewGroup) {
        A0X(viewGroup, 200);
    }

    public static void A0X(ViewGroup viewGroup, int i3) {
        A0Y(viewGroup, new AutoTransition(), i3);
    }

    public static void A0Y(ViewGroup viewGroup, Transition transition, int i3) {
        transition.setDuration(i3);
        transition.setInterpolator(new AccelerateDecelerateInterpolator());
        TransitionManager.beginDelayedTransition(viewGroup, transition);
    }

    public static void A0Z(Button button) {
        Typeface typeface = Typeface.create(A0C(124, 13, 115), 0);
        button.setTypeface(typeface);
    }

    public static void A0a(TextView textView, boolean z2, int i3) {
        Typeface typeface;
        if (z2) {
            typeface = Typeface.create(A0C(137, 17, 88), 0);
        } else {
            Typeface typeface2 = Typeface.SANS_SERIF;
            typeface = Typeface.create(typeface2, 0);
        }
        textView.setTypeface(typeface);
        if (A01[5].length() != 25) {
            throw new RuntimeException();
        }
        A01[3] = "EYVeEO4Fu";
        textView.setTextSize(2, i3);
    }

    public static void A0b(Toast toast, String str, int i3, int i4, int i5) {
        if (toast == null) {
            return;
        }
        toast.setGravity(i3, i4, i5);
        TextView textViewA0B = A0B((ViewGroup) toast.getView());
        if (textViewA0B != null) {
            textViewA0B.setText(str);
            textViewA0B.setGravity(17);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:11:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x000e  */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1091)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A0c(java.util.Map<java.lang.String, java.lang.String> r5, com.facebook.ads.redexgen.core.AbstractC1813jd r6) {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.YB.A0c(java.util.Map, com.facebook.ads.redexgen.X.jd):void");
    }

    public static void A0d(View... viewArr) {
        for (View view : viewArr) {
            A0J(view);
        }
    }

    public static boolean A0e(int i3) {
        return P3.A00(i3) < 0.5d;
    }

    public static boolean A0f(EnumC0897Mq enumC0897Mq, Map<String, String> extraData) {
        boolean nonIabDestination = !A0C(162, 9, 82).equals(extraData.get(A0C(15, 12, 15)));
        boolean nonCtaClick = enumC0897Mq != EnumC0897Mq.A08;
        return nonIabDestination && nonCtaClick;
    }

    public static boolean A0g(EnumC0897Mq enumC0897Mq, Map<String, String> extraData) {
        boolean zEquals = A0C(162, 9, 82).equals(extraData.get(A0C(15, 12, 15)));
        boolean ctaClick = enumC0897Mq != EnumC0897Mq.A08;
        return zEquals && ctaClick;
    }

    public static boolean A0h(C1648gi c1648gi, EnumC0897Mq enumC0897Mq) {
        return enumC0897Mq == EnumC0897Mq.A08 && C1098Up.A2w(c1648gi);
    }
}
