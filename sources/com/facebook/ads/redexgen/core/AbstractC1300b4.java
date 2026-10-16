package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import android.webkit.WebView;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.b4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1300b4 {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 82);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{Ascii.VT, 8, 5, Ascii.US, Ascii.RS, 80, 8, 6, Ascii.VT, 4, 1, 119, 107, 107, 111, 108, 37, 48, 48, 104, 104, 104, Framer.STDOUT_FRAME_PREFIX, 58, 108, Framer.STDOUT_FRAME_PREFIX, 121, 126, 124, 122, 125, 112, 112, 116, Framer.STDOUT_FRAME_PREFIX, 124, 112, 114, Framer.STDOUT_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX, 41, 42, 99, 118, 118, 46, 46, 46, 119, 63, 56, 58, 60, 59, 54, 54, Framer.STDERR_FRAME_PREFIX, 119, 58, 54, 52, 118};
    }

    public static String A01(String str) {
        return TextUtils.isEmpty(str) ? A00(38, 25, 11) : String.format(Locale.US, A00(11, 27, 77), str);
    }

    public static void A03(WebView webView) {
        webView.loadUrl(A00(0, 11, 56));
        webView.clearCache(true);
    }

    public static void A04(WebView webView) {
        webView.getSettings().setMixedContentMode(0);
    }
}
