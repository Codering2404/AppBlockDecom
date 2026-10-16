package com.facebook.ads.redexgen.core;

import java.util.Set;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1603fz {
    public C1607g3 A00;
    public Set<String> A01;
    public Set<String> A02;
    public boolean A03;
    public boolean A04 = true;

    public final C1603fz A00(C1607g3 c1607g3) {
        this.A00 = c1607g3;
        return this;
    }

    public final C1603fz A01(Set<String> pinnedCertificates) {
        this.A01 = pinnedCertificates;
        return this;
    }

    public final C1603fz A02(Set<String> pinnedPublicKeys) {
        this.A02 = pinnedPublicKeys;
        return this;
    }

    public final C1603fz A03(boolean z2) {
        this.A04 = z2;
        return this;
    }

    public final C1603fz A04(boolean z2) {
        this.A03 = z2;
        return this;
    }

    public final C1604g0 A05() {
        return new C1604g0(this.A00, this.A04, this.A02, this.A01, this.A03);
    }
}
