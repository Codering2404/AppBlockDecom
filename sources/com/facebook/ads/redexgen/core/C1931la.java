package com.facebook.ads.redexgen.core;

import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.la, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1931la implements InterfaceC0812Jj {
    public final List<C2158pT> A00;

    public C1931la(List<C2158pT> list) {
        this.A00 = Collections.unmodifiableList(list);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0812Jj
    public final List<C2158pT> A7X(long j3) {
        return j3 >= 0 ? this.A00 : Collections.emptyList();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0812Jj
    public final long A83(int i3) {
        AbstractC04323y.A07(i3 == 0);
        return 0L;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0812Jj
    public final int A84() {
        return 1;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0812Jj
    public final int A8a(long j3) {
        return j3 < 0 ? 0 : -1;
    }
}
