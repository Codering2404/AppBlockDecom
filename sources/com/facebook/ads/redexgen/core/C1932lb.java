package com.facebook.ads.redexgen.core;

import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1932lb implements InterfaceC0812Jj {
    public static String[] A01 = {"5dk9XJP2wGzKf", "t9Sqq8YLjeTrFPP9jF9lF", "ZSSLQReFK2RnB4Tl20", "6LiPtiUXCvNXZPkDmbiLO", "ML1syn76y5DaiFADQPhnbgz9k8Qidn9e", "l6QdmjZcy6MGH", "", "GeXYkzAGCbUHzEIcx9bq6WN7r3"};
    public static final C1932lb A02 = new C1932lb();
    public final List<C2158pT> A00;

    public C1932lb() {
        this.A00 = Collections.emptyList();
    }

    public C1932lb(C2158pT c2158pT) {
        this.A00 = Collections.singletonList(c2158pT);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0812Jj
    public final List<C2158pT> A7X(long j3) {
        return j3 >= 0 ? this.A00 : Collections.emptyList();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0812Jj
    public final long A83(int i3) {
        AbstractC04323y.A07(i3 == 0);
        if (A01[5].length() != 13) {
            throw new RuntimeException();
        }
        A01[7] = "BSEyCnkUJKVAglTMpAGc69o360";
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
