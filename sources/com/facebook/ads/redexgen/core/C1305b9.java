package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.b9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1305b9 {
    public static byte[] A01;
    public final Map<String, String> A00;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 55);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-25, -6, -10, -12, -29, -31, -22, -21, -16, -10, -11, -37, -42, -36, -54, -49};
    }

    public C1305b9() {
        this.A00 = new HashMap();
    }

    public C1305b9(Map<String, String> extraData) {
        this.A00 = extraData;
    }

    public final C1305b9 A02(Y2 y2) {
        if (y2 != null) {
            this.A00.put(A00(11, 5, 48), AbstractC1159Xd.A01(y2.A04()));
        }
        return this;
    }

    public final C1305b9 A03(C1593fp c1593fp) {
        if (c1593fp != null) {
            this.A00.putAll(c1593fp.A0S());
        }
        return this;
    }

    public final C1305b9 A04(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.A00.put(A00(0, 11, 75), str);
        }
        return this;
    }

    public final Map<String, String> A05() {
        return this.A00;
    }
}
