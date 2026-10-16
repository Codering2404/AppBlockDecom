package com.facebook.ads.redexgen.core;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1933lc implements InterfaceC0812Jj {
    public final KM A00;
    public final Map<String, KT> A01;
    public final Map<String, String> A02;
    public final Map<String, KN> A03;
    public final long[] A04;

    public C1933lc(KM km, Map<String, KT> map, Map<String, KN> map2, Map<String, String> imageMap) {
        this.A00 = km;
        this.A03 = map2;
        this.A02 = imageMap;
        this.A01 = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.A04 = km.A0G();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0812Jj
    public final List<C2158pT> A7X(long j3) {
        return this.A00.A0E(j3, this.A01, this.A03, this.A02);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0812Jj
    public final long A83(int i3) {
        return this.A04[i3];
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0812Jj
    public final int A84() {
        return this.A04.length;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0812Jj
    public final int A8a(long j3) {
        int iA0K = C5C.A0K(this.A04, j3, false, false);
        int index = this.A04.length;
        if (iA0K < index) {
            return iA0K;
        }
        return -1;
    }
}
