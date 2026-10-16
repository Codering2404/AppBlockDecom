package com.facebook.ads.redexgen.core;

import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Lh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0862Lh extends AbstractRunnableC1135Wc {
    public final WeakReference<C1593fp> A00;

    public C0862Lh(C1593fp c1593fp) {
        this.A00 = new WeakReference<>(c1593fp);
    }

    public C0862Lh(WeakReference<C1593fp> weakReference) {
        this.A00 = weakReference;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1135Wc
    public final void A07() {
        C1593fp viewabilityChecker = this.A00.get();
        if (viewabilityChecker != null) {
            viewabilityChecker.A0U();
        }
    }
}
