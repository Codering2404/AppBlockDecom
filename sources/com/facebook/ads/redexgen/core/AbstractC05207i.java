package com.facebook.ads.redexgen.core;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7i, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract /* synthetic */ class AbstractC05207i {
    public static int A00(int i3) {
        return A06(i3, 0, 0);
    }

    public static int A01(int i3) {
        return i3 & 24;
    }

    public static int A02(int i3) {
        return i3 & 384;
    }

    public static int A03(int i3) {
        return i3 & 7;
    }

    public static int A04(int i3) {
        return i3 & 64;
    }

    public static int A05(int i3) {
        return i3 & 32;
    }

    public static int A06(int i3, int i4, int i5) {
        return A07(i3, i4, i5, 0, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
    }

    public static int A07(int i3, int i4, int i5, int i6, int i7) {
        return i3 | i4 | i5 | i6 | i7;
    }
}
