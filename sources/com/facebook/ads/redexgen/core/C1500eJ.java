package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.eJ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1500eJ {
    public static byte[] A09;
    public static String[] A0A = {"4QAeMuK9yCc4xE434", "vsUO926M2mRMCBHvkZDLDSVJZasjRX8H", "m75JG3kyGBA9Pa8Q", "BsXoGLiaQGDi3KDXWPANO86ZRypkU3", "NEfK90sKL", "NA5kCdAu0CbcY72yECaBPvDnC3FLldwL", "T76ZrsNa0P6C1lpNf7S0Tx3scEBkBq8W", "cxX21NDQKlhKMPjA26xNh3AVlSUU32"};
    public String A00;
    public String A01;
    public final T8 A02;
    public final VA A03;
    public final VI A04;
    public final C1499eI A05;
    public final String A06;
    public final Map<String, String> A07;
    public final boolean A08;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A09, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 88);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A09 = new byte[]{88, 79, 78, 78, 85, 84, 101, 89, 86, 83, 89, 81, 93, 74, 75, 75, 80, 81, 96, 81, 94, 82, 90, 8, 3, 9, Framer.STDERR_FRAME_PREFIX, Ascii.SO, Ascii.FF, Ascii.US, 9, Framer.STDERR_FRAME_PREFIX, Ascii.RS, 5, 2, Ascii.SUB, Framer.STDERR_FRAME_PREFIX, Ascii.CAN, Ascii.GS, 19, 0, 19, Ascii.CAN, 2, 41, 19, Ascii.SO, 2, 4, Ascii.ETB, Framer.ENTER_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, Framer.ENTER_FRAME_PREFIX, 42, 48, Ascii.ESC, 48, 61, 52, Framer.ENTER_FRAME_PREFIX, 78, 72, 68, 76, 118, 69, 70, 72, 77, 81, 88, 75, 88, 81, 98, 94, 82, 80, 77, 81, 88, 73, 88, 98, 107, Framer.EXIT_FRAME_PREFIX, 107, 98, 81, 96, 111, 99, 107, 104, 38};
    }

    static {
        A04();
    }

    public C1500eJ(T8 t8, C1499eI c1499eI, VA va, Map<String, String> metricsData, String str) {
        this.A02 = t8;
        this.A05 = c1499eI;
        this.A03 = va;
        this.A07 = metricsData;
        this.A06 = str;
        this.A04 = new VI(this.A06, this.A03);
        this.A08 = C1098Up.A2G(c1499eI.getContext());
    }

    private void A01() {
        HashMap map = new HashMap();
        map.put(A00(50, 10, 28), A00(60, 9, 113));
        A07(map);
    }

    private void A02() {
        this.A04.A04(VH.A0d, null);
    }

    private void A03() {
        HashMap map = new HashMap();
        map.put(A00(50, 10, 28), A00(23, 16, 53));
        A07(map);
    }

    private void A05(String str) {
        HashMap map = new HashMap();
        map.put(A00(83, 10, 86), String.valueOf(str));
        HashMap map2 = new HashMap();
        map2.put(A00(50, 10, 28), A00(69, 14, 101));
        map2.put(A00(39, 11, 46), AbstractC1159Xd.A01(map));
        A07(map2);
    }

    private void A06(String str, float f3, float f4) {
        HashMap map = new HashMap();
        map.put(A00(12, 11, 103), str);
        map.put(A00(93, 1, 72), String.valueOf(f3));
        map.put(A00(94, 1, 7), String.valueOf(f4));
        HashMap map2 = new HashMap();
        map2.put(A00(50, 10, 28), A00(0, 12, 98));
        map2.put(A00(39, 11, 46), AbstractC1159Xd.A01(map));
        A07(map2);
    }

    private void A07(Map<String, String> data) {
        if (TextUtils.isEmpty(this.A06)) {
            return;
        }
        data.putAll(this.A07);
        data.putAll(AbstractC1501eK.A01(this.A02, this.A00, this.A01));
        this.A03.ABr(this.A06, data);
    }

    @JavascriptInterface
    public void initializeLogging(String str, String str2) {
        if (!this.A08) {
            return;
        }
        this.A00 = str;
        if (A0A[4].length() == 10) {
            throw new RuntimeException();
        }
        A0A[1] = "4HHX0Lv3voylt1VaUhFjcSRGfPCuBfwt";
        this.A01 = str2;
    }

    @JavascriptInterface
    public void logButtonClick(String str, float f3, float f4) {
        if (!this.A08) {
            return;
        }
        A06(str, f3, f4);
    }

    @JavascriptInterface
    public void logEndCardShowUp() {
        if (!this.A08) {
            return;
        }
        A03();
    }

    @JavascriptInterface
    public void logGameLoad() {
        if (!this.A08) {
            return;
        }
        A01();
    }

    @JavascriptInterface
    public void logLevelComplete(String str) {
        if (!this.A08) {
            return;
        }
        A05(str);
    }

    @JavascriptInterface
    public void onCTAClick() {
        A02();
        this.A05.A0B();
    }
}
