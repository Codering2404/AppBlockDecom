package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.In, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0791In extends AbstractC1592fo {
    public static byte[] A01;
    public final /* synthetic */ AbstractC0787Ij A00;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 78);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-37, -32, -39, -31, -26, -35, -36, -41, -39, -36, -41, -31, -26, -36, -35, -16};
    }

    public C0791In(AbstractC0787Ij abstractC0787Ij) {
        this.A00 = abstractC0787Ij;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1592fo
    public final void A03() {
        if (!this.A00.A0A.A07()) {
            this.A00.A0A.A05();
            if (!TextUtils.isEmpty(this.A00.A06.A2E())) {
                Map<String, String> mapA05 = new C1305b9().A03(this.A00.A0D).A02(this.A00.A0A).A04(this.A00.A06.A0z()).A05();
                mapA05.put(A00(0, 16, 42), A00(0, 0, 96) + this.A00.A02);
                this.A00.A08.ABJ(this.A00.A06.A2E(), mapA05);
                C1144Wl.A00(this.A00.A07).A0E(this.A00.A0C.A8l(), this.A00.A06.A2E());
                C0912Ng.A07(this.A00.A06.A2A(), this.A00.A07);
                this.A00.A07.A0F().A3L();
                if (!this.A00.A04) {
                    AbstractC0932Oa.A02(this.A00.A06.A0y(), AbstractC1168Xm.A00(this.A00.A06.A10()));
                }
                if (!this.A00.A05) {
                    this.A00.A0B.A4j(this.A00.A0C.A8G());
                }
            }
        }
    }
}
