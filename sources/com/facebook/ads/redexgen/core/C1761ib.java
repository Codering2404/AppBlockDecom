package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ib, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1761ib extends N2 {
    public static byte[] A01;
    public final /* synthetic */ C1759iZ A00;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 43);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{9, Ascii.CAN, 1, 36, 40, 41, 51, 53, 40, 43, 43, 34, 53, 103, 46, 52, 103, 41, Framer.STDERR_FRAME_PREFIX, 43, 43};
    }

    public C1761ib(C1759iZ c1759iZ) {
        this.A00 = c1759iZ;
    }

    @Override // com.facebook.ads.redexgen.core.N2
    public final void A06() {
        this.A00.A07.onRewardServerFailed();
    }

    @Override // com.facebook.ads.redexgen.core.N2
    public final void A07() {
        this.A00.A07.onRewardServerSuccess();
    }

    @Override // com.facebook.ads.redexgen.core.N2
    public final void A08() {
        if (this.A00.A02 == null) {
            this.A00.A07.onRewardedVideoCompleted();
        }
    }

    @Override // com.facebook.ads.redexgen.core.N2
    public final void A09() {
        if (this.A00.A02 == null) {
            this.A00.A07.onRewardedVideoActivityDestroyed();
        }
    }

    @Override // com.facebook.ads.redexgen.core.N2
    public final void A0A() {
        if (this.A00.A02 != null) {
            SJ sj = (SJ) this.A00.A02.buildShowAdConfig();
            sj.A02(System.currentTimeMillis() - this.A00.A01);
            this.A00.A02.show(sj.build());
            return;
        }
        this.A00.A07.onRewardedVideoClosed();
    }

    @Override // com.facebook.ads.redexgen.core.N2
    public final void A0C() {
        this.A00.A06.A0F().A3K();
        this.A00.A07.onAdClicked(this.A00.A08.A6k());
    }

    @Override // com.facebook.ads.redexgen.core.N2
    public final void A0D() {
        this.A00.A07.onLoggingImpression(this.A00.A08.A6k());
    }

    @Override // com.facebook.ads.redexgen.core.N2
    public final void A0F(N1 n12) {
        if (this.A00.A04 == null) {
            this.A00.A06.A08().ABC(A00(0, 3, 67), AbstractC1060Td.A0N, new C1061Te(A00(3, 18, 108)));
            return;
        }
        AbstractC1817jh abstractC1817jh = (AbstractC1817jh) n12;
        if (this.A00.A08.A03 != null) {
            abstractC1817jh.A02(this.A00.A08.A03);
        }
        this.A00.A08.A00 = abstractC1817jh.A0H();
        this.A00.A05 = true;
        this.A00.A03 = this.A00.A04.A0I();
        if (this.A00.A03 != null) {
            int iA26 = 0;
            if (!this.A00.A03.A1b()) {
                iA26 = ((AbstractC1813jd) this.A00.A03).A26();
            }
            if (iA26 > 0) {
                XC xc = new XC();
                if (xc.A09(this.A00.A06, this.A00.A08.A06, iA26)) {
                    xc.A08(this.A00.A06, true);
                    this.A00.A02 = xc.A07(this.A00.A06, this.A00.A08.A0D, this.A00.A08.A06);
                } else {
                    xc.A08(this.A00.A06, false);
                }
            }
        }
        if (this.A00.A02 != null) {
            ((AbstractC1813jd) this.A00.A03).A2J(true);
            RewardedVideoAd.RewardedVideoLoadAdConfig loadAdConfig = this.A00.A02.buildLoadAdConfig().withFailOnCacheFailureEnabled(true).withRewardData(this.A00.A03.A0s()).withAdExperience(this.A00.A08.A02).withAdListener(new OI(this)).build();
            this.A00.A02.loadAd(loadAdConfig);
            return;
        }
        this.A00.A07.onAdLoaded(this.A00.A08.A6k());
    }

    @Override // com.facebook.ads.redexgen.core.N2
    public final void A0G(C1120Vm c1120Vm) {
        this.A00.A0D(true);
        this.A00.A08.A0B.A0F().A3N(Y1.A01(this.A00.A00), c1120Vm.A03().getErrorCode(), c1120Vm.A04());
        this.A00.A07.onError(this.A00.A08.A6k(), XE.A00(c1120Vm));
    }
}
