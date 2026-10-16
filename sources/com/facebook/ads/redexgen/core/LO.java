package com.facebook.ads.redexgen.core;

import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class LO {
    public final int A00;
    public final long A01;

    public LO(int i3, long j3) {
        this.A00 = i3;
        this.A01 = j3;
    }

    public static LO A00(InterfaceC1999ms interfaceC1999ms, C04554v c04554v) throws IOException {
        interfaceC1999ms.AGt(c04554v.A0l(), 0, 8);
        c04554v.A0f(0);
        int iA0C = c04554v.A0C();
        long size = c04554v.A0O();
        return new LO(iA0C, size);
    }
}
