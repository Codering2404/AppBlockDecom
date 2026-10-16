package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.eC, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1493eC extends AbstractRunnableC1135Wc {
    public static byte[] A02;
    public final /* synthetic */ AudienceNetworkAds.InitListener A00;
    public final /* synthetic */ AudienceNetworkAds.InitResult A01;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 77);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{81, 80, 80, 82, 6, 1, 85, 83, Ascii.DLE, 7, 8, 99, 42, Framer.STDIN_FRAME_PREFIX, 42, 55, 42, 34, 47, 42, 57, 34, 55, 42, 44, Framer.STDIN_FRAME_PREFIX, 99, 32, 44, 46, 51, 47, 38, 55, 38, 17, Ascii.SYN, Ascii.CR, 48, 2, 5, 6};
    }

    public C1493eC(AudienceNetworkAds.InitListener initListener, AudienceNetworkAds.InitResult initResult) {
        this.A00 = initListener;
        this.A01 = initResult;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1135Wc
    public final void A07() {
        AbstractC1131Vy.A05(A00(35, 7, 46), A00(8, 27, 14), A00(0, 8, 40));
        this.A00.onInitialized(this.A01);
    }
}
