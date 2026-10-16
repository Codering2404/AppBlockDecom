package com.facebook.ads.redexgen.core;

import android.content.Context;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.NativeAdScrollView;
import com.facebook.ads.NativeAdView;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.NativeAdsManager;
import com.facebook.ads.internal.api.NativeAdScrollViewApi;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class S3 implements NativeAdScrollViewApi {
    public static byte[] A07;
    public static String[] A08 = {"nVlKDJKKuSIwTlTd16ukFrbX3MHjOHdA", "", "ICm0nIVybe3UlAuBnNKxRWg2mc3pSWnS", "", "SSXPkfr4Ttu5KI5IplEjDPNbu7CwAkh6", "a5Au6kTC9kTmWkoQnewo7jq8", "NRpBzWywFD0YlyTuhproyOYpEldGp2Hb", "m"};
    public final int A00;
    public final NativeAdScrollView.AdViewProvider A01;
    public final NativeAdView.Type A02;
    public final NativeAdViewAttributes A03;
    public final NativeAdsManager A04;
    public final C1675h9 A05;
    public final C1648gi A06;

    public static String A06(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 114);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        byte[] bArr = {60, 4, 2, 5, 81, 1, 3, Ascii.RS, 7, Ascii.CAN, Ascii.NAK, Ascii.DC4, 81, Ascii.DLE, 81, 63, Ascii.DLE, 5, Ascii.CAN, 7, Ascii.DC4, 48, Ascii.NAK, 39, Ascii.CAN, Ascii.DC4, 6, Framer.STDIN_REQUEST_FRAME_PREFIX, 37, 8, 1, Ascii.DC4, 93, 81, 48, Ascii.NAK, 39, Ascii.CAN, Ascii.DC4, 6, Framer.ENTER_FRAME_PREFIX, 3, Ascii.RS, 7, Ascii.CAN, Ascii.NAK, Ascii.DC4, 3, 81, Ascii.RS, 3, 81, Ascii.DLE, 81, Ascii.US, Ascii.DLE, 5, Ascii.CAN, 7, Ascii.DC4, 48, Ascii.NAK, 39, Ascii.CAN, Ascii.DC4, 6, 57, Ascii.DC4, Ascii.CAN, Ascii.SYN, Ascii.EM, 5, 53, 1, 52, Ascii.ESC, Ascii.SO, 19, Ascii.FF, Ascii.US, 59, Ascii.RS, 9, 55, Ascii.ESC, Ascii.DC4, Ascii.ESC, Ascii.GS, Ascii.US, 8, 90, Ascii.DC4, Ascii.NAK, Ascii.SO, 90, Ascii.SYN, Ascii.NAK, Ascii.ESC, Ascii.RS, Ascii.US, Ascii.RS};
        String[] strArr = A08;
        if (strArr[6].charAt(14) != strArr[0].charAt(14)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A08;
        strArr2[2] = "Ml52sYoz4FZavAZNhfJ3fi3jnwDnZY4L";
        strArr2[4] = "tWqTcrLKFqppCUd7uCsjOJfAn0Jrdt0w";
        A07 = bArr;
    }

    static {
        A07();
    }

    public S3(NativeAdScrollView nativeAdScrollView, Context context, NativeAdsManager nativeAdsManager, NativeAdScrollView.AdViewProvider adViewProvider, int i3, NativeAdView.Type type, NativeAdViewAttributes nativeAdViewAttributes, int i4) {
        if (nativeAdsManager.isLoaded()) {
            if (type != null || adViewProvider != null || i3 > 0) {
                this.A06 = C1021Rp.A03(context);
                this.A04 = nativeAdsManager;
                this.A03 = nativeAdViewAttributes;
                this.A01 = adViewProvider;
                this.A02 = type;
                this.A00 = i4;
                C1676hA c1676hA = new C1676hA(this);
                this.A05 = new C1675h9(context);
                if (this.A02 == null) {
                    if (i3 > 0) {
                        this.A05.A00(((int) XX.A02) * i3);
                    }
                } else {
                    this.A05.A00((int) (XX.A02 * this.A02.getHeight()));
                }
                this.A05.setAdapter(c1676hA);
                setInset(20);
                c1676hA.A09();
                nativeAdScrollView.addView(this.A05);
                return;
            }
            throw new IllegalArgumentException(A06(0, 74, 3));
        }
        throw new IllegalStateException(A06(74, 27, 8));
    }

    @Override // com.facebook.ads.internal.api.NativeAdScrollViewApi
    public final void setInset(int i3) {
        if (i3 > 0) {
            float f3 = XX.A02;
            float density = i3;
            int insetDp = Math.round(density * f3);
            this.A05.setPadding(insetDp, 0, insetDp, 0);
            float density2 = i3 / 2;
            this.A05.setPageMargin(Math.round(density2 * f3));
            this.A05.setClipToPadding(false);
        }
    }
}
