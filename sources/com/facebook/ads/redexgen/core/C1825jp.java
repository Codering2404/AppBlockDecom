package com.facebook.ads.redexgen.core;

import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1825jp implements SM {
    public final /* synthetic */ C05347w A00;

    public C1825jp(C05347w c05347w) {
        this.A00 = c05347w;
    }

    @Override // com.facebook.ads.redexgen.core.SM
    public final void ACx() {
        this.A00.A0C.set(true);
        this.A00.A01.AFm(this.A00);
    }

    @Override // com.facebook.ads.redexgen.core.SM
    public final void ACy() {
        this.A00.A01.AFp(this.A00, AdError.CACHE_ERROR);
    }
}
