package com.facebook.ads.redexgen.core;

import android.content.Context;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.AdExperienceType;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.RewardedInterstitialAd;
import com.facebook.ads.internal.api.RewardedInterstitialAdApi;
import com.facebook.ads.internal.context.Repairable;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class SD implements RewardedInterstitialAdApi, Repairable {
    public static byte[] A01;
    public final SH A00;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 66);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{80, 80, 1, 84, 82, 91, 91, 2, 54, 52, 97, 96, 100, 96, 55, 96, 108, 106, 59, 56, 60, 105, 56, 63, Ascii.SO, 93, 93, Ascii.FF, 10, 88, 8, Ascii.VT, 64, 119, 101, 115, 96, 118, 119, 118, Framer.STDERR_FRAME_PREFIX, 123, 124, 102, 119, 96, 97, 102, 123, 102, 123, 115, 126, Framer.STDERR_FRAME_PREFIX, 115, 118, Framer.STDERR_FRAME_PREFIX, 118, 119, 97, 102, 96, 125, 107, 119, 118, Ascii.RS, 41, 59, Framer.STDIN_FRAME_PREFIX, 62, 40, 41, 40, 108, 37, 34, 56, 41, 62, 63, 56, 37, 56, 37, Framer.STDIN_FRAME_PREFIX, 32, 108, Framer.STDIN_FRAME_PREFIX, 40, 108, 32, 35, Framer.STDIN_FRAME_PREFIX, 40, 108, 62, 41, 61, 57, 41, 63, 56, 41, 40, 122, 77, Framer.STDIN_REQUEST_FRAME_PREFIX, 73, 90, 76, 77, 76, 8, 65, 70, 92, 77, 90, 91, 92, 65, 92, 65, 73, 68, 8, 73, 76, 8, 91, 64, 71, Framer.STDIN_REQUEST_FRAME_PREFIX, 8, 75, 73, 68, 68, 77, 76, 126, Ascii.DEL, 105, 110, 104, 117, 99, Ascii.US, Ascii.FS, Ascii.DC2, Ascii.ETB, Framer.STDERR_FRAME_PREFIX, Ascii.ETB, 41, Framer.STDERR_FRAME_PREFIX, 53, Framer.STDIN_FRAME_PREFIX};
    }

    public SD(Context context, String str, RewardedInterstitialAd rewardedInterstitialAd) {
        this.A00 = new SH(context, str, rewardedInterstitialAd);
    }

    @Override // com.facebook.ads.internal.api.RewardedInterstitialAdApi, com.facebook.ads.FullScreenAd
    public final RewardedInterstitialAd.RewardedInterstitialAdLoadConfigBuilder buildLoadAdConfig() {
        return new SF(this.A00.buildLoadAdConfig());
    }

    @Override // com.facebook.ads.internal.api.RewardedInterstitialAdApi, com.facebook.ads.FullScreenAd
    public final RewardedInterstitialAd.RewardedInterstitialAdShowConfigBuilder buildShowAdConfig() {
        return new SG(this.A00.buildShowAdConfig());
    }

    @Override // com.facebook.ads.internal.api.RewardedInterstitialAdApi, com.facebook.ads.Ad
    public final void destroy() {
        AbstractC1131Vy.A05(A00(141, 7, 88), A00(32, 34, 80), A00(24, 8, 121));
        this.A00.A04();
    }

    public final void finalize() {
        this.A00.finalize();
    }

    @Override // com.facebook.ads.internal.api.RewardedInterstitialAdApi, com.facebook.ads.Ad
    public final String getPlacementId() {
        return this.A00.getPlacementId();
    }

    @Override // com.facebook.ads.internal.api.RewardedInterstitialAdApi
    public final int getVideoDuration() {
        return this.A00.getVideoDuration();
    }

    @Override // com.facebook.ads.Ad
    public final boolean isAdInvalidated() {
        return this.A00.isAdInvalidated();
    }

    @Override // com.facebook.ads.internal.api.RewardedInterstitialAdApi
    public final boolean isAdLoaded() {
        return this.A00.isAdLoaded();
    }

    @Override // com.facebook.ads.internal.api.RewardedInterstitialAdApi, com.facebook.ads.Ad
    public final void loadAd() {
        AbstractC1131Vy.A05(A00(148, 6, 49), A00(66, 39, 14), A00(16, 8, 27));
        this.A00.A07(null, AdExperienceType.AD_EXPERIENCE_TYPE_REWARDED_INTERSTITIAL, true);
    }

    @Override // com.facebook.ads.internal.api.RewardedInterstitialAdApi
    public final void loadAd(RewardedInterstitialAd.RewardedInterstitialLoadAdConfig rewardedInterstitialLoadAdConfig) {
        ((SF) rewardedInterstitialLoadAdConfig).A00();
    }

    @Override // com.facebook.ads.internal.context.Repairable
    public final void repair(Throwable th) {
        this.A00.repair(th);
    }

    @Override // com.facebook.ads.internal.api.RewardedInterstitialAdApi, com.facebook.ads.Ad
    @Deprecated
    public final void setExtraHints(ExtraHints extraHints) {
        this.A00.setExtraHints(extraHints);
    }

    @Override // com.facebook.ads.internal.api.RewardedInterstitialAdApi, com.facebook.ads.FullScreenAd
    public final boolean show() {
        AbstractC1131Vy.A05(A00(154, 4, 24), A00(105, 36, 106), A00(0, 8, 33));
        return this.A00.A08(new SJ().withAppOrientation(-1).build());
    }

    @Override // com.facebook.ads.internal.api.RewardedInterstitialAdApi
    public final boolean show(RewardedInterstitialAd.RewardedInterstitialShowAdConfig rewardedInterstitialShowAdConfig) {
        AbstractC1131Vy.A05(A00(154, 4, 24), A00(105, 36, 106), A00(8, 8, 64));
        return this.A00.A08(((SG) rewardedInterstitialShowAdConfig).A00());
    }
}
