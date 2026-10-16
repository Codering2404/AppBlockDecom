package com.facebook.ads.redexgen.core;

import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Jf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0808Jf implements InterfaceC1304b8 {
    public final WeakReference<AnonymousClass67> A00;

    public C0808Jf(AnonymousClass67 anonymousClass67) {
        this.A00 = new WeakReference<>(anonymousClass67);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1304b8
    public final void AE7(C1303b7 c1303b7) {
        AnonymousClass67 anonymousClass67 = this.A00.get();
        if (anonymousClass67 != null) {
            anonymousClass67.A06 = c1303b7.A00() != null;
            anonymousClass67.A02();
        }
    }
}
