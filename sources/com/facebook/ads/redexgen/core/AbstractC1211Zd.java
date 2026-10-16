package com.facebook.ads.redexgen.core;

import android.widget.FrameLayout;
import com.facebook.ads.AdClosedListener;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1211Zd extends FrameLayout {
    public static String[] A0E = {"5RNIIKEidNz4CxH4JgV5654XoKm2WCRJ", "1p9zA", "TyFhTVOKfwCiarLUW0", "qGg1KSsP6zNQFhXHIMmjZGXDOHal5qmq", "ysvkaelauuCqE6L7ICudiIGq1Ejo0wOd", "BlsqFJOSCgQfST", "dpiEaUs9Aor9er1WGZ", "tfv9H94"};
    public int A00;
    public AdClosedListener A01;
    public EnumC0940Oi A02;
    public C0941Oj A03;
    public C0942Ok A04;
    public InterfaceC1210Zc A05;
    public final C0938Og A06;
    public final C1648gi A07;
    public final VA A08;
    public final InterfaceC1189Yh A09;
    public final InterfaceC1190Yi A0A;
    public final String A0B;
    public final C0918Nm A0C;
    public final InterfaceC1213Zf A0D;

    public abstract void A0O();

    public abstract void A0P();

    public abstract void A0R(C0942Ok c0942Ok, EnumC0940Oi enumC0940Oi);

    public abstract boolean A0S();

    public AbstractC1211Zd(C1648gi c1648gi, VA va, String str) {
        this(c1648gi, va, str, null, null, null);
    }

    public AbstractC1211Zd(C1648gi c1648gi, VA va, String str, C0918Nm c0918Nm, InterfaceC1190Yi interfaceC1190Yi, InterfaceC1189Yh interfaceC1189Yh) {
        super(c1648gi);
        this.A00 = 0;
        this.A02 = EnumC0940Oi.A05;
        this.A04 = null;
        this.A0D = new MF(this);
        this.A07 = c1648gi;
        this.A08 = va;
        this.A0A = interfaceC1190Yi;
        this.A09 = interfaceC1189Yh;
        this.A0B = str;
        this.A0C = c0918Nm;
        this.A06 = AbstractC0939Oh.A00(this.A07.A02());
    }

    public static /* synthetic */ int A02(AbstractC1211Zd abstractC1211Zd) {
        int i3 = abstractC1211Zd.A00;
        abstractC1211Zd.A00 = i3 + 1;
        return i3;
    }

    public static /* synthetic */ int A03(AbstractC1211Zd abstractC1211Zd) {
        int i3 = abstractC1211Zd.A00;
        abstractC1211Zd.A00 = i3 - 1;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0E() {
        if (this.A03.A0A()) {
            this.A08.AB3(this.A0B, this.A03.A02());
            this.A03.A03();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0F() {
        this.A04 = null;
        this.A03.A05();
        A0O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0G(C0942Ok c0942Ok) {
        this.A03.A08(this.A02);
        A0Q(c0942Ok, this.A02);
        N8.A01(this.A07).A0L();
        if (A0S()) {
            A0E();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0H(C0942Ok c0942Ok) {
        this.A04 = c0942Ok;
        this.A03.A09(this.A02, this.A00);
        A0R(c0942Ok, this.A02);
    }

    public final void A0M() {
        A0E();
    }

    public final void A0N() {
        this.A03 = new C0941Oj(new VI(this.A0B, this.A08));
        if (this.A0A != null) {
            InterfaceC1190Yi interfaceC1190Yi = this.A0A;
            if (A0E[0].charAt(22) == 'O') {
                throw new RuntimeException();
            }
            A0E[7] = "FLAi4P2";
            interfaceC1190Yi.AFA(true);
        }
        if (this.A05 != null) {
            this.A05.ACs();
        }
        A0F();
    }

    public void A0Q(C0942Ok c0942Ok, EnumC0940Oi enumC0940Oi) {
        if (this.A01 != null) {
            this.A07.A0F().ABV();
            this.A01.onAdClosed();
        }
    }

    public void setAdReportingCallbackListener(InterfaceC1210Zc interfaceC1210Zc) {
        this.A05 = interfaceC1210Zc;
    }

    public void setOnAdClosedListener(AdClosedListener adClosedListener) {
        this.A01 = adClosedListener;
    }
}
