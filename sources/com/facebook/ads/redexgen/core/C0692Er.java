package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Er, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0692Er extends AbstractRunnableC1135Wc {
    public final /* synthetic */ int A00;
    public final /* synthetic */ int A01;
    public final /* synthetic */ C0685Ek A02;
    public final /* synthetic */ EnumC1590fm A03;

    public C0692Er(C0685Ek c0685Ek, EnumC1590fm enumC1590fm, int i3, int i4) {
        this.A02 = c0685Ek;
        this.A03 = enumC1590fm;
        this.A00 = i3;
        this.A01 = i4;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1135Wc
    public final void A07() {
        if (this.A03 == EnumC1590fm.A07) {
            this.A02.A0M(VH.A0y);
            this.A02.A0B.A0F().A3j();
            this.A02.A0C.A02(C0685Ek.A0J);
            return;
        }
        if (this.A03 == EnumC1590fm.A03) {
            this.A02.A0M(VH.A0t);
            this.A02.A04 = true;
            this.A02.A0C.A02(C0685Ek.A0H);
            this.A02.A0L(this.A00);
            return;
        }
        if (this.A03 == EnumC1590fm.A06) {
            this.A02.A0M(VH.A0s);
            this.A02.A0B.A0F().A3b();
            this.A02.A04 = true;
            this.A02.A08.removeCallbacksAndMessages(null);
            this.A02.A0C.A02(new C4K(this.A01, this.A01));
            this.A02.A0L(this.A01);
            return;
        }
        if (this.A03 == EnumC1590fm.A0A) {
            if (C1098Up.A1z(this.A02.A0B)) {
                this.A02.A0B.A0B().AGc();
            }
            this.A02.A0M(VH.A0w);
            this.A02.A0B.A0F().A3q();
            this.A02.A0C.A02(C0685Ek.A0I);
            this.A02.A08.removeCallbacksAndMessages(null);
            this.A02.A0I();
            return;
        }
        if (this.A03 == EnumC1590fm.A05) {
            this.A02.A0M(VH.A0v);
            this.A02.A0B.A0F().A3f();
            UM um = this.A02.A0C;
            final int i3 = this.A00;
            um.A02(new EB(i3) { // from class: com.facebook.ads.redexgen.X.4B
            });
            this.A02.A08.removeCallbacksAndMessages(null);
            this.A02.A0L(this.A00);
            return;
        }
        if (this.A03 == EnumC1590fm.A04) {
            this.A02.A0M(VH.A0u);
            this.A02.A0B.A0F().A3c();
            this.A02.A0C.A02(C0685Ek.A0L);
            this.A02.A08.removeCallbacksAndMessages(null);
            return;
        }
        if (this.A03 == EnumC1590fm.A09) {
            this.A02.A0M(VH.A0s);
            this.A02.A0B.A0F().A3l();
            this.A02.A04 = true;
            this.A02.A08.removeCallbacksAndMessages(null);
            this.A02.A0C.A02(new C4K(this.A00, this.A01));
            this.A02.A0L(this.A00);
        }
    }
}
