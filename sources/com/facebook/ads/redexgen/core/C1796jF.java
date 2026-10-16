package com.facebook.ads.redexgen.core;

import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1796jF implements SM {
    public final /* synthetic */ AbstractC1813jd A00;
    public final /* synthetic */ InterfaceC0925Nt A01;
    public final /* synthetic */ C0926Nu A02;
    public final /* synthetic */ C1648gi A03;
    public final /* synthetic */ boolean A04;

    public C1796jF(C0926Nu c0926Nu, C1648gi c1648gi, boolean z2, AbstractC1813jd abstractC1813jd, InterfaceC0925Nt interfaceC0925Nt) {
        this.A02 = c0926Nu;
        this.A03 = c1648gi;
        this.A04 = z2;
        this.A00 = abstractC1813jd;
        this.A01 = interfaceC0925Nt;
    }

    @Override // com.facebook.ads.redexgen.core.SM
    public final void ACx() {
        if (C1098Up.A1q(this.A03) && this.A04) {
            this.A02.A02.add(AbstractC1433dD.A01(this.A03, this.A00, 1, new C1797jG(this)));
        } else {
            this.A01.ACp();
        }
    }

    @Override // com.facebook.ads.redexgen.core.SM
    public final void ACy() {
        this.A01.ACo(AdError.CACHE_ERROR);
    }
}
