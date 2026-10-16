package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC0772Hu {
    public final InterfaceC0755Hd A00;

    public abstract boolean A0B(C04554v c04554v) throws C3K;

    public abstract boolean A0C(C04554v c04554v, long j3) throws C3K;

    public AbstractC0772Hu(InterfaceC0755Hd interfaceC0755Hd) {
        this.A00 = interfaceC0755Hd;
    }

    public final boolean A00(C04554v c04554v, long j3) throws C3K {
        return A0B(c04554v) && A0C(c04554v, j3);
    }
}
