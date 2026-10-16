package com.facebook.ads.redexgen.core;

import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ld, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1934ld implements InterfaceC0812Jj {
    public final long[] A00;
    public final C2158pT[] A01;

    public C1934ld(C2158pT[] c2158pTArr, long[] jArr) {
        this.A01 = c2158pTArr;
        this.A00 = jArr;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0812Jj
    public final List<C2158pT> A7X(long j3) {
        int iA0L = C5C.A0L(this.A00, j3, true, false);
        if (iA0L == -1 || this.A01[iA0L] == C2158pT.A0J) {
            return Collections.emptyList();
        }
        return Collections.singletonList(this.A01[iA0L]);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0812Jj
    public final long A83(int i3) {
        boolean z2 = true;
        AbstractC04323y.A07(i3 >= 0);
        if (i3 >= this.A00.length) {
            z2 = false;
        }
        AbstractC04323y.A07(z2);
        return this.A00[i3];
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0812Jj
    public final int A84() {
        return this.A00.length;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0812Jj
    public final int A8a(long j3) {
        int iA0K = C5C.A0K(this.A00, j3, false, false);
        int index = this.A00.length;
        if (iA0K < index) {
            return iA0K;
        }
        return -1;
    }
}
