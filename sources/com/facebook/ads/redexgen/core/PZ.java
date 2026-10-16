package com.facebook.ads.redexgen.core;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class PZ extends RelativeLayout implements InterfaceC1190Yi {
    public static byte[] A0G;
    public static final String A0H;
    public static final int A0I;
    public long A00;
    public long A01;
    public String A02;
    public boolean A03;
    public String A04;
    public boolean A05;
    public final InterfaceC1016Rk A06;
    public final LinearLayout A07;
    public final C1010Re A08;
    public final C1648gi A09;
    public final VA A0A;
    public final InterfaceC1189Yh A0B;
    public final C1277ah A0C;
    public final InterfaceC1286aq A0D;
    public final M3 A0E;
    public final InterfaceC1291av A0F;

    public static String A0D(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0G, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 44);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0E() {
        A0G = new byte[]{90, 112, 112, 125, 112, Ascii.DC4, 63, 61, 112, 19, 63, 62, 36, 53, 62, 36, 112, Ascii.FS, 63, Framer.STDOUT_FRAME_PREFIX, 52, 53, 52, 112, 4, 57, 61, 53, 106, 112, 48, Ascii.SUB, Ascii.SUB, Ascii.ETB, Ascii.SUB, 118, 85, 91, 94, Ascii.SUB, 124, 83, 84, 83, 73, 82, Ascii.SUB, 110, 83, 87, Framer.STDIN_REQUEST_FRAME_PREFIX, 0, Ascii.SUB, Framer.STDIN_REQUEST_FRAME_PREFIX, 117, 117, Framer.EXIT_FRAME_PREFIX, 117, Ascii.EM, 58, 52, Framer.STDOUT_FRAME_PREFIX, 117, 6, Framer.ENTER_FRAME_PREFIX, 52, 39, Framer.ENTER_FRAME_PREFIX, 117, 1, 60, 56, 48, 111, 117, 117, Framer.STDIN_REQUEST_FRAME_PREFIX, Framer.STDIN_REQUEST_FRAME_PREFIX, 82, Framer.STDIN_REQUEST_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX, Ascii.SUB, Ascii.FF, Ascii.SI, Ascii.DLE, 17, Ascii.FF, Ascii.SUB, Framer.STDIN_REQUEST_FRAME_PREFIX, 58, 17, Ascii.ESC, Framer.STDIN_REQUEST_FRAME_PREFIX, 43, Ascii.SYN, Ascii.DC2, Ascii.SUB, 69, Framer.STDIN_REQUEST_FRAME_PREFIX, 109, 71, 71, 74, 71, 52, 4, Ascii.NAK, 8, Ascii.VT, Ascii.VT, 71, 53, 2, 6, 3, Ascii.RS, 71, 51, Ascii.SO, 10, 2, 93, 71, 87, 125, 125, 112, 125, Ascii.SO, 56, 46, 46, 52, Framer.STDERR_FRAME_PREFIX, 51, 125, Ascii.ESC, 52, 51, 52, 46, 53, 125, 9, 52, 48, 56, 103, 125, 42, Ascii.SUB, 48, 48, 61, 48, 88, 113, 126, 116, 124, 117, 98, 48, 68, 121, 125, 117, 42, 48, 97, 81, 76, 84, 80, 70, 81, 3, 80, 70, 80, 80, 74, 76, 77, 3, 71, 66, 87, 66, 3, 79, 76, 68, 68, 70, 71, 3, 99, 3, 126, 125, 112, 106, 107, 37, 125, 115, 126, 113, 116, 67, 83, 78, 86, 82, 68, 83, 116, 115, 109, 85, 90, Framer.STDIN_REQUEST_FRAME_PREFIX, 83, 88, 66, 98, 89, 93, 83, 88, 37, 44, 35, 41, Framer.ENTER_FRAME_PREFIX, 40, 63, Ascii.EM, 36, 32, 40};
    }

    static {
        A0E();
        A0H = PZ.class.getSimpleName();
        A0I = XV.A0A;
    }

    public PZ(C1010Re c1010Re, C1648gi c1648gi, VA va, InterfaceC1189Yh interfaceC1189Yh, boolean z2) {
        M3 m3;
        super(c1648gi);
        this.A06 = new C0960Pc(this);
        this.A05 = true;
        this.A01 = -1L;
        this.A03 = true;
        this.A08 = c1010Re;
        this.A0A = va;
        this.A0B = interfaceC1189Yh;
        this.A09 = c1648gi;
        if (c1648gi.A0E() == null) {
            c1648gi.A0F().A9v();
        }
        this.A0D = A0F();
        if (AbstractC1099Uq.A02(c1648gi) || c1648gi.A0E() == null) {
            m3 = new M3(c1648gi, this.A0D);
        } else {
            m3 = new M3(c1648gi, c1648gi.A0E(), this.A0D);
        }
        this.A0E = m3;
        this.A0F = A0C(z2);
        this.A07 = (LinearLayout) this.A0F;
        this.A07.setId(View.generateViewId());
        this.A0F.setListener(new C0959Pb(this));
        this.A0E.setBrowserNavigationListener(this.A0F.getBrowserNavigationListener());
        this.A0C = new C1277ah(c1648gi, null, R.attr.progressBarStyleHorizontal);
        A0G();
        c1010Re.A0A(this.A06);
    }

    private InterfaceC1291av A0C(boolean z2) {
        if (z2) {
            return new M8(this.A09, this.A0E, false);
        }
        return new M6(this.A09, this.A0E);
    }

    public InterfaceC1286aq A0F() {
        return new C0958Pa(this);
    }

    public void A0G() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        this.A07.setPadding(XV.A0b, XV.A0b, XV.A0b, XV.A0b);
        this.A0B.A45(this.A07, layoutParams);
        RelativeLayout.LayoutParams webViewParams = new RelativeLayout.LayoutParams(-1, -2);
        webViewParams.addRule(3, this.A07.getId());
        webViewParams.addRule(12);
        this.A0B.A45(this.A0E, webViewParams);
        RelativeLayout.LayoutParams webViewParams2 = new RelativeLayout.LayoutParams(-1, A0I);
        webViewParams2.addRule(3, this.A07.getId());
        this.A0C.setProgress(0);
        this.A0B.A45(this.A0C, webViewParams2);
    }

    public void A0H() {
        this.A08.finish(1);
    }

    public void A0I(String str) {
    }

    public void AAu(Intent intent, Bundle bundle, C1010Re c1010Re) {
        if (this.A01 < 0) {
            this.A01 = System.currentTimeMillis();
        }
        String strA0D = A0D(231, 11, 97);
        String strA0D2 = A0D(220, 11, 26);
        String url = A0D(210, 10, 13);
        if (bundle == null) {
            this.A02 = intent.getStringExtra(url);
            this.A04 = intent.getStringExtra(strA0D2);
            this.A00 = intent.getLongExtra(strA0D, -1L);
        } else {
            this.A02 = bundle.getString(url);
            this.A04 = bundle.getString(strA0D2);
            this.A00 = bundle.getLong(strA0D, -1L);
        }
        String strA0D3 = this.A02 != null ? this.A02 : A0D(199, 11, 51);
        this.A0F.setUrl(strA0D3);
        this.A0E.loadUrl(strA0D3);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1190Yi
    public final void AFA(boolean z2) {
        this.A0E.onPause();
        if (this.A03) {
            this.A03 = false;
            C1280ak c1280akA07 = new C1279aj(this.A0E.getFirstUrl()).A01(this.A00).A03(this.A01).A04(this.A0E.getResponseEndMs()).A00(this.A0E.getDomContentLoadedMs()).A05(this.A0E.getScrollReadyMs()).A02(this.A0E.getLoadFinishMs()).A06(System.currentTimeMillis()).A07();
            this.A0A.AB5(this.A04, c1280akA07.A02());
            if (BuildConfigApi.isDebug()) {
                String str = A0D(169, 30, 15) + System.currentTimeMillis() + A0D(149, 20, 60) + c1280akA07.A01 + A0D(53, 22, 121) + c1280akA07.A03 + A0D(75, 24, 83) + c1280akA07.A04 + A0D(0, 30, 124) + c1280akA07.A00 + A0D(99, 24, 75) + c1280akA07.A05 + A0D(30, 23, 22) + c1280akA07.A02 + A0D(123, 26, 113) + c1280akA07.A06;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1190Yi
    public final void AFi(boolean z2) {
        this.A0E.onResume();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1190Yi
    public final void AIv(Bundle bundle) {
        bundle.putString(A0D(210, 10, 13), this.A02);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1190Yi
    public String getCurrentClientToken() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1190Yi
    public final boolean onActivityResult(int i3, int i4, Intent intent) {
        return false;
    }

    public void onDestroy() {
        this.A08.A0B(this.A06);
        AbstractC1300b4.A03(this.A0E);
        this.A0E.destroy();
    }

    public void setListener(InterfaceC1189Yh interfaceC1189Yh) {
    }
}
