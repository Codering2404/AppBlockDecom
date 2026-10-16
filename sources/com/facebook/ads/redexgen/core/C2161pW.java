package com.facebook.ads.redexgen.core;

import android.os.Bundle;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.pW, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2161pW implements AnonymousClass24 {
    public final float A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public static String[] A04 = {"W5WZRfo3traFBsuJqUeacov", "AOz8vYfc0kUMyRrWtsrS4pOQsYE8BP6P", "ocEUeDJ9UZl7Q6o8h21wMsDJowBHj84j", "pkgO1YjXdbsvKDgws3J49uWJB6yyqkG7", "vCvp8tg1JPxrxhdMnot9YI84PFBkssaD", "Dazl9IXOnyCH5QLsvPseWpscLh5D5M0t", "ZYJ1zYUUdaXBOvkE2t6KLICz8MhT9p2M", "ySOVjFSAiUWhoASiDo2jZct"};
    public static final C2161pW A06 = new C2161pW(0, 0);
    public static final String A0A = C5C.A0h(0);
    public static final String A07 = C5C.A0h(1);
    public static final String A09 = C5C.A0h(2);
    public static final String A08 = C5C.A0h(3);
    public static final AnonymousClass23<C2161pW> A05 = new AnonymousClass23() { // from class: com.facebook.ads.redexgen.X.pX
        @Override // com.facebook.ads.redexgen.core.AnonymousClass23
        public final AnonymousClass24 A6f(Bundle bundle) {
            return C2161pW.A00(bundle);
        }
    };

    public C2161pW(int i3, int i4) {
        this(i3, i4, 0, 1.0f);
    }

    public C2161pW(int i3, int i4, int i5, float f3) {
        this.A03 = i3;
        this.A01 = i4;
        this.A02 = i5;
        this.A00 = f3;
    }

    public static /* synthetic */ C2161pW A00(Bundle bundle) {
        int i3 = bundle.getInt(A0A, 0);
        int i4 = bundle.getInt(A07, 0);
        int height = bundle.getInt(A09, 0);
        return new C2161pW(i3, i4, height, bundle.getFloat(A08, 1.0f));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        boolean z2 = obj instanceof C2161pW;
        String[] strArr = A04;
        if (strArr[4].charAt(6) == strArr[2].charAt(6)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[4] = "xwJKUsQcskzDCgeEWIG9ozPdTsTzWcW9";
        strArr2[2] = "cRblKPLDWf1oyG1RJoVr7n5QNKGN7idl";
        if (!z2) {
            return false;
        }
        C2161pW c2161pW = (C2161pW) obj;
        return this.A03 == c2161pW.A03 && this.A01 == c2161pW.A01 && this.A02 == c2161pW.A02 && this.A00 == c2161pW.A00;
    }

    public final int hashCode() {
        int result = this.A03;
        int result2 = ((((7 * 31) + result) * 31) + this.A01) * 31;
        int result3 = this.A02;
        return ((result2 + result3) * 31) + Float.floatToRawIntBits(this.A00);
    }
}
