package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Cj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0633Cj implements InterfaceC1635gV {
    @Override // com.facebook.ads.redexgen.core.InterfaceC1635gV
    public final long A5m() {
        return System.nanoTime();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1635gV
    public final void AK4(Object obj, long j3) throws InterruptedException {
        obj.wait(j3);
    }
}
