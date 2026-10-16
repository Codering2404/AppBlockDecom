package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1352bu {
    public static float A00(NR nr) {
        int height = nr.A0H().A01();
        int width = nr.A0H().A00();
        if (width > 0) {
            return height / width;
        }
        return -1.0f;
    }

    public static int A01(double d3) {
        int availableWidth = (int) (((double) (XW.A00().widthPixels - (AbstractC1361c3.A08 * 2))) / d3);
        return availableWidth;
    }

    public static int A02(int bottomMargin) {
        int ctaMargin = YB.A01(16);
        int ctaTextHeight = AbstractC1333bb.A0D;
        int ctaSpacing = ctaTextHeight * 2;
        int ctaTextHeight2 = AbstractC1361c3.A08;
        int ctaMargin2 = ctaMargin + ctaSpacing + (ctaTextHeight2 * 2);
        int ctaTextHeight3 = XW.A00().heightPixels;
        return (ctaTextHeight3 - bottomMargin) - ctaMargin2;
    }

    public static ViewOnClickListenerC1351bt A03(ViewOnClickListenerC0846Kr viewOnClickListenerC0846Kr, String str) {
        return new ViewOnClickListenerC1351bt(viewOnClickListenerC0846Kr, str);
    }

    public static boolean A04(double d3) {
        return d3 < 0.9d;
    }

    public static boolean A05(double d3, int i3) {
        return A02(i3) < A01(d3);
    }

    public static boolean A06(int i3, int i4, double d3) {
        return i3 == 2 || A05(d3, i4);
    }
}
