package com.facebook.ads.redexgen.core;

import java.util.Objects;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1989mi extends H2 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1989mi(final HJ hj, int i3, long j3, long j4) {
        super(new InterfaceC0749Gx() { // from class: com.facebook.ads.redexgen.X.mk
            @Override // com.facebook.ads.redexgen.core.InterfaceC0749Gx
            public final long AKQ(long j5) {
                return hj.A07(j5);
            }
        }, new C1990mj(hj, i3), hj.A06(), 0L, hj.A09, j3, j4, hj.A05(), Math.max(6, hj.A06));
        Objects.requireNonNull(hj);
    }
}
