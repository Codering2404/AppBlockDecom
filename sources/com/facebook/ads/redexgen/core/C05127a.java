package com.facebook.ads.redexgen.core;

import android.os.Handler;
import com.facebook.ads.RewardData;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7a, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C05127a extends AbstractC1783j0 {
    public static byte[] A00;
    public static String[] A01 = {"vV6RQP0QGAizSnvHrhrEiTJKYqnkk7vR", "gVueu7WJkm8gI", "", "raAPQvYZN3qaAVuN8G4E0NVfm2Y0LRUe", "w5hc", "", "RHGb3VvP2c2qxldOqnFEpaAIYmVmOJg8", "ZdfM9COnhESAyQW1NqvAdN1Ku5n51qre"};

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 32);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{-43, -45, -32, -110, -31, -32, -34, -21, -110, -27, -41, -26, -110, -31, -32, -110, -28, -41, -23, -45, -28, -42, -41, -42, -110, -24, -37, -42, -41, -31, -110, -45, -42, -27, -80, -79, 98, -93, -90, -93, -78, -74, -89, -76, 98, -76, -89, -93, -90, -69, 98, -74, -79, 98, -75, -89, -74, 98, -76, -89, -71, -93, -76, -90, 98, -79, -80};
    }

    static {
        A02();
    }

    public C05127a(C1648gi c1648gi, O7 o7) {
        super(c1648gi, o7);
    }

    private C1772ip A00(Runnable runnable) {
        return new C1772ip(this, runnable);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1783j0
    public final void A0P() {
        AbstractC1817jh abstractC1817jh = (AbstractC1817jh) this.A01;
        abstractC1817jh.A00(this.A08.A00);
        abstractC1817jh.A01(this.A08.A01);
        abstractC1817jh.A0J();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1783j0
    public final void A0R(N1 n12, C1079Tw c1079Tw, C1077Tu c1077Tu, O8 o8) {
        C05347w c05347w = (C05347w) n12;
        C1776it c1776it = new C1776it(this, o8, c05347w);
        if (C1098Up.A2f(this.A0B)) {
            Handler handlerA0H = A0H();
            C1080Tx c1080TxA05 = c1079Tw.A05();
            String[] strArr = A01;
            if (strArr[3].charAt(31) != strArr[7].charAt(31)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[5] = "";
            strArr2[2] = "";
            handlerA0H.postDelayed(c1776it, c1080TxA05.A05());
        }
        c05347w.A0K(this.A0B, A00(c1776it), o8, this.A08.A06, this.A08.A04, this.A08.A05);
    }

    public final void A0a(RewardData rewardData) {
        if (this.A01 != null) {
            if (this.A01.A8k() == AdPlacementType.REWARDED_VIDEO) {
                AbstractC1817jh rewardedVideoAdapter = (AbstractC1817jh) this.A01;
                rewardedVideoAdapter.A02(rewardData);
                return;
            }
            throw new IllegalStateException(A01(0, 34, 82));
        }
        throw new IllegalStateException(A01(34, 33, 34));
    }
}
