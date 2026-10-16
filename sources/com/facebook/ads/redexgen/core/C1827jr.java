package com.facebook.ads.redexgen.core;

import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1827jr implements SM {
    public final /* synthetic */ C05347w A00;
    public final /* synthetic */ boolean A01;

    public C1827jr(C05347w c05347w, boolean z2) {
        this.A00 = c05347w;
        this.A01 = z2;
    }

    @Override // com.facebook.ads.redexgen.core.SM
    public final void ACx() {
        if (!C1098Up.A1t(this.A00.A04) || !this.A01) {
            this.A00.A0C.set(true);
            this.A00.A01.AFm(this.A00);
        } else {
            this.A00.A06 = AbstractC1433dD.A01(this.A00.A04, (C05237l) this.A00.A03, 0, new C1828js(this));
        }
    }

    @Override // com.facebook.ads.redexgen.core.SM
    public final void ACy() {
        this.A00.A01.AFp(this.A00, AdError.CACHE_ERROR);
    }
}
