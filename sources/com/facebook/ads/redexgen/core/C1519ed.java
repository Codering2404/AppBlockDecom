package com.facebook.ads.redexgen.core;

import com.facebook.ads.AudienceNetworkAds;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ed, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1519ed extends AbstractRunnableC1135Wc {
    public static byte[] A02;
    public static String[] A03 = {"w4GsGaTCcJA9wFWp2KNopTJOjqP8UDpw", "KJoDcXHO6XERgkU18ZjJw4XTw2kjUjU4", "R80wDz5faPpVYHVxJychiW2DfFSiKcfh", "t0Fzi1DjxmxSLCfz9XJ2VaEQot34azEH", "xhDPy00jOuqmtbPp3auQzix75rw9IX8h", "Uu427jBhvNl8yC5HrJluoVTOz", "6hGUj4iS9agb9", "ga1SCcoGdvIpCjYHRj6uJxXsB"};
    public final /* synthetic */ AudienceNetworkAds.InitListener A00;
    public final /* synthetic */ C1644ge A01;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            byte b3 = bArrCopyOfRange[i6];
            if (A03[1].charAt(16) != '8') {
                throw new RuntimeException();
            }
            A03[1] = "4HO8Ss9k2AmZ8k9M8zrjCYxt48xbOoMK";
            bArrCopyOfRange[i6] = (byte) ((b3 ^ i5) ^ 70);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{3, 52, 59, 112, 35, 37, 51, 51, 53, 35, 35, 54, 37, 60, 60, 41, 112, 57, 62, 57, 36, 57, Framer.STDOUT_FRAME_PREFIX, 60, 57, 42, 53, 52, 113};
    }

    static {
        A01();
    }

    public C1519ed(C1644ge c1644ge, AudienceNetworkAds.InitListener initListener) {
        this.A01 = c1644ge;
        this.A00 = initListener;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1135Wc
    public final void A07() {
        try {
            ZR.A02().A0C(this.A01);
        } catch (Throwable th) {
            this.A01.A08().A4I(th);
        }
        U2.A0C(this.A01);
        if (this.A00 != null) {
            U2.A04(this.A00, new U1(true, A00(0, 29, 22)));
        }
    }
}
