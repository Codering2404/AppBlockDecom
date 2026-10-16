package com.facebook.ads.redexgen.core;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class M3 extends AbstractC1294ay {
    public static ValueCallback A08;
    public static boolean A09;
    public static boolean A0A;
    public static byte[] A0B;
    public static String[] A0C = {"r5lFqG0C0bBGIxytTEblkmz8pOWiln6U", "Y5tMFhpuLobi6U3v3neZGAzEpbrZh2e0", "35iZKMkwZFt7WP5rciHAZ1WswbletKXm", "1wdh7bxI31pnh6pFTaTypUqx", "X0GEkrMG66X1N8QG", "HQ8AmQiqT9dTkfwWyhZ7u2ZNdQoS7Fbv", "yjHJSxajRdLfdjSgilcNPSPFyTq4dELg", "ut8cBtSHXrZx3QiSKTpc7NoA9ie10da9"};
    public static final Set<String> A0D;
    public long A00;
    public long A01;
    public long A02;
    public long A03;
    public C1648gi A04;
    public C1281al A05;
    public InterfaceC1286aq A06;
    public C1289at A07;

    public static String A03(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 50);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A0B = new byte[]{43, 55, 55, 51, 100, Framer.EXIT_FRAME_PREFIX, Framer.EXIT_FRAME_PREFIX, 124, Ascii.DEL};
    }

    static {
        A06();
        A0D = new HashSet(2);
        A09 = false;
        A0A = false;
        A0D.add(A03(0, 4, 113));
        A0D.add(A03(4, 5, 62));
    }

    public M3(C1648gi c1648gi, Activity activity, InterfaceC1286aq interfaceC1286aq) {
        super(activity, c1648gi);
        this.A02 = -1L;
        this.A00 = -1L;
        this.A03 = -1L;
        this.A01 = -1L;
        A08(c1648gi, interfaceC1286aq);
    }

    public M3(C1648gi c1648gi, InterfaceC1286aq interfaceC1286aq) {
        super(c1648gi);
        this.A02 = -1L;
        this.A00 = -1L;
        this.A03 = -1L;
        this.A01 = -1L;
        A08(c1648gi, interfaceC1286aq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC1294ay
    /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final C1289at A0H() {
        return new C1289at(new WeakReference(this.A04), new WeakReference(this.A06), new WeakReference(this.A05));
    }

    private void A05() {
        if (this.A02 > -1 && this.A00 > -1 && this.A01 > -1) {
            this.A05.A05(false);
        }
    }

    public static void A07(int i3, int i4, Intent intent) {
        if (A08 != null && i3 == 1001) {
            A08.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(i4, intent));
            A08 = null;
        }
    }

    private void A08(C1648gi c1648gi, InterfaceC1286aq interfaceC1286aq) {
        this.A04 = c1648gi;
        this.A06 = interfaceC1286aq;
        this.A05 = new C1281al(this);
        A09 = AbstractC1099Uq.A03(this.A04);
        A0A = AbstractC1099Uq.A04(this.A04);
        WebSettings settings = getSettings();
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setAllowFileAccess(false);
        setWebChromeClient(A0G());
        this.A07 = A0H();
        setWebViewClient(this.A07);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1294ay
    public final WebChromeClient A0G() {
        return new C1288as(new WeakReference(this.A04), new WeakReference(this.A06), new WeakReference(this.A05));
    }

    public final void A0K(long j3) {
        if (this.A00 < 0) {
            this.A00 = j3;
        }
        A05();
        String[] strArr = A0C;
        if (strArr[6].charAt(18) == strArr[0].charAt(18)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0C;
        strArr2[4] = "TnIn5PelVgDBsDwa";
        strArr2[3] = "kaGwwHcDVWZGOuagxs1W4ZQa";
    }

    public final void A0L(long j3) {
        if (this.A01 < 0) {
            this.A01 = j3;
        }
        A05();
    }

    public final void A0M(long j3) {
        if (this.A02 < 0) {
            this.A02 = j3;
        }
        A05();
        String[] strArr = A0C;
        if (strArr[5].charAt(4) == strArr[7].charAt(4)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0C;
        strArr2[6] = "DwC46XxC2zY9iA5O924mXxlTXzY8IGhb";
        strArr2[0] = "1LscF1ZcfF08U7LpSibJFf3LFm8iDmJu";
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1294ay, android.webkit.WebView
    public final void destroy() {
        this.A06 = null;
        AbstractC1300b4.A03(this);
        super.destroy();
    }

    public long getDomContentLoadedMs() {
        return this.A00;
    }

    public String getFirstUrl() {
        WebBackForwardList webBackForwardListCopyBackForwardList = copyBackForwardList();
        if (webBackForwardListCopyBackForwardList.getSize() > 0) {
            return webBackForwardListCopyBackForwardList.getItemAtIndex(0).getUrl();
        }
        return getUrl();
    }

    public long getLoadFinishMs() {
        return this.A01;
    }

    public long getResponseEndMs() {
        return this.A02;
    }

    public long getScrollReadyMs() {
        return this.A03;
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.A03 < 0 && computeVerticalScrollRange() > getHeight()) {
            this.A03 = System.currentTimeMillis();
        }
    }

    public void setBrowserNavigationListener(InterfaceC1287ar interfaceC1287ar) {
        this.A07.A05(new WeakReference<>(interfaceC1287ar));
    }
}
