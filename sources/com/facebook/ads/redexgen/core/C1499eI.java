package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebSettings;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.eI, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1499eI extends FrameLayout {
    public static byte[] A0C;
    public static String[] A0D = {"5vYLtEaU9MAxDoI06TlJjFfWs8tiaGj", "TX23sib3Tj6X7eJy5cgYAILp0vVPLOiW", "Lxz50jZMaNdiu", "yIxUapHBf", "xsW4qvb7U5EMj5cNQbMl14i5qh6u6uOh", "8XLPt3rjq6gnj0Cd96o3z24ZTqMdgzej", "IIODaFrLnzdPntRGftRJpuPC", "ODWlzaCdU1siup4vWOfVQK22DnthNinE"};
    public static final float A0E;
    public static final RelativeLayout.LayoutParams A0F;
    public int A00;
    public long A01;
    public Map<String, String> A02;
    public final AbstractC1813jd A03;
    public final C0920No A04;
    public final C1648gi A05;
    public final VA A06;
    public final InterfaceC1297b1 A07;
    public final LV A08;
    public final InterfaceC1497eG A09;
    public final AtomicBoolean A0A;
    public final AtomicBoolean A0B;

    public static String A07(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 9);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0A() {
        String[] strArr = A0D;
        if (strArr[1].charAt(1) != strArr[5].charAt(1)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0D;
        strArr2[7] = "Af0WM9g7Nak7nSkWG18ndsMVC8MahONd";
        strArr2[4] = "VergmF1iO6RBn6aZ7U2vBdquKGl77VZm";
        A0C = new byte[]{54, Ascii.DC2, 32, Ascii.FS, 17, 9, 17, Ascii.DC2, Ascii.FS, Ascii.NAK, Framer.STDOUT_FRAME_PREFIX, Ascii.DC4, 19, 34, Framer.STDOUT_FRAME_PREFIX, 48, 42, Framer.STDIN_FRAME_PREFIX, 36, 99, 38, Framer.STDOUT_FRAME_PREFIX, Framer.STDOUT_FRAME_PREFIX, 44, Framer.STDOUT_FRAME_PREFIX, 68, Framer.EXIT_FRAME_PREFIX, 117, 109, 117, 118, Framer.EXIT_FRAME_PREFIX, 113, 52, 112, 123, 87, 96, 117, 87, Framer.EXIT_FRAME_PREFIX, 125, 119, Ascii.DEL, 52, 96, 102, 125, 115, 115, 113, 102, 113, 112, 52, 99, 125, 96, 124, 52, 100, 102, 113, 57, 113, 98, 113, 122, 96, 52, 119, Framer.EXIT_FRAME_PREFIX, 125, 119, Ascii.DEL, 103, 52, 119, 123, 97, 122, 96, 52, 117, 122, 112, 52, 80, 113, Framer.EXIT_FRAME_PREFIX, 117, 109, Ascii.CR, Framer.STDOUT_FRAME_PREFIX, 60, 36, 60, 63, Framer.STDOUT_FRAME_PREFIX, 56, Ascii.FS, 57, 46, Ascii.VT, 52, 56, 42, 114, 117, 119, 121, 126, 48, 124, Ascii.DEL, 113, 116, 121, 126, 119, 48, 98, 117, 125, Ascii.DEL, 100, 117, 48, 96, 124, 113, 105, 113, 114, 124, 117, 34, Framer.STDIN_FRAME_PREFIX, 40, 34, 42, Framer.STDERR_FRAME_PREFIX, 5, 4, Ascii.CR, 0, Ascii.CAN, 114, 110, 99, 123, 99, 96, 110, 103, 52, 40, 37, 61, 37, 38, 40, Framer.ENTER_FRAME_PREFIX, Ascii.ESC, 54, Framer.ENTER_FRAME_PREFIX, 41, 43, 48, Framer.ENTER_FRAME_PREFIX, Framer.STDIN_REQUEST_FRAME_PREFIX, 72, 64, 66, 89, 72, 114, 94, 72, 94, 94, 68, 66, 67, 114, 68, 73, 78, 85, 81, Framer.STDIN_REQUEST_FRAME_PREFIX, 84, 119, 101, 98, Framer.STDIN_REQUEST_FRAME_PREFIX, 118, 105, 101, 119};
    }

    static {
        A0A();
        A0E = (int) (XX.A02 * 4.0f);
        A0F = new RelativeLayout.LayoutParams(-1, -1);
    }

    public C1499eI(C1648gi c1648gi, AbstractC1813jd abstractC1813jd, C0920No c0920No, VA va, InterfaceC1497eG interfaceC1497eG, Map<String, String> playableMetricsData) {
        super(c1648gi);
        this.A0A = new AtomicBoolean(false);
        this.A0B = new AtomicBoolean(false);
        this.A01 = -1L;
        this.A00 = 0;
        this.A07 = new AbstractC0870Lp() { // from class: com.facebook.ads.redexgen.X.4S
            @Override // com.facebook.ads.redexgen.core.InterfaceC1297b1
            public final void ACz() {
            }

            @Override // com.facebook.ads.redexgen.core.AbstractC0870Lp, com.facebook.ads.redexgen.core.InterfaceC1297b1
            public final void ADu(int i3, String str) {
                this.A00.A0B.set(true);
                this.A00.A09.AEh();
            }

            @Override // com.facebook.ads.redexgen.core.InterfaceC1297b1
            public final void AEA() {
                if (this.A00.A0B.get() || !this.A00.A0A.compareAndSet(false, true)) {
                    return;
                }
                this.A00.A09.AEA();
            }

            @Override // com.facebook.ads.redexgen.core.InterfaceC1297b1
            public final void AF8() {
                if (!this.A00.A04.A0b()) {
                    return;
                }
                this.A00.A09.AFQ();
            }

            @Override // com.facebook.ads.redexgen.core.InterfaceC1297b1
            public final void AGg() {
                this.A00.A09.AGg();
            }
        };
        this.A05 = c1648gi;
        this.A03 = abstractC1813jd;
        this.A04 = c0920No;
        this.A06 = va;
        this.A09 = interfaceC1497eG;
        this.A02 = playableMetricsData;
        this.A08 = A05();
        if (C1098Up.A1z(this.A05)) {
            this.A05.A0B().AKn(this.A08, this.A03.A2E(), false);
        }
        addView(this.A08, A0F);
    }

    public static /* synthetic */ int A00(C1499eI c1499eI) {
        int i3 = c1499eI.A00;
        c1499eI.A00 = i3 + 1;
        return i3;
    }

    private LV A05() {
        LV lv = new LV(this.A05, (WeakReference<InterfaceC1297b1>) new WeakReference(this.A07), 10, C1098Up.A28(this.A05));
        lv.setCornerRadius(A0E);
        lv.setLogMultipleImpressions(false);
        lv.setCheckAssetsByJavascriptBridge(false);
        lv.setWebViewTimeoutInMillis(this.A04.A0F());
        lv.setRequestId(this.A03.A1D());
        lv.setOnTouchListener(new ViewOnTouchListenerC1498eH(this));
        WebSettings settings = lv.getSettings();
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs(true);
        lv.addJavascriptInterface(new C1500eJ(this.A05, this, this.A06, this.A02, this.A03.A2E()), A07(0, 12, 121));
        return lv;
    }

    public final void A0B() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.A01;
        C1061Te c1061Te = new C1061Te(A07(25, 67, 29));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(A07(136, 6, 72), this.A00);
            jSONObject.put(A07(142, 5, 104), jCurrentTimeMillis);
            jSONObject.put(A07(187, 5, 51), this.A03.A2E());
        } catch (JSONException e3) {
            Log.e(A07(92, 15, 84), A07(12, 13, 74), e3);
        }
        c1061Te.A07(jSONObject);
        c1061Te.A05(1);
        InterfaceC1059Tc interfaceC1059TcA08 = this.A05.A08();
        int i3 = AbstractC1060Td.A2D;
        String strA07 = A07(147, 8, 11);
        interfaceC1059TcA08.ABD(strA07, i3, c1061Te);
        this.A00 = 0;
        if (!C1098Up.A1u(this.A05)) {
            this.A09.ADX();
            return;
        }
        if (jCurrentTimeMillis <= C1098Up.A0L(this.A05)) {
            InterfaceC1497eG interfaceC1497eG = this.A09;
            String[] strArr = A0D;
            if (strArr[7].charAt(0) == strArr[4].charAt(0)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0D;
            strArr2[1] = "0XAlcIRGce3nNmobAWWNAzxTwWjfpKo1";
            strArr2[5] = "vX4VpuJxASYV4FwrDvVxGQ4QiWthZxUm";
            interfaceC1497eG.ADX();
            return;
        }
        c1061Te.A05(0);
        this.A05.A08().ABC(strA07, AbstractC1060Td.A2E, c1061Te);
    }

    public final void A0C() {
        String strA0L;
        if (this.A04.A0Y()) {
            C1061Te c1061Te = new C1061Te(A07(107, 29, 25));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(A07(170, 17, 36), this.A04.A0P());
                jSONObject.put(A07(187, 5, 51), this.A03.A2E());
            } catch (JSONException e3) {
                String strA07 = A07(92, 15, 84);
                String strA072 = A07(12, 13, 74);
                String[] strArr = A0D;
                if (strArr[1].charAt(1) != strArr[5].charAt(1)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0D;
                strArr2[3] = "qKqF8GsLC";
                strArr2[6] = "yUBs4wOBB81EmWZp6CsNCuI0";
                Log.e(strA07, strA072, e3);
            }
            c1061Te.A07(jSONObject);
            c1061Te.A05(1);
            InterfaceC1059Tc interfaceC1059TcA08 = this.A05.A08();
            int i3 = AbstractC1060Td.A2G;
            String strA073 = A07(ModuleDescriptor.MODULE_VERSION, 15, 77);
            interfaceC1059TcA08.ABD(strA073, i3, c1061Te);
            if (C1098Up.A0r(this.A05) && AbstractC1181Xz.A00(this.A05) == EnumC1180Xy.A07) {
                this.A05.A08().ABD(strA073, AbstractC1060Td.A2F, c1061Te);
                this.A07.ADu(0, null);
                String[] strArr3 = A0D;
                if (strArr3[1].charAt(1) != strArr3[5].charAt(1)) {
                    String[] strArr4 = A0D;
                    strArr4[7] = "eYeTyqsAvkMxTzxGPJMzaaOJBs1WoRUE";
                    strArr4[4] = "DGSgvEgHkFrTWskIwQomZOyU4ros1fyW";
                    return;
                } else {
                    String[] strArr5 = A0D;
                    strArr5[1] = "QXwUk7ZcYbXDO6xLw92fyo5XHWgn18Du";
                    strArr5[5] = "iXthj0ZXJZZP0QlicLBvNNfJ4d5EWvqr";
                    return;
                }
            }
        }
        try {
            LV lv = this.A08;
            if (!TextUtils.isEmpty(this.A04.A0I())) {
                strA0L = this.A04.A0I();
            } else {
                strA0L = this.A04.A0L();
            }
            lv.loadUrl(strA0L);
        } catch (Exception e4) {
            this.A05.A08().ABC(A07(192, 8, 9), AbstractC1060Td.A2f, new C1061Te(e4));
        }
    }

    public final void A0D() {
        if (C1098Up.A1z(this.A05)) {
            this.A05.A0B().AKU(this.A08);
        }
        this.A08.removeJavascriptInterface(A07(0, 12, 121));
        this.A08.destroy();
    }

    public final void A0E(int i3) {
        this.A08.setVisibility(i3);
        if (i3 == 0) {
            this.A08.resumeTimers();
        } else {
            this.A08.pauseTimers();
        }
    }

    public Y2 getTouchDataRecorder() {
        return this.A08.getTouchDataRecorder();
    }

    public C1593fp getViewabilityChecker() {
        return this.A08.getViewabilityChecker();
    }
}
