package com.facebook.ads.redexgen.core;

import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nT, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2035nT implements InterfaceC0812Jj {
    public final long A00;
    public final BP<C2158pT> A01;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BP != com.google.common.collect.ImmutableList<com.facebook.ads.androidx.media3.common.text.Cue> */
    public C2035nT(long j3, BP<C2158pT> bp) {
        this.A00 = j3;
        this.A01 = bp;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0812Jj
    public final List<C2158pT> A7X(long j3) {
        return j3 >= this.A00 ? this.A01 : Collections.emptyList();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0812Jj
    public final long A83(int i3) {
        AbstractC04323y.A07(i3 == 0);
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0812Jj
    public final int A84() {
        return 1;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0812Jj
    public final int A8a(long j3) {
        return this.A00 > j3 ? 0 : -1;
    }
}
