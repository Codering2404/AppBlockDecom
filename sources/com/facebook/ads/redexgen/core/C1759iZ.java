package com.facebook.ads.redexgen.core;

import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.AdError;
import com.facebook.ads.AdExperienceType;
import com.facebook.ads.RewardData;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.S2SRewardedVideoAdExtendedListener;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.iZ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1759iZ implements OG {
    public static byte[] A09;
    public static final String A0A;
    public long A01;
    public RewardedVideoAd A02;
    public NQ A03;
    public C05127a A04;
    public final C1648gi A06;
    public final S2SRewardedVideoAdExtendedListener A07;
    public final C1743iI A08;
    public boolean A05 = false;
    public long A00 = -1;

    public static String A09(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A09, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 14);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0A() {
        A09 = new byte[]{116, -95, 83, -108, -105, 83, -97, -94, -108, -105, 83, -100, -90, 83, -108, -97, -91, -104, -108, -105, -84, 83, -100, -95, 83, -93, -91, -94, -102, -91, -104, -90, -90, 97, 83, -116, -94, -88, 83, -90, -101, -94, -88, -97, -105, 83, -86, -108, -100, -89, 83, -103, -94, -91, 83, -108, -105, Ascii.DEL, -94, -108, -105, -104, -105, 91, 92, 83, -89, -94, 83, -107, -104, 83, -106, -108, -97, -97, -104, -105, -60, -15, -15, -18, -15, -97, -21, -18, -32, -29, -24, -19, -26, -97, -15, -28, -10, -32, -15, -29, -28, -29, -97, -11, -24, -29, -28, -18, -97, -32, -29, -19, -4, -11};
    }

    static {
        A0A();
        A0A = C1759iZ.class.getSimpleName();
    }

    public C1759iZ(C1743iI c1743iI, OW ow, String str) {
        this.A08 = c1743iI;
        this.A06 = c1743iI.A0B;
        this.A07 = new C1740iF(str, ow, this, c1743iI);
    }

    private void A0C(String str, AdExperienceType adExperienceType, boolean z2) {
        String extraHints;
        if (!this.A05 && this.A04 != null) {
            Log.w(A0A, A09(0, 78, 37));
        }
        A0D(false);
        this.A05 = false;
        O7 o7 = new O7(this.A08.A0D, EnumC1123Vq.A07, AdPlacementType.REWARDED_VIDEO, EnumC1122Vp.A08, 1, this.A08.A0C);
        o7.A08(z2);
        if (C1098Up.A2g(this.A06) && (extraHints = XC.A02(this.A06, this.A08.A06)) != null) {
            this.A08.A06 = extraHints;
        }
        o7.A06(this.A08.A06);
        o7.A07(this.A08.A07);
        this.A04 = new C05127a(this.A08.A0B, o7);
        this.A04.A0S(new C1761ib(this));
        this.A04.A0X(str, adExperienceType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0D(boolean z2) {
        if (this.A04 != null) {
            this.A04.A0S(new C1760ia(this));
            this.A04.A0Y(z2);
            this.A04.A0K();
            this.A04 = null;
        }
    }

    public final long A0F() {
        if (this.A04 != null) {
            return this.A04.A0G();
        }
        return -1L;
    }

    public final C1743iI A0G() {
        return this.A08;
    }

    public final C1648gi A0H() {
        return this.A06;
    }

    public final void A0I(RewardData rewardData) {
        this.A08.A03 = rewardData;
        if (this.A05 && this.A04 != null) {
            this.A04.A0a(rewardData);
        }
    }

    public final void A0J(String str, AdExperienceType adExperienceType, boolean z2) {
        this.A00 = System.currentTimeMillis();
        try {
            A0C(str, adExperienceType, z2);
        } catch (Exception e3) {
            Log.e(A0A, A09(78, 31, 113), e3);
            this.A08.A0B.A08().ABC(A09(109, 3, 126), AbstractC1060Td.A0b, new C1061Te(e3));
            AdError adErrorInternalError = AdError.internalError(AdError.INTERNAL_ERROR_2004);
            this.A08.A0B.A0F().A3N(Y1.A01(this.A00), adErrorInternalError.getErrorCode(), adErrorInternalError.getErrorMessage());
            this.A07.onError(this.A08.A6k(), adErrorInternalError);
        }
    }

    public final boolean A0K() {
        return this.A04 == null || this.A04.A0Z();
    }

    public final boolean A0L() {
        return this.A05;
    }

    public final boolean A0M(int i3, long j3) {
        if (!this.A05) {
            this.A07.onError(this.A08.A6k(), AdError.SHOW_CALLED_BEFORE_LOAD_ERROR);
            return false;
        }
        if (this.A04 != null) {
            this.A01 = System.currentTimeMillis();
            this.A04.A08.A02(i3);
            this.A04.A08.A03(j3);
            this.A04.A0M();
            this.A05 = false;
            return true;
        }
        this.A05 = false;
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.OG
    public final void destroy() {
        A0D(true);
    }
}
