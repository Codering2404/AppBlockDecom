package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.Arrays;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1820jk extends N3 {
    public static byte[] A02;

    @Nullable
    public final C1818ji A00;
    public final VA A01;

    static {
        A02();
    }

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 26);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{70, 69, 74, 74, 65, 86};
    }

    public C1820jk(C1648gi c1648gi, N4 n4, C1593fp c1593fp, VA va, C1818ji c1818ji) {
        super(c1648gi, n4, c1593fp);
        this.A01 = va;
        this.A00 = c1818ji;
    }

    @Override // com.facebook.ads.redexgen.core.N3
    public final void A08(Map<String, String> map) {
        if (this.A00 != null && !TextUtils.isEmpty(this.A00.A7O())) {
            this.A02.A0F().A3L();
            AbstractC0932Oa.A02(this.A00.A0a(), AbstractC1168Xm.A00(A01(0, 6, 62)));
            this.A01.ABJ(this.A00.A7O(), map);
            if (C1098Up.A1A(this.A02)) {
                String string = AdPlacementType.MEDIUM_RECTANGLE.toString();
                C1144Wl c1144WlA00 = C1144Wl.A00(this.A02);
                String placementType = this.A00.A7O();
                c1144WlA00.A0E(string, placementType);
            }
        }
    }
}
