package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1821jl extends N3 {
    public static byte[] A06;
    public static final String A07;
    public C1823jn A00;
    public EnumC1122Vp A01;
    public boolean A02;
    public final C1648gi A03;
    public final VA A04;
    public final AbstractC1294ay A05;

    public static String A04(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 53);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A06 = new byte[]{-55, -56, -43, -43, -52, -39};
    }

    static {
        A05();
        A07 = C1821jl.class.getSimpleName();
    }

    public C1821jl(C1648gi c1648gi, VA va, AbstractC1294ay abstractC1294ay, C1593fp c1593fp, N4 n4, EnumC1122Vp enumC1122Vp) {
        super(c1648gi, n4, c1593fp);
        this.A04 = va;
        this.A05 = abstractC1294ay;
        this.A03 = c1648gi;
        this.A01 = enumC1122Vp;
    }

    @Override // com.facebook.ads.redexgen.core.N3
    public final void A08(Map<String, String> map) {
        String string;
        if (this.A00 != null && !TextUtils.isEmpty(this.A00.A7O())) {
            this.A03.A0F().A3L();
            AbstractC0932Oa.A02(this.A00.A05(), AbstractC1168Xm.A00(A04(0, 6, 50)));
            this.A04.ABJ(this.A00.A7O(), map);
            if (C1098Up.A1A(this.A03)) {
                if (this.A01 == EnumC1122Vp.A09) {
                    string = AdPlacementType.MEDIUM_RECTANGLE.toString();
                } else {
                    string = AdPlacementType.BANNER.toString();
                }
                C1144Wl c1144WlA00 = C1144Wl.A00(this.A03);
                String placementType = this.A00.A7O();
                c1144WlA00.A0E(string, placementType);
            }
        }
    }

    public final synchronized void A09() {
        if (!this.A02 && this.A00 != null) {
            this.A02 = true;
            if (!TextUtils.isEmpty(this.A00.A03())) {
                Y4.A00(new C1822jm(this));
            }
        }
    }

    public final void A0A(C1823jn c1823jn) {
        this.A00 = c1823jn;
    }
}
