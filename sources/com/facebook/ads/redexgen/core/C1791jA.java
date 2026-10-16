package com.facebook.ads.redexgen.core;

import android.webkit.WebView;
import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jA, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1791jA implements InterfaceC1046Sp {
    public final C0920No A00;
    public final O3 A01;
    public final C1054Sx A02;
    public final C1648gi A03;
    public final boolean A04;

    public C1791jA(C1648gi c1648gi, O3 o3, C1054Sx c1054Sx, C0920No c0920No, boolean z2) {
        this.A03 = c1648gi;
        this.A01 = o3;
        this.A02 = c1054Sx;
        this.A00 = c0920No;
        this.A04 = z2;
    }

    private final void A00() {
        WebView webView = new WebView(this.A03);
        webView.getSettings().setCacheMode(1);
        O4 playableWebViewClient = new O4(this.A00, this.A01, this.A04);
        webView.setWebViewClient(playableWebViewClient);
        webView.loadUrl(this.A00.A0L());
        playableWebViewClient.A03();
    }

    private void A01(boolean z2) {
        if (this.A00.A0G() == EnumC0921Np.A05) {
            A00();
            return;
        }
        String strA0L = this.A00.A0L();
        if (z2) {
            C1054Sx c1054Sx = this.A02;
            String markupUrlResult = this.A00.A0L();
            strA0L = c1054Sx.A0S(markupUrlResult);
        }
        this.A00.A0T(strA0L);
        this.A01.AFG();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1046Sp
    public final void ADL() {
        if (this.A04) {
            this.A01.AFF(AdError.CACHE_ERROR);
        } else {
            A01(false);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1046Sp
    public final void ADT() {
        A01(true);
    }
}
